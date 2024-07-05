package com.taxi.pricing.controller;

import com.taxi.framework.pricing.controller.AbstractPricingController;
import com.taxi.framework.pricing.service.AbstractPricingServiceImpl;
import com.taxi.pricing.dto.ExtendedBasePricingDto;
import com.taxi.pricing.dto.ExtendedBaseResponsePricingDto;
import com.taxi.user.logging.UserActionLogger;
import com.taxi.pricing.service.ExtendedPricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/pricing")
@RestController
public class ExtendedPricingController extends AbstractPricingController<ExtendedBasePricingDto, ExtendedBaseResponsePricingDto> {

    @Autowired
    private UserActionLogger userActionLogger;

    @Autowired
    private ExtendedPricingService pricingService;

    protected ExtendedPricingController(AbstractPricingServiceImpl<ExtendedBasePricingDto, ExtendedBaseResponsePricingDto> pricingService, UserActionLogger userActionLogger) {
        super(pricingService);
        this.userActionLogger = userActionLogger;
    }

    @PostMapping("/calculate")
    public ResponseEntity<?> calculatePrice(@RequestBody ExtendedBasePricingDto pricingDto) {
        userActionLogger.logUserAction(pricingDto.getUserId(), "calculate price");
        ExtendedBaseResponsePricingDto response = pricingService.getResponse(pricingDto);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updatePricing(@RequestBody ExtendedBasePricingDto pricingDto) {
        userActionLogger.logUserAction(pricingDto.getUserId(), "update pricing");
        pricingService.updatePricing(pricingDto);
        return ResponseEntity.ok("Pricing updated");
    }
}
