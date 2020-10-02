import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        List<BankAccount> users = new ArrayList<>();

        while (!"End".equals(command)) {
            String[] info = command.split("\\s+");
            boolean exist = false;

            switch (info[0]) {
                case "Create":
                    BankAccount user = new BankAccount();
                    System.out.println("Account ID" + user.getId() + " created");
                    users.add(user);
                    break;
                case "Deposit":
                    for (BankAccount u: users) {
                        if (u.getId() == Integer.parseInt(info[1])) {
                            u.deposit(Double.parseDouble(info[2]));
                            System.out.printf("Deposited %s to ID%d%n", info[2], u.getId());
                            exist = true;
                            break;
                        }
                    }
                    if (!exist)
                        System.out.println("Account does not exist");
                    break;
                case "SetInterest":
                    BankAccount.setInterest(Double.parseDouble(info[1]));
                    break;
                case "GetInterest":
                    for (BankAccount u: users) {
                        if (u.getId() == Integer.parseInt(info[1])) {
                            System.out.printf("%.2f%n", u.getInterest(Integer.parseInt(info[2])));
                            exist = true;
                            break;
                        }
                    }
                    if (!exist)
                        System.out.println("Account does not exist");
                    break;

            }
            command = scan.nextLine();
        }
    }
}
