import java.util.NoSuchElementException;

public class RingBuffer {
  final int maxSize;
  int size;

  public RingBuffer(int maxSize) {
    this.maxSize = maxSize;
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

  public void addItem(int i) {
    if(isFull()){
      throw new IllegalStateException("The buffer is full!");
    }

    size++;
  }

  public int getItem() {

    if(isEmpty()) {
      throw new NoSuchElementException("The buffer is empty!");
    }
    return 1;
  }
}
