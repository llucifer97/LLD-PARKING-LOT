package model;

import java.time.ZonedDateTime;

public class Ticket {
    String id;
    Slot slot;
    ZonedDateTime issuedAt;
    ZonedDateTime expiredAt;

    public Ticket(String id, Slot slot, ZonedDateTime issuedAt) {
        this.id = id;
        this.slot = slot;
        this.issuedAt = issuedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlotId(Slot slot) {
        this.slot = slot;
    }

    public ZonedDateTime getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(ZonedDateTime issuedAt) {
        this.issuedAt = issuedAt;
    }

    public ZonedDateTime getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(ZonedDateTime expiredAt) {
        this.expiredAt = expiredAt;
    }

    public boolean expireTicket(Ticket ticket) {
        ticket.setExpiredAt(ZonedDateTime.now());
        return true;
    }
}
