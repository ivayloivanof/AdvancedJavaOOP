package enumerations_and_anotations.card_compare_to;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ivanof on 7/24/16.
 */
public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String card = br.readLine();
            String paint = br.readLine();
            CardCompare cardCompare = new CardCompare(card, paint);
            card = br.readLine();
            paint = br.readLine();
            cardCompare.compareTo(new CardCompare(card, paint));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
