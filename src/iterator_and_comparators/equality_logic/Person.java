package iterator_and_comparators.equality_logic;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || this.getClass() != other.getClass()) {
            return false;
        }

        Person person = (Person) other;

        if (this.age != person.age) {
            return false;
        }

        return this.name != null ? this.name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = this.name != null ? this.name.hashCode() : 0;
        result = 31 * result + this.age;

        return result;
    }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.hashCode(), other.hashCode());
    }
}
