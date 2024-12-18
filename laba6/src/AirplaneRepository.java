import java.util.ArrayList;
import java.util.List;

class AirplaneRepository {
    private List<Airplane> airplanes;

    public AirplaneRepository() {
        airplanes = new ArrayList<>();
    }

    public void addAirplane(Airplane airplane) {
        airplanes.add(airplane);
    }

    public void removeAirplane(String flightName) {
        airplanes.removeIf(airplane -> airplane.getFlightName().equals(flightName));
    }

    public void updateAirplane(String flightName, int newPassengers, double newFuel) {
        for (Airplane airplane : airplanes) {
            if (airplane.getFlightName().equals(flightName)) {
                airplane.passengers = newPassengers;
                airplane.fuel = newFuel;
                break;
            }
        }
    }

    public List<Airplane> getAirplanes() {
        return airplanes;
    }
}