package br.xksoberbado;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

//    public static final int MAX = 10_000;
//    public static final int MAX = 100_000;
    public static final int MAX = 1_000_000;

    private static final List<Integer> numbers1 = new ArrayList<>();
    private static final List<Integer> numbers2 = new LinkedList<>();

    static {
        IntStream.rangeClosed(0, MAX)
            .forEach(n -> {
                numbers1.add(n);
                numbers2.add(n);
            });
    }

    public static void main(String[] args) {
//        System.out.print("S");
//        run(
//            () -> IntStream.rangeClosed(1, MAX)
//                .filter(n -> n % 2 == 0)
//                .count()
//        );
//
//        System.out.print("P");
//        run(
//            () -> IntStream.rangeClosed(1, MAX)
//                .parallel()
//                .filter(n -> n % 2 == 0)
//                .count()
//        );

        System.out.print("A");
        run(
            () -> numbers1.parallelStream()
                .filter(n -> n % 2 == 0)
                .count()
        );

        System.out.print("L");
        run(
            () -> numbers2.parallelStream()
                .filter(n -> n % 2 == 0)
                .count()
        );
    }

    private static void run(final Runnable runnable) {
        final var start = LocalDateTime.now();

        runnable.run();

        final var end = LocalDateTime.now();
        System.out.println(": " + Duration.between(start, end).toNanos());
    }
}