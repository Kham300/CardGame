import java.util.HashMap;

public class Game {
    public static void main(String[] args) {
        Deck d1;
        Hand h1;
        int totalRezult =0;
        HashMap<String, Integer> rezultMap = new HashMap<>();
        for (int i = 0; i < 1000000; i++) {
            d1 = new Deck();
            d1.populate();
            d1.shuffle();
            h1 = new Hand();
            //deal cards to our
            d1.deal(h1, 5);
            h1.printHandType();
           // System.out.println(h1.getRezalt()+"\n");
            totalRezult += h1.getRezalt();
            if(rezultMap.containsKey(h1.getFirstCardSuit())){
                int count = rezultMap.get(h1.getFirstCardSuit());
                rezultMap.put(h1.getFirstCardSuit(), count + h1.getRezalt());
            }
            else
            rezultMap.put(h1.getFirstCardSuit(), h1.getRezalt());
        }
        for (String str : rezultMap.keySet()){
            System.out.println(str + ": " + rezultMap.get(str));
        }
        System.out.println(totalRezult);
    }
}
