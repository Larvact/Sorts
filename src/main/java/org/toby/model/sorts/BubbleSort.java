package org.toby.model.sorts;

import java.util.List;

public class BubbleSort<T extends Double> extends Sort<T>{

    public BubbleSort(List<T> unSortedList) {
        super(unSortedList);
    }

    @Override
    protected void sort() {
        for(int count = 0; count < this.unSortedList.size() - 1; count++){
            for(int listIndex = 0; listIndex < this.unSortedList.size() - count - 1; listIndex++){
                if(this.unSortedList.get(listIndex).compareTo(this.unSortedList.get(listIndex + 1)) > 0){
                    T firstVal = this.unSortedList.get(listIndex);
                    T secondVal = this.unSortedList.get(listIndex + 1);
                    this.unSortedList.set(listIndex, secondVal);
                    this.unSortedList.set(listIndex + 1, firstVal);
                }
            }
        }
        this.sortedList = this.unSortedList;
    }
}
