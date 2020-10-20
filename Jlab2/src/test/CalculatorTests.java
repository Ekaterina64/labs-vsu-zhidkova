import org.junit.Assert;
import org.junit.Test;

public class CalculatorTests {
    Calculator p = new Calculator(5);
    @Test
    public void testSummation() throws Exception {
        Assert.assertEquals(p.Parse("2+2"), 4, 0.001);
        Assert.assertEquals(p.Parse("1+2+3"), 6, 0.001);
    }

    @Test
    public void testSubtraction() throws Exception {
        Assert.assertEquals(p.Parse("2-2"), 0, 0.001);
        Assert.assertEquals(p.Parse("3-X-1"), -3, 0.001);
    }

    @Test
    public void testMultiplication() throws Exception {
        Assert.assertEquals(p.Parse("2*2"), 4, 0.001);
        Assert.assertEquals(p.Parse("1*X*3"), 15, 0.001);
    }

    @Test
    public void testDivision() throws Exception {
        Assert.assertEquals(p.Parse("2/2"), 1, 0.001);
        Assert.assertEquals(p.Parse("6/3/2"), 1, 0.001);
    }

    @Test
    public void testFunction() throws Exception {
        Assert.assertEquals(p.Parse("abs(-5)*X"), 25, 0.001);
        Assert.assertEquals(p.Parse("sin(0)"), 0, 0.001);
        Assert.assertEquals(p.Parse("cos(0)"), 1, 0.001);
        Assert.assertEquals(p.Parse("exp(0)"), 1, 0.001);
    }

    @Test
    public void testExpressionWithSubexrpession() throws Exception {
        Assert.assertEquals(p.Parse("abs(exp(0))"), 1, 0.001);
        Assert.assertEquals(p.Parse("exp(sin(0))"), 1, 0.001);
    }

    @Test
    public void someTests() throws Exception {
        Assert.assertEquals(p.Parse("2+X*3+abs(-3)"), 20, 0.001);
        Assert.assertEquals(p.Parse("(2+1)*4"), 12, 0.001);
    }
}

