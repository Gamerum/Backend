package com.gamerum.backend.external.client.api.game.igdb.utils.query;

public class QueryBuilder {
    private String fields = "";
    private String exclude = "";
    private String limit = "";
    private String offset = "";
    private String sort = "";
    private String where = "";

    // Private constructor to prevent instantiation outside of the builder
    private QueryBuilder() {
    }

    public static QueryBuilder builder() {
        return new QueryBuilder();
    }

    public QueryBuilder sort(String field, Sort order) {
        this.sort = "s " + field + " " + order + ";";
        return this;
    }

    public QueryBuilder fields(String fields) {
        this.fields = "f " + fields + ";";
        return this;
    }

    public QueryBuilder exclude(String fields) {
        this.exclude = "x " + fields + ";";
        return this;
    }

    public QueryBuilder limit(int limit) {
        this.limit = "l " + limit + ";";
        return this;
    }

    public QueryBuilder offset(int offset) {
        this.offset = "o " + offset + ";";
        return this;
    }

    public QueryBuilder where(String where) {
        if (where.contains("where ") || where.contains("w ")) {
            this.where = where;
        } else {
            if (where.contains(";")) this.where = "w " + where;
            else this.where = "w " + where + ";";
        }
        return this;
    }

    public String build() {
        StringBuilder queryBuilder = new StringBuilder();
        if (!fields.isBlank())  queryBuilder.append(fields);
        if (!exclude.isBlank()) queryBuilder.append(exclude);
        if (!sort.isBlank())    queryBuilder.append(sort);
        if (!where.isBlank())   queryBuilder.append(where);
        if (!limit.isBlank())   queryBuilder.append(limit);
        if (!offset.isBlank())  queryBuilder.append(offset);

        return queryBuilder.toString();
    }
}
