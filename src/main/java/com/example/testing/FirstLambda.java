package com.example.testing;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class FirstLambda {

    public static void main(String[] args) {

        FileFilter fileFilter = new FileFilter() {
            @Override public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        };

        FileFilter filterLambda = (File pathname) -> pathname.getName().endsWith(".java");

        File dir = new File("/Users/s610231/work/micro-services/mortgage-credit-decisioning-services/application/src/main/java/com/cybg/services/mortgage/credit/decisioning/controller/");
        File[] files = dir.listFiles(filterLambda);

        for(File f : files) {
            System.out.println(f.getName());
        }

        List<String> strings = Arrays.asList("a", "b", "c");
        Consumer<String> c1 = System.out::println;
        strings.forEach(c1);
    }
}
