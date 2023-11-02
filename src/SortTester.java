import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Comparator;
import org.junit.jupiter.api.Test;

/**
 * Tests of Sorter objects.
 *
 * @author Shuta Shibue
 */
public class SortTester {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  Sorter sorter;

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  static Comparator<Integer> compareInts = (x, y) -> x == y ? 0 : x < y ? -1 : 1;

  /**
   * Compare strings.
   */
  static Comparator<String> compareStrings = (x, y) -> x.compareTo(y);

  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()

  @Test
  public void orderedStringTest() {
    String[] original = {"alpha", "bravo", "charlie", "delta", "foxtrot"};
    String[] expected = original.clone();
    sorter.sort(original, compareStrings);
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void reverseOrderedStringTest() {
    String[] original = {"foxtrot", "delta", "charlie", "bravo", "alpha"};
    String[] expected = {"alpha", "bravo", "charlie", "delta", "foxtrot"};
    sorter.sort(original, compareStrings);
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void orderedNumberTest() {
    Integer[] original = {1, 2, 3, 4, 5};
    Integer[] expected = {1, 2, 3, 4, 5};
    sorter.sort(original, compareInts);
    assertArrayEquals(original, expected);
  } // orderedNumberTest

  @Test
  public void reverseOrderedNumberTest() {
    Integer[] original = {5, 4, 3, 2, 1};
    Integer[] expected = {1, 2, 3, 4, 5};
    sorter.sort(original, compareInts);
    assertArrayEquals(original, expected);
  } // reverseOrderedNumberTest

  @Test
  public void randomStringTest() {
    String[] original = {"delta", "alpha", "charlie", "foxtrot", "bravo"};
    String[] expected = {"alpha", "bravo", "charlie", "delta", "foxtrot"};
    sorter.sort(original, compareStrings);
    assertArrayEquals(original, expected);
  } // randomStringTest

  @Test
  public void randomNumberTest() {
    Integer[] original = {-1, 200, 5, 3, 8, 110};
    Integer[] expected = {-1, 3, 5, 8, 110, 200};
    sorter.sort(original, compareInts);
    assertArrayEquals(original, expected);
  } // randomNumberTest

  @Test
  public void zeroSizeStringTest() {
    String[] original = {};
    String[] expected = {};
    sorter.sort(original, compareStrings);
    assertArrayEquals(original, expected);
  } // reverseOrderedNumberTest


} // class SortTester
