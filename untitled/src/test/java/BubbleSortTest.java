import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;
import org.example.BubbleSort;

public class BubbleSortTest {

    @Test
    public void testSortEmptyArray() {
        int[] array = {};
        BubbleSort.sort(array);
        int[] expected = {};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testSortSingleElementArray() {
        int[] array = {1};
        BubbleSort.sort(array);
        int[] expected = {1};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testSortAlreadySortedArray() {
        int[] array = {1, 2, 3, 4, 5};
        BubbleSort.sort(array);
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testSortReverseSortedArray() {
        int[] array = {5, 4, 3, 2, 1};
        BubbleSort.sort(array);
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testSortUnsortedArray() {
        int[] array = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        BubbleSort.sort(array);
        int[] expected = {1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9};
        assertArrayEquals(expected, array);
    }
}
