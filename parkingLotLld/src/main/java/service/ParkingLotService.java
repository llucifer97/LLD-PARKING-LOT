package service;

import Pricing.ParkingLotPricing;
import model.*;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

public class ParkingLotService {
    ParkingLot parkingLot;

    ParkingLotPricing parkingLotPricing;

    private final ReentrantLock lock = new ReentrantLock(true); // shared lock

    public ParkingLotService(ParkingLot parkingLot, ParkingLotPricing parkingLotPricing) {
        this.parkingLot = parkingLot;
        this.parkingLotPricing = parkingLotPricing;
    }

    public Ticket issueTicket(Vehicle vehicle) throws Exception {

        lock.lock();
        try{
            Slot slot = parkingLot.getAvailableSlot(vehicle.vehicleType);
            if(slot == null) {
                throw new Exception("no parking lot is available...  ");
            }

            Boolean acquire = parkingLot.acquireSlot(slot);
            System.out.println("acquiring slot matcha " + slot.getId() + " "  );
            if(Boolean.FALSE.equals(acquire)){
                throw new Exception("not able to acquire slot for vehicle   " + vehicle.getId());
            }

            Ticket ticket = generateTicket(slot);
            List<Ticket> ticketList = vehicle.getCustomer().getTicketList();
            ticketList.add(ticket);
            vehicle.getCustomer().setTicketList(ticketList);
            return ticket;

        }
        finally {
            lock.unlock();
        }






    }

    private Ticket generateTicket(Slot slot) {
         return new Ticket(UUID.randomUUID().toString(),slot, ZonedDateTime.now());
    }

    public Boolean processTicket(Ticket ticket) throws Exception {

        lock.lock();
        try{
            validateTicket(ticket);
            BigDecimal bigDecimal = calculatePrice(ticket);
            System.out.println("cost is " + bigDecimal);
            freeSlot(ticket);
            expireTicket(ticket);
            return true;
        }
      finally {
            lock.unlock();
        }

    }

    private boolean expireTicket(Ticket ticket) {
        return ticket.expireTicket(ticket);
    }

    Boolean validateTicket(Ticket ticket) throws Exception {
         if(ticket.getExpiredAt() != null && ZonedDateTime.now().isAfter(ticket.getExpiredAt())){
             throw new Exception("ticket is expired,id: " + ticket.getId());
         }

        if(ZonedDateTime.now().isBefore(ticket.getIssuedAt())){
            throw new Exception("ticket is dummy,id: " + ticket.getId());
        }

        return true;
    }

    BigDecimal calculatePrice(Ticket ticket){
        return parkingLotPricing.calculatePrice(ticket);
    }

    Boolean freeSlot(Ticket ticket) {
       return parkingLot.freeSlot(ticket.getSlot());
    }



}
