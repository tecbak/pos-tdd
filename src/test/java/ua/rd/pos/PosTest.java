package ua.rd.pos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.rd.pos.coin.Coin;
import ua.rd.pos.coin.Coins;
import ua.rd.pos.product.Product;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PosTest {
    private Pos pos;
    private Coin one;
    private Coin five;
    private Coin twentyFive;

    @Before
    public void setUp() throws Exception {
        pos = new Pos();
        one = Coins.ONE;
        five = Coins.FIVE;
        twentyFive = Coins.TWENTY_FIVE;
    }

    @Test
    public void testInsertAndReturnCoin() throws Exception {
        pos.insertCoin(one);
        pos.insertCoin(five);

        List<Coin> expected = pos.returnCoins();
        List<Coin> actual = new ArrayList<Coin>() {{
            add(one);
            add(five);
        }};

        assertEquals(expected, actual);
    }

    @Test
    public void testBuyProduct() throws Exception {
        pos.insertCoin(twentyFive);
        Product purchasedProduct = pos.buy("tea");
        String actual = purchasedProduct.getName();
        String expected = "Tea";
        assertEquals(expected, actual);
    }
}

