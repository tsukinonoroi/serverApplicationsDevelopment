package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static final int potFull = 3;
    public static int pot = potFull;
    public static final Object lock = new Object();
    public static ArrayList<ThreadSavage2> savages = new ArrayList<>();
    public static void main(String[] args) {
        //Для запуска потоков используем функции lab3part1 и lab3part2
    }

    public static void lab3part1() {
        for (int i = 0; i < 5; i++) {
            new ThreadSavage(i).start();
        }
        new ThreadCooker().start();
    }

    public static void lab3part2() {
        for (int i = 0; i < 5; i++) {
            ThreadSavage2 savage = new ThreadSavage2(i, false);
            savages.add(savage);
            savage.start();
        }

        new ThreadCooker2().start();
    }
}