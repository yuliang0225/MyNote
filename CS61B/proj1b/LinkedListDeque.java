/** Deque: “Double Ended Queue” based on lists */
/** Maybe dirty, however it is mine! */
public class LinkedListDeque<T> implements Deque<T> {
    private int size =0 ;
    private DLList sentinel = new DLList (null, null, null);

    /** Establish a IntNode class as a link table element with prev and next pointers */
    private class DLList{
        /** prev point
         *  T item
         *  next point */
        public T item;
        public DLList prev;
        public DLList next;
        public DLList (T i, DLList p, DLList n){
            prev = p;
            item = i;
            next = n;
        }
    }
    /** Initialization sentinel */
    public LinkedListDeque(){
        sentinel.next = sentinel;
        sentinel.prev = sentinel.next;
    }

    /** Adds an item of type T to the front of the deque. */
    @Override
    public void addFirst(T item){
        DLList addNode = new DLList(item,sentinel,sentinel.next);
        if (sentinel.prev.equals(sentinel)) {
            sentinel.prev = addNode;
            sentinel.next = addNode;
        }
        else{
            sentinel.next.prev = addNode;
            sentinel.next = addNode;
        }
        size += 1;
    }

    /** Adds an item of type T to the back of the deque. */
    @Override
    public void addLast(T item){
        DLList addNode = new DLList(item,sentinel.prev,sentinel);
        if (sentinel.prev.equals(sentinel)) {
            sentinel.prev = addNode;
            sentinel.next = addNode;
        }
        else{
            sentinel.prev.next = addNode;
            sentinel.prev = addNode;
        }
        size += 1;

    }

    /** Returns true if deque is empty, false otherwise. */
    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    /** Returns the number of items in the deque. */
    @Override
    public int size(){
        return size;
    }

    /** Prints the items in the deque from first to last, separated by a space. */
    @Override
    public void printDeque(){
        DLList tempValue = sentinel.next;
        while (tempValue.item != null){
            System.out.print(tempValue.item);
            System.out.print(' ');
            tempValue = tempValue.next;
        }
        System.out.println("\n");
    }

    /** Removes and returns the item at the front of the deque.
     * If no such item exists, returns null. */
    @Override
    public T removeFirst(){
        if (size == 0){
            return null;
        }
        T tempValue= sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return tempValue;
    }

    /** Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.*/
    @Override
    public T removeLast(){
        if (size == 0){
            return null;
        }
        T tempValue = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
        return tempValue;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque! */
    @Override
    public T get(int index){
        int count = 0;
        DLList tempNode = new DLList (null,sentinel.prev,sentinel.next);
        if(index<0 || index > size){
            return null;
        }
        while (count < index+1){
            tempNode = tempNode.next;
            count += 1;
        }
        return tempNode.item;
    }
    /** Same as get, but uses recursion. */
    private T getRec(DLList lst, int index) {
        if (index == 0) {
            return lst.item;
        }
        else if (index >= size) {
            return null;
        }
        else {
            return getRec(lst.next, index-1);
        }
    }
    public T getRecursive(int index) {
        return getRec(sentinel.next, index);
    }

}
