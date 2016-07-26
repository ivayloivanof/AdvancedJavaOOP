package inrface_and_abstraction.food_shortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Objects;

/**
 * Created by ivanof on 7/17/16.
 */
public class Main {

    public static void main(String[] args) {
        LinkedHashMap<String, Person> peoples = new LinkedHashMap<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int numberOfPeople = Integer.parseInt(br.readLine());
            for (int i = 0; i < numberOfPeople; i++) {
                String[] data = br.readLine().split("\\s+");
                if (data.length == 4) {
                    peoples.put(
                            data[0],
                            new Citizen(data[0], Integer.parseInt(data[1]), data[2], data[3])
                    );
                } else if (data.length == 3){
                    peoples.put(
                            data[0],
                            new Rebel(data[0], Integer.parseInt(data[1]), data[2])
                    );
                }
            }

            String name = br.readLine();
            int sum = 0;
            while (!Objects.equals(name, "End")) {
                if (peoples.containsKey(name)) {
                    peoples.get(name).BuyFood();
                    sum+= peoples.get(name).getIncreaseFood();
                }
                name = br.readLine();
            }

            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Rebel extends Person {

    private String name;
    private int age;
    private String group;
    private Integer food;

    public Rebel(String name, int age, String group) {
        super(null, null);
        this.setName(name);
        this.setAge(age);
        this.setGroup(group);
        this.setFood(Buyer.food);
    }

    private String getName() {
        return name;
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

    public String getGroup() {
        return this.group;
    }

    private void setGroup(String group) {
        this.group = group;
    }

    public Integer getFood() {
        return this.food;
    }

    private void setFood(Integer food) {
        this.food = food;
    }

    @Override
    public int getIncreaseFood() {
        return 5;
    }

    @Override
    public void BuyFood() {
        this.setFood(this.getFood() + this.getIncreaseFood());
    }
}

class Citizen extends Person {
    private String name;
    private int age;
    private Integer food;

    public Citizen(String name, int age, String id, String birthDay) {
        super(id, birthDay);
        this.setName(name);
        this.setAge(age);
        this.setFood(Buyer.food);
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

    public Integer getFood() {
        return this.food;
    }

    private void setFood(Integer food) {
        this.food = food;
    }

    @Override
    public int getIncreaseFood() {
        return 10;
    }

    @Override
    public void BuyFood() {
        this.setFood(this.getFood() + this.getIncreaseFood());
    }
}

class Robot extends Person {
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

    @Override
    public int getIncreaseFood() {
        return 0;
    }

    @Override
    public void BuyFood() {

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

    @Override
    public int getIncreaseFood() {
        return 0;
    }

    @Override
    public void BuyFood() {

    }
}

abstract class Person implements P, Buyer {
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

interface Buyer {
    Integer food = 0;
    int getIncreaseFood();
    void BuyFood();
}