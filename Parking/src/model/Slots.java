package model;

public class Slots {
    private String slotNo;
    private String slotVehicleType;
    private String slotStatus;

    public Slots() {
    }

    public Slots(String slotNo, String slotVehicleType, String slotStatus) {
        this.slotNo = slotNo;
        this.slotVehicleType = slotVehicleType;
        this.slotStatus = slotStatus;
    }

    public String getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(String slotNo) {
        this.slotNo = slotNo;
    }

    public String getSlotVehicleType() {
        return slotVehicleType;
    }

    public void setSlotVehicleType(String slotVehicleType) {
        this.slotVehicleType = slotVehicleType;
    }

    public String getSlotStatus() {
        return slotStatus;
    }

    public void setSlotStatus(String slotStatus) {
        this.slotStatus = slotStatus;
    }
}
