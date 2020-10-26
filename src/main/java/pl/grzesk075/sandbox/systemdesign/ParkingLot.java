package pl.grzesk075.sandbox.systemdesign;

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
public class ParkingLot {  // Singleton
    Spot placeVehicle(Vehicle vehicle) {
    }

    void removeVehicle(Vehicle vehicle) {
    }
}

class Spot {
    int id;
    Size size;
}

class Vehicle {
    String licensePlate;
    Size size;
}

class Gate {
    int id;
}

class Receipt {
    long id;
}

class Ticket {
    long id;
}

class CashRegister {
    long id;
}

//Optionally sensors of vehicle with lights to show route from gate to spot and vice versa.