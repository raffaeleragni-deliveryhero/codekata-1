import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class RingBufferTest {

  RingBuffer buffer;

  @BeforeEach
  void setup() {
    buffer = new RingBuffer(5);
  }

  @Test
  void testEmpty() {
    assertThat(buffer.isEmpty(), is(true));
  }

  @Test
  void testMaxSize() {
    assertThat(buffer.maxSize(), is(5));
  }

  @Test
  void testSize() {
    assertThat(buffer.size(), is(0));
  }

  @Test
  void testAddItem() {
    buffer.addItem(1);
    
    assertFalse(buffer.isEmpty());
    assertThat(buffer.size(), is(1));
  }
  
  @Test
  void testAddMultipleItems() {
    buffer.addItem(1);
    buffer.addItem(2);
    
    assertThat(buffer.size(), is(2));
  }
  
  @Test
  void testGetItem() {
    buffer.addItem(1);
    var item = buffer.getItem();
    
    assertThat(item, is(1));
  }

  @Test
  void testWhenEmpty(){
    assertThrows(NoSuchElementException.class,
            () -> buffer.getItem());

  }

  @Test
  void testAddWhenMaxSize(){

    int i = 0;
    while (i < 5){
      buffer.addItem(i);
      i++;
    }
    assertThrows(IllegalStateException.class,
            () -> buffer.addItem(6));
  }
}
