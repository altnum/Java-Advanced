package Tuple;

import java.util.ArrayList;
import java.util.List;

public class Tuple<T, E> {
    List<T> values1;
    List<E> values2;

    public Tuple () {
        this.values1 = new ArrayList<>();
        this.values2 = new ArrayList<>();
    }

    public void setValues1(T element) {
        this.values1.add(element);
    }

    public void setValues2(E element) {
        this.values2.add(element);
    }

    @Override
    public String toString() {
        return String.format(values1.get(0) + " -> " + values2.get(0));
    }
}
