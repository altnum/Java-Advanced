package easterRaces.core;

import easterRaces.core.interfaces.Controller;
import easterRaces.entities.cars.Car;
import easterRaces.entities.cars.MuscleCar;
import easterRaces.entities.cars.SportsCar;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.drivers.DriverImpl;
import easterRaces.entities.racers.Race;
import easterRaces.entities.racers.RaceImpl;
import easterRaces.repositories.CarRepository;
import easterRaces.repositories.DriverRepository;
import easterRaces.repositories.RaceRepository;
import easterRaces.repositories.interfaces.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static easterRaces.common.ExceptionMessages.*;
import static easterRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Driver> driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driver) {
        if (driverRepository.getByName(driver) != null)
            throw new IllegalArgumentException(String.format(DRIVER_EXISTS, driver));

        Driver dr = new DriverImpl(driver);

        driverRepository.add(dr);

        return String.format(DRIVER_CREATED, driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car = null;

        switch (type) {
            case "Muscle":
                car = new MuscleCar(model, horsePower);
                break;
            case "Sports":
                car = new SportsCar(model, horsePower);
                break;
        }

        if (carRepository.getByName(model) != null)
            throw new IllegalArgumentException(String.format(CAR_EXISTS, model));

        carRepository.add(car);

        return String.format(CAR_CREATED, type + "Car", model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        if (driverRepository.getByName(driverName) == null)
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));

        if (carRepository.getByName(carModel) == null)
            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND, carModel));

        driverRepository.getByName(driverName).addCar(carRepository.getByName(carModel));

        return String.format(CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        if (raceRepository.getByName(raceName) == null)
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));

        if (driverRepository.getByName(driverName) == null)
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));

        raceRepository.getByName(raceName).addDriver(driverRepository.getByName(driverName));

        return String.format(DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        if (raceRepository.getByName(raceName) == null)
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));

        if (raceRepository.getByName(raceName).getDrivers().size() < 3)
            throw new IllegalArgumentException(String.format(RACE_INVALID, raceName, 3));

        List<Driver> result = raceRepository.getByName(raceName).getDrivers().stream()
                .sorted(Comparator.comparingDouble(r -> r.getCar().calculateRacePoints(raceRepository.getByName(raceName).getLaps()))).collect(Collectors.toList());

        raceRepository.remove(raceRepository.getByName(raceName));

        StringBuilder sb = new StringBuilder(String.format(DRIVER_FIRST_POSITION, result.get(2).getName(), raceName));
        sb.append(System.lineSeparator());
        sb.append(String.format(DRIVER_SECOND_POSITION, result.get(1).getName(), raceName));
        sb.append(System.lineSeparator());
        sb.append(String.format(DRIVER_THIRD_POSITION, result.get(0).getName(), raceName));


        return sb.toString();
    }

    @Override
    public String createRace(String name, int laps) {
        Race race = new RaceImpl(name, laps);

        if (raceRepository.getByName(race.getName()) != null)
            throw new IllegalArgumentException(String.format(RACE_EXISTS, race.getName()));

        raceRepository.add(race);

        return String.format(RACE_CREATED, race.getName());
    }
}
