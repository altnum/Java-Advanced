package MilitaryElite;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();
        List<PrivateImpl> privates = new LinkedList<>();

        while (!"End".equals(command)) {
            String[] tokens = command.split("\\s+");

            switch (tokens[0]) {
                case "MilitaryElite.Private":
                    PrivateImpl privateSoldier = new PrivateImpl(Integer.parseInt(tokens[1]), tokens[2], tokens[3], Double.parseDouble(tokens[4]));
                    privates.add(privateSoldier);
                    System.out.println(privateSoldier.toString().trim());
                    break;
                case "LeutenantGeneral":
                    LieutenantGeneralImpl lieutenantGeneral = new LieutenantGeneralImpl(Integer.parseInt(tokens[1]), tokens[2], tokens[3], Double.parseDouble(tokens[4]));
                    for (int i = 5; i < tokens.length; i++) {
                        for (PrivateImpl pr : privates) {
                            if (pr.getId() == Integer.parseInt(tokens[i]))
                                lieutenantGeneral.addPrivate(pr);
                        }
                    }
                    System.out.println(lieutenantGeneral.toString().trim());
                    break;
                case "MilitaryElite.Engineer":
                    if (tokens[5].equals("Marines") || tokens[5].equals("Airforces")) {
                        EngineerImpl engineer = new EngineerImpl(Integer.parseInt(tokens[1]), tokens[2], tokens[3], Double.parseDouble(tokens[4]), Corps.valueOf(tokens[5].toUpperCase()));
                        for (int i = 6; i < tokens.length - 1; i += 2) {
                            Repair repair = new Repair(tokens[i], Integer.parseInt(tokens[i + 1]));
                            engineer.addRepair(repair);
                        }
                        System.out.println(engineer.toString().trim());
                    }
                    break;
                case "MilitaryElite.Commando":
                    if (tokens[5].equals("Marines") || tokens[5].equals("Airforces")) {
                        CommandoImpl commando = new CommandoImpl(Integer.parseInt(tokens[1]), tokens[2], tokens[3], Double.parseDouble(tokens[4]), Corps.valueOf(tokens[5].toUpperCase()));
                        for (int i = 6; i < tokens.length - 1; i += 2) {
                            if (tokens[i + 1].equals("Finished") || tokens[i + 1].equals("inProgress")) {
                                State state = State.valueOf(tokens[i + 1].toUpperCase());
                                Mission mission = new Mission(tokens[i], state);
                                commando.addMission(mission);
                            }
                        }
                        System.out.println(commando.toString().trim());
                    }
                    break;
                case "MilitaryElite.Spy":
                    SpyImpl spy = new SpyImpl(Integer.parseInt(tokens[1]), tokens[2], tokens[3], tokens[4]);
                    System.out.println(spy.toString().trim());
                    break;
                default:
                    break;
            }
            command = scan.nextLine();
        }
    }
}
