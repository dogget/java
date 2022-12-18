package pal;

public class ArrayQueueModule {
    private static final int START_CAPACITY = 10;
    private static Object array[] = new Object[START_CAPACITY];
    private static int size = 0;
    private static int head = 0;
    private static int tail = 0;

    // Pre: capacity' > 0
    // Post: if required capacity of array bigger then current
    // Post: capacity' = capacity * 2
    // Inv: if (capacity' = capacity * 2) head < tail
    private static void ensureCapacity(int capacity) {
        if (capacity >= array.length) {
            Object[] temp = new Object[array.length << 1];
            int count = tail < head ? array.length - head : size;
            System.arraycopy(array, head, temp, 0, count);
            if (tail < head)
                System.arraycopy(array, 0, temp, count, tail);
            array = temp;
            head = 0;
            tail = size;
        }
    }

    // Pre: value != null
    // Pre: value is immutable
    // Post: queue[size - 1] = element
    // Post: size' = size + 1
    public static void enqueue(Object element) {
        assert element != null;
        ensureCapacity(size + 1);
        array[tail] = element;
        tail = (tail + 1) % array.length;
        size++;
    }

    // Pre: size > 0
    // Post: Result = queue[0]
    public static Object element() {
        assert size > 0;
        return array[head];
    }

    // Pre: size > 0
    // Post: Result = queue[0]
    // Post: size' = size - 1
    public static Object dequeue() {
        assert size > 0;
        Object result = element();
        array[head] = null;
        size--;
        head = (head + 1) % array.length;
        return result;
    }

    // Post: Result = size
    public static int size() {
        return size;
    }

    // Post: Result = size > 0?
    public static boolean isEmpty() {
        return size == 0;
    }

    // INV: size' = 0;
    // Post: Clear the queue
    public static void clear() {
        size = head = tail = 0;
        array = new Object[START_CAPACITY];
    }

    public static String toStr() {
        if (isEmpty()){
            return "Queue: {\n}\n";
        }
        String str = "Queue: \n{";
        for (int i=head;i<tail-1;i++){
            str+=array[i]+",\n";
        }
        str+=array[tail-1] + "}\n";
        return str;
    }
}