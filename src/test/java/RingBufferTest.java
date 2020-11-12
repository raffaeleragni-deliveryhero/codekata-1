
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RingBufferTest {
  RingBuffer buffer;

  @BeforeEach
  void setup() {
    buffer = new RingBuffer();
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
}