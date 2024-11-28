import java.util.ArrayList;
import java.util.List;

public class Airport {
    public static void main(String[] args) {
        List<Airplane> airplanes = new ArrayList<>();
        airplanes.add(new PassengerPlane(150, 5000, "Airbus A220-300"));
        airplanes.add(new CargoPlane(2, 8000, "Flight B456"));
        airplanes.add(new MilitaryPlane(2, 100, "F-15C"));

        System.out.println("Расход топлива пассажирского самолета: " + airplanes.get(0).calculateFuelConsumption());
        System.out.println("Расход топлива грузового самолета: " + airplanes.get(1).calculateFuelConsumption());
        System.out.println("Расход топлива военного самолета: " + airplanes.get(2).calculateFuelConsumption());

        int passengerThreshold = 100;
        char bykva1 = 'F';

        System.out.println("Самолеты с количеством пассажиров меньше " + passengerThreshold + ":");
        for (Airplane airplane : airplanes) {
            if (airplane.getPassengers() < passengerThreshold) {
                System.out.println(airplane.getFlightName());
            }
        }

        System.out.println("Самолеты, название которых начинается с буквы " + bykva1 + ":");
        for (Airplane airplane : airplanes) {
            if (airplane.getFlightName().charAt(0) == bykva1) {
                System.out.println(airplane.getFlightName());
            }
        }
    }
}
