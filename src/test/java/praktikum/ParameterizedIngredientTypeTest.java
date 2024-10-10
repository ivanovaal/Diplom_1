package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class ParameterizedIngredientTypeTest {

    private final IngredientType ingredientType;

    public ParameterizedIngredientTypeTest(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {FILLING},
                {SAUCE}
        };
    }

    @Test
    public void valueOfTest() {
        IngredientType actualValue = IngredientType.valueOf(this.ingredientType.name());
        Assert.assertEquals(this.ingredientType, actualValue);
    }
}