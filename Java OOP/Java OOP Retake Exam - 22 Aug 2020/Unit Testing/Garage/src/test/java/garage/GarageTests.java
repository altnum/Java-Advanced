package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GarageTests {
    //TODO: Test Garage class
    private Garage garage;
    private Car car1;
    private Car car2;
    private Car car3;

    @Before
    public void setUp() {
        this.garage = new Garage();
        car1 = new Car("Mazda", 250, 7200);
        car2 = new Car("Bugatti", 450, 2000000);
        car3 = new Car("Mercedes-Benz", 280, 450000);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void modifiable() {
        garage.getCars().remove(0);
    }

    @Test
    public void testRightCount() {
        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);

        Assert.assertEquals(3, garage.getCount());
    }

    @Test
    public void testTheRightCarsWithSpeedAbove() {
        List<Car> cars = new ArrayList<>();
        cars.add(car2);
        cars.add(car3);

        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);

        Assert.assertEquals(cars, garage.findAllCarsWithMaxSpeedAbove(250));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWhenCarIsNull () {
        garage.addCar(null);
    }

    @Test
    public void theMostExpensive() {
        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);

        Assert.assertEquals(car2, garage.getTheMostExpensiveCar());
    }

    @Test
    public void theMostExpensiveReturnsNullWhenGarageIsEmpty() {
        Assert.assertNull(garage.getTheMostExpensiveCar());
    }

    @Test
    public void findingByBrand() {
        List<Car> cars = new ArrayList<>();
        cars.add(car1);

        garage.addCar(car1);
        garage.addCar(car2);

        Assert.assertEquals(cars, garage.findAllCarsByBrand("Mazda"));
    }

}