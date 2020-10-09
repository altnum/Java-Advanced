package GenericsArrayCreator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator {

    @SuppressWarnings("unchecked")
    public static <T> T[] create(int length, T element) {
        Object arr = Array.newInstance(element.getClass(), length);

        Arrays.fill((T[]) arr, element);

        return (T[])arr;
    }
    @SuppressWarnings("uncchecked")
    public static <T> T[] create(Class<T> clazz, int length, T item) {
        Object arr = Array.newInstance(clazz, length);
        Arrays.fill((T[]) arr, item);
        return (T[]) arr;

    }
}
