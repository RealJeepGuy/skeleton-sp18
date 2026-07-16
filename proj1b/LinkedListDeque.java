import java.util.LinkedList;

public class LinkedListDeque<T> extends LinkedList<T> implements Deque<T>{


    //function that prints the items in the deque from first to last, separated by a space.
    @Override
    public void printDeque() {
        // You just need to implement this specific print logic
        for (T x : this) {
            System.out.print(x + " ");
        }
        System.out.println();
    }


    //function that gets the item at the given index, 0 being the first item (front). Returns null if item doesn't exist.
    @Override
    public T get(int index) {
        return super.get(index); // Calls Java's built-in fast indexing
    }








}