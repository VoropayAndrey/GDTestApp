package com.hardway.gdtest;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class JavaDequeue {
    static final int EXPECTED_RESULT = 3;

    @Test
    public void test() {
        Scanner in = new Scanner("6 3\n" +
                "5 3 5 2 3 2");
        Deque deque = new ArrayDeque<Integer>();
        int n = in.nextInt(); // Array length
        int m = in.nextInt(); // Subarray length

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
        }

        ArrayList subarray = new ArrayList(3);
        subarray.ensureCapacity(3);
        int numberOfSubArrays = (n - m) + 1;

        for(int i = 0; i < numberOfSubArrays; i++) {
            Iterator<Integer> iterator = deque.iterator();
            for(int j = 0; j < m; j++) {
                subarray.add(j, iterator.next());
            }
            deque.removeFirst();
        }
    }

    public int getUnique(ArrayList array) {
        HashSet<Integer> set = new HashSet<Integer>(array);
        return set.size();
    }

    @Test
    public void test2() {
        final int EXCEPTED_RESULT = 3;
        ArrayList<Integer> array = new ArrayList<>();
        array.add(0, 1);
        array.add(0, 2);
        array.add(0, 3);
        Assert.assertEquals(EXCEPTED_RESULT, getUnique(array));
    }

    @Test
    public void test3() {
        final int EXCEPTED_RESULT = 2;
        ArrayList<Integer> array = new ArrayList<>();
        array.add(0, 3);
        array.add(0, 2);
        array.add(0, 3);
        Assert.assertEquals(EXCEPTED_RESULT, getUnique(array));
    }

    @Test
    public void test4() {
        final int EXCEPTED_RESULT = 1;
        ArrayList<Integer> array = new ArrayList<>();
        array.add(0, 3);
        array.add(0, 3);
        array.add(0, 3);
        Assert.assertEquals(EXCEPTED_RESULT, getUnique(array));
    }
}
