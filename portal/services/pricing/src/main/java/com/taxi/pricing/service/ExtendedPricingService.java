package com.taxi.pricing.service;

import com.taxi.framework.pricing.service.AbstractPricingServiceImpl;
import com.taxi.pricing.dto.ExtendedBasePricingDto;
import com.taxi.pricing.dto.ExtendedBaseResponsePricingDto;
import com.taxi.user.logging.UserActionLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.micrometer.core.annotation.Timed;


@Service
public class ExtendedPricingService extends AbstractPricingServiceImpl<ExtendedBasePricingDto, ExtendedBaseResponsePricingDto> {

    @Autowired
    private UserActionLogger userActionLogger;

    @Override
    @Timed(value = "pricing.get_response", description = "Tracks the time taken to calculate and respond with pricing information")
    public ExtendedBaseResponsePricingDto getResponse(ExtendedBasePricingDto dto) {
        userActionLogger.logUserAction(dto.getUserId(), "calculate price");
        ExtendedBaseResponsePricingDto extendedBaseResponsePricingDto = new ExtendedBaseResponsePricingDto();
        extendedBaseResponsePricingDto.setTravelPrice(calculateTravelCost(dto));
        extendedBaseResponsePricingDto.setUserId(dto.getUserId());
        return extendedBaseResponsePricingDto;
    }

    @Override
    public double offPrice(String code, double price) {
        return price;
    }

    @Override
    public double checkRainyCost() {
        return 1.2;
    }

    @Override
    public double checkSnowyCost() {
        return 1.3;
    }

    public void updatePricing(ExtendedBasePricingDto pricingDto) {
        userActionLogger.logUserAction(pricingDto.getUserId(), "update pricing");
        // Implement the logic for updating pricing
    }
}
