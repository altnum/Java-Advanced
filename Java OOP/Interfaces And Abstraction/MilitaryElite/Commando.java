package MilitaryElite;

import java.util.Collection;

public interface Commando {
    int getId();
    String getFirstName();
    String getLastName();
    Corps getCorps();
    Collection<Mission> getMissions();
}
