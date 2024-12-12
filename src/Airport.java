import java.util.ArrayList;
import java.util.List;

// Главный класс для запуска программы
public class Airport {
    public static void main(String[] args) {
        AirplaneRepository repository = new AirplaneRepository();

        // Добавление самолетов в репозиторий
        repository.addAirplane(new PassengerPlane(150, 5000, "Airbus A220-300"));
        repository.addAirplane(new CargoPlane(2, 8000, "Flight B456"));
        repository.addAirplane(new MilitaryPlane(2, 100, "F-15C"));

        // Показать расход топлива для каждого самолета
        for (Airplane airplane : repository.getAirplanes()) {
            System.out.println("Расход топлива " + airplane.getFlightName() + ": " + airplane.calculateFuelConsumption());
        }

        // Порог для количества пассажиров
        int passengerThreshold = 100;
        char bykva1 = 'F';

        // Показать самолеты с количеством пассажиров меньше порога
        System.out.println("Самолеты с количеством пассажиров меньше " + passengerThreshold + ":");
        for (Airplane airplane : repository.getAirplanes()) {
            if (airplane.getPassengers() < passengerThreshold) {
                System.out.println(airplane.getFlightName());
            }
        }

        // Показать самолеты, названия которых начинаются с определенной буквы
        System.out.println("Самолеты, название которых начинается с буквы " + bykva1 + ":");
        for (Airplane airplane : repository.getAirplanes()) {
            if (airplane.getFlightName().charAt(0) == bykva1) {
                System.out.println(airplane.getFlightName());
            }
        }
    }
}