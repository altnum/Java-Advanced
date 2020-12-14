package MilitaryElite;

import java.util.Collection;
import java.util.LinkedHashSet;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    Collection<Mission> Missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.Missions = new LinkedHashSet<>();
    }

    @Override
    public Collection<Mission> getMissions() {
        return this.Missions;
    }

    public void addMission(Mission mission) {


        this.Missions.add(mission);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("Name: %s %s Id: %d Salary: %.2f%n", this.getFirstName(), this.getLastName(), this.getId(), this.getSalary()));
        sb.append("MilitaryElite.Corps: ").append(this.getCorps().getCorps()).append(System.lineSeparator());
        sb.append("Missions: ").append(System.lineSeparator());

        for (Mission mission : this.Missions) {
            sb.append(mission.toString());
        }

        return sb.toString();
    }
}
