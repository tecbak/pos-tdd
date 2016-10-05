package ua.rd.pos;

import ua.rd.pos.coin.Coin;
import ua.rd.pos.coin.Coins;
import ua.rd.pos.product.Product;
import ua.rd.pos.product.Products;

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


    public Product buy(String name) {
        Product product = Products.valueOf(name.toUpperCase());
        if (totalValue(coins) >= product.getPrice()) {
            coins = getChange(coins, product.getPrice());
            return product;
        } else {
            return null;
        }
    }

    private List<Coin> getChange(List<Coin> coins, int price) {
        List<Coin> change = new ArrayList<>();
        while (price > 0) {
            for (Coins coin : Coins.values()) {
                if (price >= coin.getValue()) {
                    change.add(coin);
                    price -= coin.getValue();
                    break;
                }
            }
        }
        return change;
    }

    private int totalValue(List<Coin> coins) {
        int sum = 0;
        for (Coin coin : coins) {
            sum = coin.getValue();
        }
        return sum;
    }
}
