
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class RingBufferTest {
  RingBuffer buffer;

  @BeforeEach
  void setup() {
    buffer = new RingBuffer();
  }

  @Test
  void testIsNotEmpty() {
    buffer.add("test");
    assertThat(buffer.isEmpty(), is(false));
  }
  
  @Test
  void testIsEmpty() {
    assertThat(buffer.isEmpty(), is(true));
  }
}
