package model;

import Enum.*;

public class Vehicle {
    String id;
    public VehicleType vehicleType;
    Customer customer;

    public Vehicle(String id, VehicleType vehicleType, Customer customer) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.customer = customer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
