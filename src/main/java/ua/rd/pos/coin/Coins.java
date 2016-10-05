package ua.rd.pos.coin;

public enum Coins implements Coin {
    FIFTY(50),
    TWENTY_FIVE(25),
    TEN(10),
    FIVE(5),
    ONE(1);

    private int value;

    Coins(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }
}
