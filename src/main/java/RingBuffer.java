
public class RingBuffer {
  final int maxSize;

  public RingBuffer(int maxSize) {
    this.maxSize = maxSize;
  }

  public boolean isEmpty() {
    return true;
  }

  public int maxSize() {
    return maxSize;
  }

  public int size() {
    return 0;
  }
}
