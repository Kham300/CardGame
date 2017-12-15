import java.util.ArrayList;
import java.util.Collections;

public class Deck extends Hand {
    public ArrayList populate(){//creates deck of cards
        clear();
        for (Suit suit : Suit.values()){
            for (Rank rank : Rank.values()){
                Card card = new Card(rank, suit);
                cards.add(card);//add not form arraylist its just our method, allredy adds to arraylist
            }
        }
        return cards;
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }


    public void clear(){
        cards.clear();
    }

    public void deal(Hand[] hands, int perHand){
        for (int i = 0; i < perHand; i++){
            for (int j = 0; j < hands.length; j++){
                this.give(cards.get(0), hands[j]);
            }
        }
    }
    public void dealNoRemovingCard(Hand hand, int perHand){
        //for one player
        for (int i = 0; i < perHand; i++){
            this.giveNoRemove(cards.get(i), hand);
        }
    }

    public void deal(Hand hand, int perHand){
        //for one player
        for (int i = 0; i < perHand; i++){
            this.give(cards.get(0), hand);
        }
    }

    public void printDeck() {
        int icount = 0;
        for (Card c : cards) {
            System.out.print(c);
            icount ++;
        }
        System.out.println(icount);
    }
}
