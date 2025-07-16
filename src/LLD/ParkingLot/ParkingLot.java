package LLD.ParkingLot;

import LLD.ParkingLot.fee.FeeCalculationStrategy;
import LLD.ParkingLot.fee.FlatRateFeeStrategy;
import LLD.ParkingLot.parkingSpot.ParkingSpot;
import LLD.ParkingLot.vehicle.Vehicle;

import java.util.*;

/**
 * @author parachau
 **/
public class ParkingLot {
    private String id;
    private List<Floor> floorList;
    private FeeCalculationStrategy feeCalculationStrategy;
    private Map<String,Ticket> activeTickets;

    private ParkingLot(){
        this.id = UUID.randomUUID().toString();
        floorList = new ArrayList<>();
        activeTickets = new HashMap<>();
        feeCalculationStrategy = new FlatRateFeeStrategy();
    }

    private static class InstanceHelper{
        private static final ParkingLot instance = new ParkingLot();
    }

    public static ParkingLot getInstance(){
        return InstanceHelper.instance;
    }

    public void addFloor(Floor floor){
        floorList.add(floor);
    }

    public void setFeeCalculationStrategy(FeeCalculationStrategy feeCalculationStrategy){
        this.feeCalculationStrategy = feeCalculationStrategy;
    }

    public synchronized Ticket parkVehicle(Vehicle vehicle) throws Exception {
        for(Floor floor : floorList){
            Optional<ParkingSpot> parkingSpot = floor.getAvailableParkingSpot(vehicle);
            if(parkingSpot.isPresent()) {
                ParkingSpot spot = parkingSpot.get();
                if(spot.assignVehicle(vehicle)){
                    Ticket ticket = new Ticket(vehicle, spot);
                    System.out.println("Parked vehicle " + ticket.toEntryTicketString());
                    activeTickets.put(vehicle.getNumberPlate(),ticket);
                    return ticket;
                }
            }
        }
        throw new Exception("No parking spot found for vehicle " + vehicle);
    }

    public synchronized double unparkVehicle(String numberPlate) throws Exception {
        Ticket ticket = activeTickets.remove(numberPlate);
        if(ticket == null){ throw new Exception("Ticket not found"); }
        ticket.setExitTime();
        double fee = feeCalculationStrategy.calculateFee(ticket);
        System.out.println("Fee for " + ticket.toExitTicketString() + " is " + fee);
        ticket.getParkingSpot().removeVehicle();
        return fee;
    }


}
