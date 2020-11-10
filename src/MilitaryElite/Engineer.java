package MilitaryElite;

import java.util.Collection;

public interface Engineer {
    int getId();
    String getFirstName();
    String getLastName();
    Corps getCorps();
    Collection<Repair> getRepair();
}
