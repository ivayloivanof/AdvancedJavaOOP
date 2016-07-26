package enumerations_and_anotations.card_rank;

/**
 * Created by ivanof on 7/24/16.
 */
public enum Cards {
    ACE(0),
    TWO(1),
    THREE(2),
    FOUR(3),
    FIVE(4),
    SIX(5),
    SEVEN(6),
    EIGHT(7),
    NINE(8),
    TEN(9),
    JACK(10),
    QUEEN(11),
    KING(12);

    private final int num;

    Cards(int number) {
        this.num = number;
    }

    public int getNum() {
        return this.num;
    }
}
