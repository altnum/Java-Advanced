package Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    List<Pokemon> pokemon;
    List<Parents> parents;
    List<Children> children;

    public String getName() {
        return name;
    }

    public Person(String name) {
        this.name = name;
        this.pokemon = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    private Company company;
    private Car car;

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(String name, String department, double salary) {
        this.company = new Company(name, department, salary);
    }

    public void setCar(String model, int speed) {
        this.car = new Car(model, speed);
    }

    public Car getCar() {
        return car;
    }

    protected class Company {
        private String name;
        private String department;
        private double salary;

        public Company(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        public double getSalary() {
            return salary;
        }
    }

    public void setPokemon(String name, String type) {
        boolean has = false;
        if (!this.pokemon.isEmpty()) {
            for (Pokemon p : this.pokemon) {
                if (p.getName().equals(name)) {
                    p.type = type;
                    has = true;
                }
            }
            if (!has) {
                Pokemon p = new Pokemon(name, type);
                this.pokemon.add(p);
            }
        } else {
            this.pokemon.add(new Pokemon(name, type));
        }
    }

    public List<Parents> getParents() {
        return parents;
    }

    public void setParents(List<Parents> parents, String name, String birthday) {
        boolean has = false;

        for (Parents p :parents) {
            if (p.getName().equals(name)){
                p.birthday = birthday;
                has = true;
            }
        }
        if(!has) {
            Parents p = new Parents(name, birthday);
            parents.add(p);
        }
        this.parents = parents;
    }

    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children, String name, String birthday) {
        boolean has = false;

        for (Children p :children) {
            if (p.getName().equals(name)){
                p.birthday = birthday;
                has = true;
            }
        }
        if(!has) {
            Children p = new Children(name, birthday);
            children.add(p);
        }
        this.children = children;
    }

    protected class Pokemon {
        private String name;
        private String type;

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public Pokemon(String name, String type) {
            this.name = name;
            this.type = type;
        }
    }

    protected class Parents {
        private String name;
        private String birthday;

        public String getName() {
            return name;
        }

        public String getBirthday() {
            return birthday;
        }

        public Parents(String name, String birthday) {
            this.name = name;
            this.birthday = birthday;
        }
    }

    protected class Children {
        private String name;

        public String getName() {
            return name;
        }

        public String getBirthday() {
            return birthday;
        }

        private String birthday;

        public Children(String name, String birthday) {
            this.name = name;
            this.birthday = birthday;
        }
    }

    protected class Car {
        private String model;
        private int speed;

        public Car(String model, int speed) {
            this.model = model;
            this.speed = speed;
        }

        public String getModel() {
            return model;
        }

        public int getSpeed() {
            return speed;
        }
     }
}
