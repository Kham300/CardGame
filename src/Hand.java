import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Hand {
    public ArrayList<Card> cards;

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
        if (isStraight()){
            retval = HandType.STRAIGHT;
        }
        if (isFlush()){
            retval = HandType.FLUSH;
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
            case FLUSH:
                System.out.print("FLUSH: ");
                break;
            case BOSH:
                System.out.print("BOSH: ");
        }
    }

    public boolean isThreeOfKind(){
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
            if (numberCount.get(str)>=3){
                return true;
            }
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

    public boolean isStraight() {//додумать до трехкарточного!!!!!!
        ArrayList<Integer> straightList = new ArrayList<>();

        for (Card c : cards) {
            straightList.add(c.getRank());
        }

        Collections.sort(straightList);
        boolean retval = false;

        int minimum = straightList.get(0);
        ArrayList<Integer> expectedSequence = new ArrayList<>();

        for (int i = minimum; i < minimum + 5; i++) {// поменять на три
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

    public boolean isFlush(){//переделать на isStraigthFlush если выполнится условие стрита
        HashMap<String, Integer> charCount = new HashMap<>();

        for (Card c : cards){
            if (charCount.containsKey(c.getSuit())){
                int count = charCount.get(c.getSuit());
                charCount.put(c.getSuit(), count + 1);
            }
            else
                charCount.put(c.getSuit(), 1);
        }

        for (String str : charCount.keySet()){
            if (charCount.get(str) >= 5){
                return true;
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
