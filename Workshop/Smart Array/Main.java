public class Main {
    public static void main(String[] args) {
        SmartArray smartArray = new SmartArray();

        for (int i = 0; i < 1024; i++) {
            smartArray.add(i + 1);
        }

        for (int i = 0; i < 1023; i++) {
            smartArray.remove(1023 - i);
        }


        System.out.println();
    }
}
