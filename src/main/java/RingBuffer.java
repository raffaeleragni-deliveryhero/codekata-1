
public class RingBuffer {

  boolean empty = true;
  
  boolean isEmpty() {
    return empty;
  }

  public void add(String item) {
    if(item == null){
      throw new IllegalArgumentException("The item is empty!");
    }
    empty = false;
  }



}
