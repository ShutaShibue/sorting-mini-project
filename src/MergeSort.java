import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort using merge sort.
 *
 * @author Shuta Shibue
 */

public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MergeSort() {} // MergeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+


  public <T> void sort(T[] vals, Comparator<? super T> comparator) {
    sort(vals, comparator, 0, vals.length);
    // STUB
  } // sort(T[], Comparator<? super T>

  /**
   * 
   * @param vals Arrays to sort
   * @param comparator Comparator to compare elements of vals
   * @param lo starting index, inclusive
   * @param hi ending index, exclusive
   */
  public <T> void sort(T[] vals, Comparator<? super T> comparator, int lo, int hi) {

    if (hi - lo > 1) {
      int m = (lo + hi) / 2;
      // sort left half and then right half
      System.out.println("left: " + lo + " mid: " + m + " right: " + hi);
      sort(vals, comparator, lo, m);
      sort(vals, comparator, m, hi);
      merge(vals, lo, m, hi, comparator);
    }

  }

  /**
   * Merge the values from positions [lo..mid) and [mid..hi) back into the same part of the array.
   *
   * Preconditions: Each subarray is sorted accorting to comparator.
   */
  static <T> void merge(T[] vals, int lo, int mid, int hi, Comparator<? super T> comparator) {
    int l = 0;
    int r = 0;
    int v = lo;

    T[] left = Arrays.copyOfRange(vals, lo, mid);
    T[] right = Arrays.copyOfRange(vals, mid, hi);

    while (l < left.length && r < right.length) {
      if (comparator.compare(left[l], right[r]) < 0) {
        vals[v++] = left[l++];
      } else {
        vals[v++] = right[r++];
      }
    }
    while (l < left.length) {
      vals[v++] = left[l++];
    }
    while (r < right.length) {
      vals[v++] = right[r++];
    }
  } // merge

} // class MergeSort
