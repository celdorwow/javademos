import org.apache.commons.csv.CSVFormat;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.summingInt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;
import java.io.Reader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String fileName = "file.csv";
        List<Information> information = getInformation(fileName);

        if (information == null) {
            System.err.println("Cannot continue. No data!");
        } else {
            groupingByWithList(information);
            groupingByWithListOfCustomType(information);
            complexGroupingByWithMapAllocator(information);
            complexGroupingByWithMapAllocatorAndList(information);
        }

    }

    // --- Create list
    private static List<Information> getInformation(String fileName) {
        // List<Information> information = new ArrayList<>();
        try (Reader in = new FileReader(fileName)) {
            return StreamSupport.stream(CSVFormat.DEFAULT.parse(in).spliterator(), false)
                .map(record ->
                    new Information(
                        record.get(1), record.get(2),
                        Integer.parseInt(record.get(3)),
                        Double.parseDouble(record.get(4)),
                        Double.parseDouble(record.get(5)),
                        Double.parseDouble(record.get(6)),
                        record.get(7), record.get(8),
                        Double.parseDouble(record.get(9))
                    ))
                .toList();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    /* Methods using collector groupingBy */

    private static void groupingByWithList(List<Information> information) {
        // Simpler groupingBy due to identical stream and List type
        Map<String, List<Information>> map = information
            .stream()
            .collect(
                groupingBy(
                    Information::getPurpose,   // Classifier
                    HashMap::new,              // custom allocator - can be omitted
                    toList()                   // Simple Collector because type of stream and combiner
                    //   is the same, here List<Information>
                )
            );
        for (String key : map.keySet()) {
            System.out.printf("%s:%n\t%s%n", key, map.get(key));
        }
    }

    private static void groupingByWithListOfCustomType(List<Information> information) {
        // Additional mapping required from List<Information> to List<Integer>
        Map<String, List<Integer>> mapWithCustomCollector =
            information
                .stream()
                .collect(
                    groupingBy(
                        Information::getPurpose,           // Classifier
                        mapping(                           // mapping(Function<>, Collector<>) as type of Combiner
                            Information::getCount,         //   different (List<Integer>, no List<Information>.
                            toCollection(ArrayList::new)   // Must remain toCollection(ArrayList::new) if map Values
                        )                                  //   were Arralist<> not List<>. Otherwise toList() would do.
                    )
                );
        for (String key : mapWithCustomCollector.keySet()) {
            System.out.println(key + " : " + mapWithCustomCollector.get(key).stream().mapToInt(e -> e).sum());
        }
    }

    private static void complexGroupingByWithMapAllocator(List<Information> information) {
        // Complex groupingBy with int summary
        Map<String, Map<String, Integer>> complexMapSum =
            information
                .stream()
                .collect(
                    groupingBy(
                        Information::getPurpose,
                        groupingBy(
                            Information::getSuplier,
                            summingInt(Information::getCount)
                        )
                    )
                );
        System.out.println();
        for (String key : complexMapSum.keySet()) {
            System.out.printf("%s   {%n", key);
            for (String subKey : complexMapSum.get(key).keySet()) {
                System.out.printf("\t%s : %s,%n", subKey, complexMapSum.get(key).get(subKey));
            }
            System.out.printf("}%n");
        }
    }

    private static void complexGroupingByWithMapAllocatorAndList(List<Information> information) {
        // Complex groupingBy with list
        Map<String, Map<String, List<Integer>>> complexMapList =
            information
                .stream()
                .collect(
                    groupingBy(
                        Information::getPurpose,
                        groupingBy(
                            Information::getSuplier,
                            mapping(
                                Information::getCount,
                                toList()
                            )
                        )
                    )
                );
        System.out.println();
        for (String key : complexMapList.keySet()) {
            System.out.printf("%s: {%n", key);
            for (String subKey : complexMapList.get(key).keySet()) {
                System.out.printf("\t%s: {%n", subKey);
                for (int i : complexMapList.get(key).get(subKey)) {
                    System.out.printf("\t\t%d,%n", i);
                }
                System.out.printf("\t}%n");
            }
            System.out.printf("}%n");
        }
    }
}
