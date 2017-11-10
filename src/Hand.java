
import java.util.*;

public class Hand {
    public ArrayList<Card> cards;
    public ArrayList<Card> cardsToZero;
    int rezultZero = 0;

    public Hand(){
        cards = new ArrayList<>();
    }

    public void clear(){
        cards.clear();
    }

    public void add(Card card){
        cards.add(card);
    }

    public String showHand(){
        /*show cards and their total points,
         */
        String str ="";
        for (Card c : cards) {
            str += c.toString();
           // str += "total points = " + getTotal() + "\n";
        }
        return  str   += " Points = " + getTotal();
    }

    public HandType evaluateHandType(){
        HandType retval = null;

        /*if (isOnePair()){
            retval = HandType.TWO_PAIR;
        }*/

        if (isThreeOfKind()){
            retval = HandType.THREE_OF_A_KIND;
        }
        if (isStrFlush()){
            retval = HandType.STRAIGHTFLUSH;
        }
        if (isFourOfAKind()){
            retval = HandType.FOUR_OF_A_KIND;
        }
        if (retval == null){
            return HandType.BOSH;
        }
        return retval;
    }

    public void printHandType(){
        switch (evaluateHandType()){
            case THREE_OF_A_KIND:
                System.out.print("THEE OF A KIND: ");
                break;
            case FOUR_OF_A_KIND:
                System.out.print("FOUR OF A KIND: ");
                break;
            case STRAIGHT:
                System.out.print("STRAIGHT: " );
                break;
            case STRAIGHTFLUSH:
                System.out.print("STRAIGHTFLUSH: ");
                break;
            case BOSH:
                System.out.print("BOSH: ");
        }
    }

    public boolean isThreeOfKind() {
        HashMap<String, List<Card>> map = new HashMap<>();
        for (Card c : cards) {
            map.computeIfAbsent(c.getStringRank(), k -> new ArrayList<>()).add(c);
        }
        for(String str : map.keySet())
            if (map.get(str).size()==3){
                cardsToZero = new ArrayList<>();
                cardsToZero = (ArrayList<Card>) map.get(str);
                rezultZero = cardsToZero.get(0).getRank();
                rezultZero = rezultZero*3;
                //System.out.println("from method rezult :" + rezultZero);
                return true;
            }
        return false;
    }

    public boolean isFourOfAKind(){
        HashMap<String, Integer> numberCount = new HashMap<>();
        for (Card c: cards){
            if(numberCount.containsKey(c.getStringRank())){
                int count = numberCount.get(c.getStringRank());
                numberCount.put(c.getStringRank(), count + 1);
            }
            else
                numberCount.put(c.getStringRank(), 1);
        }

        for (String str : numberCount.keySet()){
            if (numberCount.get(str)>=4){
                return true;
            }
        }
        return false;
    }

    public boolean isStraight(ArrayList<Card> listFromFlush) {//додумать до трехкарточного!!!!!!
        ArrayList<Integer> straightList = new ArrayList<>();

        for (Card c : listFromFlush) {
            straightList.add(c.getRank());
        }

        Collections.sort(straightList);
        boolean retval = false;

        int minimum = straightList.get(0);
        ArrayList<Integer> expectedSequence = new ArrayList<>();
        //ArrayList<Integer> expectedSequence2

        for (int i = minimum; i < minimum + listFromFlush.size(); i++) {// поменять на три
            expectedSequence.add(i);
        }
        HashSet<Integer> givenSequence = new HashSet<>();
        for (Integer i : straightList) {
            givenSequence.add(i);
        }
        if (givenSequence.containsAll(expectedSequence)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isStrFlush(){//переделать на isStraigthFlush если выполнится условие стрита
        HashSet<String> suitKeys = new HashSet<>();
        ArrayList<Card> cardsToStrFlush = new ArrayList<>();
       // Map<String, ArrayList<Card>> countOfSuits = new HashMap<>();
        //for (Suit suit : Suit.values()){
        //    countOfSuits.put(suit.getSuit(), null);
        //}

        for (Card c : cards){
           if (suitKeys.contains(c.getSuit())){//ксли содержит ключ
               cardsToStrFlush.add(c);
            } else {
               suitKeys.add(c.getSuit());
            }if(cardsToStrFlush.size() >=3){
                return isStraight(cardsToStrFlush);
            }
        }
        return false;
    }


    //return total of hand
    public int getTotal(){
        int totalPTS = 0;
        for (int i = 0; i < cards.size(); i++){
            totalPTS += cards.get(i).getRank();
        }
        return totalPTS;
    }

    public boolean give(Card card, Hand otherHand){
        if (!cards.contains(card)){
            return false;
        }else{
            cards.remove(card);
            otherHand.add(card);
            return true;
        }
    }


}
