package inrface_and_abstraction.birthday_celebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Created by ivanof on 7/16/16.
 */
public class Main {

    public static void main(String[] args) {
        LinkedList<Person> persons = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String line = br.readLine();
            while (!Objects.equals(line, "End")) {
                String[] data = line.split("\\s+");
                Person p = null;
                if(Objects.equals(data[0], "Citizen")) {
                    p = new Citizen(data[1], Integer.parseInt(data[2]), data[3], data[4]);
                } else if (Objects.equals(data[0], "Pet")) {
                    p = new Pet(data[1], data[2]);
                } else if (Objects.equals(data[0], "Robot")) {
                    p = new Robot(data[1], data[2]);
                }
                persons.add(p);

                line = br.readLine();
            }


            String year = br.readLine();
            LinkedList<Boolean> print = new LinkedList<>();

            persons.stream()
                    .filter(person -> {
                        if (person.getBirthDay() != null) {
                            String birthDay = person.getBirthDay().split("/")[2];
                            if (Objects.equals(birthDay, year)) {
                                print.add(true);
                                return true;
                            } else {
                                return false;
                            }
                        }
                        return false;
                    })
                    .forEach(person -> {
                        System.out.println(person.getBirthDay());
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Citizen extends Person{
    private String name;
    private int age;

    public Citizen(String name, int age, String id, String birthDay) {
        super(id, birthDay);
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        this.age = age;
    }
}

class Robot extends Person{
    private String model;

    public Robot(String model, String id) {
        super(id, null);
        this.setModel(model);
    }

    public String getModel() {
        return this.model;
    }

    private void setModel(String model) {
        this.model = model;
    }
}

class Pet extends Person {
    private String name;

    public Pet(String name, String birthDay) {
        super(null, birthDay);
        this.setName(name);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }
}

abstract class Person implements P {
    private String id;
    private String birthDay;

    protected Person(String id, String birthDay) {
        this.setId(id);
        this.setBirthDay(birthDay);
    }

    public String getBirthDay() {
        return this.birthDay;
    }

    private void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    private void setId(String id) {
        this.id = id;
    }

    @Override
    public String getID() {
        return this.id;
    }
}

interface P {
    String getID();
}