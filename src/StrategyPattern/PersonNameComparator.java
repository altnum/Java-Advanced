package StrategyPattern;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        int result = p1.getName().length() - p2.getName().length();

        if (result == 0) {
            for (int i = 0; i < p1.getName().length(); i++) {
                result = p1.getName().toLowerCase().charAt(i) - p2.getName().toLowerCase().charAt(i);
                if (result != 0)
                    return result;
            }

        }

        return result;
    }
}
