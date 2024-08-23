package com.example.testing;

import com.example.testing.model.Country;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

   /* public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        Predicate<Integer> nOdd = n -> n%2 !=0;
        Predicate<Integer> nZero = n -> n==0;
        Predicate<Integer> nEven= n -> n%2 == 0;
        Predicate<Integer> nRange2To5 = n -> n != 2 && n != 4;
        Predicate<Integer> nRangeGreaterThan20 = n -> n <= 20;

        if(nZero.or(nOdd).or(nEven.and(nRange2To5.and(nRangeGreaterThan20))).test(N)) {
            System.out.println("Weird");
        } else {
            System.out.println("Not Weird");
        }
        scanner.close();
    }*/

   /* public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        Double d = scan.nextDouble();
        scan.nextLine();
        String s = scan.nextLine();


        // Write your code here.

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
*/

    /*    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Consumer<Integer> tableRow = number -> System.out.println(N + " x " + number + " = " + N * number);

        numbers.forEach(tableRow);

        bufferedReader.close();
    }*/

    /*public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(3,2,1,6,5,4,7,1);

        Predicate<Integer> omitSomeNumbers = number -> number != 2 && number != 6;

        ints.stream().filter(omitSomeNumbers).sorted(Comparator.reverseOrder()).distinct().forEach(System.out::println);

    }*/



    /*public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.fizzBuzz(n);

        bufferedReader.close();
    }*/

   /*6
    3
                    4
                    5
                    2
                    1
                    1
3
    public static void main(String[] args) {

        List<Integer> skillLevel = Arrays.asList(3,4,5,2,1,1);
        int minDiff = 3;



        Map<Map<Integer,Integer>,Integer> mapofMaps = new HashMap<>();
        Set<Integer> indicesMap = new TreeSet<>();
        int count = 0;
        int index = 0;
        for(Integer i1 : skillLevel) {
            //System.out.println(i1);
            count++;
            int internalIndex = 0;
            for(Integer i2 : skillLevel) {
                count++;
                if(index != internalIndex) {
                    //System.out.println(i2);

                    if(i1-i2 >= 3) {
                        indicesMap.add(i1);
                    }
                }
                internalIndex++;
            }
            index++;
        }

        System.out.println("size = " + indicesMap.size() + "count = " + count);

       // Arrays.asList(3,4,5,2,1,1);



            //Given no of players the array , give the count of no of pair that don't violate max diff.
            //1 player can be part of just one pairing.

            //List<Integer> skillLevel = Arrays.asList(3,4,5,2,1,1);
            //maxDiff = 3




        ListIterator<Integer> l1 = skillLevel.listIterator();
        ListIterator<Integer> l2 = skillLevel.listIterator();
        Set<Integer> indicesMap1 = new TreeSet<>();

        int countTimes = 0;
        while(l1.hasNext()){
            countTimes++;
            while(l2.hasNext()) {

                if(l1.next() - l2.next() >=minDiff) {
                    indicesMap.add(1);
                    l1.remove();
                    l2.remove();
                }
                countTimes++;
            }
        }

        System.out.println("size = " + indicesMap.size() + "count = " + countTimes);

    }*/



    /*public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();

        if(A.equalsIgnoreCase(new StringBuffer(A).reverse().toString())) {

        }

    }*/


    /*public static void main(String[] args) {


        String A = "anagram";
        String B = "margana";

        String A = "bbcc";
        String B = "dabc";

        String A = "Hello";
        String B = "hello";


        A.toLowerCase().codePoints().forEach(System.out::println);
        B.toLowerCase().codePoints().forEach(System.out::println);

        B.toLowerCase().chars()
                        .sorted().forEach(System.out::println);

        String sortedA = A.toLowerCase().chars()
                        .sorted()
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString();

        String sortedB = B.toLowerCase().chars()
                        .sorted()
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString();


        long countA = A.toLowerCase().codePoints().summaryStatistics().getSum();
        long countB = B.toLowerCase().codePoints().summaryStatistics().getSum();

        System.out.println("A " + countA + " B " + countB);

        BiPredicate<Long, Long> sumEquality = (i, f) -> {
            return i.longValue() == f.longValue();
        };

        BiPredicate<String, String> stringEquality = (a, b) -> {
            return a.toLowerCase().equalsIgnoreCase(b.toLowerCase());
        };


        if(sumEquality.test(countA, countB) && stringEquality.test(sortedA, sortedB)) {
            System.out.println("Anagrams");
        } else {
            System.out.println("Not Anagrams");
        }

    }*/

    //kdiff
    /*List<Country> countryList = customerInfo.getPersonalDetails().getCountry();
        if(Objects.nonNull(countryList)) {
        for(Country country : countryList) {
            if (country.getStatus().equals(ACTIVE)){
                countriesOfCitizenship.add(country.getValue());
            }
        }
    }*/

    //instead of Object.nonull check
   /* public static void main(String[] args) {
        List<Country> countries = Arrays.asList(new Country(true, "india"),
                        new Country(false , "somalia"),
                        new Country(true,"uk"));

        List<String> countryString = Optional.ofNullable(countries).orElseGet(Collections::emptyList)
                        .stream()
                        .filter(Objects::nonNull)
                        .filter(c -> c.getStatus() == true)
                        .map(c -> c.getValue())
                        .collect(Collectors.toList());

        System.out.println(countryString);*/

    public static void main(String[] args) {
//        String sortCode = "05-23-34";
//        Stream<String> stream = Arrays.stream(sortCode.split( "-" ));
//        String sortCode1 = stream.collect(Collectors.joining()).substring(2,6);
//
//
//        System.out.println(sortCode1);
//

        String accountNo = "019293";
        System.out.println(org.apache.commons.lang3.StringUtils.substring(accountNo, 7,9));
    }



}

