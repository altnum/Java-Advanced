package ListUtilities;

import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

public class ListUtils<T> {

    public static <T extends Comparable<T>> T getMin(List<T> list) {
        T min = list.stream().min(Comparable::compareTo).orElseThrow(IllegalArgumentException::new);
        return min;

    }
    public static <T extends Comparable<T>> T getMax(List<T> list) {
        T max = list.stream().max(Comparable::compareTo).orElseThrow(IllegalArgumentException::new);
        return max;
    }
}
