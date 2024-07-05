package com.taxi.report.service;

import com.taxi.report.dto.ReportResponseDto;
import com.taxi.report.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Override
    public ReportResponseDto getTotalActions() {
        Map<String, Object> result = reportRepository.totalActions();
        return new ReportResponseDto("Total number of user actions", result);
    }

    @Override
    public List<ReportResponseDto> getActionsGroupedByType() {
        List<Map<String, Object>> results = reportRepository.actionsGroupedByType();
        return results.stream()
                      .map(result -> new ReportResponseDto("User actions grouped by type", result))
                      .collect(Collectors.toList());
    }

    @Override
    public List<ReportResponseDto> getMostActiveUsers() {
        List<Map<String, Object>> results = reportRepository.mostActiveUsers();
        return results.stream()
                      .map(result -> new ReportResponseDto("Most active users", result))
                      .collect(Collectors.toList());
    }

    @Override
    public List<ReportResponseDto> getUserActionsOverTime() {
        List<Map<String, Object>> results = reportRepository.userActionsOverTime();
        return results.stream()
                      .map(result -> new ReportResponseDto("User actions over time", result))
                      .collect(Collectors.toList());
    }

    @Override
    public List<ReportResponseDto> getPeakActivityHours() {
        List<Map<String, Object>> results = reportRepository.peakActivityHours();
        return results.stream()
                      .map(result -> new ReportResponseDto("Peak activity hours", result))
                      .collect(Collectors.toList());
    }

    @Override
    public List<ReportResponseDto> getBookingsMadeEachDay() {
        List<Map<String, Object>> results = reportRepository.bookingsMadeEachDay();
        return results.stream()
                      .map(result -> new ReportResponseDto("Bookings made each day", result))
                      .collect(Collectors.toList());
    }

    @Override
    public List<ReportResponseDto> getLoginAttemptsLastWeek() {
        List<Map<String, Object>> results = reportRepository.loginAttemptsLastWeek();
        return results.stream()
                      .map(result -> new ReportResponseDto("Login attempts over the last week", result))
                      .collect(Collectors.toList());
    }

    @Override
    public List<ReportResponseDto> getUserActionsLastMonth() {
        List<Map<String, Object>> results = reportRepository.userActionsLastMonth();
        return results.stream()
                      .map(result -> new ReportResponseDto("User actions in the last month", result))
                      .collect(Collectors.toList());
    }

    @Override
    public List<ReportResponseDto> getActionTypesByUser() {
        List<Map<String, Object>> results = reportRepository.actionTypesByUser();
        return results.stream()
                      .map(result -> new ReportResponseDto("Action types by user", result))
                      .collect(Collectors.toList());
    }

    @Override
    public List<ReportResponseDto> getMostActiveDaysOfWeek() {
        List<Map<String, Object>> results = reportRepository.mostActiveDaysOfWeek();
        return results.stream()
                      .map(result -> new ReportResponseDto("Most active days of the week", result))
                      .collect(Collectors.toList());
    }

    @Override
    public List<ReportResponseDto> getHourlyBookingTrends() {
        List<Map<String, Object>> results = reportRepository.hourlyBookingTrends();
        return results.stream()
                      .map(result -> new ReportResponseDto("Hourly booking trends", result))
                      .collect(Collectors.toList());
    }

    @Override
    public List<ReportResponseDto> getTopActionsBySpecificUser(String username) {
        List<Map<String, Object>> results = reportRepository.topActionsBySpecificUser(username);
        return results.stream()
                      .map(result -> new ReportResponseDto("Top actions by user: " + username, result))
                      .collect(Collectors.toList());
    }

    @Override
    public ReportResponseDto getAvgActionsPerUser() {
        Map<String, Object> result = reportRepository.avgActionsPerUser();
        return new ReportResponseDto("Average number of actions per user", result);
    }

    @Override
    public List<ReportResponseDto> getUsersWithMoreThanTenActions() {
        List<Map<String, Object>> results = reportRepository.usersWithMoreThanTenActions();
        return results.stream()
                      .map(result -> new ReportResponseDto("Users with more than 10 actions", result))
                      .collect(Collectors.toList());
    }

    @Override
    public List<ReportResponseDto> getDistributionOfActionsPastMonth() {
        List<Map<String, Object>> results = reportRepository.distributionOfActionsPastMonth();
        return results.stream()
                      .map(result -> new ReportResponseDto("Distribution of actions over the past month", result))
                      .collect(Collectors.toList());
    }

    @Override
    public List<ReportResponseDto> getAvgTimeBetweenActionsPerUser() {
        List<Map<String, Object>> results = reportRepository.avgTimeBetweenActionsPerUser();
        return results.stream()
                      .map(result -> new ReportResponseDto("Average time between actions per user", result))
                      .collect(Collectors.toList());
    }

    @Override
    public List<ReportResponseDto> getMostFrequentActionSequences() {
        List<Map<String, Object>> results = reportRepository.mostFrequentActionSequences();
        return results.stream()
                      .map(result -> new ReportResponseDto("Most frequent action sequences", result))
                      .collect(Collectors.toList());
    }

    @Override
    public ReportResponseDto getUserRetentionRate() {
        Map<String, Object> result = reportRepository.userRetentionRate();
        return new ReportResponseDto("User retention rate based on repeated logins", result);
    }

    @Override
    public List<ReportResponseDto> getActionsLeadingToCancellations() {
        List<Map<String, Object>> results = reportRepository.actionsLeadingToCancellations();
        return results.stream()
                      .map(result -> new ReportResponseDto("Actions leading to cancellations", result))
                      .collect(Collectors.toList());
    }

    @Override
    public List<ReportResponseDto> getMonthlyActiveUsers() {
        List<Map<String, Object>> results = reportRepository.monthlyActiveUsers();
        return results.stream()
                      .map(result -> new ReportResponseDto("Monthly active users", result))
                      .collect(Collectors.toList());
    }

    @Override
    public List<ReportResponseDto> getWeeklyActiveUsers() {
        List<Map<String, Object>> results = reportRepository.weeklyActiveUsers();
        return results.stream()
                      .map(result -> new ReportResponseDto("Weekly active users", result))
                      .collect(Collectors.toList());
    }

    @Override
    public List<ReportResponseDto> getDailyActiveUsers() {
        List<Map<String, Object>> results = reportRepository.dailyActiveUsers();
        return results.stream()
                      .map(result -> new ReportResponseDto("Daily active users", result))
                      .collect(Collectors.toList());
    }

    @Override
    public List<ReportResponseDto> getCorrelationBetweenActionsAndRatings() {
        List<Map<String, Object>> results = reportRepository.correlationBetweenActionsAndRatings();
        return results.stream()
                      .map(result -> new ReportResponseDto("Correlation between actions and user ratings", result))
                      .collect(Collectors.toList());
    }

    @Override
    public List<ReportResponseDto> getActionsLeadingToHighRatings() {
        List<Map<String, Object>> results = reportRepository.actionsLeadingToHighRatings();
        return results.stream()
                      .map(result -> new ReportResponseDto("User actions leading to high ratings", result))
                      .collect(Collectors.toList());
    }

    @Override
    public List<ReportResponseDto> getTimeToFirstActionAfterSignup() {
        List<Map### `ReportServiceImpl.java` (continued)

```java
    @Override
    public List<ReportResponseDto> getTimeToFirstActionAfterSignup() {
        List<Map<String, Object>> results = reportRepository.getTimeToFirstActionAfterSignup();
        return results.stream()
                      .map(result -> new ReportResponseDto("Time to first action after signup", result))
                      .collect(Collectors.toList());
    }
}
