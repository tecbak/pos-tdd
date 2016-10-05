package ua.rd.pos;

import java.util.ArrayList;
import java.util.List;

public class Pos {
    private List<Coin> coins = new ArrayList<>();

    public void insertCoin(Coin coin) {
        coins.add(coin);
    }


    public List<Coin> returnCoins() {
        List<Coin> coinsToReturn = coins;
        coins = null;
        return coinsToReturn;
    }
}
