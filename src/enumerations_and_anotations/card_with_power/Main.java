package enumerations_and_anotations.card_with_power;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ivanof on 7/24/16.
 */
public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            Cards card = Cards.valueOf(br.readLine());
            Cards paint = Cards.valueOf(br.readLine());
            System.out.printf("Card name: %s of %s; Card power: %d%n", card.name(), paint.name(), (card.getNum() + paint.getNum()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
