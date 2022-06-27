package com.itheima.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 帅才
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList();
        ArrayList<Integer> arrayList1 = new ArrayList();

        for (int i = 1; i <= 100; i++) {
            arrayList.add(i);
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if ((arrayList.get(i) % 5) == 0) {
                arrayList1.add(arrayList.get(i));
            }

        }
        for (Integer o : arrayList1) {
            System.out.println(o);
        }

        System.out.println("===================================");

        List<Integer> newArray = arrayList.stream()
                .filter(a -> a % 5 == 0)
                .collect(Collectors.toList());
        newArray.forEach(System.out::println);

    }
}
