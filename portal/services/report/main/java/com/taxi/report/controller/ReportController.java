package com.taxi.report.controller;

import com.taxi.report.dto.ReportResponseDto;
import com.taxi.report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/total-actions")
    public ResponseEntity<ReportResponseDto> getTotalActions() {
        ReportResponseDto response = reportService.getTotalActions();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/actions-grouped-by-type")
    public ResponseEntity<List<ReportResponseDto>> getActionsGroupedByType() {
        List<ReportResponseDto> response = reportService.getActionsGroupedByType();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/most-active-users")
    public ResponseEntity<List<ReportResponseDto>> getMostActiveUsers() {
        List<ReportResponseDto> response = reportService.getMostActiveUsers();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user-actions-over-time")
    public ResponseEntity<List<ReportResponseDto>> getUserActionsOverTime() {
        List<ReportResponseDto> response = reportService.getUserActionsOverTime();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/peak-activity-hours")
    public ResponseEntity<List<ReportResponseDto>> getPeakActivityHours() {
        List<ReportResponseDto> response = reportService.getPeakActivityHours();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/bookings-made-each-day")
    public ResponseEntity<List<ReportResponseDto>> getBookingsMadeEachDay() {
        List<ReportResponseDto> response = reportService.getBookingsMadeEachDay();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/login-attempts-last-week")
    public ResponseEntity<List<ReportResponseDto>> getLoginAttemptsLastWeek() {
        List<ReportResponseDto> response = reportService.getLoginAttemptsLastWeek();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user-actions-last-month")
    public ResponseEntity<List<ReportResponseDto>> getUserActionsLastMonth() {
        List<ReportResponseDto> response = reportService.getUserActionsLastMonth();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/action-types-by-user")
    public ResponseEntity<List<ReportResponseDto>> getActionTypesByUser() {
        List<ReportResponseDto> response = reportService.getActionTypesByUser();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/most-active-days-of-week")
    public ResponseEntity<List<ReportResponseDto>> getMostActiveDaysOfWeek() {
        List<ReportResponseDto> response = reportService.getMostActiveDaysOfWeek();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/hourly-booking-trends")
    public ResponseEntity<List<ReportResponseDto>> getHourlyBookingTrends() {
        List<ReportResponseDto> response = reportService.getHourlyBookingTrends();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/top-actions-by-user")
    public ResponseEntity<List<ReportResponseDto>> getTopActionsByUser(@RequestParam String username) {
        List<ReportResponseDto> response = reportService.getTopActionsBySpecificUser(username);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/avg-actions-per-user")
    public ResponseEntity<ReportResponseDto> getAvgActionsPerUser() {
        ReportResponseDto response = reportService.getAvgActionsPerUser();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/users-with-more-than-ten-actions")
    public ResponseEntity<List<ReportResponseDto>> getUsersWithMoreThanTenActions() {
        List<ReportResponseDto> response = reportService.getUsersWithMoreThanTenActions();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/distribution-of-actions-past-month")
    public ResponseEntity<List<ReportResponseDto>> getDistributionOfActionsPastMonth() {
        List<ReportResponseDto> response = reportService.getDistributionOfActionsPastMonth();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/avg-time-between-actions-per-user")
    public ResponseEntity<List<ReportResponseDto>> getAvgTimeBetweenActionsPerUser() {
        List<ReportResponseDto> response = reportService.getAvgTimeBetweenActionsPerUser();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/most-frequent-action-sequences")
    public ResponseEntity<List<ReportResponseDto>> getMostFrequentActionSequences() {
        List<ReportResponseDto> response = reportService.getMostFrequentActionSequences();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user-retention-rate")
    public ResponseEntity<ReportResponseDto> getUserRetentionRate() {
        ReportResponseDto response = reportService.getUserRetentionRate();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/actions-leading-to-cancellations")
    public ResponseEntity<List<ReportResponseDto>> getActionsLeadingToCancellations() {
        List<ReportResponseDto> response = reportService.getActionsLeadingToCancellations();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/monthly-active-users")
    public ResponseEntity<List<ReportResponseDto>> getMonthlyActiveUsers() {
        List<ReportResponseDto> response = reportService.getMonthlyActiveUsers();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/weekly-active-users")
    public ResponseEntity<List<ReportResponseDto>> getWeeklyActiveUsers() {
        List<ReportResponseDto> response = reportService.getWeeklyActiveUsers();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/daily-active-users")
    public ResponseEntity<List<ReportResponseDto>> getDailyActiveUsers() {
        List<ReportResponseDto> response = reportService.getDailyActiveUsers();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/correlation-between-actions-and-ratings")
    public ResponseEntity<List<ReportResponseDto>> getCorrelationBetweenActionsAndRatings() {
        List<ReportResponseDto> response = reportService.getCorrelationBetweenActionsAndRatings();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/actions-leading-to-high-ratings")
    public ResponseEntity<List<ReportResponseDto>> getActionsLeadingToHighRatings() {
        List<ReportResponseDto> response = reportService.getActionsLeadingToHighRatings();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/time-to-first-action-after-signup")
    public ResponseEntity<List<ReportResponseDto>> getTimeToFirstActionAfterSignup() {
        List<ReportResponseDto> response = reportService.getTimeToFirstActionAfterSignup();
        return ResponseEntity.ok(response);
    }
}
