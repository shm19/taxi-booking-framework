package com.taxi.framework.report.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class BaseReportResponseDTO {
    private String query;
    private Map<String, Object> result;

    public BaseReportResponseDTO(String query, Map<String, Object> result) {
        this.query = query;
        this.result = result;
    }
}
