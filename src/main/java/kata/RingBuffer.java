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
    writePointer = 0;
    readPointer = 0;
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  /*
   *  
   */
  public int size() {
    var writeDistance = buffer.length - writePointer;
    var readDistance = buffer.length - readPointer;
    
    if (writeDistance <= readDistance) {
      return writePointer - readPointer;
    }
    
    return writePointer + readDistance;
  }

  public void add(String item) {
    ensureNotNull(item);
    if (isFull()) {
      throw new IllegalStateException("Buffer full");
    }
    
    if(writePointer == buffer.length) {
      writePointer = 0;
    }
    
    insertItem(item);
  }

  private boolean isFull() {
    return size() == buffer.length;
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
