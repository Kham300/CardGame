public enum Rank {
    ACE(1, "A"),
    DEUCE(2, "2"),
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    TEN(10, "10"),
    JACK(11, "J"),
    QUEEN(12, "Q"),
    KING(13, "K");

    private final int rankValue;
    private final String rankString;

    Rank( int rankValue, String rankString){
        this.rankValue = rankValue;
        this.rankString = rankString;
    }

    public int getRank(){
        return rankValue;
    }

    public String getStringRank(){
        return rankString;
    }

}
