package GenericCountMethodDouble;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {

    public List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void Add(T element)  {
        this.values.add(element);
    }

    public void Swap(int index1, int index2) {
        T element = this.values.get(index1);
        this.values.set(index1, this.values.get(index2));
        this.values.set(index2, element);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T value:this.values) {
            sb.append(String.format("%s: %s", value.getClass().getName(), value));
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public int Compare(T element) {
        int count = 0;
        for (T e: this.values) {
            if (e.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }
}
