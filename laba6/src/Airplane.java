// Класс, представляющий общий самолет
class Airplane {
    protected int passengers;
    protected double fuel;
    protected String flightName;

    public Airplane(int passengers, double fuel, String flightName) {
        this.passengers = passengers;
        this.fuel = fuel;
        this.flightName = flightName;
    }

    public int getPassengers() {
        return passengers;
    }

    public String getFlightName() {
        return flightName;
    }

    public double calculateFuelConsumption() {
        return 0; // Базовый метод, который будет переопределен в подклассах
    }
}