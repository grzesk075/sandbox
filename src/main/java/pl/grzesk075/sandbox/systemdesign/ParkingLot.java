package pl.grzesk075.sandbox.systemdesign;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

enum Size {
    CAR,
    VAN,
    BUS,
    TRUCK
}

/**
 * Design a Parking Lot.
 * 1. Handling ambiguity. Ask general questions.
 * What it looks like? Is this open space or building with multiple levels? Is it free or paid?
 * Are there premium spots? How many spots, entrances and exits? How many acceptable vehicle sizes?
 * 2. Systematic approach. Ask system design questions.
 * Do we want class diagram or some code? Choose and discuss data structure, lookups and complexity.
 * Preferable is O(1) - big o (ou) of one.
 * Design dictionaries in enums and data flow in functions.
 */
public class ParkingLot {

    Map<Size, List<Spot>> freeSpots; //persistent hash map

    Map<Vehicle, Spot> occupiedSpots; //persistent hash map

    List<Gate> gates;

    List<CashRegister> cashRegisters;

    List<Receipt> archivedReceipts; //persistent list with retention policy

    public ParkingLot(Path config) {
    }

    synchronized Spot placeVehicle(Vehicle vehicle) {
        final List<Spot> spots = freeSpots.get(vehicle.size);
        if (spots.isEmpty()) {
            throw new RuntimeException("No available slots of this size.");
        }
        final Spot spot = spots.remove(0);
        occupiedSpots.put(vehicle, spot);
        return spot;
    }

    void removeVehicle(Vehicle vehicle) {
        final Spot spot = occupiedSpots.remove(vehicle);
        final List<Spot> spots = freeSpots.get(vehicle.size);
        spots.add(spot);
    }
}

class Spot {
    int id;
    Size size;
}

class Vehicle {
    String licensePlate;
    Size size;

    public Vehicle(final String licensePlate, final Size size) {

    }

    //hashCode, equals using natural composite key
}

class Gate {
    int id;
    ParkingLot parkingLot;

    Ticket placeVehicle(String licensePlate, Size size) {
        final Spot spot = parkingLot.placeVehicle(new Vehicle(licensePlate, size));
        return new Ticket();
    }

    void releaseVehicle(Ticket ticket) {
        if (ticket.paid) {
            parkingLot.removeVehicle(ticket.vehicle);
        } else {
            //Ticket not paid.
        }
    }
}

class Receipt {
    long id;
    LocalDateTime issueTime;
    LocalDateTime fromTime;
    LocalDateTime toTime;
    String licensePlate;
    int price; //dollars
    byte priceFraction; //cents
    String isoCurrencyCode;  //ISO 4217 currency code
}

class Ticket {
    long id;
    boolean paid;
    Vehicle vehicle;
    String customerInfo;
}

class CashRegister {
    int id;
    Tariff tariff;
}

class Tariff {
    String isoCurrencyCode;  //ISO 4217 currency code
    Object priceList;
}

//Optionally sensors of vehicle with lights to show route from gate to spot and vice versa.