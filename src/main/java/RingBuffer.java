import java.util.NoSuchElementException;

public class RingBuffer {
  final int maxSize;
  int size;
  int[] items;
  int writePointer;
  int readPointer;

  public RingBuffer(int maxSize) {
    this.maxSize = maxSize;
    this.items = new int[maxSize];
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int maxSize() {
    return maxSize;
  }

  public int size() {
    return size;
  }

  public boolean isFull(){
    return size() == maxSize();
  }

  public void addItem(int item) {
    if(isFull()){
      throw new IllegalStateException("The buffer is full!");
    }

    size++;
    items[writePointer] = item;
    writePointer++;
    writePointer = writePointer % 5;
  }

  public int getItem() {
    if(isEmpty()) {
      throw new NoSuchElementException("The buffer is empty!");
    }
    var item = items[readPointer];
    readPointer++;
    readPointer = readPointer % 5;
    size--;
    return item;
  }
}
