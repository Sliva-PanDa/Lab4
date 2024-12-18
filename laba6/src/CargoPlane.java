class CargoPlane extends Airplane {
    public CargoPlane(int passengers, double fuel, String flightName) {
        super(passengers, fuel, flightName);
    }

    @Override
    public double calculateFuelConsumption() {
        return fuel * 0.5; // Расход топлива для грузового самолета
    }
}