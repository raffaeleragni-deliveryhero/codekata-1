
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

  public void addItem(int i) {
    size++;
  }

  public int getItem() {
    return 1;
  }
}
