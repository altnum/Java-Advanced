package robotService.core;

import robotService.core.interfaces.Controller;
import robotService.models.garages.GarageImpl;
import robotService.models.garages.interfaces.Garage;
import robotService.models.procedures.Charge;
import robotService.models.procedures.Repair;
import robotService.models.procedures.Work;
import robotService.models.procedures.interfaces.Procedure;
import robotService.models.robots.Cleaner;
import robotService.models.robots.Housekeeper;
import robotService.models.robots.interfaces.Robot;

import java.util.LinkedHashMap;

import static robotService.common.ExceptionMessages.INVALID_ROBOT_TYPE;
import static robotService.common.ExceptionMessages.NON_EXISTING_ROBOT;
import static robotService.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Garage garage;
    private Procedure charge;
    private Procedure repair;
    private Procedure work;

    public ControllerImpl() {
        this.garage = new GarageImpl(new LinkedHashMap<>());
        this.repair = new Repair();
        this.charge = new Charge();
        this.work = new Work();
    }

    @Override
    public String manufacture(String robotType, String name, int energy, int happiness, int procedureTime) {
        Robot robot;
        switch (robotType) {
            case "Cleaner":
                robot = new Cleaner(name, energy, happiness, procedureTime);
                break;
            case "Housekeeper":
                robot = new Housekeeper(name, energy, happiness, procedureTime);
                break;
            default:
                throw new IllegalArgumentException(String.format(INVALID_ROBOT_TYPE, robotType));
        }

        garage.manufacture(robot);

        return String.format(ROBOT_MANUFACTURED, name);
    }

    @Override
    public String repair(String robotName, int procedureTime) {
        checkIfRobotExists(robotName);

        this.repair.doService(garage.getRobots().get(robotName), procedureTime);

        return String.format(REPAIR_PROCEDURE, robotName);
    }

    @Override
    public String work(String robotName, int procedureTime) {
        checkIfRobotExists(robotName);

        this.work.doService(garage.getRobots().get(robotName), procedureTime);

        return String.format(WORK_PROCEDURE, robotName, procedureTime);
    }

    @Override
    public String charge(String robotName, int procedureTime) {
        checkIfRobotExists(robotName);

        this.charge.doService(garage.getRobots().get(robotName), procedureTime);

        return String.format(CHARGE_PROCEDURE, robotName);
    }

    @Override
    public String sell(String robotName, String ownerName) {
        checkIfRobotExists(robotName);

        garage.sell(robotName, ownerName);

        return String.format(SELL_ROBOT, ownerName, robotName);
    }

    @Override
    public String history(String procedureType) {
        switch (procedureType) {
            case "Work":
                return work.history();
            case "Charge":
                return charge.history();
            case "Repair":
                return repair.history();
        }
        return null;
    }

    public void checkIfRobotExists(String robotName) {
        if(!garage.getRobots().containsKey(robotName))
            throw new IllegalArgumentException(String.format(NON_EXISTING_ROBOT, robotName));
    }
}
