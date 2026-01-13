package Pricing;

import model.Ticket;

import java.math.BigDecimal;

public interface ParkingLotPricing {
    BigDecimal calculatePrice(Ticket ticket);
}
