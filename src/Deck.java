import java.util.Random;

public class Deck extends Hand {
    Random random = new Random();
    public void populate(){//creates deck of cards
        for (Suit suit : Suit.values()){
            for (Rank rank : Rank.values()){
                Card card = new Card(rank, suit);
                this.add(card);//add not form arraylist its just our method, allredy adds to arraylist
            }
        }
    }

    public void shuffle(){
        for (int i = cards.size() -1; i > 0; i--){
            //swap a random card between the beginning
            //and last card of the loop
            int pick = random.nextInt(i);//picks card random
            Card randomCard = cards.get(pick);
            Card lastCard = cards.get(i);
            cards.set(i, randomCard);
            cards.set(pick, lastCard);
        }
    }

    public void deal(Hand[] hands, int perHand){
        for (int i = 0; i < perHand; i++){
            for (int j = 0; j < hands.length; j++){
                this.give(cards.get(0), hands[j]);
            }
        }
    }

    public void deal(Hand hand, int perHand){
        //for one player
        for (int i = 0; i < perHand; i++){
            this.give(cards.get(0), hand);
        }
    }
}
