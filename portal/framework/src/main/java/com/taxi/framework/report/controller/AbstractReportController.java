package com.taxi.framework.report.controller;

import com.taxi.framework.report.dto.BaseReportResponseDTO;
import com.taxi.framework.report.service.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class AbstractReportController<T extends BaseReportResponseDTO> {

    protected final ReportService<T> reportService;

    protected AbstractReportController(ReportService<T> reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/total-actions")
    public ResponseEntity<T> getTotalActions() {
        T response = reportService.getTotalActions();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/actions-grouped-by-type")
    public ResponseEntity<List<T>> getActionsGroupedByType() {
        List<T> response = reportService.getActionsGroupedByType();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/most-active-users")
    public ResponseEntity<List<T>> getMostActiveUsers() {
        List<T> response = reportService.getMostActiveUsers();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user-actions-over-time")
    public ResponseEntity<List<T>> getUserActionsOverTime() {
        List<T> response = reportService.getUserActionsOverTime();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/peak-activity-hours")
    public ResponseEntity<List<T>> getPeakActivityHours() {
        List<T> response = reportService.getPeakActivityHours();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/bookings-made-each-day")
    public ResponseEntity<List<T>> getBookingsMadeEachDay() {
        List<T> response = reportService.getBookingsMadeEachDay();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/login-attempts-last-week")
    public ResponseEntity<List<T>> getLoginAttemptsLastWeek() {
        List<T> response = reportService.getLoginAttemptsLastWeek();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user-actions-last-month")
    public ResponseEntity<List<T>> getUserActionsLastMonth() {
        List<T> response = reportService.getUserActionsLastMonth();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/action-types-by-user")
    public ResponseEntity<List<T>> getActionTypesByUser() {
        List<T> response = reportService.getActionTypesByUser();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/most-active-days-of-week")
    public ResponseEntity<List<T>> getMostActiveDaysOfWeek() {
        List<T> response = reportService.getMostActiveDaysOfWeek();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/hourly-booking-trends")
    public ResponseEntity<List<T>> getHourlyBookingTrends() {
        List<T> response = reportService.getHourlyBookingTrends();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/top-actions-by-user")
    public ResponseEntity<List<T>> getTopActionsByUser(@RequestParam String username) {
        List<T> response = reportService.getTopActionsBySpecificUser(username);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/avg-actions-per-user")
    public ResponseEntity<T> getAvgActionsPerUser() {
        T response = reportService.getAvgActionsPerUser();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/users-with-more-than-ten-actions")
    public ResponseEntity<List<T>> getUsersWithMoreThanTenActions() {
        List<T> response = reportService.getUsersWithMoreThanTenActions();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/distribution-of-actions-past-month")
    public ResponseEntity<List<T>> getDistributionOfActionsPastMonth() {
        List<T> response = reportService.getDistributionOfActionsPastMonth();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/avg-time-between-actions-per-user")
    public ResponseEntity<List<T>> getAvgTimeBetweenActionsPerUser() {
        List<T> response = reportService.getAvgTimeBetweenActionsPerUser();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/most-frequent-action-sequences")
    public ResponseEntity<List<T>> getMostFrequentActionSequences() {
        List<T> response = reportService.getMostFrequentActionSequences();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user-retention-rate")
    public ResponseEntity<T> getUserRetentionRate() {
        T response = reportService.getUserRetentionRate();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/actions-leading-to-cancellations")
    public ResponseEntity<List<T>> getActionsLeadingToCancellations() {
        List<T> response = reportService.getActionsLeadingToCancellations();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/monthly-active-users")
    public ResponseEntity<List<T>> getMonthlyActiveUsers() {
        List<T> response = reportService.getMonthlyActiveUsers();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/weekly-active-users")
    public ResponseEntity<List<T>> getWeeklyActiveUsers() {
        List<T> response = reportService.getWeeklyActiveUsers();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/daily-active-users")
    public ResponseEntity<List<T>> getDailyActiveUsers() {
        List<T> response = reportService.getDailyActiveUsers();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/correlation-between-actions-and-ratings")
    public ResponseEntity<List<T>> getCorrelationBetweenActionsAndRatings() {
        List<T> response = reportService.getCorrelationBetweenActionsAndRatings();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/actions-leading-to-high-ratings")
    public ResponseEntity<List<T>> getActionsLeadingToHighRatings() {
        List<T> response = reportService.getActionsLeadingToHighRatings();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/time-to-first-action-after-signup")
    public ResponseEntity<List<T>> getTimeToFirstActionAfterSignup() {
        List<T> response = reportService.getTimeToFirstActionAfterSignup();
        return ResponseEntity.ok(response);
    }
}
