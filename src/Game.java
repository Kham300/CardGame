public class Game {
    public static void main(String[] args) {
        Deck d1;
        Hand h1;
        for (int i = 0; i < 1000; i++) {
            d1 = new Deck();
            d1.populate();
            d1.shuffle();
            h1 = new Hand();
            //deal cards to our
            d1.deal(h1, 5);
            if (h1.isStrFlush()) {
                h1.printHandType();
                System.out.println(h1.showHand()+ "\n");
           // } else if (h1.isThreeOfKind()){
             //   System.out.println(h1.showHand());
               // h1.printHandType();
            }

        }
    }
}
