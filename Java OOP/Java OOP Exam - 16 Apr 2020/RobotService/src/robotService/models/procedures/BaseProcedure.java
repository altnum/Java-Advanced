package robotService.models.procedures;

import robotService.models.procedures.interfaces.Procedure;
import robotService.models.robots.interfaces.Robot;

import java.util.LinkedHashMap;
import java.util.Map;

import static robotService.common.ExceptionMessages.INSUFFICIENT_PROCEDURE_TIME;

public abstract class BaseProcedure implements Procedure {
    protected Map<String, Robot> robots;

    protected BaseProcedure() {
        robots = new LinkedHashMap<>();
    }

    @Override
    public String history() {
        StringBuilder sb = new StringBuilder(this.getClass().getSimpleName());
        sb.append(System.lineSeparator());

        for (Robot robot : robots.values()) {
            sb.append(robot.toString());
            sb.append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

    @Override
    public void doService(Robot robot, int procedureTime) {
        if (robot.getProcedureTime() < procedureTime)
            throw new IllegalArgumentException(INSUFFICIENT_PROCEDURE_TIME);

        robot.setProcedureTime(robot.getProcedureTime() - procedureTime);
        robots.put(robot.getName(), robot);
    }
}
