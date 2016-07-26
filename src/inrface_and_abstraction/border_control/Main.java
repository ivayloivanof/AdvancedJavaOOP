package inrface_and_abstraction.border_control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Created by ivanof on 7/15/16.
 */
public class Main {

    public static void main(String[] args) {
        Citizen citizen = new Citizen();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String line = br.readLine();
            while (!Objects.equals(line, "End")) {
                String[] data = line.split("\\s+");
                Person person = null;
                if (data.length == 3) {
                    person = new Human(data[0], Integer.parseInt(data[1]), data[2]);
                } else {
                    person = new Robot(data[0], data[1]);
                }

                citizen.setPersons(person);

                line = br.readLine();
            }

            line = br.readLine();

            String finalLine = line;
            LinkedList<Boolean> print = new LinkedList<>();
            citizen.getPersons().stream()
                    .filter(person -> {
                        String idEnd = person.getID().substring(person.getID().length() - 3, person.getID().length());
                        if(Objects.equals(idEnd, finalLine)) {
                            print.add(true);
                            return true;
                        }
                        return false;
                    })
                    .forEach(person -> {
                        System.out.println(person.getID());
                    });

            if (print.size() == 0) {
                System.out.println("Doesn’t matter!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Citizen {
    private LinkedList<Person> persons;

    public Citizen() {
        this.persons = new LinkedList<>();
    }

    public LinkedList<Person> getPersons() {
        return this.persons;
    }

    public void setPersons(Person persons) {
        this.getPersons().add(persons);
    }
}

class Robot extends Person{

    private String model;

    public Robot(String model, String id) {
        super(id);
        this.setModel(model);
    }

    public String getModel() {
        return this.model;
    }

    private void setModel(String model) {
        this.model = model;
    }
}

class Human extends Person{

    private String name;
    private int age;

    public Human(String name, int age, String id) {
        super(id);
        this.name = name;
        this.age = age;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }
}

abstract class Person {
    private String id;

    protected Person(String id) {
        this.setId(id);
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getID() {
        return this.id;
    }
}