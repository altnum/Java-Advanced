import java.util.Scanner;

public class ParkingSystem {
    private static boolean[][] parking;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int R = scan.nextInt();
        int C = scan.nextInt();

        parking = new boolean[R][C];

        scan.nextLine();

        String[] commandInfo = scan.nextLine().split("\\s+");

        while (!"stop".equals(commandInfo[0])) {
            int Z = Integer.parseInt(commandInfo[0]);
            int X = Integer.parseInt(commandInfo[1]);
            int Y = Integer.parseInt(commandInfo[2]);

            commandInfo = scan.nextLine().split("\\s+");

            boolean parked = movement(parking, Z, X, Y);
        }

    }

    private static boolean movement(boolean[][] parking, int z, int x, int y) {
        int maneuvers = 0;

        while (z > x) {
            z--;
            maneuvers++;
        }
        while (z < x) {
            z++;
            maneuvers++;
        }
        boolean parked = false;

        if (z == x) {
            maneuvers++;
                if (parking[x][y]) {
                    int diff = 0;
                    int counter = 1;
                    boolean br1 = false;
                    boolean br2 = false;
                    boolean p1 = false;
                    boolean p2 = false;

                    while (!parked) {
                        int helper = y;
                        if (p1 && p2) {
                            diff++;
                            p1 = false;
                            p2 = false;
                        }
                        if (counter % 2 == 0) {
                            helper += diff;
                            p1 = true;
                            if (helper < parking[x].length) {

                                if (!parking[x][helper]) {
                                    parked = true;
                                    parking[x][helper] = true;
                                    maneuvers += helper;
                                }
                            } else {
                                br1 = true;
                            }
                        } else {
                            helper -= diff;
                            p2 = true;
                            if (helper >= 1) {

                                if (!parking[x][helper]) {
                                    parked = true;
                                    parking[x][helper] = true;
                                    maneuvers += helper;
                                }
                            } else {
                                br2 = true;
                            }
                        }
                        if (br1 && br2)
                            break;
                        counter++;
                    }
                } else {
                    parked = true;
                    parking[x][y] = true;
                    maneuvers += y;
                }
                if (parked) {
                    System.out.println(maneuvers);

                } else {
                    maneuvers = 0;
                    System.out.printf("Row %d full%n", x);

                }
            }
        return parked;
    }
}
