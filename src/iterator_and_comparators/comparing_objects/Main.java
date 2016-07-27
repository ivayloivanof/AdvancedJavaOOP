package iterator_and_comparators.comparing_objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> people = new LinkedList<>();
        while (true){
            String[] params = reader.readLine().split("\\s+");
            if (params[0].equals("END")){
                break;
            }
            String name = params[0];
            int age = Integer.valueOf(params[1]);
            String town = params[2];
            Person person = new Person(name, age, town);
            people.add(person);
        }

        int index = Integer.valueOf(reader.readLine());
        int equalCount = 0;
        Person toCompare = people.get(index - 1);
        for (Person person : people) {
            if (person.compareTo(toCompare) == 0){
                equalCount++;
            }
        }
        if (equalCount == 1){
            System.out.println("No matches");
        } else {
            System.out.printf("%s %s %s%n", equalCount, people.size() - equalCount, people.size());
        }
    }
}
