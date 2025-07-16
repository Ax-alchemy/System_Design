package LLD.ParkingLot;

import LLD.ParkingLot.parkingSpot.ParkingSpot;
import LLD.ParkingLot.vehicle.Vehicle;

import java.util.Date;
import java.util.UUID;

/**
 * @author parachau
 **/
public class Ticket {
    private String ticketId;
    private long entryTime;
    private long exitTime;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;

    Ticket(Vehicle vehicle,ParkingSpot parkingSpot) {
        this.ticketId = UUID.randomUUID().toString();
        this.entryTime = new Date().getTime();
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;
    }

    public String getTicketId() {
        return ticketId;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public long getExitTime() {
        return exitTime;
    }

    public void setExitTime() {
        this.exitTime = new Date().getTime();
    }


    public String toEntryTicketString() {
        return "Ticket{" +
                "entryTime=" + entryTime +
                ", vehicle=" + vehicle.toString() +
                ", parkingSpot=" + parkingSpot.toString() +
                '}';
    }

    public String toExitTicketString(){
        return "Ticket{" +
                "entryTime=" + entryTime +
                ", exitTime=" + exitTime +
                ", vehicle=" + vehicle.toString() +
                ", parkingSpot=" + parkingSpot.toString() +
                '}';
    }
}
