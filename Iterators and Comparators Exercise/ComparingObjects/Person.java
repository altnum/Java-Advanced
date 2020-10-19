package ComparingObjects;

public class Person implements Comparable<Person>{
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    @Override
    public int compareTo(Person otherPerson) {
        int res = this.name.compareTo(otherPerson.name);
        if (res == 0) {
            res = Integer.compare(this.age, otherPerson.age);
            if (res == 0) {
                res = this.town.compareTo(otherPerson.town);
            }
        }
        return res;
    }
}
