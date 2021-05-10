package org.toby.model.sorts;

import java.util.List;

public abstract class Sort<T extends Double> {

    protected List<T> unSortedList;
    protected List<T> sortedList;

    public Sort(List<T> unSortedList) {
        this.unSortedList = unSortedList;
    }

    protected abstract void sort();

    public void setUnSortedList(List<T> unSortedList) {
        this.unSortedList = unSortedList;
    }

    public List<T> getSortedList() {
        sort();
        return sortedList;
    }
}
