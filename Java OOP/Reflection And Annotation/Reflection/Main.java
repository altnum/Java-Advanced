package Reflection;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Reflection> clazz = Reflection.class;

        System.out.println("class " + clazz.getSimpleName());

        System.out.println("class " + clazz.getSuperclass().getName());

        Class<?>[] interfaces = clazz.getInterfaces();

        for (Class<?> anInterface : interfaces) {
            System.out.println("interface " + anInterface.getName());
        }

        Reflection instance = clazz.getDeclaredConstructor().newInstance();
        System.out.println(instance.toString());
    }
}
