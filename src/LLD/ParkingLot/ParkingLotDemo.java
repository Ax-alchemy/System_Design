package LLD.ParkingLot;

import LLD.ParkingLot.fee.FeeCalculationStrategy;
import LLD.ParkingLot.fee.FlatRateFeeStrategy;
import LLD.ParkingLot.fee.VehicleBasedFeeCalculation;
import LLD.ParkingLot.parkingSpot.BikeSpot;
import LLD.ParkingLot.parkingSpot.CompactSpot;
import LLD.ParkingLot.parkingSpot.LargeSpot;
import LLD.ParkingLot.parkingSpot.ParkingSpot;
import LLD.ParkingLot.vehicle.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author parachau
 **/
public class ParkingLotDemo{
    public static void main(String[] args) {
        try {
            ParkingLot parkingLot = getParkingLot();

            Vehicle bike1 = new Bike("UP17A1001");
            Vehicle bike2 = new Bike("UP17A1002");
            Vehicle car1 = new Car("UP17AB1003");
            Vehicle car2 = new Car("UP17AB1004");
            Vehicle car3 = new Car("UP17AB1005");
            Vehicle car4 = new Auto("UP17AB1006");
            Vehicle truck1 = new Truck("UP17AB1007");

            Ticket t1 = parkingLot.parkVehicle(bike1);
            Thread.sleep(1000);
            Ticket t2 = parkingLot.parkVehicle(bike2);
            Thread.sleep(2000);
            double fee = parkingLot.unparkVehicle(bike1.getNumberPlate());

            Ticket t3 = parkingLot.parkVehicle(car1);
            Ticket t4 = parkingLot.parkVehicle(car2);
            Thread.sleep(1000);
            Ticket t5 = parkingLot.parkVehicle(car3);
            Thread.sleep(2000);
            Ticket t6 = parkingLot.parkVehicle(car4);
            parkingLot.unparkVehicle(car2.getNumberPlate());
            parkingLot.unparkVehicle(car3.getNumberPlate());

            Ticket t7 = parkingLot.parkVehicle(truck1);
            Thread.sleep(1000);
            parkingLot.unparkVehicle(truck1.getNumberPlate());
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    private static ParkingLot getParkingLot() {
        ParkingLot parkingLot = ParkingLot.getInstance();
        ParkingSpot ps1 = new BikeSpot("f1_1");
        ParkingSpot ps2 = new CompactSpot("f1_2");
        ParkingSpot ps3 = new LargeSpot("f1_3");
        ParkingSpot ps4 = new LargeSpot("f1_4");
        ParkingSpot ps5 = new BikeSpot("f1_5");
        ParkingSpot ps6 = new BikeSpot("f2_1");
        ParkingSpot ps7 = new BikeSpot("f2_2");
        ParkingSpot ps8 = new CompactSpot("f2_3");
        ParkingSpot ps9 = new CompactSpot("f2_4");
        ParkingSpot ps10 = new LargeSpot("f2_5");

        Floor f1 = new Floor(1, List.of(ps1, ps2, ps3, ps4, ps5));
        Floor f2 = new Floor(2, List.of(ps6, ps7, ps8, ps9, ps10));
        parkingLot.addFloor(f1);
        parkingLot.addFloor(f2);

//        parkingLot.setFeeCalculationStrategy(new FlatRateFeeStrategy());
        parkingLot.setFeeCalculationStrategy(new VehicleBasedFeeCalculation());
        return parkingLot;
    }
}
