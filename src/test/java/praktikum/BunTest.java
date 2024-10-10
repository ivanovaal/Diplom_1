package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BunTest {

    private static final String BUN_NAME = "Brioche";
    private static final float BUN_PRICE = 1.99f;

    private Bun bun;

    @Before
    public void setUp() {
        this.bun = new Bun(BUN_NAME, BUN_PRICE);
    }

    @Test
    public void getNameTest() {
        String actualName = this.bun.getName();
        Assert.assertEquals(BUN_NAME, actualName);
    }

    @Test
    public void getPriceTest() {
        float actualPrice = this.bun.getPrice();
        Assert.assertEquals(BUN_PRICE, actualPrice, 0);
    }
}