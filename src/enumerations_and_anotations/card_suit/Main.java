package enumerations_and_anotations.card_suit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ivanof on 7/24/16.
 */
public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String line = br.readLine();
            System.out.printf("%s:%n", line);
            for (Cards card : Cards.values()) {
                System.out.printf("Ordinal value: %d; Name value: %s%n", card.getNum(), card.name());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
