package ua.rd.pos.coin;

public enum Coins implements Coin {
    ONE(1),
    FIVE(5),
    TEN(10),
    TWENTY_FIVE(25),
    FIFTY(50);

    private int value;

    Coins(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }
}
