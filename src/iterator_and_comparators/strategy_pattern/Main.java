package iterator_and_comparators.strategy_pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Person> orderedByName = new TreeSet<>(new PersonNameComparator());
        TreeSet<Person> orderedByAge = new TreeSet<>(new PersonAgeComparator());

        int n = Integer.valueOf(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] params = reader.readLine().split("\\s+");
            Person person = new Person(params[0], Integer.valueOf(params[1]));
            orderedByName.add(person);
            orderedByAge.add(person);
        }

        orderedByName.forEach(System.out::println);
        orderedByAge.forEach(System.out::println);
    }
}
