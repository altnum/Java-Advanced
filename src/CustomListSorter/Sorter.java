package CustomListSorter;

public class Sorter<T extends Comparable<T>> {

    public static void sort(CustomList list) {
        for (int i = 0; i < list.size(); i++) {
            String element = (String)list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                String element1 = (String)list.get(j);
                if (element.compareTo(element1) > 0) {
                    list.Swap(i, j);
                }
            }
        }
    }
}
