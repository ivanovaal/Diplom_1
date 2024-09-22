package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private static final float EXPECTED_BURGER_PRICE = 6.48f;
    private static final float BUN_PRICE = 1.99f;
    private static final float BBQ_SAUCE_PRICE = 2.50f;
    private static final String BBQ_SAUCE_NAME = "BBQ";
    private static final String BUN_NAME = "Brioche";

    @Mock
    private Bun mockBun;
    @Mock
    private Ingredient mockBbqSauce;
    @Mock
    private Ingredient mockFriedOnion;
    private Burger burger;

    @Before
    public void setUp() {
        this.burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        this.burger.setBuns(this.mockBun);
        Bun actualBun = this.burger.bun;
        Assert.assertEquals(this.mockBun, actualBun);
    }

    @Test
    public void addIngredientTest() {
        List<Ingredient> expectedIngredients = List.of(mockBbqSauce);
        this.burger.addIngredient(mockBbqSauce);
        List<Ingredient> actualIngredients = this.burger.ingredients;
        Assert.assertEquals(expectedIngredients, actualIngredients);
    }

    @Test
    public void removeIngredientTest() {
        this.burger.addIngredient(this.mockBbqSauce);
        int startingIngredientsSize = this.burger.ingredients.size();
        int expectedIngredientsSize = 0;
        this.burger.removeIngredient(0);
        int actualIngredientsSize = this.burger.ingredients.size();
        Assert.assertNotEquals(startingIngredientsSize, actualIngredientsSize);
        Assert.assertEquals(expectedIngredientsSize, actualIngredientsSize);
    }

    @Test
    public void moveIngredient() {
        this.burger.addIngredient(this.mockBbqSauce);
        this.burger.addIngredient(this.mockFriedOnion);
        int startingBbqSauceIndex = this.burger.ingredients.indexOf(this.mockBbqSauce);
        int expectedBbqSauceIndex = this.burger.ingredients.size() - 1;
        this.burger.moveIngredient(startingBbqSauceIndex, expectedBbqSauceIndex);
        Ingredient expectedIngredient = this.burger.ingredients.get(expectedBbqSauceIndex);
        Assert.assertEquals(this.mockBbqSauce, expectedIngredient);
    }

    @Test
    public void getPriceTest() {
        Mockito.when(this.mockBun.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(this.mockBbqSauce.getPrice()).thenReturn(BBQ_SAUCE_PRICE);
        this.burger.setBuns(this.mockBun);
        this.burger.addIngredient(this.mockBbqSauce);
        float actualPrice = this.burger.getPrice();
        Assert.assertEquals(EXPECTED_BURGER_PRICE, actualPrice, 0);
    }

    @Test
    public void getReceiptTest() {
        Mockito.when(this.mockBun.getName()).thenReturn(BUN_NAME);
        Mockito.when(this.mockBun.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(this.mockBbqSauce.getPrice()).thenReturn(BBQ_SAUCE_PRICE);
        Mockito.when(this.mockBbqSauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(this.mockBbqSauce.getName()).thenReturn(BBQ_SAUCE_NAME);
        this.burger.setBuns(this.mockBun);
        this.burger.addIngredient(this.mockBbqSauce);
        String expectedReceipt = "(==== Brioche ====)\n" +
                "= sauce BBQ =\n" +
                "(==== Brioche ====)\n" +
                "\n" +
                "Price: 6,480000\n";
        String actualReceipt = this.burger.getReceipt();
        Assert.assertEquals(expectedReceipt, actualReceipt);
    }
}