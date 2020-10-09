package JarOfT;

public class Main {
    public static void main(String[] args) {
        Jar<String> jarOfPickles = new Jar<>();

        jarOfPickles.add(new String());
        jarOfPickles.add(new String());

        String str = jarOfPickles.remove();
    }
}
