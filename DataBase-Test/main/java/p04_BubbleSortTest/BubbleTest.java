package p04_BubbleSortTest;

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {

    @Test
    public void testNotSortedArrayPassedForSortingSortArrayAsc() {
        int[] arr = new int[]{16, 7, 89, 28, 10};
        Bubble.sort(arr);
        int[] expectedArr = new int[]{7, 10, 16, 28, 89};
        assertEquals(arr.length, expectedArr.length);
        assertArrayEquals(expectedArr, arr);
    }

    @Test
    public void testSortedArrayPassedToSortReturnSameArr() {
        int[] arr = new int[]{7, 10, 16, 28, 89};
        Bubble.sort(arr);
        int[] expectedArr = new int[]{7, 10, 16, 28, 89};
        assertArrayEquals(expectedArr, arr);
    }

    @Test
    public void testWhenEmptyArrPassedToSortReturnEmpty() {
        int[] arr = new int[]{};
        Bubble.sort(arr);
        assertEquals(arr.length, 0);
    }
}