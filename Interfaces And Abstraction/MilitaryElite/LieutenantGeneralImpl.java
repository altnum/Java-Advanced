package MilitaryElite;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private List<PrivateImpl> PrivatesImpl;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.PrivatesImpl = new LinkedList<>();
    }

    @Override
    public Collection<PrivateImpl> getPrivatesImpl() {
        return PrivatesImpl;
    }

    public void addPrivate(PrivateImpl priv) {
        this.PrivatesImpl.add(priv);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("Name: %s %s Id: %d Salary: %.2f%n", this.getFirstName(), this.getLastName(), this.getId(), this.getSalary()));
        sb.append("Privates:").append(System.lineSeparator());

        this.PrivatesImpl = this.PrivatesImpl.stream().sorted((l, r) -> Integer.compare(r.getId(), l.getId()))
                .collect(Collectors.toCollection(LinkedList::new));

        for (PrivateImpl pr : this.PrivatesImpl) {
            sb.append("  ").append(pr.toString()).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
