package iterator_and_comparators.comparing_objects;

public class Person implements Comparable<Person>{
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTown() {
        return town;
    }

    @Override
    public int compareTo(Person other) {
        int result = this.getName().compareTo(other.getName());
        if (result == 0){
            result = Integer.compare(this.getAge(), other.getAge());
            result = this.getTown().compareTo(other.getTown());
        }

        return result;
    }
}
