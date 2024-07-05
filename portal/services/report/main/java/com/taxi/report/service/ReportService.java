package com.taxi.report.service;

import com.taxi.report.dto.ReportResponseDto;

import java.util.List;

public interface ReportService {
    ReportResponseDto getTotalActions();
    List<ReportResponseDto> getActionsGroupedByType();
    List<ReportResponseDto> getMostActiveUsers();
    List<ReportResponseDto> getUserActionsOverTime();
    List<ReportResponseDto> getPeakActivityHours();
    List<ReportResponseDto> getBookingsMadeEachDay();
    List<ReportResponseDto> getLoginAttemptsLastWeek();
    List<ReportResponseDto> getUserActionsLastMonth();
    List<ReportResponseDto> getActionTypesByUser();
    List<ReportResponseDto> getMostActiveDaysOfWeek();
    List<ReportResponseDto> getHourlyBookingTrends();
    List<ReportResponseDto> getTopActionsBySpecificUser(String username);
    ReportResponseDto getAvgActionsPerUser();
    List<ReportResponseDto> getUsersWithMoreThanTenActions();
    List<ReportResponseDto> getDistributionOfActionsPastMonth();
    List<ReportResponseDto> getAvgTimeBetweenActionsPerUser();
    List<ReportResponseDto> getMostFrequentActionSequences();
    ReportResponseDto getUserRetentionRate();
    List<ReportResponseDto> getActionsLeadingToCancellations();
    List<ReportResponseDto> getMonthlyActiveUsers();
    List<ReportResponseDto> getWeeklyActiveUsers();
    List<ReportResponseDto> getDailyActiveUsers();
    List<ReportResponseDto> getCorrelationBetweenActionsAndRatings();
    List<ReportResponseDto> getActionsLeadingToHighRatings();
    List<ReportResponseDto> getTimeToFirstActionAfterSignup();
    
    Double getTotalRevenue(LocalDate startDate, LocalDate endDate);
}
