package LLD.ParkingLot.fee;

import LLD.ParkingLot.Ticket;

import java.util.Date;

/**
 * @author parachau
 **/
public class FlatRateFeeStrategy implements FeeCalculationStrategy{
    private final double RATE_PER_HOUR = 15.0;

    @Override
    public double calculateFee(Ticket ticket) {
        long duration = ticket.getExitTime() - ticket.getEntryTime();
        long hours = duration/(1000 * 60 * 60) + 1;
        return hours * RATE_PER_HOUR;
    }
}
