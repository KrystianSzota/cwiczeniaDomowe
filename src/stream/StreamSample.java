package stream;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamSample {
    public static void main(String[] args) {
//        printConvertedAndSortedValues();
//        System.out.println("Liczby parzyste: " + getEvenNumbers(1, 2, 3, 4, 10, 22, 18, 16, 15));

//        List<String> names = getNamesContainingWord("a", "michal", "Jan", "MAGDA", "Oliwia");
//        System.out.println("Imiona zawierajace a: " + names);

        Optional<Integer> valueBigger = findBiggerThan(5, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        valueBigger.ifPresent(System.out::println);

    }

    private static Optional<Integer> findBiggerThan(Integer min, Integer... values) {
        return Stream.of(values)
                .filter((value) -> value > min)
                .sorted(Comparator.reverseOrder())
                .findFirst();
    }

    private static List<String> getNamesContainingWord(String searchWord, String ... names) {
        return Stream.of(names)
                .filter((name) -> name.contains(searchWord))
                .map((name) -> name.toLowerCase())
                .sorted()
                .collect(Collectors.toList());
    }

    private static String getEvenNumbers(Integer... values) {
        return Stream.of(values)
                .filter((value) -> value % 2 == 0)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }

    private static void printConvertedAndSortedValues() {
        Stream<String> sample = Stream.of("jeden", "2", "3", "10", "4", "5", "01");
        sample.filter((txt) -> {
                    try {
                        Integer.parseInt(txt);
                        return true;
                    } catch (Exception ignored) {
                        return false;
                    }
                })
                .map((txt) -> Integer.valueOf(txt))
                .sorted(Comparator.reverseOrder())
                .forEach((txt) -> System.out.println(txt));
    }
}
