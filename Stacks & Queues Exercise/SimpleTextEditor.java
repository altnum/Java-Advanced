import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        ArrayDeque<String> commandsStack = new ArrayDeque<>();
        ArrayDeque<String> removedStrings = new ArrayDeque<>();
        StringBuilder text = new StringBuilder("");

        for (int i = 0; i < n; i++) {
            String commandInfo = scan.nextLine();
            String[] command = commandInfo.split("\\s+");
            boolean not4 = true;

            switch (command[0]) {
                case "1":
                    text.append(command[1]);
                    break;
                case "2":
                    removedStrings.push(text.substring(text.length() - Integer.parseInt(command[1]), text.length()));
                    text.replace(text.length() - Integer.parseInt(command[1]), text.length(), "");
                    break;
                case "3":
                    System.out.println(text.charAt(Integer.parseInt(command[1]) - 1));
                    break;
                case "4":
                    not4 = false;

                    String removedCommandInfo = commandsStack.pop();
                    String[] removedCommand = removedCommandInfo.split("\\s+");

                    while (!"1".equals(removedCommand[0]) && !"2".equals(removedCommand[0])) {
                        removedCommand = commandsStack.pop().split("\\s+");
                    }

                    switch (removedCommand[0]) {
                        case "1":
                            int start = text.lastIndexOf(removedCommand[1]);
                            text.replace(start, text.length(), "");
                            break;
                        case "2":
                            text.append(removedStrings.pop());
                            break;
                        }
                    break;
            }

            if (not4)
                commandsStack.push(commandInfo);
        }
    }
}
