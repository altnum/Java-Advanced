import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double playerDmg = Double.parseDouble(scan.nextLine());
        int playerHP = 18500;

        String[] spellInfo = scan.nextLine().split("\\s+");
        double heiganHP = 3000000;
        String lastSpell = "";

        String[][] battlefield = new String[15][15];
        for (int i = 0; i < battlefield.length; i++) {
            Arrays.fill(battlefield[i], " ");
        }
        battlefield[7][7] = "p";
        int rowPl = 7;
        int colPl = 7;

        while (playerHP > 0 && heiganHP > 0) {
            int rowSpell = Integer.parseInt(spellInfo[1]);
            int colSpell = Integer.parseInt(spellInfo[2]);
            String spell = spellInfo[0];

            heiganHP -= playerDmg;

            if (lastSpell.equals("Cloud")) {
                playerHP -= 3500;
            }
            if (heiganHP <= 0 || playerHP <= 0)
                break;

            if (inDamageArea(rowSpell, colSpell, rowPl, colPl)) {
                if (rowPl - 1 >= 0 && !inDamageArea(rowSpell, colSpell, rowPl - 1, colPl)) {
                    rowPl--;
                    lastSpell = "";
                } else if (colPl + 1 >= 0 && !inDamageArea(rowSpell, colSpell, rowPl, colPl + 1)) {
                    colPl++;
                    lastSpell = "";
                } else if (rowPl + 1 >= 0 && !inDamageArea(rowSpell, colSpell, rowPl + 1, colPl)) {
                    rowPl++;
                    lastSpell = "";
                } else if (colPl - 1 >= 0 && !inDamageArea(rowSpell, colSpell, rowPl, colPl - 1)) {
                    colPl--;
                    lastSpell = "";
                } else {
                    switch (spell) {
                        case "Cloud":
                            playerHP -= 3500;
                            lastSpell = "Cloud";
                            break;
                        case "Eruption":
                            playerHP -= 6000;
                            lastSpell = "Eruption";
                            break;
                    }
                }

            }
            if (playerHP <= 0)
                break;
            spellInfo = scan.nextLine().split("\\s+");
        }
        lastSpell = lastSpell.equals("Cloud") ? "Plague Cloud" : "Eruption";
        String heigan = heiganHP > 0 ? String.format("Heigan: %.2f", heiganHP) : "Heigan: Defeated!";
        String player = playerHP > 0 ? String.format("Player: %d", playerHP) : String.format("Player: Killed by %s", lastSpell);
        String position = String.format("Final position: %s, %s", rowPl, colPl);

        System.out.println(heigan);
        System.out.println(player);
        System.out.println(position);


    }

    private static boolean inDamageArea(int rowSpell, int colSpell, int moveRow, int moveCol) {
        return ((rowSpell - 1 <= moveRow && moveRow <= rowSpell + 1) && (colSpell - 1 <= moveCol && colSpell + 1 >= moveCol));
    }
}
