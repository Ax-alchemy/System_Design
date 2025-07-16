package LLD.ParkingLot.fee;

import LLD.ParkingLot.Ticket;

/**
 * @author parachau
 **/
public interface FeeCalculationStrategy {
    double calculateFee(Ticket ticket);
}
