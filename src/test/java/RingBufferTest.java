
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


}