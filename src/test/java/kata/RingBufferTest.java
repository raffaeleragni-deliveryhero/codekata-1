package kata;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RingBufferTest {
  RingBuffer buffer;

  @BeforeEach
  void setup() {
    buffer = new RingBuffer(10);
  }

  @Test
  void testIsEmpty() {
    assertThat(buffer.isEmpty(), is(true));
  }

  @Test
  void testIsNotEmpty() {
    buffer.add("test");
    assertThat(buffer.isEmpty(), is(false));
  }

  @Test
  void testItemIsNull(){
    assertThrows(IllegalArgumentException.class, () -> {
      buffer.add(null);
    });
    assertThat(buffer.isEmpty(), is(true));
  }

  @Test
  void testItemSaved() {
    buffer.add("item");
    var item = buffer.get();

    assertThat(item, is("item"));
  }

  @Test
  void testItem2Saved() {
    buffer.add("item2");
    var item = buffer.get();

    assertThat(item, is("item2"));
  }

  @Test
  void testSizeZero() {
    assertThat(buffer.size(), is(0));
  }

  @Test
  void testSize1() {
    buffer.add("item");
    assertThat(buffer.size(), is(1));
  }

  @Test
  void whenAddTwoItems() {
    buffer.add("item1");
    buffer.add("item2");

    assertThat(buffer.get(), is("item1"));
    assertThat(buffer.get(), is("item2"));
  }

  @Test
  void getWhenBufferEmpty() {
    assertThrows(IllegalStateException.class, () -> buffer.get());
  }

  @Test
  void assertIsCleared(){
    buffer.add("item");
    assertThat(buffer.isEmpty(), is(false));
    buffer.clear();
    assertThat(buffer.isEmpty(), is(true));
  }
  
  @Test
  void testWhenMaxLimitIsZero() {
    assertThrows(IllegalArgumentException.class, () -> new RingBuffer(0));
  }
  
  @Test
  void testWhenMaxLimitIsNegative() {
    assertThrows(IllegalArgumentException.class, () -> new RingBuffer(-1));
  }
  
//  @Test
  void testOverflow() {
    buffer = new RingBuffer(1);
    buffer.add("item1");
    
    assertThrows(IllegalStateException.class, () -> buffer.add("item1"));
  }
}