package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType ingredientType;
    private final String name;
    private final float price;
    private final Ingredient ingredient;

    public IngredientTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
        this.ingredient = new Ingredient(this.ingredientType, this.name, this.price);
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {IngredientType.FILLING, "Fried Onion", 1.89f},
                {IngredientType.SAUCE, "BBQ", 2.50f}
        };
    }

    @Test
    public void getPriceTest() {
        float actualPrice = this.ingredient.getPrice();
        Assert.assertEquals(this.price, actualPrice, 0);
    }

    @Test
    public void getNameTest() {
        String actualName = this.ingredient.getName();
        Assert.assertEquals(this.name, actualName);
    }

    @Test
    public void getTypeTest() {
        IngredientType actualType = this.ingredient.getType();
        Assert.assertEquals(this.ingredientType, actualType);
    }
}