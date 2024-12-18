import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AirportApp extends JFrame {
    private AirplaneRepository repository;
    private DefaultListModel<String> airplaneListModel;
    private JList<String> airplaneList;
    private JTextField flightNameField;
    private JTextField passengersField;
    private JTextField fuelField;
    private JComboBox<String> airplaneTypeComboBox;
    private JTextArea fuelConsumptionArea;

    public AirportApp() {
        repository = new AirplaneRepository();
        airplaneListModel = new DefaultListModel<>();

        setTitle("Airport Manager");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Панель ввода
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));

        inputPanel.add(new JLabel("Тип самолета:"));
        airplaneTypeComboBox = new JComboBox<>(new String[]{"Пассажирский", "Грузовой", "Военный"});
        inputPanel.add(airplaneTypeComboBox);

        inputPanel.add(new JLabel("Название рейса:"));
        flightNameField = new JTextField();
        inputPanel.add(flightNameField);

        inputPanel.add(new JLabel("Пассажиры:"));
        passengersField = new JTextField();
        inputPanel.add(passengersField);

        inputPanel.add(new JLabel("Топливо:"));
        fuelField = new JTextField();
        inputPanel.add(fuelField);

        // Кнопки
        JButton addButton = new JButton("Добавить Самолет");
        JButton updateButton = new JButton("Обновить Самолет");
        JButton removeButton = new JButton("Удалить Самолет");

        inputPanel.add(addButton);
        inputPanel.add(updateButton);

        // Список самолетов
        airplaneList = new JList<>(airplaneListModel);
        JScrollPane scrollPane = new JScrollPane(airplaneList);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(removeButton, BorderLayout.SOUTH);

        // Область для отображения расхода топлива
        fuelConsumptionArea = new JTextArea();
        fuelConsumptionArea.setEditable(false);
        add(new JScrollPane(fuelConsumptionArea), BorderLayout.EAST);

        // Обработчики событий для кнопок
        addButton.addActionListener(e -> addAirplane());
        updateButton.addActionListener(e -> updateAirplane());
        removeButton.addActionListener(e -> removeAirplane());

        updateAirplaneList();
        setVisible(true);
    }

    private void addAirplane() {
        String flightName = flightNameField.getText();
        int passengers;
        double fuel;
        try {
            passengers = Integer.parseInt(passengersField.getText());
            fuel = Double.parseDouble(fuelField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Неправильный формат данных!");
            return;
        }

        Airplane newAirplane;
        String selectedType = (String) airplaneTypeComboBox.getSelectedItem();
        switch (selectedType) {
            case "Пассажирский":
                newAirplane = new PassengerPlane(passengers, fuel, flightName);
                break;
            case "Грузовой":
                newAirplane = new CargoPlane(passengers, fuel, flightName);
                break;
            case "Военный":
                newAirplane = new MilitaryPlane(passengers, fuel, flightName);
                break;
            default:
                throw new IllegalStateException("Неизвестный тип самолета");
        }

        repository.addAirplane(newAirplane);
        updateAirplaneList();
        displayFuelConsumption(newAirplane);
        clearFields();
    }

    private void updateAirplane() {
        int selectedIndex = airplaneList.getSelectedIndex();
        if (selectedIndex != -1) {
            String flightName = flightNameField.getText();
            int passengers;
            double fuel;
            try {
                passengers = Integer.parseInt(passengersField.getText());
                fuel = Double.parseDouble(fuelField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Неправильный формат данных!");
                return;
            }

            repository.updateAirplane(repository.getAirplanes().get(selectedIndex).getFlightName(), passengers, fuel);
            updateAirplaneList();
            clearFields();
        }
    }

    private void removeAirplane() {
        int selectedIndex = airplaneList.getSelectedIndex();
        if (selectedIndex != -1) {
            repository.removeAirplane(repository.getAirplanes().get(selectedIndex).getFlightName());
            updateAirplaneList();
        }
    }

    private void updateAirplaneList() {
        airplaneListModel.clear();
        List<Airplane> airplanes = repository.getAirplanes();
        for (Airplane airplane : airplanes) {
            airplaneListModel.addElement(airplane.getFlightName());
        }
    }

    private void displayFuelConsumption(Airplane airplane) {
        fuelConsumptionArea.append("Расход топлива " + airplane.getFlightName() + ": " + airplane.calculateFuelConsumption() + "\n");
    }

    private void clearFields() {
        flightNameField.setText("");
        passengersField.setText("");
        fuelField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AirportApp::new);
    }
}