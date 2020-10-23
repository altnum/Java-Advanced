import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        Function<List<Integer>, Integer> findIndexOfMinElement = list -> {
            int min = Collections.min(list);
            return list.lastIndexOf(min);
        };

        System.out.println(findIndexOfMinElement.apply(numbers));
    }
}
