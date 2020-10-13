package CustomListIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command = reader.readLine();
        CustomList<String> box = new CustomList<>();

        while(!"END".equals(command)) {
            String[] info = command.split("\\s+");
            switch (info[0]) {
                case "Add" -> box.Add(info[1]);
                case "Remove" -> box.Remove(Integer.parseInt(info[1]));
                case "Contains" -> System.out.println(box.Contains(info[1]));
                case "Swap" -> box.Swap(Integer.parseInt(info[1]), Integer.parseInt(info[2]));
                case "Greater" -> System.out.println(box.Compare(info[1]));
                case "Max" -> System.out.println(box.getMax());
                case "Min" -> System.out.println(box.getMin());
                case "Print" -> {
                    Iterator<String> it = box.iterator();
                    for (String el :
                            box) {
                        System.out.println(it.next());
                    }
                }
                case "Sort" -> Sorter.sort(box);
            }
            command = reader.readLine();
        }
    }
}
