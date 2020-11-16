package Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder("");

        label1:
        for (String number : this.numbers) {
            for (int i = 0; i < number.length(); i++) {
                if (number.charAt(i) > 57 || number.charAt(i) < 48) {
                    sb.append("Invalid number!").append(System.lineSeparator());
                    continue label1;
                }
            }
            sb.append("Calling... ").append(number).append(System.lineSeparator());
        }
        return sb.toString();
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder("");

        label1:
        for (String site : this.urls) {
            for (int i = 0; i < site.length(); i++) {
                if (site.charAt(i) >= 48 && site.charAt(i) <= 57) {
                    sb.append("Invalid URL!").append(System.lineSeparator());
                    continue label1;
                }
            }
            sb.append("Browsing: ").append(site).append("!").append(System.lineSeparator());
        }
        return sb.toString();
    }
}
