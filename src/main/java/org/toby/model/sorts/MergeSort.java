package org.toby.model.sorts;

import java.util.ArrayList;
import java.util.List;

public class MergeSort<T extends Double> extends Sort<T> {


    public MergeSort(List<T> unSortedList) {
        super(unSortedList);
    }

    @Override
    protected void sort() {
        mergeSort(this.unSortedList, 0 , this.unSortedList.size());
        this.sortedList = this.unSortedList;

    }

    private void mergeSort(List<T> list, int startIndex, int endIndex){


        if(startIndex < endIndex){
            int middleIndex = (startIndex + endIndex) / 2;
            mergeSort(list, startIndex, middleIndex);
            mergeSort(list, middleIndex + 1, endIndex);
            merge(list, startIndex, middleIndex, endIndex);
        }
    }

    private void merge(List<T> list, int startIndex, int middleIndex, int endIndex){

        List<T> firstOrderedList;
        List<T> secondOrderedList;

        firstOrderedList = new ArrayList<>();
        for(int index = startIndex; index < middleIndex; index++){
            firstOrderedList.add(list.get(index));
        }

        secondOrderedList = new ArrayList<>();
        for(int index = middleIndex; index < endIndex; index++){
            secondOrderedList.add(list.get(index));
        }

        int firstListSize = firstOrderedList.size();
        int secondListSize = secondOrderedList.size();

        int firstListIndex = 0;
        int secondListIndex = 0;
        int mergedListIndex = startIndex;

        while(firstListIndex < firstListSize && secondListIndex < secondListSize){
            if(firstOrderedList.get(firstListIndex).compareTo(secondOrderedList.get(secondListIndex)) < 0){
                list.set(mergedListIndex, firstOrderedList.get(firstListIndex));
                mergedListIndex++;
                firstListIndex++;
            }
            else{
                list.set(mergedListIndex, secondOrderedList.get(secondListIndex));
                mergedListIndex++;
                secondListIndex++;
            }
        }

        while(firstListIndex < firstListSize){
            list.set(mergedListIndex, firstOrderedList.get(firstListIndex));
            firstListIndex++;
            mergedListIndex++;
        }

        while(secondListIndex < secondListSize){
            list.set(mergedListIndex, secondOrderedList.get(secondListIndex));
            secondListIndex++;
            mergedListIndex++;
        }
    }

}
