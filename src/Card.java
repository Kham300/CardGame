public class Card {
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
}
