package com.akiriwe.adventofcode.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CalorieCounter {
    public static void main(String[] args) throws IOException {
        List<Integer> elvesCalories = getCaloriesPerElf();
        elvesCalories.sort(Comparator.reverseOrder());

        System.out.println(elvesCalories.get(0));
        System.out.println(elvesCalories.subList(0, 3).stream().reduce(0, Integer::sum));
    }

    private static List<Integer> getCaloriesPerElf() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/main/resources/day1/input.txt").toAbsolutePath());
        List<Integer> calories = new ArrayList<>();
        int calorie = 0;
        for (String line : lines) {
            if (line.equals("")) {
                calories.add(calorie);
                calorie = 0;
            } else {
                calorie += Integer.parseInt(line);
            }
        }

        return calories;
    }
}
