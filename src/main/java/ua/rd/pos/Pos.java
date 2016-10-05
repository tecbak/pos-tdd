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
        int coinsValue = totalValue(coins);
        int productPrice = product.getPrice();

        if (coinsValue >= productPrice) {
            coins = getChange(coinsValue, productPrice);
            return product;
        } else {
            return null;
        }
    }

    private List<Coin> getChange(int paid, int price) {
        if (paid < price) throw new IllegalArgumentException("Paid can't be less then price");

        List<Coin> change = new ArrayList<>();
        if (paid > price) {
            int moneyToReturn = paid - price;
            while (moneyToReturn > 0) {
                Coin coin = getTheMostExpensiveCoin(moneyToReturn, Coins.values());
                moneyToReturn -= coin.getValue();
                change.add(coin);
            }
        }
        return change;
    }

    private Coin getTheMostExpensiveCoin(int limit, Coin[] coins) {
        for (Coin coin : coins) {
            if (coin.getValue() <= limit) {
                return coin;
            }
        }
        throw new IllegalStateException("No suitable coin");
    }

    private int totalValue(List<Coin> coins) {
        int sum = 0;
        for (Coin coin : coins) {
            sum = coin.getValue();
        }
        return sum;
    }
}
