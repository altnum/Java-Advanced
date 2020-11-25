package Logger;

public class Logger {
    private String message;

    public Logger(String message) {
        this.message = message;
    }

    public void logOnConsole() {
        System.out.println(this.message);
    }

    //TODO: add file logic here
}