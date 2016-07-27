package iterator_and_comparators.stack_iterators;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StackIterator<Integer> elements = new StackIterator<>();
        while (true){
            String[] params = reader.readLine().split("[\\s,]+");
            if (params[0].equals("END")){
                break;
            }

            try {
                switch (params[0]){
                    case "Push":
                        for (int i = 1; i < params.length; i++) {
                            elements.push(Integer.valueOf(params[i]));
                        }
                        break;

                    case "Pop":
                        elements.pop();
                        break;
                }
            } catch (IllegalStateException ex){
                System.out.println(ex.getMessage());
            }
        }

        for (Integer element : elements) {
            System.out.println(element);
        }
        for (Integer element : elements) {
            System.out.println(element);
        }
    }
}
