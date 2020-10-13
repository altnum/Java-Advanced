package CustomListSorter;

import java.util.ArrayList;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> values;

    public CustomList() {
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
        if(!this.values.isEmpty()) {
            T max = this.values.get(0);

            for (T element: this.values) {
                if (element.compareTo(max) > 0)
                    max = element;
            }
            return max;
        }
        return null;
    }

    public T getMin() {
        if(!this.values.isEmpty()) {
            T min = this.values.get(0);

            for (T element: this.values) {
                if (element.compareTo(min) < 0)
                    min = element;
            }
            return min;
        }
        return null;
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

    public int size() {
        return this.values.size();
    }

    public T get(int index) {
        return this.values.get(index);
    }

    public void set (int index, T element) {
        this.values.set(index, element);
    }
}

