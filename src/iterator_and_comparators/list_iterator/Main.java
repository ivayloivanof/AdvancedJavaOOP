package iterator_and_comparators.list_iterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ivanof on 7/26/16.
 */



public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ListIterator iterator = null;
        while (true) {
            String[] commandParams = reader.readLine().split("\\s+");
            if (commandParams[0].equals("END")) {
                break;
            }
            try {
                switch (commandParams[0]) {
                    case "Create":
                        List<String> list = Arrays.asList(commandParams).stream()
                                .skip(1)
                                .collect(Collectors.toList());
                        iterator = new ListIterator<>(list);
                        break;
                    case "Print":
                        iterator.print();
                        break;
                    case "HasNext":
                        System.out.println(iterator.hasNext());
                        break;
                    case "Move":
                        System.out.println(iterator.move());
                        break;
                    case "PrintAll":
                        iterator.printAll();
                }
            } catch (IllegalStateException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}

