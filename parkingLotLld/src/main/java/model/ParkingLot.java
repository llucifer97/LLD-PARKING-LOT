package model;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import Enum.*;

public class ParkingLot {
    List<Slot> slotList;

    public ParkingLot(List<Slot> slotList) {
        this.slotList = slotList;
    }

    public Boolean isAvailable(Slot slot) {
        return slot.slotStatus.equals(SlotStatus.VACANT);
    }

    public Slot getAvailableSlot(VehicleType vehicleType){
            return slotList.stream()
                    .filter(slot -> slot.getVehicleType().equals(vehicleType))
                    .filter(slot -> slot.getSlotStatus().equals(SlotStatus.VACANT))
                    .findAny()
                    .orElse(null);
    }

    public Boolean freeSlot(Slot slot){
        slot.setSlotStatus(SlotStatus.VACANT);
        return true;
    }

    public Boolean acquireSlot(Slot slot) {
        if(slot.getSlotStatus().equals(SlotStatus.OCCUPIED)){
            throw new RuntimeException("slot is occupied match.try later");
        }
        slot.setSlotStatus(SlotStatus.OCCUPIED);
        return true;
    }

}
