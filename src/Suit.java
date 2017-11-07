public enum Suit {
    HEARTS("h"),
    SPADES("s"),
    DIAMONDS("d"),
    CLUBS("c");

    private final String suitText;

    private Suit(String suitText){
        this.suitText = suitText;
    }

    public String getSuit(){
        return suitText;
    }

}
