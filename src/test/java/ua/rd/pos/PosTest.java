package ua.rd.pos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PosTest {
    private Pos pos;

    @Before
    public void setUp() throws Exception {
        pos = new Pos();

    }

    @Test
    public void testInsertAndReturnCoin() throws Exception {
        Coin coin1 = Coins.ONE;
        Coin coin2 = Coins.FIVE;

        pos.insertCoin(coin1);
        pos.insertCoin(coin2);

        List<Coin> expected = pos.returnCoins();
        List<Coin> actual = new ArrayList<Coin>() {{
            add(coin1);
            add(coin2);
        }};

        Assert.assertEquals(expected, actual);
    }
}

