
public class RingBuffer {

  boolean empty = true;
  
  boolean isEmpty() {
    return empty;
  }

  public void add(String item) {
    empty = false;
  }

}
