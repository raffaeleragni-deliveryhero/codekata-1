import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CircularBufferTest {
  CircularBuffer buffer;

  @BeforeEach
  void setup() {
    buffer = new CircularBuffer();
  }

  @Test
  void testIsEmpty() {
    assertThat(buffer.isEmpty(), is(true));
  }

  @Test
  void testNotEmpty() {
    buffer.add(1);
    assertThat(buffer.isEmpty(), is(false));
  }

  @Test
  void testSizeZero() {
    assertThat(buffer.size(), is(0));
  }

  @Test
  void testSizeOne() {
    buffer.add(1);
    assertThat(buffer.size(), is(1));
  }

  @Test
  void testSizeTwo() {
    buffer.add(1);
    buffer.add(1);
    assertThat(buffer.size(), is(2));
  }

  @Test
  void testCannotRemoveFromEmpty() {
    assertThrows(IllegalStateException.class, () -> buffer.remove());
  }

  @Test
  void testAddAndRemove() {
    buffer.add(1);
    buffer.remove();

    assertThat(buffer.isEmpty(), is(true));
    assertThat(buffer.size(), is(0));
  }

  @Test
  void testReturnsInserted() {
    buffer.add(18);
    int x = buffer.remove();

    assertThat(x, is(18));

    buffer.add(21);
    x = buffer.remove();

    assertThat(x, is(21));
  }

  @Test
  void testReturnTwoInserted() {
    buffer.add(33);
    buffer.add(44);

    assertThat(buffer.remove(), is(33));
    assertThat(buffer.remove(), is(44));
  }

  @Test
  void testCircularOf2() {
    buffer.add(33);
    assertThat(buffer.remove(), is(33));

    buffer.add(44);
    buffer.add(55);

    assertThat(buffer.remove(), is(44));
    assertThat(buffer.remove(), is(55));
  }

  @Test
  void testIsNotFull() {
    assertThat(buffer.isFull(), is(false));
  }

  @Test
  void testIsFull() {
    buffer.add(44);
    buffer.add(55);

    assertThat(buffer.isFull(), is(true));
  }

  @Test
  void testBeyondFull() {
    buffer.add(44);
    buffer.add(55);
    assertThrows(IllegalStateException.class, () -> buffer.add(99999));
  }
}
