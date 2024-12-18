import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.stream.Stream;

public class BubbleSortApp extends JFrame {
    private JTextField inputField;
    private JTextArea resultArea;

    public BubbleSortApp() {
        setTitle("Bubble Sort Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Панель ввода
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 1));

        inputPanel.add(new JLabel("Введите массив (через пробел):"));
        inputField = new JTextField();
        inputPanel.add(inputField);

        JButton sortButton = new JButton("Сортировать");
        inputPanel.add(sortButton);

        add(inputPanel, BorderLayout.NORTH);

        // Область для вывода результатов
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        // Действие для кнопки сортировки
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputField.getText();
                try {
                    double[] arr = parseInput(inputText); // Парсим входной текст в массив

                    resultArea.setText("Исходный массив: " + Arrays.toString(arr) + "\n");

                    BubbleSort.sort(arr); // Сортируем массив

                    resultArea.append("Отсортированный массив: " + Arrays.toString(arr));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(BubbleSortApp.this, "Ошибка: Проверьте формат ввода. Введите числа, разделенные пробелом.");
                }
            }
        });

        setVisible(true);
    }
    private double[] parseInput(String input) throws NumberFormatException {
        String[] tokens = input.split("\\s+"); // Разделение по пробелам
        return Stream.of(tokens)
                .map(String::trim)
                .mapToDouble(Double::parseDouble) // Преобразование в double
                .toArray();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BubbleSortApp());
    }
}