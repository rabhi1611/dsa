/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    private final List<Integer> ls;
    Integer i = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.ls = new ArrayList<>();
        for(int j = 0; j < nestedList.size(); j++)
            fun(nestedList, this.ls, j);
    }

    @Override
    public Integer next() {
        return ls.get(i++);
    }

    @Override
    public boolean hasNext() {
        if( i >= ls.size()){
            return false;
        }

        return true;
    }

    void fun(List<NestedInteger> currList, List<Integer> ls, int i){
        if(i >= currList.size())   return;

        NestedInteger curr = currList.get(i);
        if(curr.isInteger()){
            ls.add(curr.getInteger());
        } else {
            List<NestedInteger> temp = curr.getList();
            for(int j = 0; j < temp.size(); j++){
                fun(temp, ls, j);
            }
        }
        return;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */