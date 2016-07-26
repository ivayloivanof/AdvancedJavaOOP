package enumerations_and_anotations.card_suit;

/**
 * Created by ivanof on 7/24/16.
 */
public enum Cards {
    CLUBS(0),
    DIAMONDS(1),
    HEARTS(2),
    SPADES(3);

    private final int num;

    Cards(int number) {
        this.num = number;
    }

    public int getNum() {
        return this.num;
    }
}
