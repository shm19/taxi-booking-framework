package com.taxi.service.report.dto;

import com.taxi.framework.report.dto.BaseReportResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class ReportResponseDTO extends BaseReportResponseDTO {
    public ReportResponseDTO(String query, Map<String, Object> result) {
        super(query, result);
    }
}
