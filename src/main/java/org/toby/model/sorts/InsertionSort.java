package org.toby.model.sorts;

import java.util.List;

public class InsertionSort<T extends Double> extends Sort<T>{

    public InsertionSort(List<T> unSortedList) {
        super(unSortedList);
    }

    @Override
    protected void sort() {
        for(int listIndex = 0; listIndex < this.unSortedList.size() - 1; listIndex++){
            if(this.unSortedList.get(listIndex + 1).compareTo(this.unSortedList.get(listIndex)) < 0){
                for(int sortingIndex = 0; sortingIndex < listIndex + 1; sortingIndex++){
                    if(this.unSortedList.get(listIndex + 1).compareTo(this.unSortedList.get(sortingIndex)) < 0){
                        this.unSortedList.add(sortingIndex, this.unSortedList.get(listIndex + 1));
                        this.unSortedList.remove(listIndex + 2);
                        break;
                    }
                }
            }
        }
        this.sortedList = this.unSortedList;
    }
}
