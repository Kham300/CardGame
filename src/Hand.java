
import java.util.*;

public class Hand {
    public ArrayList<Card> cards;
    int rezultZero = 0;
    int total = 0;

    public Hand(){
        cards = new ArrayList<>();
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
        }
        return  str +"\n"  +  "total points = " + getRezalt() ;
    }

    public int getRezalt(){
        return total;
    }

    public HandType evaluateHandType(){
        HandType retval = null;
        if (isThreeOfKind()!=0){
            retval = HandType.THREE_OF_A_KIND;
        }
        if (isStrFlush()!=0){
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
                //System.out.print("THEE OF A KIND: ");
                //System.out.println(getTotal(isThreeOfKind()));
                total = getTotal(isThreeOfKind());
                break;
            case FOUR_OF_A_KIND:
               // System.out.print("FOUR OF A KIND: ");
                break;
            case STRAIGHT:
               // System.out.print("STRAIGHT: " );
                break;
            case STRAIGHTFLUSH:
                //System.out.println(getTotal(isStrFlush()));
                total = getTotal(isStrFlush());
                //System.out.print("STRAIGHTFLUSH: ");
                break;
            case BOSH:
               // System.out.println(getTotal(0));
                total = getTotal(0);
               // System.out.print("BOSH: ");
        }
    }

    public int isThreeOfKind() {
        HashMap<String, List<Card>> map = new HashMap<>();
        for (Card c : cards) {
            map.computeIfAbsent(c.getStringRank(), k -> new ArrayList<>()).add(c);
        }
        for(String str : map.keySet())
            if (map.get(str).size()==3){
                Card c  = map.get(str).get(0);
                rezultZero = c.getRank()*3;
                if (rezultZero >= 30) {
                    return rezultZero = 30;
                }else {
                    return rezultZero;
                }
            }
        return 0;
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

    public int isStrFlush(){//переделать на isStraigthFlush если выполнится условие стрита
        int rezult =0;
        HashMap<String, List<Card>> map = new HashMap<>();
        ArrayList<Card> cardsToStrFlush = new ArrayList<>();
        for (Card c : cards) {
            map.computeIfAbsent(c.getSuit(), k -> new ArrayList<>()).add(c);
        }

        for(String str : map.keySet()) {
            if (map.get(str).size() >= 3) {
                cardsToStrFlush = (ArrayList<Card>) map.get(str);
            }
        }

        if (cardsToStrFlush.size()!=0){
            if (isStraight(cardsToStrFlush)){
                for (Card card : cardsToStrFlush){
                    if (card.getRank() > 10){
                        rezult += 10;
                    }else {
                        rezult += card.getRank();
                    }
                }
                return rezult;
            }
        }
        return 0;
    }
    //return total of hand
    public int getTotal(int zero){
        int totalPTS = 0;
        for (Card c : cards){
            if (c.getRank() > 10){
                totalPTS += 10;
            }else {
                totalPTS += c.getRank();
            }
        }
        return totalPTS-zero;
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

    public boolean giveNoRemove(Card card, Hand otherHand){
        if (!cards.contains(card)){
            return false;
        }else{
            otherHand.add(card);
            return true;
        }
    }


}
