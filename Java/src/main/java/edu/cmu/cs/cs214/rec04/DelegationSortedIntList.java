package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class DelegationSortedIntList implements IntegerList {
    private SortedIntList sortedIntList;
    private int element_TotalNum;
    
    @Override
    public boolean add(int num){
        this.element_TotalNum++;
        return this.sortedIntList.add(num);
    }

    @Override
    public boolean addAll(IntegerList list){
        boolean success = false;
        for (int i = 0; i < list.size(); i++)
        {
            success |= this.add(list.get(i));
        }
        return success;
    }

    @Override
    public int get(int index){
        return this.sortedIntList.get((index));
    }

    @Override
    public boolean remove(int num){
        return this.sortedIntList.remove(num);
    }

    @Override
    public boolean removeAll(IntegerList list){
        return this.sortedIntList.removeAll(list);
    }

    @Override
    public int size(){
        return this.sortedIntList.size();
    }
    
    public int getTotalAdded(){
        return this.element_TotalNum;
    }
    // Write your implementation below with API documentation

}