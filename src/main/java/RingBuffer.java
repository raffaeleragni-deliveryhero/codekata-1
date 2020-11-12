
public class RingBuffer {

  int size;
  String item;

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public void add(String item) {
    if(item == null){
      throw new IllegalArgumentException("The item is empty!");
    }
    size++;
    this.item = item;
  }

  public String get() {
    return item;
  }
}
