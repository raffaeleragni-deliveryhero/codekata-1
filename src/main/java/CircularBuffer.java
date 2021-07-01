<<<<<<< HEAD
public class CircularBuffer {

=======

public class CircularBuffer {

  int[] items = new int[2];
  int size;
  int bufferStart;
  int bufferEnd;

  boolean isEmpty() {
    return size == 0;
  }

  boolean isFull() {
    return size == items.length;
  }

  int size() {
    return size;
  }

  void add(int itemToAdd) {
    if (isFull())
      throw new IllegalStateException();
    items[bufferEnd % items.length] = itemToAdd;
    bufferEnd++;
    size++;
  }

  int remove() {
    if (isEmpty())
      throw new IllegalStateException();
    size--;
    var value = items[bufferStart % items.length];
    bufferStart++;
    return value;
  }
>>>>>>> circular buffer implementation
}
