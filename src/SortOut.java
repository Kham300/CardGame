import java.util.ArrayList;
import java.util.HashMap;

public class SortOut extends Hand {
    HashMap<Integer, Integer> tableOfAlPosssileGamesDealer = new HashMap<>();
    double sumOfLoses = 0;
    double sumOfWins = 0;
    double midPointDealer = 0;
    double noGame = 0;
    int count = 0;
    double countOfCicles = 0;
    Hand dealer, player;
    Deck deck;
    ArrayList<Card> arrayListToSort = new ArrayList<>();
    int NUMBEROFCARDS = 47;
    Card[] cardsToArray;
    public SortOut(){
        deck = new Deck();
        deck.populate();
        deck.shuffle();
        dealer = new Hand();
        player = new Hand();
        deck.deal(player, 5);
        player.printHandType();
}
    public void sortOutAllPossibleDealerHands() {
    cardsToArray = deck.cards.toArray(new Card[NUMBEROFCARDS]);
        for (int i = 0; i < NUMBEROFCARDS - 4; i++) {
            for (int j = i + 1; j < NUMBEROFCARDS - 3; j++) {
                for (int k = j + 1; k < NUMBEROFCARDS - 2; k++) {
                    for (int n = k + 1; n < NUMBEROFCARDS - 1; n++) {
                        for (int m = n + 1; m < NUMBEROFCARDS; m++) {
                           arrayListToSort.clear();
                           arrayListToSort.add(cardsToArray[i]);
                           arrayListToSort.add(cardsToArray[j]);
                           arrayListToSort.add(cardsToArray[k]);
                           arrayListToSort.add(cardsToArray[n]);
                           arrayListToSort.add(cardsToArray[m]);
                           dealer.cards = arrayListToSort;
                           dealer.printHandType();
                           midPointDealer += dealer.getRezalt();
                           tableOfAlPosssileGamesDealer.merge(dealer.getRezalt(), count, (a, b) -> a += 1);
                           countOfCicles++;
                        }
                    }
                }
            }
        }
    }

    void  displayRezult(){
//        for (Integer i : tableOfAlPosssileGamesDealer.keySet()) {
//             midPointDealer += tableOfAlPosssileGamesDealer.get(i);
//        }
        System.out.println("M :" + compareHands(player.getRezalt()));
        System.out.println(player.showHand());
        System.out.println("midpoint:" + midPointDealer / countOfCicles);
    }


    double compareHands(int player) {
        for (Integer i : tableOfAlPosssileGamesDealer.keySet()) {
            if (i > player && i <= 32){
                sumOfWins += tableOfAlPosssileGamesDealer.get(i) * 3;
            } else  if (i < player && i <= 32){
                sumOfLoses += tableOfAlPosssileGamesDealer.get(i) * -3;
            } else if (i > 32){
                noGame += tableOfAlPosssileGamesDealer.get(i) * 1;
            } else if (i == player) {
                continue;
            }
        }
        return (sumOfWins + sumOfLoses + noGame)/countOfCicles;
    }
}
