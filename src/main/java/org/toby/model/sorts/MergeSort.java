package org.toby.model.sorts;

import java.util.ArrayList;
import java.util.List;

public class MergeSort<T extends Double> extends Sort<T> {


    public MergeSort(List<T> unSortedList) {
        super(unSortedList);
    }

    @Override
    protected void sort() {

    }

    private void mergeSort(List<T> list, int startIndex, int endIndex){


        if(1 < list.size()){
            int middleIndex = (startIndex + endIndex) / 2;
            mergeSort(list, startIndex, middleIndex);
            mergeSort(list, middleIndex, endIndex);
            this.unSortedList = merge(leftSideList, rightSideList);
        }
    }

    private List<T> merge(List<T> firstOrderedList, List<T> secondOrderedList){




        int firstListSize = firstOrderedList.size();
        int secondListSize = secondOrderedList.size();
        List<T> mergedList = new ArrayList<>();

        int firstListIndex = 0;
        int secondListIndex = 0;
        int mergedListIndex = 0;

        while(firstListIndex < firstListSize && secondListIndex < secondListSize){
            if(firstOrderedList.get(firstListIndex).compareTo(secondOrderedList.get(secondListIndex)) < 0){
                mergedList.add(mergedListIndex, firstOrderedList.get(firstListIndex));
                mergedListIndex++;
                firstListIndex++;
            }
            else{
                mergedList.add(mergedListIndex, secondOrderedList.get(secondListIndex));
                mergedListIndex++;
                secondListIndex++;
            }
        }

        while(firstListIndex < firstListSize){
            mergedList.add(mergedListIndex, firstOrderedList.get(firstListIndex));
            firstListIndex++;
            mergedListIndex++;
        }

        while(secondListIndex < secondListSize){
            mergedList.add(mergedListIndex, secondOrderedList.get(secondListIndex));
            secondListIndex++;
            mergedListIndex++;
        }

        return mergedList;
    }

}
