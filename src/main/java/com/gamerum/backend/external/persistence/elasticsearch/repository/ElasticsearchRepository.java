package com.gamerum.backend.external.persistence.elasticsearch.repository;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.*;
import co.elastic.clients.elasticsearch.core.bulk.BulkOperation;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.elasticsearch.indices.DeleteIndexRequest;
import co.elastic.clients.elasticsearch.indices.DeleteIndexResponse;
import com.gamerum.backend.external.persistence.elasticsearch.document.DocumentBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ElasticsearchRepository {
    private static final Logger logger = LoggerFactory.getLogger(ElasticsearchRepository.class);
    private final ElasticsearchClient elasticsearchClient;

    public ElasticsearchRepository(ElasticsearchClient elasticsearchClient) {
        this.elasticsearchClient = elasticsearchClient;
    }

    public <T extends DocumentBase> void save(T document) throws IOException {
        IndexRequest<T> indexRequest = IndexRequest.of(i -> i
                .index(document.getIndex())
                .id(document.getId())
                .document(document));

        elasticsearchClient.index(indexRequest);
        logger.info(document.getIndex() + " Saved");
    }

    public <T extends DocumentBase> void saveAll(List<T> documents) throws IOException {
        List<BulkOperation> operations = documents.stream()
                .map(document -> BulkOperation.of(b -> b
                        .index(i -> i
                                .index(document.getIndex())
                                .id(document.getId())
                                .document(document)
                        )
                ))
                .collect(Collectors.toList());

        BulkRequest bulkRequest = BulkRequest.of(b -> b
                .operations(operations)
        );

        elasticsearchClient.bulk(bulkRequest);
        logger.info("Saved all to " + documents.getFirst().getIndex());
    }

    public <T extends DocumentBase> T getById(String indexName, String id, Class<T> documentClass) throws IOException {
        GetRequest getRequest = GetRequest.of(g -> g
                .index(indexName)
                .id(id)
        );

        GetResponse<T> getResponse = elasticsearchClient.get(getRequest, documentClass);
        logger.info("Retrieved " + documentClass.getSimpleName() + " from " + indexName);
        return getResponse.source();
    }


    public void updateByRequest(UpdateByQueryRequest request) throws IOException {
        elasticsearchClient.updateByQuery(request);
    }

    public <T extends DocumentBase> List<T> search(SearchRequest searchRequest, Class<T> documentClass) throws IOException {
        logger.info("Searched for " + documentClass.getSimpleName());
        SearchResponse<T> searchResponse = elasticsearchClient.search(searchRequest, documentClass);
        return searchResponse.hits().hits().stream()
                .map(Hit::source)
                .toList();
    }

    public DeleteResponse deleteById(String id, String index) throws IOException {
        DeleteRequest deleteRequest = DeleteRequest.of(d -> d
                .index(index)
                .id(id)
        );
        logger.warn("Deleting document with {} id from {}", id, index);
        return elasticsearchClient.delete(deleteRequest);
    }

    public DeleteIndexResponse deleteIndex(String index) throws IOException {
        DeleteIndexRequest deleteIndexRequest = DeleteIndexRequest.of(d -> d
                .index(index)
        );
        logger.warn("Deleting index {}", index);
        return elasticsearchClient.indices().delete(deleteIndexRequest);
    }

}
