import Pricing.GenericPricing;
import Pricing.ParkingLotPricing;
import model.*;

import java.util.ArrayList;
import java.util.List;
import Enum.*;
import service.CustomerService;
import service.ParkingLotService;
import service.VehicleService;

public class Main {


    public static void main(String[] args) {

        List<Slot> slotList = new ArrayList<>();
        for(int i = 0; i< 1; i++) {
            slotList.add(new Slot(String.valueOf(i) , SlotStatus.VACANT,VehicleType.CAR));
        }

        ParkingLot parkingLot = new ParkingLot(slotList);


        CustomerService customerService = new CustomerService();
        Customer c1 = customerService.createCustomer("123");
        Customer c2 = customerService.createCustomer("456");

        VehicleService vehicleService = new VehicleService();
        Vehicle v1 = vehicleService.registerVehicle("1",VehicleType.CAR,c1);
        Vehicle v2 = vehicleService.registerVehicle("1",VehicleType.CAR,c1);
        ParkingLotPricing parkingLotPricing = new GenericPricing();
        ParkingLotService parkingLotService = new ParkingLotService(parkingLot,parkingLotPricing);



//        try {
//            Ticket ticket = parkingLotService.issueTicket(v2);
//            parkingLotService.processTicket(ticket);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }


        Runnable task1 = () -> {
            try {
                Ticket ticket = parkingLotService.issueTicket(v1);
                parkingLotService.processTicket(ticket);
                System.out.println(Thread.currentThread().getName()
                        + " parked vehicle " + v1.getId());
            } catch (Exception e) {
                System.out.println(Thread.currentThread().getName()
                        + " failed to park vehicle " + v1.getId());
            }
        };

        Runnable task2 = () -> {
            try {
                Ticket ticket = parkingLotService.issueTicket(v2);
                parkingLotService.processTicket(ticket);
                System.out.println(Thread.currentThread().getName()
                        + " parked vehicle " + v2.getId());
            } catch (Exception e) {
                System.out.println(Thread.currentThread().getName()
                        + " failed to park vehicle " + v2.getId());
            }
        };

        Thread t1 = new Thread(task1, "Thread-1");
        Thread t2 = new Thread(task2, "Thread-2");

        t1.start();
        t2.start();




    }
}
