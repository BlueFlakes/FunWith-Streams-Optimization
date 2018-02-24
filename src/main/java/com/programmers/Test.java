package com.programmers;

import com.programmers.customstream.StreamFacade;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    @FunctionalInterface
    interface Procedure {
        void invoke();
    }

    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 100000; i <= 1_000_000_0; i *= 10) {
            List<Integer> testData = fill(i, random::nextInt);
            Procedure optimized = () -> optimizedStreamFacade(testData);
            Procedure builtInStream = () -> builtInStream(testData);
            Procedure traditionalLoop = () -> stringList(testData);

            testHandler("traditional: ", traditionalLoop);
            testHandler("builtIn Stream", builtInStream);
            testHandler("Optimized stream", optimized);
        }
    }

    private static void testHandler(String type, Procedure procedure) {
        System.out.println("-------------------------------------");
        System.out.println("Start with: " + type);
        LocalDateTime begin = LocalDateTime.now();

        procedure.invoke();

        long millis = ChronoUnit.MILLIS.between(begin, LocalDateTime.now());
        System.out.println("Cost millis: " + millis);
        System.out.println("-------------------------------------");
    }

    public static List<String> optimizedStreamFacade(List<Integer> container) {
        return StreamFacade.of(container).magicMap(c -> c + "abc")
                                  .extendMap(c -> c + "abc")
                                  .extendMap(c -> c + "abc")
                                  .extendMap(c -> c + "abc")
                                  .extendMap(c -> c + "abc")
                                  .execute()
                                  .collect(Collectors.toList());
    }

    public static List<String> stringList(List<Integer> container) {
        List<String> accumulator = new ArrayList<>();

        for (Integer number : container) {
            String stringRepresentation = number.toString();

            stringRepresentation += "abc";
            stringRepresentation += "abc";
            stringRepresentation += "abc";
            stringRepresentation += "abc";
            stringRepresentation += "abc";
            accumulator.add(stringRepresentation);
        }

        return accumulator;
    }

    public static List<String> builtInStream(List<Integer> container) {
        return container.stream()
                 .map(c -> c + "abc")
                 .map(c -> c + "abc")
                 .map(c -> c + "abc")
                 .map(c -> c + "abc")
                 .map(c -> c + "abc")
                 .collect(Collectors.toList());
    }


    public static <T> List<T> fill(int quantity, Supplier<T> supplier) {
        return Stream.generate(supplier)
                     .limit(quantity)
                     .collect(Collectors.toList());
    }
}
