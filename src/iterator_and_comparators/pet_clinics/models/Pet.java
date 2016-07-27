package iterator_and_comparators.pet_clinics.models;

public class Pet {
    private String name;
    private int age;
    private String kind;

    public Pet(String name, int age, String kind) {
        this.name = name;
        this.age = age;
        this.kind = kind;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", this.name, this.age, this.kind);
    }
}
