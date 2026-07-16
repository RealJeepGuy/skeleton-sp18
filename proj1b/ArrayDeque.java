
public class ArrayDeque<T> implements Deque<T>{
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 3;
        nextLast =4;
    }

    private int plusOne(int index){
        return (index + 1) % items.length;
    }

    private int minusOne(int index){
        return (index - 1 + items.length) % items.length;
    }

    private void resize(int capacity){
        T[] a = (T[]) new Object [capacity]; //Creates a new array of desired capacity
        int first = plusOne(nextFirst);
        for (int i = 0; i < size; i++){
            a[i] = items[(first + i) % items.length];
        }
        items = a;
        nextFirst = capacity - 1;
        nextLast = size;
    }
    @Override
    public void addFirst(T item){
        if(size == items.length){
            resize(size*2);
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size += 1;
    }
    @Override
    public void addLast(T item){
        if(size == items.length){
            resize(size*2);
        }
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size ++;
    }
    @Override
    public boolean isEmpty(){
        return size == 0;
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public T removeFirst(){
        if(isEmpty()){
            return null;
        }
        nextFirst = plusOne(nextFirst);
        T removed = items[nextFirst];
        items[nextFirst] = null;
        size -= 1;
        return removed;
    }
    @Override
    public T removeLast(){
        if (isEmpty()){
            return null;
        }
        nextLast = minusOne(nextLast);
        T removed = items[nextLast];
        items[nextLast] = null;
        size -= 1;
        return removed;
    }
    @Override
    public T get(int index){
        if(index < 0 || index >= size) {
            return null;
        }
        int first = plusOne(nextFirst);
        return items[(first + index) % items.length];
    }
    @Override
    public void printDeque() {
        int current = (nextFirst + 1) % items.length;
        for (int i = 0; i < size; i++) {
            System.out.print(items[current] + " ");
            current = (current + 1) % items.length;
        }
        System.out.println();
    }
}