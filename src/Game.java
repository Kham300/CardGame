public class Game {
    /*public static void main(String[] args) {
        Deck d1 = new Deck();
        Hand[] hands;
        Hand h1, h2, h3, dealer;
        int totalRezult = 0;
        int count = 0;
        double countOfAllNotGames = 0.0;
        HashMap<String, Integer> rezultMap = new HashMap<>();
        HashMap<String, Integer> howManyPlayGame = new HashMap<>();
        // for (int i = 0; i < 1000000; i++) {
        d1.populate();
        d1.shuffle();
        h1 = new Hand();
        // h2 = new Hand();
        // h3 = new Hand();
        hands = new Hand[]{h1};
        //d1.printDeck();
        //deal cards to our
        d1.deal(hands, 4);
        for (Hand h : hands) {
            h.printHandType();
            System.out.println(h.showHand());
        }
        // d1.printDeck();
        for (int i = 0; i < 1000000; i++) {
            d1.shuffle();
            dealer = new Hand();
            d1.dealNoRemovingCard(dealer, 5);
            dealer.printHandType();
            totalRezult += dealer.getRezalt();
            rezultMap.merge(dealer.cards.get(0).printRank(), dealer.getRezalt(), (a, b) -> a += b);
            if (dealer.getRezalt() > 32) {
                howManyPlayGame.merge(dealer.cards.get(0).printRank(), count, (a, b) -> a += 1);
            }
        }
        for (String str : rezultMap.keySet()) {
            System.out.println(str + ": " + rezultMap.get(str));
        }

        for (String str : howManyPlayGame.keySet()) {
            System.out.println(str + ": " + howManyPlayGame.get(str));
            countOfAllNotGames += howManyPlayGame.get(str);
        }
        System.out.println(totalRezult);
        System.out.println(countOfAllNotGames / 1000000);

        // }
    }*/
}



