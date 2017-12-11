package p05_Square;

import org.junit.Assert;
import org.junit.Test;

public class RectangleTests {
	
    @Test
    public void getSidesTest() {
        Rectangle rect = new Rectangle(10, 5);
        Assert.assertEquals(5, rect.getHeight());
        Assert.assertEquals(10, rect.getWidth());
    }

    @Test
    public void getAreaTest() {
        Rectangle rect = new Rectangle(5, 10);
        Rectangle square = new Square(5);
        Assert.assertEquals("ERROR: in getArea() for Rectangle!", 50, rect.getArea());
        Assert.assertEquals("ERROR: in getArea() for Square!", 25, square.getArea());
    }
    
}
