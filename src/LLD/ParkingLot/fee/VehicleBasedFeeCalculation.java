package LLD.ParkingLot.fee;

import LLD.ParkingLot.Ticket;
import LLD.ParkingLot.vehicle.VehicleType;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author parachau
 **/
public class VehicleBasedFeeCalculation implements FeeCalculationStrategy{
    private Map<VehicleType, Double> hourlyRates;

    public VehicleBasedFeeCalculation() {
        hourlyRates = new HashMap<>();
        hourlyRates.put(VehicleType.BIKE, 5.0);
        hourlyRates.put(VehicleType.AUTO, 10.0);
        hourlyRates.put(VehicleType.CAR, 20.0);
        hourlyRates.put(VehicleType.TRUCK, 50.0);
    }
    @Override
    public double calculateFee(Ticket ticket) {
        long duration = ticket.getExitTime() - ticket.getEntryTime();
        long hours = duration/(1000 * 60 * 60) + 1;
        return hours * hourlyRates.get(ticket.getVehicle().getVehicleType());
    }
}
