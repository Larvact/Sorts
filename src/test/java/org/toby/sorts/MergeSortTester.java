package org.toby.sorts;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.toby.model.sorts.MergeSort;
import org.toby.model.sorts.Sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSortTester {

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
        sorter = new MergeSort<>(unsortedList);
    }

    @Test
    public void ensureAfterSortingAnEmptyListThatTheResultantSortedListIsEmpty(){
        sorter = new MergeSort<>(emptyList);
        Assert.assertEquals(expectedEmptyList, sorter.getSortedList());
    }

    @Test
    public void ensureAfterSortingAListThatTheResultantSortedListIsCorrect(){
        sorter = new MergeSort<>(unsortedList);
        Assert.assertEquals(expectedSortedList, sorter.getSortedList());
    }
}

//[-55.0, -4.56, 9.4, -22.5, 0.0, 67.0, 129.1, -5.8, 32.6, -4.56]
//[-55.0, -4.56, 9.4, -22.5, 0.0, 67.0, -4.56, 32.6, -5.8, 129.1]
