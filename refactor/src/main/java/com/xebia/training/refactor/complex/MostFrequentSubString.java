package com.xebia.training.refactor.complex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MostFrequentSubString {

    public static void main(String[] args) throws Exception {
        String[] inputs = readInputs("/Users/sameerarora/Desktop/input002.txt");
        int n =  Integer.valueOf(inputs[0]);
        String[] split = inputs[1].split(" ");
        int k = Integer.valueOf(split[0]);
        int l = Integer.valueOf(split[1]);
        int m = Integer.valueOf(split[2]);
        String inputString =inputs[2];
        System.out.println(findMostFrequentSubstrings(n, k, l, m, inputString));
    }

    private static int findMostFrequentSubstrings(int n, int k, int l, int m, String inputString) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        if (inputString.length() < k)
            return 0;
        if (k >= 2 && l <= 26) {
            for (int i = k; i <= l; i++) {
                for (int j = 0; j + i <= n; j++) {
                    String substring = inputString.substring(j, j + i);
                    Integer count = 0;
                    if (uniqueChars(substring) < m) {
                        if (map.containsKey(substring)) {
                            count = map.get(substring);
                            map.remove(substring);
                        }
                        count++;
                        map.put(substring, count);
                    }
                }
            }
        }
        return maxValue(map.values());
    }

    private static int uniqueChars(String input) {
        int uniqueChars = 0;
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) != input.charAt(i + 1))
                uniqueChars++;
        }
        return uniqueChars;
    }

    private static int maxValue(Collection<Integer> values) {
        int max = 0;
        for (Integer value : values) {
            if (max < value) {
                max = value;
            }
        }
        return max;
    }

    public static String[] readInputs(String arg) throws IOException {
        String[] inputs = new String[3];
        BufferedReader br = new BufferedReader(new FileReader(new File(arg)));
        String line;
        int counter = 0;
        while ((line = br.readLine()) != null && counter < inputs.length) {
            inputs[counter] = line;
            counter++;
        }
        return inputs;
    }
}
