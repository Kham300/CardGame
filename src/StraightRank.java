public enum StraightRank {
    ACE(1),
    DEUCE(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(11),
    JACK(12),
    QUEEN(13),
    KING(14);

    private final int straightRankValue;

    private StraightRank(int straightRankValue) {
        this.straightRankValue = straightRankValue;
    }

    public int getStraightRankValue(){
        return straightRankValue;
    }
}
