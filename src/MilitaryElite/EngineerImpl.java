package MilitaryElite;

import java.util.*;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private List<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new LinkedList<>();
    }

    @Override
    public Collection<Repair> getRepair() {
        return this.repairs;
    }

    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    public Collection<Repair> getRepairs() {
        return this.repairs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("Name: %s %s Id: %d Salary: %.2f%n", getFirstName(), this.getLastName(), this.getId(), this.getSalary()));
        sb.append("MilitaryElite.Corps: ").append(this.getCorps().getCorps()).append(System.lineSeparator());
        sb.append("Repairs:").append(System.lineSeparator());

        for (Repair repair : this.repairs) {
            sb.append(repair.toString()).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
