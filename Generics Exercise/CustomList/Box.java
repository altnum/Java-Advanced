package CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void Add(T element)  {
        this.values.add(element);
    }
    public void Remove(int index) {
        this.values.remove(index);
    }

    public boolean Contains(T element) {
        if (this.values.contains(element))
            return true;
        return false;
    }

    public void Swap(int index1, int index2) {
        T element = this.values.get(index1);
        this.values.set(index1, this.values.get(index2));
        this.values.set(index2, element);
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

    public T getMax() {
        return Collections.max(this.values);
    }

    public T getMin() {
        return Collections.min(this.values);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.values.size(); i++) {
            if (i == this.values.size() - 1) {
                sb.append(this.values.get(i));
                break;
            }
            sb.append(String.format("%s%n", this.values.get(i)));
        }
        return sb.toString();
    }
}
