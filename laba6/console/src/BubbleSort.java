public class BubbleSort {
    public static void sort(double[] array) { // Используем double[]
        boolean swapped;
        for (int i = 0; i < array.length - 1; i++) {
            swapped = false; // Сброс флага на каждом проходе
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    double temp = array[j]; // Используем double
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true; // Установка флага, если произошла перестановка
                }
            }
            // Если не было перестановок, массив уже отсортирован
            if (!swapped) break;
        }
    }
}