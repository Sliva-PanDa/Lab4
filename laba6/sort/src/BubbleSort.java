import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BubbleSort {

    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Встроенный класс для тестирования
    public static class Tests {

        // Проводим тест на пустом массиве
        @Test
        public void testSortEmptyArray() {
            int[] array = new int[0];
            BubbleSort.sort(array);
            assertArrayEquals(new int[0], array);
        }

        // Тестируем массив с одним элементом
        @Test
        public void testSortSingleElementArray() {
            int[] array = { 1 };
            BubbleSort.sort(array);
            assertArrayEquals(new int[] { 1 }, array);
        }

        // Тестируем уже отсортированный массив
        @Test
        public void testSortAlreadySortedArray() {
            int[] array = { 1, 2, 3, 4, 5 };
            BubbleSort.sort(array);
            assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, array);
        }

        // Тестируем несортированный массив
        @Test
        public void testSortUnsortedArray() {
            int[] array = { 5, 3, 1, 4, 2 };
            BubbleSort.sort(array);
            assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, array);
        }

        // Тестируем массив с дубликатами
        @Test
        public void testSortArrayWithDuplicates() {
            int[] array = { 4, 2, 2, 5, 3 };
            BubbleSort.sort(array);
            assertArrayEquals(new int[] { 2, 2, 3, 4, 5 }, array);
        }
    }
}
