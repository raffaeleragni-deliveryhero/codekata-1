package kata;

import java.util.Deque;
import java.util.LinkedList;

public class RingBuffer {

  int size;
  Deque<String> queue = new LinkedList<>();

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public void add(String item) {
    ensureNotNull(item);

    size++;

    queue.add(item);
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

    return queue.poll();
  }

  public void clear(){
    queue.clear();
    size =0;
  }

}