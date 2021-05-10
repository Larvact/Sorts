package org.toby.sorts;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.toby.model.sorts.BubbleSort;
import org.toby.model.sorts.InsertionSort;
import org.toby.model.sorts.Sort;

import java.util.ArrayList;
import java.util.List;

public class InsertionSortTester {

    private static List<Double> unsortedList;
    private static List<Double> emptyList;
    private static List<Double> expectedSortedList;
    private static List<Double> expectedEmptyList;

    private static Sort<Double> sorter;

    @BeforeClass
    public static void setup(){
        setupEmptyList();
        setupUnsortedList();
        setupExpectedEmptyList();
        setupExpectedSortedList();
        setupBubbleSorter();
    }

    private static void setupEmptyList(){
        emptyList = new ArrayList<>();
    }

    private static void setupUnsortedList(){
        unsortedList = new ArrayList<>();
        unsortedList.add(-4.56);
        unsortedList.add(9.4);
        unsortedList.add(-22.5);
        unsortedList.add(0.0);
        unsortedList.add(67.0);
        unsortedList.add(-55.0);
        unsortedList.add(129.1);
        unsortedList.add(-5.8);
        unsortedList.add(32.6);
        unsortedList.add(-4.56);
    }

    private static void setupExpectedEmptyList(){
        expectedEmptyList = new ArrayList<>();
    }

    private static void setupExpectedSortedList(){
        expectedSortedList = new ArrayList<>();
        expectedSortedList.add(-55.0);
        expectedSortedList.add(-22.5);
        expectedSortedList.add(-5.8);
        expectedSortedList.add(-4.56);
        expectedSortedList.add(-4.56);
        expectedSortedList.add(0.0);
        expectedSortedList.add(9.4);
        expectedSortedList.add(32.6);
        expectedSortedList.add(67.0);
        expectedSortedList.add(129.1);
    }

    private static void setupBubbleSorter(){
        sorter = new BubbleSort<>(unsortedList);
    }

    @Test
    public void ensureAfterSortingAnEmptyListThatTheResultantSortedListIsEmpty(){
        sorter = new InsertionSort<>(emptyList);
        Assert.assertEquals(expectedEmptyList, sorter.getSortedList());
    }

    @Test
    public void ensureAfterSortingAListThatTheResultantSortedListIsCorrect(){
        sorter = new InsertionSort<>(unsortedList);
        Assert.assertEquals(expectedSortedList, sorter.getSortedList());
    }

}
