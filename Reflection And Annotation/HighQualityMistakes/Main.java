package HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static class MethodComparatorByName implements Comparator<Method> {
        @Override
        public int compare(Method o1, Method o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("HighQualityMistakes.Reflection");

        Set<Field> fields = new TreeSet<>(Comparator.comparing(Field::getName));
        Set<Method> getters = new TreeSet<>(new MethodComparatorByName());
        Set<Method> setters = new TreeSet<>(new MethodComparatorByName());

        fields.addAll(
                Arrays.stream(clazz.getDeclaredFields())
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .collect(Collectors.toList())
        );

        System.out.println(fields.stream().map(f -> f.getName() + " must be private!")
        .collect(Collectors.joining(System.lineSeparator())));

        Method[] declaredMethods = clazz.getDeclaredMethods();

        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.getName().startsWith("get") && !Modifier.isPublic(declaredMethod.getModifiers())) {
                getters.add(declaredMethod);
            } else if (declaredMethod.getName().startsWith("set") && !Modifier.isPrivate(declaredMethod.getModifiers())) {
                setters.add(declaredMethod);
            }
        }

        System.out.println(getters.stream().map(g -> g.getName() + " have to be public!")
                .collect(Collectors.joining(System.lineSeparator())));

        System.out.println(setters.stream().map(s -> s.getName() + " have to be private!")
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
