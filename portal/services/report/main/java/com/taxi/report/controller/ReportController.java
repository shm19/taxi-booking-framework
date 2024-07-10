package com.taxi.service.report.controller;

import com.taxi.framework.report.controller.AbstractReportController;
import com.taxi.service.report.dto.ReportResponseDTO;
import com.taxi.service.report.service.ReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController extends AbstractReportController<ReportResponseDTO> {

    private final ReportServiceImpl reportService;

    @Autowired
    public ReportController(ReportServiceImpl reportService) {
        super(reportService);
        this.reportService = reportService;
    }

    @Override
    @GetMapping("/total-actions")
    public ResponseEntity<ReportResponseDTO> getTotalActions() {
        ReportResponseDTO response = reportService.getTotalActions();
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/actions-grouped-by-type")
    public ResponseEntity<List<ReportResponseDTO>> getActionsGroupedByType() {
        List<ReportResponseDTO> response = reportService.getActionsGroupedByType();
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/most-active-users")
    public ResponseEntity<List<ReportResponseDTO>> getMostActiveUsers() {
        List<ReportResponseDTO> response = reportService.getMostActiveUsers();
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/user-actions-over-time")
    public ResponseEntity<List<ReportResponseDTO>> getUserActionsOverTime() {
        List<ReportResponseDTO> response = reportService.getUserActionsOverTime();
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/peak-activity-hours")
    public ResponseEntity<List<ReportResponseDTO>> getPeakActivityHours() {
        List<ReportResponseDTO> response = reportService.getPeakActivityHours();
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/bookings-made-each-day")
    public ResponseEntity<List<ReportResponseDTO>> getBookingsMadeEachDay() {
        List<ReportResponseDTO> response = reportService.getBookingsMadeEachDay();
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/login-attempts-last-week")
    public ResponseEntity<List<ReportResponseDTO>> getLoginAttemptsLastWeek() {
        List<ReportResponseDTO> response = reportService.getLoginAttemptsLastWeek();
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/user-actions-last-month")
    public ResponseEntity<List<ReportResponseDTO>> getUserActionsLastMonth() {
        List<ReportResponseDTO> response = reportService.getUserActionsLastMonth();
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/action-types-by-user")
    public ResponseEntity<List<ReportResponseDTO>> getActionTypesByUser() {
        List<ReportResponseDTO> response = reportService.getActionTypesByUser();
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/most-active-days-of-week")
    public ResponseEntity<List<ReportResponseDTO>> getMostActiveDaysOfWeek() {
        List<ReportResponseDTO> response = reportService.getMostActiveDaysOfWeek();
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/hourly-booking-trends")
    public ResponseEntity<List<ReportResponseDTO>> getHourlyBookingTrends() {
        List<ReportResponseDTO> response = reportService.getHourlyBookingTrends();
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/top-actions-by-user")
    public ResponseEntity<List<ReportResponseDTO>> getTopActionsByUser(@RequestParam String username) {
        List<ReportResponseDTO> response = reportService.getTopActionsBySpecificUser(username);
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/avg-actions-per-user")
    public ResponseEntity<ReportResponseDTO> getAvgActionsPerUser() {
        ReportResponseDTO response = reportService.getAvgActionsPerUser();
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/users-with-more-than-ten-actions")
    public ResponseEntity<List<ReportResponseDTO>> getUsersWithMoreThanTenActions() {
        List<ReportResponseDTO> response = reportService.getUsersWithMoreThanTenActions();
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/distribution-of-actions-past-month")
    public ResponseEntity<List<ReportResponseDTO>> getDistributionOfActionsPastMonth() {
        List<ReportResponseDTO> response = reportService.getDistributionOfActionsPastMonth();
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/avg-time-between-actions-per-user")
    public ResponseEntity<List<ReportResponseDTO>> getAvgTimeBetweenActionsPerUser() {
        List<ReportResponseDTO> response = reportService.getAvgTimeBetweenActionsPerUser();
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/most-frequent-action-sequences")
    public ResponseEntity<List<ReportResponseDTO>> getMostFrequentActionSequences() {
        List<ReportResponseDTO> response = reportService.getMostFrequentActionSequences();
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/user-retention-rate")
    public ResponseEntity<ReportResponseDTO> getUserRetentionRate() {
        ReportResponseDTO response = reportService.getUserRetentionRate();
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/actions-leading-to-cancellations")
    public ResponseEntity<List<ReportResponseDTO>> getActionsLeadingToCancellations() {
        List<ReportResponseDTO> response = reportService.getActionsLeadingToCancellations();
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/monthly-active-users")
    public ResponseEntity<List<ReportResponseDTO>> getMonthlyActiveUsers() {
        List<ReportResponseDTO> response = reportService.getMonthlyActiveUsers();
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/weekly-active-users")
    public ResponseEntity<List<ReportResponseDTO>> getWeeklyActiveUsers() {
        List<ReportResponseDTO> response = reportService.getWeeklyActiveUsers();
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/daily-active-users")
    public ResponseEntity<List<ReportResponseDTO>> getDailyActiveUsers() {
        List<ReportResponseDTO> response = reportService.getDailyActiveUsers();
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/correlation-between-actions-and-ratings")
    public ResponseEntity<List<ReportResponseDTO>> getCorrelationBetweenActionsAndRatings() {
        List<ReportResponseDTO> response = reportService.getCorrelationBetweenActionsAndRatings();
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/actions-leading-to-high-ratings")
    public ResponseEntity<List<ReportResponseDTO>> getActionsLeadingToHighRatings() {
        List<ReportResponseDTO> response = reportService.getActionsLeadingToHighRatings();
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/time-to-first-action-after-signup")
    public ResponseEntity<List<ReportResponseDTO>> getTimeToFirstActionAfterSignup() {
        List<ReportResponseDTO> response = reportService.getTimeToFirstActionAfterSignup();
        return ResponseEntity.ok(response);
    }
}
