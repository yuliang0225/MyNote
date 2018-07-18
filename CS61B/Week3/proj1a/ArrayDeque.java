
public class ArrayDeque<T> {
    private int size;
    private T[] array;
    private static int SizeOfArray = 8;
    private int prev;
    private int next;

    /**  */
    public ArrayDeque(){
        array = (T[]) new Object[SizeOfArray];
        size = 0;
        prev = 4;
        next = 5;
    }

    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T item){
        if (size == array.length){
            resize(SizeOfArray*2);
        }
        array[prev] = item;
        if (prev == 0){
            prev = SizeOfArray-1;
        }else {
            prev -= 1;
        }
        size += 1;
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item){
        if (size == array.length){
            resize(SizeOfArray*2);
        }
        array[next] = item;
        if(next == SizeOfArray-1){
            next = 0;
        }else{
            next += 1;
        }
        size +=1;
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        return false;
    }

    /** Returns the number of items in the deque. */
    public int size(){
        return size;
    }

    /** Prints the items in the deque from first to last, separated by a space. */
    public void printDeque(){
        int count = size;
        int temp = prev +1;

        while (count != 0){
            if (temp > SizeOfArray-1){
                temp = 0;
            }
            System.out.print(array[temp]);
            System.out.print(" ");
            temp += 1;
            count -= 1;
        }
        System.out.print("\n");
    }

    /** Removes and returns the item at the front of the deque.
     * If no such item exists, returns null. */
    public T removeFirst(){
        while (size == 0){
            return null;
        }
        if (size < 0.25*array.length){
            resize((int)(array.length*0.5));
        }
        size -= 1;
        int temp = prev +1;
        while (temp > SizeOfArray -1){
            temp = 0;
        }
        prev = temp;
        return array[temp];
    }

    /** Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.*/
    public T removeLast(){
        while (size == 0){
            return null;
        }
        if (size < 0.25*array.length){
            resize((int)(array.length*0.5));
        }
        size -= 1;
        int temp = next -1;
        while (temp < 0){
            temp = SizeOfArray-1;
        }
        next = temp;
        return array[temp];
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque! */
    public T get(int index){
        while (size < index){
            return null;
        }
        int temp = prev+1;
        while (index != 0){
            while (temp > SizeOfArray -1){
                temp = -1;
            }
            temp += 1;
            index -= 1;
        }
        return array[temp];

    }
    /** Resize the array */
    private void resize (int capacity){
        T[] newArray = (T[]) new Object[capacity];
        System.arraycopy(array,0,newArray,1,size);
        array = newArray;
        prev = 0;
        next = size +1;
    }

}
