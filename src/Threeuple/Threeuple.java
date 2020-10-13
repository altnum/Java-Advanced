package Threeuple;

import java.util.ArrayList;
import java.util.List;

public class Threeuple<T, E, S> {
    private T values1;
    private E values2;
    private S values3;



    public Threeuple (T f, E s, S t) {
        this.values1 = f;
        this.values2 = s;
        this.values3 = t;
    }

    public T getValues1() {
        return values1;
    }

    public E getValues2() {
        return values2;
    }

    public S getValues3() {
        return values3;
    }

    public void setValues1(T values1) {
        this.values1 = values1;
    }

    public void setValues2(E values2) {
        this.values2 = values2;
    }

    public void setValues3(S values3) {
        this.values3 = values3;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.values1).append(" -> ").append(this.values2).append(" -> ").append(this.values3);

        return sb.toString();
    }
}
