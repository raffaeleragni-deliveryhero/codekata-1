
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

}
