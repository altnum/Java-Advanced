package FamilyTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Person person = new Person(reader.readLine());

        ArrayDeque<String> queue = new ArrayDeque<>();
        List<String> infoForPeople = new LinkedList<>();

        String info = reader.readLine();

        while(!"End".equals(info)) {
            if (info.contains("-")) {
                queue.offer(info);
            } else {
                if (info.contains(person.getInfo())) {
                    person.setInfo(info);
                }
                infoForPeople.add(info);
            }
            info = reader.readLine();
        }

        while(!queue.isEmpty()) {
            String[] decide = queue.poll().split(" - ");
            String parent = decide[0];
            String child = decide[1];

            for (String i: infoForPeople) {
                if (i.contains(parent)) {
                    parent = i;
                } else if (i.contains(child)) {
                    child = i;
                }
            }

            if (parent.equals(person.getInfo())) {
                person.setChildren(child);
            }
            if (child.equals(person.getInfo())) {
                person.setParents(parent);
            }
        }
        System.out.println(person.toString());
    }
}
