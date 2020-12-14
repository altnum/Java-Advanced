package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ComputerTest {
    Computer computer;
    Part part1;
    Part part2;

    @Before
    public void setUp() {
        computer = new Computer("Acer");
        part1 = new Part("Type-C connector", 20);
        part2 = new Part("Intel Core i5", 300);
        computer.addPart(part1);
        computer.addPart(part2);
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("Acer", computer.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testReturnExceptionIfNameIsNull() {
        Computer c = new Computer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testReturnExceptionIfNameIsBlank() {
        Computer c = new Computer("");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testUnmodifiableList() {
        computer.getParts().add(part1);
    }

    @Test
    public void testRightTotalPrice() {
        double d = 320.0;
        Assert.assertEquals(d, Double.parseDouble(String.valueOf(computer.getTotalPrice())), 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowExceptionIfAddedPartIsNull() {
        computer.addPart(null);
    }

    @Test
    public void testIfPartWasRemoved() {
        Assert.assertTrue(computer.removePart(part1));
    }

    @Test
    public void testGetPartByName() {
        Assert.assertEquals(part1, computer.getPart("Type-C connector"));
    }

    @Test
    public void testGetPartByNameReturnNullIfItDoesNotExist() {
        assertNull(computer.getPart("Radeon"));
    }
}