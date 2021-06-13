package com.designpatterns;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CompositionDemo {

    public static void main(String[] args) {
        // Level 5
        Component leaf51 = new Leaf("Leaf51");
        Component leaf52 = new Leaf("Leaf52");
        Component leaf53 = new Leaf("Leaf53");
        Component leaf54 = new Leaf("Leaf54");

        // Level 4
        Component leaf41 = new Leaf("Leaf41");
        Component leaf42 = new Leaf("Leaf42");
        Component leaf43 = new Leaf("Leaf43");
        Component leaf44 = new Leaf("Leaf44");
        Component branch45 = new Composite(Arrays.asList(leaf51, leaf52), "Branch45");
        Component branch46 = new Composite(Arrays.asList(leaf53, leaf54), "Branch46");

        // Level 3
        Component branch31 = new Composite(Arrays.asList(leaf41, leaf42), "Branch31");
        Component branch32 = new Composite(Arrays.asList(leaf43, leaf44), "Branch32");
        Component branch33 = new NullLeaf();
        Component branch34 = new Composite(Arrays.asList(branch45, branch46), "Branch34");
        Component leaf35 = new Leaf("Leaf35");
        Component leaf36 = new Leaf("Leaf36");

        // Level 2
        Component branch21 = new Composite(Arrays.asList(branch31, branch32), "Branch21");
        Component branch22 = new Composite(Arrays.asList(branch33, branch34), "Branch22");
        Component branch23 = new Composite(Arrays.asList(leaf35, leaf36), "Branch23");

        // Level 1
        Component branch1 = new Composite(Arrays.asList(branch21, branch22, branch23), "Branch1");

        // Run operation:
        branch1.operation();

        List<String> strs = Arrays.asList("aa", "bbbbbbbb", "cccc", "d", "eeeee");
        Map<String, Integer> theMap = strs.stream().collect(Collectors.toMap(e -> e, String::length));

        System.out.println();
        for (Map.Entry<String, Integer> pair : theMap.entrySet()) {
            System.out.println(String.format("Key (name) is: %s, Value (age) is : %s", pair.getKey(), pair.getValue()));
        }
    }
}
