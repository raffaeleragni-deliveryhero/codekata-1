package kata;

public class RingBuffer {

  int readPointer;
  int writePointer;
  final String[] buffer;

  public RingBuffer(int maxSize) {
    if (maxSize <= 0) {
      throw new IllegalArgumentException("not to be 0");
    }
    buffer = new String[maxSize];
  }

  public boolean isEmpty() {
    return writePointer == readPointer;
  }

  public int size() {
    return writePointer - readPointer;
  }

  public void add(String item) {
    ensureNotNull(item);
    if(writePointer == buffer.length){
      throw new IllegalStateException("max size reached");
    }
    insertItem(item);
  }

  void insertItem(String item) {
    buffer[writePointer] = item;
    writePointer++;
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
    var result = buffer[readPointer];
    readPointer++;
    return result;
  }

  public void clear(){
    writePointer = 0;
  }

}
