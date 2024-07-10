package com.taxi.framework.report.service;

import com.taxi.framework.report.dto.BaseReportResponseDTO;

import java.util.List;

public interface ReportService<T extends BaseReportResponseDTO> {
    T getTotalActions();
    List<T> getActionsGroupedByType();
    List<T> getMostActiveUsers();
    List<T> getUserActionsOverTime();
    List<T> getPeakActivityHours();
    List<T> getBookingsMadeEachDay();
    List<T> getLoginAttemptsLastWeek();
    List<T> getUserActionsLastMonth();
    List<T> getActionTypesByUser();
    List<T> getMostActiveDaysOfWeek();
    List<T> getHourlyBookingTrends();
    List<T> getTopActionsBySpecificUser(String username);
    T getAvgActionsPerUser();
    List<T> getUsersWithMoreThanTenActions();
    List<T> getDistributionOfActionsPastMonth();
    List<T> getAvgTimeBetweenActionsPerUser();
    List<T> getMostFrequentActionSequences();
    T getUserRetentionRate();
    List<T> getActionsLeadingToCancellations();
    List<T> getMonthlyActiveUsers();
    List<T> getWeeklyActiveUsers();
    List<T> getDailyActiveUsers();
    List<T> getCorrelationBetweenActionsAndRatings();
    List<T> getActionsLeadingToHighRatings();
    List<T> getTimeToFirstActionAfterSignup();
}
