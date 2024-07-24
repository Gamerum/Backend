package com.gamerum.backend.external.client.api.igdb.query;

public class IGDBQueryBuilder {
    private String fields = "";
    private String exclude = "";
    private String limit = "";
    private String offset = "";
    private String sort = "";
    private String where = "";

    // Private constructor to prevent instantiation outside of the builder
    private IGDBQueryBuilder() {
    }

    public static IGDBQueryBuilder builder() {
        return new IGDBQueryBuilder();
    }

    public IGDBQueryBuilder sort(String sort) {
        this.sort = "s " + sort + ";";
        return this;
    }

    public IGDBQueryBuilder fields(String fields) {
        this.fields = "f " + fields + ";";
        return this;
    }

    public IGDBQueryBuilder exclude(String fields) {
        this.exclude = "x " + fields + ";";
        return this;
    }

    public IGDBQueryBuilder limit(int limit) {
        this.limit = "l " + limit + ";";
        return this;
    }

    public IGDBQueryBuilder offset(int offset) {
        this.offset = "o " + offset + ";";
        return this;
    }

    public IGDBQueryBuilder where(String where) {
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
