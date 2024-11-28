public class PassengerPlane extends Airplane {
    public PassengerPlane(int passengers, double fuel, String flightName) {
        super(passengers, fuel, flightName);
    }

    @Override
    public double calculateFuelConsumption() {
        return fuel * 0.39;
    }
}
