package com.taxi.framework.report.service;

import com.taxi.framework.report.dto.BaseReportResponseDTO;
import com.taxi.framework.report.repository.ReportRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractReportService<T extends BaseReportResponseDTO> implements ReportService<T> {

    @Autowired
    protected ReportRepository reportRepository;

    @Override
    public T getTotalActions() {
        Map<String, Object> result = reportRepository.totalActions();
        return createReportResponse("Total number of user actions", result);
    }

    @Override
    public List<T> getActionsGroupedByType() {
        List<Map<String, Object>> results = reportRepository.actionsGroupedByType();
        return results.stream()
                      .map(result -> createReportResponse("User actions grouped by type", result))
                      .collect(Collectors.toList());
    }

    @Override
    public List<T> getMostActiveUsers() {
        List<Map<String, Object>> results = reportRepository.mostActiveUsers();
        return results.stream()
                      .map(result -> createReportResponse("Most active users", result))
                      .collect(Collectors.toList());
    }

    @Override
    public List<T> getUserActionsOverTime() {
        List<Map<String, Object>> results = reportRepository.userActionsOverTime();
        return results.stream()
                      .map(result -> createReportResponse("User actions over time", result))
                      .collect(Collectors.toList());
    }

    @Override
    public List<T> getPeakActivityHours() {
        List<Map<String, Object>> results = reportRepository.peakActivityHours();
        return results.stream()
                      .map(result -> createReportResponse("Peak activity hours", result))
                      .collect(Collectors.toList());
    }

    @Override
    public List<T> getBookingsMadeEachDay() {
        List<Map<String, Object>> results = reportRepository.bookingsMadeEachDay();
        return results.stream()
                      .map(result -> createReportResponse("Bookings made each day", result))
                      .collect(Collectors.toList());
    }

    @Override
    public List<T> getLoginAttemptsLastWeek() {
        List<Map<String, Object>> results = reportRepository.loginAttemptsLastWeek();
        return results.stream()
                      .map(result -> createReportResponse("Login attempts over the last week", result))
                      .collect(Collectors.toList());
    }

    @Override
    public List<T> getUserActionsLastMonth() {
        List<Map<String, Object>> results = reportRepository.userActionsLastMonth();
        return results.stream()
                      .map(result -> createReportResponse("User actions in the last month", result))
                      .collect(Collectors.toList());
    }

    @Override
    public List<T> getActionTypesByUser() {
        List<Map<String, Object>> results = reportRepository.actionTypesByUser();
        return results.stream()
                      .map(result -> createReportResponse("Action types by user", result))
                      .collect(Collectors.toList());
    }

    @Override
    public List<T> getMostActiveDaysOfWeek() {
        List<Map<String, Object>> results = reportRepository.mostActiveDaysOfWeek();
        return results.stream()
                      .map(result -> createReportResponse("Most active days of the week", result))
                      .collect(Collectors.toList());
    }

    @Override
    public List<T> getHourlyBookingTrends() {
        List<Map<String, Object>> results = reportRepository.hourlyBookingTrends();
        return results.stream()
                      .map(result -> createReportResponse("Hourly booking trends", result))
                      .collect(Collectors.toList());
    }

    @Override
    public List<T> getTopActionsBySpecificUser(String username) {
        List<Map<String, Object>> results = reportRepository.topActionsBySpecificUser(username);
        return results.stream()
                      .map(result -> createReportResponse("Top actions by user: " + username, result))
                      .collect(Collectors.toList());
    }

    @Override
    public T getAvgActionsPerUser() {
        Map<String, Object> result = reportRepository.avgActionsPerUser();
        return createReportResponse("Average number of actions per user", result);
    }

    @Override
    public List<T> getUsersWithMoreThanTenActions() {
        List<Map<String, Object>> results = reportRepository.usersWithMoreThanTenActions();
        return results.stream()
                      .map(result -> createReportResponse("Users with more than 10 actions", result))
                      .collect(Collectors.toList());
    }

    @Override
    public List<T> getDistributionOfActionsPastMonth() {
        List<Map<String, Object>> results = reportRepository.distributionOfActionsPastMonth();
        return results.stream()
                      .map(result -> createReportResponse("Distribution of actions over the past month", result))
                      .collect(Collectors.toList());
    }

    @Override
    public List<T> getAvgTimeBetweenActionsPerUser() {
        List<Map<String, Object>> results = reportRepository.avgTimeBetweenActionsPerUser();
        return results.stream()
                      .map(result -> createReportResponse("Average time between actions per user", result))
                      .collect(Collectors.toList());
    }

    @Override
    public List<T> getMostFrequentActionSequences() {
        List<Map<String, Object>> results = reportRepository.mostFrequentActionSequences();
        return results.stream()
                      .map(result -> createReportResponse("Most frequent action sequences", result))
                      .collect(Collectors.toList());
    }

    @Override
    public T getUserRetentionRate() {
        Map<String, Object> result = reportRepository.userRetentionRate();
        return createReportResponse("User retention rate based on repeated logins", result);
    }

    @Override
    public List<T> getActionsLeadingToCancellations() {
        List<Map<String, Object>> results = reportRepository.actionsLeadingToCancellations();
        return results.stream()
                      .map(result -> createReportResponse("Actions leading to cancellations", result))
                      .collect(Collectors.toList());
    }

    @Override
    public List<T> getMonthlyActiveUsers() {
        List<Map<String, Object>> results = reportRepository.monthlyActiveUsers();
        return results.stream()
                      .map(result -> createReportResponse("Monthly active users", result))
                      .collect(Collectors.toList());
    }

    @Override
    public List<T> getWeeklyActiveUsers() {
        List<Map<String, Object>> results = reportRepository.weeklyActiveUsers();
        return results.stream()
                      .map(result -> createReportResponse("Weekly active users", result))
                      .collect(Collectors.toList());
    }

    @Override
    public List<T> getDailyActiveUsers() {
        List<Map<String, Object>> results = reportRepository.dailyActiveUsers();
        return results.stream()
                      .map(result -> createReportResponse("Daily active users", result))
                      .collect(Collectors.toList());
    }

    @Override
    public List<T> getCorrelationBetweenActionsAndRatings() {
        List<Map<String, Object>> results = reportRepository.correlationBetweenActionsAndRatings();
        return results.stream()
                      .map(result -> createReportResponse("Correlation between actions and user ratings", result))
                      .collect(Collectors.toList());
    }

    @Override
    public List<T> getActionsLeadingToHighRatings() {
        List<Map<String, Object>> results = reportRepository.actionsLeadingToHighRatings();
        return results.stream()
                      .map(result -> createReportResponse("User actions leading to high ratings", result))
                      .collect(Collectors.toList());
    }

    @Override
    public List<T> getTimeToFirstActionAfterSignup() {
        List<Map<String, Object>> results = reportRepository.timeToFirstActionAfterSignup();
        return results.stream()
                      .map(result -> createReportResponse("Time to first action after signup", result))
                      .collect(Collectors.toList());
    }

    protected abstract T createReportResponse(String query, Map<String, Object> result);
}
