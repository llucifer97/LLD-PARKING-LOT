package model;


import Enum.*;

public class Slot {
    String id;
    public SlotStatus slotStatus;
    public VehicleType vehicleType;

    public Slot(String id, SlotStatus slotStatus, VehicleType vehicleType) {
        this.id = id;
        this.slotStatus = slotStatus;
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SlotStatus getSlotStatus() {
        return slotStatus;
    }

    public void setSlotStatus(SlotStatus slotStatus) {
        this.slotStatus = slotStatus;
    }


}
