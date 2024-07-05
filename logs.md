# User Action Logging in Taxi Booking Framework

## Overview

This document lists all the user actions being logged in the Taxi Booking Framework, including the purpose of each log.

## 1. Booking Service

### BookingControllerImpl.java

- **Log**: "create booking"
  - **Purpose**: Logs when a user creates a new booking.
- **Log**: "update booking"
  - **Purpose**: Logs when a user updates an existing booking.
- **Log**: "cancel booking"
  - **Purpose**: Logs when a user cancels a booking.

### BookingCreationServiceImpl.java

- **Log**: "create booking"
  - **Purpose**: Logs the service-level action for creating a new booking.
- **Log**: "update booking"
  - **Purpose**: Logs the service-level action for updating an existing booking.
- **Log**: "cancel booking"
  - **Purpose**: Logs the service-level action for canceling a booking.

## 2. Dispatch Service

### DispatchControllerImpl.java

- **Log**: "assign driver to booking {bookingId}"
  - **Purpose**: Logs when a driver is assigned to a booking.
- **Log**: "update driver location"
  - **Purpose**: Logs when a driver updates their location.

### FindCarServiceImpl.java

- **Log**: "assign driver to booking {bookingId}"
  - **Purpose**: Logs the service-level action for assigning a driver to a booking.
- **Log**: "update driver location"
  - **Purpose**: Logs the service-level action for updating a driver's location.

## 3. Fleet Service

### FleetControllerImpl.java

- **Log**: "register vehicle"
  - **Purpose**: Logs when a vehicle is registered.
- **Log**: "update vehicle status to {status}"
  - **Purpose**: Logs when a vehicle's status is updated.

### FleetServiceImpl.java

- **Log**: "register vehicle"
  - **Purpose**: Logs the service-level action for registering a vehicle.
- **Log**: "update vehicle status to {status}"
  - **Purpose**: Logs the service-level action for updating a vehicle's status.

## 4. Pricing Service

### ExtendedPricingController.java

- **Log**: "calculate price"
  - **Purpose**: Logs when a user requests a price calculation.
- **Log**: "update pricing"
  - **Purpose**: Logs when a user updates pricing details.

### ExtendedPricingService.java

- **Log**: "calculate price"
  - **Purpose**: Logs the service-level action for calculating price.
- **Log**: "update pricing"
  - **Purpose**: Logs the service-level action for updating pricing details.

## Summary

This logging system ensures that critical user actions across different services in the Taxi Booking Framework are tracked for analytics and debugging purposes. The logs provide insights into user behavior, system performance, and potential areas for improvement.
