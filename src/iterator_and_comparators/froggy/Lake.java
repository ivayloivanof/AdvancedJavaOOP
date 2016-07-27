package iterator_and_comparators.froggy;

import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer>{
    private List<Integer> data;

    public Lake(List<Integer> data) {
        this.data = data;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int evenIndex = 0;
            private int oddIndex = 1;

            @Override
            public boolean hasNext() {
                return !(this.evenIndex >= data.size()) || !(this.oddIndex >= data.size());
            }

            @Override
            public Integer next() {
                if (this.evenIndex < data.size()){
                    int current = data.get(this.evenIndex);
                    this.evenIndex += 2;
                    return current;
                }

                int current = data.get(this.oddIndex);
                this.oddIndex += 2;
                return current;
            }
        };
    }
}
