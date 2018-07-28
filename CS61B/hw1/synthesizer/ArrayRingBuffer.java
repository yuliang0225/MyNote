package synthesizer;
import java.util.Iterator;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        //       Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        this.first = 0;
        this.last = 0;
        this.capacity = capacity;
        this.rb = (T[]) new Object[capacity];
        this.fillCount = 0;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    @Override
    public void enqueue(T x) {
        /** Enqueue the item. Don't forget to increase fillCount and update last.
         * Dequeue oldest item in the ring buffer. If the buffer is empty, then
         * throw new RuntimeException("Ring buffer underflow"). Exceptions
         * covered Monday.
         */
        if (isFull()){
            throw new RuntimeException("Ring Buffer Overflow");
        }
        rb[last] = x;
        last = plusOne(last);
        fillCount += 1;
    }

    /* Returns the next index in the ring buffer. */
    private int plusOne(int index) {
        if (index + 1 == capacity) {
            return 0;
        }
        return index + 1;
    }

    @Override
    public T dequeue() {
        /** Dequeue the first item. Don't forget to decrease fillCount and update
         * Return oldest item, but don't remove it.
         */
        if (isEmpty()){
            throw new RuntimeException("Ring Buffer Underflow");
        }
        fillCount -= 1;
        T temp = rb[first];
        first = plusOne(first);
        return temp;
    }


    @Override
    public T peek() {
        // Return the first item. None of your instance variables should change.
        if (isEmpty()){
            throw new RuntimeException("Ring Buffer Underflow");
        }
        return rb[first];
    }

    // When you get to part 5, implement the needed code to support iteration.

    private class BfItertor implements Iterator<T>{
        private int ptr;
        public BfItertor(){
            ptr = 0;
        }

        @Override
        public boolean hasNext(){
            return (ptr != capacity);
        }

        @Override
        public T next(){
            T returnItem = rb[ptr];
            ptr += 1;
            return returnItem;
        }
    }
    @Override
    public Iterator<T> iterator(){
        return new BfItertor();
    }








}
