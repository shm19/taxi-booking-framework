package com.taxi.report.dto;

import java.util.Map;

public class ReportResponseDto {
    private String query;
    private Map<String, Object> result;

    // Constructors
    public ReportResponseDto() {}

    public ReportResponseDto(String query, Map<String, Object> result) {
        this.query = query;
        this.result = result;
    }

    // Getters and Setters
    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Map<String, Object> getResult() {
        return result;
    }

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }
}
