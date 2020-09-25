import java.util.Scanner;

public class RadioactiveMutantVampireBunnies {
    private static String result = "";
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int M = scan.nextInt();
        scan.nextLine();

        String[][] lair = new String[N][M];

        for (int i = 0; i < N; i++) {
            String line = scan.nextLine();
            for (int j = 0; j < line.length(); j++) {
                lair[i][j] = String.valueOf(line.charAt(j));
            }
        }

        String directions = scan.nextLine();
        boolean won = false;
        boolean dead = false;
        int count = 0;

        while (!won && !dead) {
            String direction = String.valueOf(directions.charAt(count));

            won = playerMoves(lair, direction);
            dead = bunniesSpread(lair);
            count++;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(lair[i][j]);
            }
            System.out.println();
        }
        System.out.println(result);
    }

    private static boolean bunniesSpread(String[][] lair) {
        for (int i = 0; i < lair.length; i++) {
            for (int j = 0; j < lair[0].length; j++) {
                if ("B".equals(lair[i][j])) {
                    if (i - 1 >= 0) {
                        if ("P".equals(lair[i - 1][j])) {
                            result = "dead: " + (i - 1) + " " + j;
                        }
                        if (!"B".equals(lair[i - 1][j]))
                            lair[i - 1][j] = "*";
                    }
                    if (i + 1 < lair.length) {
                        if ("P".equals(lair[i + 1][j])) {
                            result = "dead: " + (i + 1) + " " + j;
                        }
                        if (!"B".equals(lair[i + 1][j]))
                            lair[i + 1][j] = "*";
                    }
                    if (j - 1 >= 0) {
                        if ("P".equals(lair[i][j - 1])) {
                            result = "dead: " + i + " " + (j - 1);
                        }
                        if (!"B".equals(lair[i][j - 1]))
                            lair[i][j - 1] = "*";
                    }
                    if (j + 1 < lair[0].length) {
                        if ("P".equals(lair[i][j + 1])) {
                            result = "dead: " + i + " " + (j + 1);
                        }
                        if (!"B".equals(lair[i][j + 1]))
                            lair[i][j + 1] = "*";
                    }
                }
            }
        }
        for (int i = 0; i < lair.length; i++) {
            for (int j = 0; j < lair[0].length; j++) {
                if (lair[i][j].equals("*"))
                    lair[i][j] = "B";
            }
        }
        for (int i = 0; i < lair.length; i++) {
            for (int j = 0; j < lair[0].length; j++) {
                if ("P".equals(lair[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean playerMoves(String[][] lair, String direction) {
        int playerRow = 0;
        int playerCol = 0;
        boolean br = false;

        for (int i = 0; i < lair.length; i++) {
            for (int j = 0; j < lair[0].length; j++) {
                if ("P".equals(lair[i][j])) {
                    playerRow = i;
                    playerCol = j;
                    br = true;
                    break;
                }
            }
            if (br)
                break;
        }
        int lastRow = playerRow;
        int lastCol = playerCol;

        if ("U".equals(direction)) {
            playerRow--;
        } else if ("R".equals(direction)) {
            playerCol++;
        } else if ("D".equals(direction)) {
            playerRow++;
        } else if ("L".equals(direction)) {
            playerCol--;
        }

        if ((playerRow < 0 || playerRow >= lair.length) || (playerCol < 0 || playerCol >= lair[0].length)) {
            lair[lastRow][lastCol] = ".";
            result = "won: " + lastRow + " " + lastCol;
            return true;
        } else if (lair[playerRow][playerCol].equals("B")) {
            lair[lastRow][lastCol] = ".";
            result = "dead: " + playerRow + " " + playerCol;
            return false;
        } else if (lair[playerRow][playerCol].equals(".")) {
            lair[lastRow][lastCol] = ".";
            lair[playerRow][playerCol] = "P";
            return false;
        }
        return false;
    }
}
