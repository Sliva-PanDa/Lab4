class MilitaryPlane extends Airplane {
    public MilitaryPlane(int passengers, double fuel, String flightName) {
        super(passengers, fuel, flightName);
    }

    @Override
    public double calculateFuelConsumption() {
        return fuel * 0.124; // Расход топлива для военного самолета
    }
}