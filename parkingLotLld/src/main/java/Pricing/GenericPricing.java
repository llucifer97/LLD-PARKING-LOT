package Pricing;

import model.Ticket;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.ZonedDateTime;

public class GenericPricing implements ParkingLotPricing{
    @Override
    public BigDecimal calculatePrice(Ticket ticket) {
        Duration duration = Duration.between(ticket.getIssuedAt(), ZonedDateTime.now());
        return BigDecimal.valueOf(duration.toNanos()*50);
    }
}
