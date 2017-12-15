public class Card implements Comparable<Card> {
    private Suit suit;
    private Rank rank;
    //private StraightRank straightRank;

    public Card(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
       // this.straightRank = straightRank;
    }
    public String printRank(){
        return rank.getStringRank();
    }

    public String getSuit(){
        return suit.getSuit();
    }

    public int getRank(){
        return rank.getRank();
    }
    public String getStringRank(){
        return this.rank.getStringRank();
    }

    public String toString(){
        String str = "";
            str += rank.getStringRank() + suit.getSuit();
        return str;
    }


    @Override
    public int compareTo(Card o) {
        final int rankComparison = Integer.compare(this.rank.getRank(), o.rank.getRank());
            return rankComparison;


    }
}
