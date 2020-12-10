
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


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
}
