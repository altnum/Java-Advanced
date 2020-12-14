package MilitaryElite;

import java.util.Collection;

public interface LieutenantGeneral {
    Collection<PrivateImpl> getPrivatesImpl();
    int getId();
    String getFirstName();
    String getLastName();
    void addPrivate(PrivateImpl priv);

}
