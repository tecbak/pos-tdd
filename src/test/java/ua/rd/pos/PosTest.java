package ua.rd.pos;

import org.junit.Before;
import org.junit.Test;
import ua.rd.pos.coin.Coin;
import ua.rd.pos.product.Product;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static ua.rd.pos.coin.Coins.*;

public class PosTest {
    private Pos pos;


    @Before
    public void setUp() throws Exception {
        pos = new Pos();

    }

    @Test
    public void testInsertAndReturnCoin() throws Exception {
        pos.insertCoin(ONE);
        pos.insertCoin(FIVE);

        List<Coin> expected = pos.returnCoins();
        List<Coin> actual = new ArrayList<Coin>() {{
            add(ONE);
            add(FIVE);
        }};

        assertEquals(expected, actual);
    }

    @Test
    public void testBuyProduct() throws Exception {
        pos.insertCoin(TWENTY_FIVE);
        Product purchasedProduct = pos.buy("tea");
        String actual = purchasedProduct.getName();
        String expected = "Tea";
        assertEquals(expected, actual);
    }

    @Test
    public void testReturnChange() throws Exception {
        pos.insertCoin(FIFTY);
        pos.buy("coffee");
        List<Coin> actual = pos.returnCoins();
        List<Coin> expected = new ArrayList<>();
        expected.add(TEN);
        expected.add(FIVE);
        assertEquals(expected, actual);
    }
}

