package FirstAndReserveTeam;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.age = age;
        this.setSalary(salary);
    }

    public void setLastName(String lastName) {
        validateNameLength(lastName, "Last name");
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        validateNameLength(firstName, "First name");
        this.firstName = firstName;
    }

    public void setSalary(double salary) {
        if (salary < 460) {
            throw new IllegalArgumentException("Salary cannot be less than " + salary + " leva");
        }

        this.salary = salary;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("ValidationData.FirstAndReserveTeam.ShoppingSpree.DefineAnInterfacePerson.Person age cannot be zero or negative integer");
        }

        this.age = age;
    }

    public double getSalary() {
        return this.salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    private void validateNameLength(String name, String messagePrefix) {
        if (name.length() < 3) {
            throw new IllegalArgumentException(messagePrefix + " cannot be less than 3 symbols");
        }
    }

    public void increaseSalary(double bonus) {
        if (this.age < 30) {
            bonus /= 2;
        }

        this.salary = this.salary * (1 + bonus / 100);
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %.2f leva", this.getFirstName(), this.getLastName(), this.getSalary());
    }
}
