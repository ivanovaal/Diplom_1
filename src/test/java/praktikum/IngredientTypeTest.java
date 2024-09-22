package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTypeTest {

    @Test
    public void valuesTest() {
        IngredientType[] expectedValues = {
                IngredientType.SAUCE,
                IngredientType.FILLING
        };
        IngredientType[] actualValues = IngredientType.values();
        Assert.assertArrayEquals(expectedValues, actualValues);
    }
}