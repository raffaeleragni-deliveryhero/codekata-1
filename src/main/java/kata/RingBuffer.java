package kata;

public class RingBuffer {

  boolean full;
  int readPointer;
  int writePointer;
  final String[] buffer;

  public RingBuffer(int maxSize) {
    if (maxSize <= 0) {
      throw new IllegalArgumentException("not to be 0");
    }
    buffer = new String[maxSize];
    writePointer = 0;
    readPointer = 0;
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public int size() {
    if (full)
      return buffer.length;

    var writeDistance = buffer.length - writePointer;
    var readDistance = buffer.length - readPointer;

    if (writeDistance <= readDistance) {
      return writePointer - readPointer;
    }

    return writePointer + readDistance;
  }

  public void add(String item) {
    ensureNotNull(item);
    if (full) {
      throw new IllegalStateException("Buffer full");
    }

    insertItem(item);
  }

  void insertItem(String item) {
    if (writePointer == buffer.length)
      writePointer = 0;

    buffer[writePointer] = item;

    writePointer++;

    if (size() == buffer.length || writePointer == readPointer)
      full = true;
  }

  void ensureNotNull(String item) {
    if(item == null){
      throw new IllegalArgumentException("The item is empty!");
    }
  }

  public String get() {
    if (isEmpty()) {
      throw new IllegalStateException();
    }

    return fetchItem();
  }

  String fetchItem() {
    if (readPointer == buffer.length)
      readPointer = 0;

    var result = buffer[readPointer];

    readPointer++;
    full = false;

    return result;
  }

  public void clear(){
    writePointer = 0;
  }

}
