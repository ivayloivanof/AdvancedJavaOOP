package enumerations_and_anotations.card_compare_to;

/**
 * Created by ivanof on 7/24/16.
 */
public class CardCompare implements Comparable {
    private Cards cardName;
    private Cards cardPaint;

    public CardCompare(String cardName, String cardPaint) {
        this.setCardName(cardName);
        this.setCardPaint(cardPaint);
    }

    @Override
    public int compareTo(Object o) {
        CardCompare  cardCompare = (CardCompare) o;
        if((this.getCardName().getNum() + this.getCardPaint().getNum()) > (cardCompare.getCardName().getNum() + cardCompare.getCardPaint().getNum())) {
            System.out.printf("Card name: %s of %s; Card power: %d%n",
                    this.getCardName().toString(),
                    this.getCardPaint().toString(),
                    (this.getCardName().getNum() + this.getCardPaint().getNum()));
            return 1;
        } else if((this.getCardName().getNum() + this.getCardPaint().getNum()) < (cardCompare.getCardName().getNum() + cardCompare.getCardPaint().getNum())) {
            System.out.printf("Card name: %s of %s; Card power: %d%n",
                    cardCompare.getCardName().toString(),
                    cardCompare.getCardPaint().toString(),
                    (cardCompare.getCardName().getNum() + cardCompare.getCardPaint().getNum()));
            return -1;
        }

        System.out.printf("Card name: %s of %s; Card power: %d%n",
                this.getCardName().toString(),
                this.getCardPaint().toString(),
                (this.getCardName().getNum() + this.getCardPaint().getNum()));
        return 0;
    }

    public Cards getCardName() {
        return cardName;
    }

    private void setCardName(String cardName) {
        this.cardName = Cards.valueOf(cardName);
    }

    public Cards getCardPaint() {
        return cardPaint;
    }

    private void setCardPaint(String cardPaint) {
        this.cardPaint = Cards.valueOf(cardPaint);
    }
}
