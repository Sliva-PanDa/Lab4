import java.util.ArrayList; // Импорт для использования ArrayList
import java.util.List; // Импорт для использования List

// Класс-репозиторий для управления самолетами
class AirplaneRepository {
    private List<Airplane> airplanes; // Коллекция самолетов

    public AirplaneRepository() {
        airplanes = new ArrayList<>(); // Инициализация списка
    }

    // Метод для добавления самолета в коллекцию
    public void addAirplane(Airplane airplane) {
        airplanes.add(airplane);
    }

    // Метод для удаления самолета из коллекции по названию рейса
    public void removeAirplane(String flightName) {
        airplanes.removeIf(airplane -> airplane.getFlightName().equals(flightName));
    }

    // Метод для обновления данных самолета
    public void updateAirplane(String flightName, int newPassengers, double newFuel) {
        for (Airplane airplane : airplanes) {
            if (airplane.getFlightName().equals(flightName)) {
                airplane.passengers = newPassengers; // Обновление количества пассажиров
                airplane.fuel = newFuel; // Обновление расхода топлива
                break;
            }
        }
    }

    // Метод для получения списка самолетов
    public List<Airplane> getAirplanes() {
        return airplanes;
    }
}