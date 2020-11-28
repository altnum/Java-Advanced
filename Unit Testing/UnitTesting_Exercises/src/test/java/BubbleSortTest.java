import org.junit.Assert;
import org.junit.Test;
import p04_BubbleSortTest.Bubble;

import java.util.Arrays;

public class BubbleSortTest {
    @Test
    public void testSort () {
        int[] arr = {100, 13, 7, 0, -5, -2};
        int[] expectedSortedArr = {100, 13, 7, 0, -5, -2};
        Bubble.sort(arr);
        Arrays.sort(expectedSortedArr);

        for (int i = 0; i < arr.length; i++) {
            Assert.assertEquals(arr[i], expectedSortedArr[i]);
        }
    }
}
