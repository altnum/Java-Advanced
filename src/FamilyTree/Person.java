package FamilyTree;

import java.util.LinkedList;
import java.util.List;

public class Person {
    private String info;
    private List<String> parents;
    private List<String> children;

    public Person(String info) {
        this.info = info;
        this.parents = new LinkedList<>();
        this.children = new LinkedList<>();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<String> getParents() {
        return parents;
    }

    public void setParents(String parent) {
        this.parents.add(parent);
    }

    public List<String> getChildren() {
        return children;
    }

    public void setChildren(String child) {
        this.children.add(child);
    }

    @Override
    public String toString() {
        String output = this.info + "\n" + "Parents: \n";

        for (String parent: this.parents) {
            output += parent + "\n";
        }
        output += "Children: \n";
        for (String child: this.children) {
            output += child + "\n";
        }
        return output;
    }
}
