package enumerations_and_anotations.card_compare_to;

/**
 * Created by ivanof on 7/24/16.
 */
public enum Cards {
    ACE(14),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private final int num;

    Cards(int number) {
        this.num = number;
    }

    public int getNum() {
        return this.num;
    }
}
