package iterator_and_comparators.strategy_pattern;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        int result = Integer.compare(o1.getName().length(), o2.getName().length());
        if (result != 0){
            return result;
        }

        char first = Character.toLowerCase(o1.getName().charAt(0));
        char second = Character.toLowerCase(o2.getName().charAt(0));
        return Character.compare(first, second);
    }
}
