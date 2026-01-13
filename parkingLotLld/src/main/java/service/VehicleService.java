package service;

import model.Customer;
import model.Vehicle;

import java.util.ArrayList;
import java.util.List;
import Enum.VehicleType;

public class VehicleService {
    List<Vehicle>  vehicles;

    public VehicleService() {
        vehicles = new ArrayList<>();
    }

    public Vehicle registerVehicle(String id, VehicleType vehicleType, Customer customer){
        Vehicle vehicle = new Vehicle(id,vehicleType,customer);
        vehicles.add(vehicle);
        return vehicle;
    }


    public Vehicle getCustomerInfo(String id) {
        return vehicles.stream().filter(i -> i.getId().equals(id)).findAny().orElse(null);
    }

}
