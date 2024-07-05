package com.taxi.report.service;

import com.taxi.report.dto.ReportResponseDto;
import com.taxi.report.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.micrometer.core.annotation.Timed;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Override
    @Timed(value = "report.get_total_actions")
    public ReportResponseDto getTotalActions() {
        Map<String, Object> result = reportRepository.totalActions();
        return new ReportResponseDto("Total number of user actions", result);
    }

    @Override
    @Timed(value = "report.get_actions_grouped_by_type")
    public List<ReportResponseDto> getActionsGroupedByType() {
        List<Map<String, Object>> results = reportRepository.actionsGroupedByType();
        return results.stream()
                      .map(result -> new ReportResponseDto("User actions grouped by type", result))
                      .collect(Collectors.toList());
    }

    @Override
    @Timed(value = "report.get_most_active_users", description="Tracks the time taken to retrieve the most active users report")
    public List<ReportResponseDto> getMostActiveUsers() {
        List<Map<String, Object>> results = reportRepository.mostActiveUsers();
        return results.stream()
                      .map(result -> new ReportResponseDto("Most active users", result))
                      .collect(Collectors.toList());
    }

    @Override
    @Timed(value = "report.get_user_actions_over_time", description="Tracks the time taken to retrieve user actions over time report")
    public List<ReportResponseDto> getUserActionsOverTime() {
        List<Map<String, Object>> results = reportRepository.userActionsOverTime();
        return results.stream()
                      .map(result -> new ReportResponseDto("User actions over time", result))
                      .collect(Collectors.toList());
    }

    @Override
    @Timed(value = "report.get_peak_activity_hours", description="Tracks the time taken to retrieve peak activity hours report")
    public List<ReportResponseDto> getPeakActivityHours() {
        List<Map<String, Object>> results = reportRepository.peakActivityHours();
        return results.stream()
                      .map(result -> new ReportResponseDto("Peak activity hours", result))
                      .collect(Collectors.toList());
    }

    @Override
    @Timed(value = "report.get_bookings_made_each_day", description="Tracks the time taken to retrieve bookings made each day report")
    public List<ReportResponseDto> getBookingsMadeEachDay() {
        List<Map<String, Object>> results = reportRepository.bookingsMadeEachDay();
        return results.stream()
                      .map(result -> new ReportResponseDto("Bookings made each day", result))
                      .collect(Collectors.toList());
    }

    @Override
    @Timed(value = "report.get_login_attempts_last_week", description="Tracks the time taken to retrieve login attempts last week report")
    public List<ReportResponseDto> getLoginAttemptsLastWeek() {
        List<Map<String, Object>> results = reportRepository.loginAttemptsLastWeek();
        return results.stream()
                      .map(result -> new ReportResponseDto("Login attempts over the last week", result))
                      .collect(Collectors.toList());
    }

    @Override
    @Timed(value = "report.get_user_actions_last_month", description="Tracks the time taken to retrieve user actions last month report")
    public List<ReportResponseDto> getUserActionsLastMonth() {
        List<Map<String, Object>> results = reportRepository.userActionsLastMonth();
        return results.stream()
                      .map(result -> new ReportResponseDto("User actions in the last month", result))
                      .collect(Collectors.toList());
    }

    @Override
    @Timed(value = "report.get_action_types_by_user", description="Tracks the time taken to retrieve action types by user report")
    public List<ReportResponseDto> getActionTypesByUser() {
        List<Map<String, Object>> results = reportRepository.actionTypesByUser();
        return results.stream()
                      .map(result -> new ReportResponseDto("Action types by user", result))
                      .collect(Collectors.toList());
    }

    @Override
    @Timed(value = "report.get_most_active_days_of_week", description="Tracks the time taken to retrieve most active days of the week report")
    public List<ReportResponseDto> getMostActiveDaysOfWeek() {
        List<Map<String, Object>> results = reportRepository.mostActiveDaysOfWeek();
        return results.stream()
                      .map(result -> new ReportResponseDto("Most active days of the week", result))
                      .collect(Collectors.toList());
    }

    @Override
    @Timed(value = "report.get_hourly_booking_trends", description="Tracks the time taken to retrieve hourly booking trends report")
    public List<ReportResponseDto> getHourlyBookingTrends() {
        List<Map<String, Object>> results = reportRepository.hourlyBookingTrends();
        return results.stream()
                      .map(result -> new ReportResponseDto("Hourly booking trends", result))
                      .collect(Collectors.toList());
    }

    @Override
    @Timed(value = "report.get_top_actions_by_user", description = "Retrieves a report containing the most frequently performed actions by a specific user identified by username.")
    public List<ReportResponseDto> getTopActionsBySpecificUser(String username) {
        List<Map<String, Object>> results = reportRepository.topActionsBySpecificUser(username);
        return results.stream()
                      .map(result -> new ReportResponseDto("Top actions by user: " + username, result))
                      .collect(Collectors.toList());
    }

    @Override
    @Timed(value = "report.get_avg_actions_per_user", description = "Retrieves a report containing the average number of actions performed by all users.")
    public ReportResponseDto getAvgActionsPerUser() {
        Map<String, Object> result = reportRepository.avgActionsPerUser();
        return new ReportResponseDto("Average number of actions per user", result);
    }

    @Override
    @Timed(value = "report.get_users_with_more_than_ten_actions", description = "Retrieves a report containing a list of users who have performed more than 10 actions.")
    public List<ReportResponseDto> getUsersWithMoreThanTenActions() {
        List<Map<String, Object>> results = reportRepository.usersWithMoreThanTenActions();
        return results.stream()
                      .map(result -> new ReportResponseDto("Users with more than 10 actions", result))
                      .collect(Collectors.toList());
    }

    @Override
    @Timed(value = "report.get_distribution_of_actions_past_month", description = "Tracks the time taken to retrieve action distribution over the past month report")
    public List<ReportResponseDto> getDistributionOfActionsPastMonth() {
        List<Map<String, Object>> results = reportRepository.distributionOfActionsPastMonth();
        return results.stream()
                      .map(result -> new ReportResponseDto("Distribution of actions over the past month", result))
                      .collect(Collectors.toList());
    }

    @Override
    @Timed(value = "report.get_avg_time_between_actions_per_user", description = "Tracks the time taken to retrieve average time between actions per user report")
    public List<ReportResponseDto> getAvgTimeBetweenActionsPerUser() {
        List<Map<String, Object>> results = reportRepository.avgTimeBetweenActionsPerUser();
        return results.stream()
                      .map(result -> new ReportResponseDto("Average time between actions per user", result))
                      .collect(Collectors.toList());
    }

    @Override
    @Timed(value = "report.get_most_frequent_action_sequences", description = "Tracks the time taken to retrieve most frequent action sequences report")
    public List<ReportResponseDto> getMostFrequentActionSequences() {
        List<Map<String, Object>> results = reportRepository.mostFrequentActionSequences();
        return results.stream()
                      .map(result -> new ReportResponseDto("Most frequent action sequences", result))
                      .collect(Collectors.toList());
    }

    @Override
    @Timed(value = "report.get_user_retention_rate", description = "Tracks the time taken to retrieve user retention rate report")
    public ReportResponseDto getUserRetentionRate() {
        Map<String, Object> result = reportRepository.userRetentionRate();
        return new ReportResponseDto("User retention rate based on repeated logins", result);
    }

    @Override
    @Timed(value = "report.get_actions_leading_to_cancellations", description = "Tracks the time taken to retrieve actions leading to cancellations report")
    public List<ReportResponseDto> getActionsLeadingToCancellations() {
        List<Map<String, Object>> results = reportRepository.actionsLeadingToCancellations();
        return results.stream()
                      .map(result -> new ReportResponseDto("Actions leading to cancellations", result))
                      .collect(Collectors.toList());
    }

    @Override
    @Timed(value = "report.get_monthly_active_users", description = "Tracks the time taken to retrieve monthly active users report")
    public List<ReportResponseDto> getMonthlyActiveUsers() {
        List<Map<String, Object>> results = reportRepository.monthlyActiveUsers();
        return results.stream()
                      .map(result -> new ReportResponseDto("Monthly active users", result))
                      .collect(Collectors.toList());
    }

    @Override
    @Timed(value = "report.get_weekly_active_users", description = "Tracks the time taken to retrieve weekly active users report")
    public List<ReportResponseDto> getWeeklyActiveUsers() {
        List<Map<String, Object>> results = reportRepository.weeklyActiveUsers();
        return results.stream()
                      .map(result -> new ReportResponseDto("Weekly active users", result))
                      .collect(Collectors.toList());
    }

    @Override
    @Timed(value = "report.get_daily_active_users", description = "Tracks the time taken to retrieve daily active users report")
    public List<ReportResponseDto> getDailyActiveUsers() {
        List<Map<String, Object>> results = reportRepository.dailyActiveUsers();
        return results.stream()
                      .map(result -> new ReportResponseDto("Daily active users", result))
                      .collect(Collectors.toList());
    }

    @Override
    @Timed(value = "report.get_correlation_between_actions_and_ratings", description = "Tracks the time taken to retrieve correlation between actions and ratings report")
    public List<ReportResponseDto> getCorrelationBetweenActionsAndRatings() {
        List<Map<String, Object>> results = reportRepository.correlationBetweenActionsAndRatings();
        return results.stream()
                      .map(result -> new ReportResponseDto("Correlation between actions and user ratings", result))
                      .collect(Collectors.toList());
    }

    @Override
    @Timed(value = "report.get_actions_leading_to_high_ratings", description = "Tracks the time taken to retrieve actions leading to high ratings report")
    public List<ReportResponseDto> getActionsLeadingToHighRatings() {
        List<Map<String, Object>> results = reportRepository.actionsLeadingToHighRatings();
        return results.stream()
                      .map(result -> new ReportResponseDto("User actions leading to high ratings", result))
                      .collect(Collectors.toList());
    }

    @Override
    @Timed(value = "report.get_time_to_first_action_after_signup", description = "Tracks the time taken to retrieve time to first action after signup report")
    public List<ReportResponseDto> getTimeToFirstActionAfterSignup() {
        List<Map<String, Object>> results = reportRepository.getTimeToFirstActionAfterSignup();
        return results.stream()
                      .map(result -> new ReportResponseDto("Time to first action after signup", result))
                      .collect(Collectors.toList());
    }
}
