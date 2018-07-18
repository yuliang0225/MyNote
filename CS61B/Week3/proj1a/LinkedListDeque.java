/** Deque: “Double Ended Queue” based on lists */
public class LinkedListDeque<T> {
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
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T item){
        DLList addNode = new DLList(item,sentinel,sentinel.next);
        if (sentinel.prev.equals(sentinel)) {
            sentinel.prev = addNode;
        }
        else{
            sentinel.next = addNode;
        }
        size += 1;
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item){
//Todo        DLList addNode = new DLList(item,sentinel.next,sentinel)
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty(){
        return size == 0;
    }

    /** Returns the number of items in the deque. */
    public int size(){
        return size;
    }

//    /** Prints the items in the deque from first to last, separated by a space. */
//    public void printDeque(){}
//
//    /** Removes and returns the item at the front of the deque.
//     * If no such item exists, returns null. */
//    public T removeFirst(){}
//
//    /** Removes and returns the item at the back of the deque.
//     * If no such item exists, returns null.*/
//    public T removeLast(){}
//
//    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
//     * If no such item exists, returns null. Must not alter the deque! */
//    public T get(int index){}

}
