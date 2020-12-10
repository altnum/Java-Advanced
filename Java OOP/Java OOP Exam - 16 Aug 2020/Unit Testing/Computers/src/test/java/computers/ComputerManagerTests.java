package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ComputerManagerTests {
    private ComputerManager computerManager;
    private Computer computer;
    private Computer computer2;
    private Computer computer3;

    @Before
    public void setUp() {
        this.computerManager = new ComputerManager();
        computer = new Computer("DELL", "A4532", 300.00);
        computer2 = new Computer("Asus", "ROG", 500.00);
        computer3 = new Computer("Asus", "A4532", 500.00);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetComputers() {
        computerManager.getComputers().remove(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSecondAdd() {
        this.computerManager.addComputer(computer);
        this.computerManager.addComputer(computer);
    }

    @Test
    public void testAdd() {
        this.computerManager.addComputer(computer);
        Assert.assertEquals(1, this.computerManager.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGet() {
        this.computerManager.getComputer(null, "test_model");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGet2() {
        this.computerManager.getComputer("test_man", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetNonExisting() {
        this.computerManager.getComputer(computer.getManufacturer(), computer.getModel());
    }

    //?
    @Test
    public void testGetReturnsCorrect() {
        this.computerManager.addComputer(computer);
        Computer returned = this.computerManager.getComputer(this.computer.getManufacturer(), computer.getModel());
        assertNotNull(returned);

        assertEquals(computer.getManufacturer(), returned.getManufacturer());
        assertEquals(computer.getModel(), returned.getModel());
    }

    @Test
    public void testGetByMan() {
        this.computerManager.addComputer(computer2);
        this.computerManager.addComputer(computer3);
        List<Computer> test = this.computerManager.getComputersByManufacturer("Asus");
        List<Computer> test1 = new ArrayList<>();
        test1.add(computer2);
        test1.add(computer3);

        Assert.assertEquals(test, test1);
    }
}