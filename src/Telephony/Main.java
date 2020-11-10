package Telephony;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> phonesToCall = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toCollection(LinkedList::new));
        List<String> sitesToBrowse = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toCollection(LinkedList::new));
        Smartphone smartphone = new Smartphone(phonesToCall, sitesToBrowse);

        System.out.println(smartphone.call().trim());
        System.out.println(smartphone.browse().trim());
    }
}
