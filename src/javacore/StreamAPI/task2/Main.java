package javacore.StreamAPI.task2;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        long minor = persons.stream()
                .filter(x -> x.getAge() < 18)
                .count();
        System.out.println("minor = " + minor);

        List<String> serviceman = persons.stream()
                .filter(x -> x.getAge() > 18 && x.getAge() < 27)
                .map(x -> x.getFamily())
                .collect(Collectors.toList());
        System.out.println("serviceman = " + serviceman.stream().count());

        List<Person> workable = persons.stream()
                .filter(x -> x.getEducation().equals(Education.HIGHER))
                .filter(x -> x.getAge() > 18 && x.getAge() < 60 && x.getSex().equals(Sex.WOMAN) ||
                        x.getAge() > 18 && x.getAge() < 65 && x.getSex().equals(Sex.MAN))
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());

        System.out.println("workable = " + workable.size());
    }
}
