package myTest;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThrows;
import myAdapter.*;

/**
 * Test class for {@link myAdapter.ListAdapter}
 * 
 * @safe.testsuitesummary This test suite is in charge of testing the {@link myAdapter.ListAdapter} class. The target of this test suite is
 * to verify that the adapter class {@link myAdapter.ListAdapter} behaves as described in the {@link myAdapter.HList} interface.
 * @safe.testsuitedesign Each individual method will be tested in multiple scenarios to verify that the behavior is the one expected. Both
 * standard and exceptional situations will be tested to verify that unconventional operation are managed correctly without compromising the
 * execution.
 * @safe.testsuiteprecondition An initially empty {@link myAdapter.HList} (the subject of the tests) and {@link myAdapter.HCollection} (that
 * will help checking the functionalities) that will be manipulated in the test cases. Execution variables are initialized in
 * {@link before()}.
 * @safe.testsuitepostcondition The behavior of {@link myAdapter.ListAdapter} is expected to be the same as described in the
 * {@link myAdapter.HList} interface.
 * @safe.testsuitetestcases See Test cases in Method Summary below.
 * 
 * @see myAdapter.HList
 * @see myAdapter.ListAdapter
 */
public class ListAdapterTest {

	/*
	 * TEST SUITE EXECUTION VARIABLES
	 */
	private HList testList;
	private HCollection helperCollection;

	/**
	 * In this section the execution variables are initialized before each test to ensure that the tests run on a newly initialized variables
	 * and that tests do not interfere with each other.
	 */
	@Before
	public void before() {
		testList = new ListAdapter();
		helperCollection = new ListAdapter();
	}

	/*
	 * TEST SUITE TEST CASES
	 */

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#add(int,Object)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test the attempt to add a null element (in a valid index) in a List.
	 * @hw.precondition a List
	 * @hw.postcondition NullPointerException thrown
	 * @hw.expectedresults The element has not been added because it was invalid.
	 */
	@Test
	public void testAdd1_1() {
		assertThrows(NullPointerException.class, () -> testList.add(0, null));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#add(int,Object)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test the attempt to add in an valid index (a valid element) in a List
	 * @hw.precondition a List
	 * @hw.postcondition IndexOutOfBoundsException thrown
	 * @hw.expectedresults The element has not been added because the given index was invalid.
	 */
	@Test
	public void testAdd1_2() {
		assertThrows(IndexOutOfBoundsException.class, () -> testList.add(-1, "one"));
		assertThrows(IndexOutOfBoundsException.class, () -> testList.add(1, "one"));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#add(int,Object)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test the addition of 3 elements (two of them identical) in determined indexes in a List
	 * @hw.precondition an empty List
	 * @hw.postcondition List size = 3, the list has changed
	 * @hw.expectedresults The elements have been added in the right position
	 */
	@Test
	public void testAdd1_3() {
		testList.add(0, "one");
		testList.add(1, "one");
		testList.add(2, "three");

		assertEquals(3, testList.size());
		String[] myArray = { "one", "one", "three" };
		assertArrayEquals(myArray, testList.toArray());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#add(int,Object)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test the addition of 3 elements of different types in determined indexes in a List
	 * @hw.precondition an empty List
	 * @hw.postcondition List size = 3
	 * @hw.expectedresults The elements have been added in the right position
	 */
	@Test
	public void testAdd1_4() {
		testList.add(0, 2.2);
		testList.add(0, "one");
		testList.add(2, "two");

		assertEquals(3, testList.size());
		Object[] myArray = { "one", 2.2, "two" };
		assertArrayEquals(myArray, testList.toArray());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#add(Object)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test the attempt to add a null element (in a valid index) in a List
	 * @hw.precondition a List
	 * @hw.postcondition NullPointerException thrown
	 * @hw.expectedresults The element has not been added because it was invalid
	 */
	@Test
	public void testAdd2_1() {
		assertThrows(NullPointerException.class, () -> testList.add(null));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#add(Object)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test the addition of 3 elements (two of them identical)
	 * @hw.precondition an empty List
	 * @hw.postcondition List size = 3
	 * @hw.expectedresults The elements have been added
	 */
	@Test
	public void testAdd2_2() {
		testList.add("one");
		testList.add("one");
		testList.add("three");

		assertEquals(3, testList.size());
		String[] myArray = { "one", "one", "three" };
		assertArrayEquals(myArray, testList.toArray());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#add(Object)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test the addition of 3 elements of different types
	 * @hw.precondition an empty List
	 * @hw.postcondition List size = 3
	 * @hw.expectedresults The elements have been added
	 */
	@Test
	public void testAdd2_3() {
		testList.add(2.2);
		testList.add("one");
		testList.add("two");

		assertEquals(3, testList.size());
		Object[] myArray = { 2.2, "one", "two" };
		assertArrayEquals(myArray, testList.toArray());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#addAll(HCollection)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test the addition of a null Collection to the List
	 * @hw.precondition a List and a null Collection
	 * @hw.postcondition NullPointerException thrown
	 * @hw.expectedresults The collection has not been added because it was invalid
	 */
	@Test
	public void testAddAll1_1() {
		assertThrows(NullPointerException.class, () -> testList.addAll(null));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#addAll(HCollection)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test the addition of a Collection of 3 elements to the List
	 * @hw.precondition a List and a 3 element Collection
	 * @hw.postcondition List size = 3
	 * @hw.expectedresults The collection has been added
	 */
	@Test
	public void testAddAll1_2() {
		helperCollection.add("one");
		helperCollection.add("two");
		helperCollection.add("three");

		testList.addAll(helperCollection);
		assertEquals(3, testList.size());
		String[] myArray = { "one", "two", "three" };
		assertArrayEquals(myArray, testList.toArray());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#addAll(HCollection)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test the addition of a Collection of 3 elements of different types to the List
	 * @hw.precondition a List and a 3 element Collection
	 * @hw.postcondition List size = 3
	 * @hw.expectedresults The collection has been added
	 */
	@Test
	public void testAddAll1_3() {
		helperCollection.add("one");
		helperCollection.add("two");
		helperCollection.add(2.2);

		testList.addAll(helperCollection);
		assertEquals(3, testList.size());
		Object[] myArray = { "one", "two", 2.2 };
		assertArrayEquals(myArray, testList.toArray());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#addAll(int,HCollection)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test the addition of a Collection in an invalid index of a List
	 * @hw.precondition a List and a Collection
	 * @hw.postcondition IndexOutOfBoundsException thrown
	 * @hw.expectedresults The collection has not been added because the index was invalid
	 */
	@Test
	public void testAddAll2_1() {
		helperCollection.add("one");

		assertThrows(IndexOutOfBoundsException.class, () -> testList.addAll(-1, helperCollection));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#addAll(int,HCollection)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test the addition of an empty Collection in a List
	 * @hw.precondition a List and an empty Collection
	 * @hw.postcondition List size = 0
	 * @hw.expectedresults The collection has been added but hasn't changed because it was empty
	 */
	@Test
	public void testAddAll2_2() {
		testList.addAll(0, helperCollection);

		assertEquals(0, testList.size());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#addAll(int,HCollection)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test the addition of a Collection of 3 elements of different types to the List in a valid index
	 * @hw.precondition a List and a 3 element Collection
	 * @hw.postcondition List size = 3
	 * @hw.expectedresults The collection has been added in the right position
	 */
	@Test
	public void testAddAll2_3() {
		helperCollection.add("one");
		helperCollection.add("two");
		helperCollection.add(2.2);
		testList.add("three");

		testList.addAll(1, helperCollection);
		assertEquals(4, testList.size());
		Object[] myArray = { "three", "one", "two", 2.2 };
		assertArrayEquals(myArray, testList.toArray());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#clear()} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test the clearing of an already empty List
	 * @hw.precondition an empty List
	 * @hw.postcondition List size = 0
	 * @hw.expectedresults The list has been cleared but it was already cleared
	 */
	@Test
	public void testClear_1() {
		testList.clear();

		assertEquals(0, testList.size());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#clear()} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test the clearing of a not empty List
	 * @hw.precondition a List with 1 element
	 * @hw.postcondition List size = 0
	 * @hw.expectedresults The list has been cleared
	 */
	@Test
	public void testClear_2() {
		testList.add("one");
		testList.clear();

		assertEquals(0, testList.size());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#contains(Object)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test if a List contains a null element
	 * @hw.precondition a List
	 * @hw.postcondition NullPointerException thrown
	 * @hw.expectedresults It was not possible to check if the element was contained because it was invalid
	 */
	@Test
	public void testContains_1() {
		assertThrows(NullPointerException.class, () -> testList.contains(null));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#contains(Object)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test if a List contains an element that is in the List
	 * @hw.precondition a List with 1 element
	 * @hw.postcondition return value true
	 * @hw.expectedresults The element was contained in the list
	 */
	@Test
	public void testContains_2() {
		testList.add("one");

		assertEquals(true, testList.contains("one"));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#contains(Object)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test if a List contains an element that is not in the List
	 * @hw.precondition a List with 1 element
	 * @hw.postcondition return value false
	 * @hw.expectedresults The element was not contained in the list
	 */
	@Test
	public void testContains_3() {
		testList.add("one");

		assertEquals(false, testList.contains(2.2));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#containsAll(HCollection)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test if a List contains a null Collection
	 * @hw.precondition a List
	 * @hw.postcondition NullPointerException thrown
	 * @hw.expectedresults It was not possible to check if the collection was contained because it was invalid
	 */
	@Test
	public void testContainsAll_1() {
		assertThrows(NullPointerException.class, () -> testList.containsAll(null));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#containsAll(HCollection)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test if a List contains all elements of a Collection but only contains some
	 * @hw.precondition a List with 1 elements and a Collection with 2 elements
	 * @hw.postcondition return value false
	 * @hw.expectedresults The collection was not (entirely) contained in the list
	 */
	@Test
	public void testContainsAll_2() {
		testList.add("one");
		helperCollection.add("one");
		helperCollection.add("two");

		assertEquals(false, testList.containsAll(helperCollection));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#containsAll(HCollection)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test if a List contains all elements of a Collection that are in the List
	 * @hw.precondition a List with 2 elements and a Collection with 2 elements
	 * @hw.postcondition return value true
	 * @hw.expectedresults The collection was entirely contained in the list
	 */
	@Test
	public void testContainsAll_3() {
		testList.add("one");
		testList.add("two");
		helperCollection.add("one");
		helperCollection.add("two");

		assertEquals(true, testList.containsAll(helperCollection));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#equals(Object)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test the equalness when the other list is equal
	 * @hw.precondition Two lists with the same elements
	 * @hw.postcondition return value true
	 * @hw.expectedresults The lists were equal
	 */
	@Test
	public void testEquals_1() {
		testList.add("one");
		HList other = new ListAdapter();
		other.add("one");

		assertEquals(true, testList.equals(other));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#equals(Object)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test the equalness when the other list is not equal
	 * @hw.precondition Two lists with the different elements
	 * @hw.postcondition return value false
	 * @hw.expectedresults The lists were not equal
	 */
	@Test
	public void testEquals_2() {
		testList.add("one");
		HList other = new ListAdapter();
		other.add("two");

		assertEquals(false, testList.equals(other));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#get(int)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test getting an element in an invalid position
	 * @hw.precondition a list
	 * @hw.postcondition IndexOutOfBoundsException thrown
	 * @hw.expectedresults It was not possibile to get the element because the index was invalid
	 */
	@Test
	public void testGet_1() {
		assertThrows(IndexOutOfBoundsException.class, () -> testList.get(-1));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#get(int)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test getting a present element in a valid position
	 * @hw.precondition a list with some elements
	 * @hw.postcondition returned elements is equal to the one added before
	 * @hw.expectedresults The getted element was the one in the given index
	 */
	@Test
	public void testGet_2() {
		testList.add("one");

		assertEquals("one", testList.get(0));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#hashCode()} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test comparing hashcodes of two different lists
	 * @hw.precondition two lists
	 * @hw.postcondition returned value false
	 * @hw.expectedresults The two different lists have different hashcodes
	 */
	@Test
	public void testHashCode_1() {
		testList.add("one");
		HList otherList = new ListAdapter();
		otherList.add("two");

		assertEquals(false, testList.hashCode() == otherList.hashCode());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#hashCode()} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test comparing hashcodes of two identical lists
	 * @hw.precondition two lists
	 * @hw.postcondition returned value true
	 * @hw.expectedresults The two identical lists have same hashcodes
	 */
	@Test
	public void testHashCode_2() {
		testList.add("one");
		HList otherList = new ListAdapter();
		otherList.add("one");

		assertEquals(true, testList.hashCode() == otherList.hashCode());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#indexOf(Object)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test getting index of a null element
	 * @hw.precondition a list
	 * @hw.postcondition NullPointerException thrown
	 * @hw.expectedresults It was not possible to get the index of an invalid element
	 */
	@Test
	public void testIndexOf_1() {
		assertThrows(NullPointerException.class, () -> testList.indexOf(null));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#indexOf(Object)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test getting index of valid element
	 * @hw.precondition a list with some elements
	 * @hw.postcondition the index returned is the same of the index of the given element
	 * @hw.expectedresults The getted index was the one corresponding to the given element
	 */
	@Test
	public void testIndexOf_2() {
		testList.add("one");

		assertEquals(0, testList.indexOf("one"));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#isEmpty()} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test if a not empty list is considered empty
	 * @hw.precondition a not empty list
	 * @hw.postcondition returned value false
	 * @hw.expectedresults The list was not empty
	 */
	@Test
	public void testIsEmpty_1() {
		testList.add("one");

		assertEquals(false, testList.isEmpty());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#isEmpty()} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test if an empty list is considered empty
	 * @hw.precondition an empty list
	 * @hw.postcondition returned value true
	 * @hw.expectedresults The list was empty
	 */
	@Test
	public void testIsEmpty_2() {
		assertEquals(true, testList.isEmpty());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#iterator()} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test checking if there is a next element on an empty list
	 * @hw.precondition a list and the related iterator
	 * @hw.postcondition returned value false
	 * @hw.expectedresults The is no next element in an empty list
	 */
	@Test
	public void testIterator_1() {
		HIterator myIterator = testList.iterator();

		assertEquals(false, myIterator.hasNext());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#iterator()} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test iterating to next element
	 * @hw.precondition a list and the related iterator
	 * @hw.postcondition returned value true, the nex element is the same as the one added before
	 * @hw.expectedresults The is a next element and it's the one added before
	 */
	@Test
	public void testIterator_2() {
		testList.add("one");
		HIterator myIterator = testList.iterator();

		assertEquals(true, myIterator.hasNext());
		assertEquals("one", myIterator.next());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#iterator()} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test removing an element via iterator after next has been called
	 * @hw.precondition a list and the related iterator
	 * @hw.postcondition returned value false and the list size is back to 0
	 * @hw.expectedresults The element has been removed, now there is no next element
	 */
	@Test
	public void testIterator_3() {
		testList.add("one");
		HIterator myIterator = testList.iterator();

		assertEquals("one", myIterator.next());
		myIterator.remove();
		assertEquals(false, myIterator.hasNext());
		assertEquals(0, testList.size());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#iterator()} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test removing an element via iterator before next has been called
	 * @hw.precondition a list and the related iterator
	 * @hw.postcondition returned value false
	 * @hw.expectedresults It was not possible to call remove before calling next
	 */
	@Test
	public void testIterator_4() {
		testList.add("one");
		HIterator myIterator = testList.iterator();

		assertThrows(IllegalStateException.class, () -> myIterator.remove());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#lastIndexOf(Object)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test getting last index of a null element
	 * @hw.precondition a list
	 * @hw.postcondition NullPointerException thrown
	 * @hw.expectedresults It was not possible to get the last index of a non valid element
	 */
	@Test
	public void testLastIndexOf_1() {
		assertThrows(NullPointerException.class, () -> testList.lastIndexOf(null));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#lastIndexOf(Object)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test getting last index of an element when there are 2
	 * @hw.precondition a list with two identical elements
	 * @hw.postcondition the index returned is the index of the second element added
	 * @hw.expectedresults The last index is the one corrisponding to the last occurency of the given element
	 */
	@Test
	public void testLastIndexOf_2() {
		testList.add("one");
		testList.add("one");

		assertEquals(1, testList.lastIndexOf("one"));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#listIterator(int)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test trying to get an iterator with an invalid index
	 * @hw.precondition a list
	 * @hw.postcondition IndexOutOfBoundsException thrown
	 * @hw.expectedresults It was not possible to get a list iterator at an invalid index
	 */
	@Test
	public void TestListIterator_1() {
		assertThrows(IndexOutOfBoundsException.class, () -> testList.listIterator(-1));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#listIterator()} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test adding elements and iterating using next and previous via a listIterator
	 * @hw.precondition a list and the related iterator
	 * @hw.postcondition at first hasNext/hasPrev=false, after adding elements hasPrev=true and size=2, calling prev one time returnes the last
	 * added , the second time the first added
	 * @hw.expectedresults The elements will be added and previous will return them starting from the last added
	 */
	@Test
	public void TestListIterator_2() {
		HListIterator myIterator = testList.listIterator();

		assertEquals(false, myIterator.hasNext());
		assertEquals(false, myIterator.hasPrevious());
		myIterator.add("one");
		myIterator.add("two");
		assertEquals(2, testList.size());
		assertEquals(false, myIterator.hasNext());
		assertEquals(true, myIterator.hasPrevious());
		assertEquals("two", myIterator.previous());
		assertEquals("one", myIterator.previous());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#listIterator()} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test trying to set an element before callig next/prev
	 * @hw.precondition a list and the related iterator
	 * @hw.postcondition IllegalStateException thrown
	 * @hw.expectedresults It was not possible to set an element before calling next/prev
	 */
	@Test
	public void TestListIterator_3() {
		HListIterator myIterator = testList.listIterator();

		myIterator.add("one");
		assertThrows(IllegalStateException.class, () -> myIterator.set("two"));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#listIterator(int)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test trying to set an element after callig next/prev
	 * @hw.precondition a list and the related iterator
	 * @hw.postcondition the correct element has been updated
	 * @hw.expectedresults The element has been setted
	 */
	@Test
	public void TestListIterator_4() {
		testList.add("zero");

		HListIterator myIterator = testList.listIterator(1);
		myIterator.add("one");
		myIterator.add("two");
		myIterator.previous();
		myIterator.set("three");
		Object[] myArray = { "zero", "one", "three" };
		assertArrayEquals(myArray, testList.toArray());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#listIterator()} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test getting previous/next indexes
	 * @hw.precondition a list and the related iterator
	 * @hw.postcondition the correct element has been updated
	 * @hw.expectedresults The indexes of the next/prev elements are correct after removing and adding elements
	 */
	@Test
	public void TestListIterator_5() {
		HListIterator myIterator = testList.listIterator();

		assertEquals(-1, myIterator.previousIndex());
		assertEquals(0, myIterator.nextIndex());
		myIterator.add("one");
		assertEquals(0, myIterator.previousIndex());
		assertEquals(1, myIterator.nextIndex());
		myIterator.previous();
		myIterator.remove();
		assertEquals(-1, myIterator.previousIndex());
		assertEquals(0, myIterator.nextIndex());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#remove(int)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test removing an element using an invalid index
	 * @hw.precondition a list
	 * @hw.postcondition IndexOutOfBoundsException thrown
	 * @hw.expectedresults It's not possible to remove an element using an invalid index
	 */
	@Test
	public void testRemove1_1() {
		assertThrows(IndexOutOfBoundsException.class, () -> testList.remove(-1));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#remove(int)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test removing an element using a valid index
	 * @hw.precondition a list with one element
	 * @hw.postcondition the element returned is the same added before and the list in now empty
	 * @hw.expectedresults The element has been removed
	 */
	@Test
	public void testRemove1_2() {
		testList.add("one");

		assertEquals("one", testList.remove(0));
		assertEquals(0, testList.size());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#remove(Object)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test removing a null element
	 * @hw.precondition a list
	 * @hw.postcondition NullPointerException thrown
	 * @hw.expectedresults It's not possible to remove an invalid element
	 */
	@Test
	public void testRemove2_1() {
		assertThrows(NullPointerException.class, () -> testList.remove(null));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#remove(Object)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test removing a non present element
	 * @hw.precondition a list with some elements
	 * @hw.postcondition returned value false
	 * @hw.expectedresults The element has not been removed because it wasn't present
	 */
	@Test
	public void testRemove2_2() {
		testList.add("one");

		assertEquals(false, testList.remove("two"));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#remove(Object)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test removing a present element
	 * @hw.precondition a list with some elements
	 * @hw.postcondition returned value true
	 * @hw.expectedresults The element has been removed
	 */
	@Test
	public void testRemove2_3() {
		testList.add("one");

		assertEquals(true, testList.remove("one"));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#removeAll(HCollection)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test removing elements using a null collection
	 * @hw.precondition a list
	 * @hw.postcondition NullPointerException thrown
	 * @hw.expectedresults It's not possible to remove an invalid collection
	 */
	@Test
	public void TestRemoveAll_1() {
		assertThrows(NullPointerException.class, () -> testList.removeAll(null));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#removeAll(HCollection)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test removing elements using a valid collection
	 * @hw.precondition a list with two elements, a collection with one element equal to one in the list
	 * @hw.postcondition returned value true and the list has been correctly modified
	 * @hw.expectedresults The elements of the collection has been removed
	 */
	@Test
	public void TestRemoveAll_2() {
		testList.add("one");
		testList.add("two");
		helperCollection.add("one");

		assertEquals(true, testList.removeAll(helperCollection));
		Object[] myArray = { "two" };
		assertArrayEquals(myArray, testList.toArray());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#retainAll(HCollection)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test retaining elements using a null collection
	 * @hw.precondition a list
	 * @hw.postcondition NullPointerException thrown
	 * @hw.expectedresults It's not possible to retain elements of an invalid collection
	 */
	@Test
	public void TestRetainAll_1() {
		assertThrows(NullPointerException.class, () -> testList.retainAll(null));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#retainAll(HCollection)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test retaining elements using a valid collection
	 * @hw.precondition a list with two elements, a collection with one element equal to one in the list
	 * @hw.postcondition returned value true and the list has been correctly modified
	 * @hw.expectedresults Only the elements of the collection has been retained
	 */
	@Test
	public void TestRetainAll_2() {
		testList.add("one");
		testList.add("two");
		helperCollection.add("one");

		assertEquals(true, testList.retainAll(helperCollection));
		Object[] myArray = { "one" };
		assertArrayEquals(myArray, testList.toArray());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#set(int,Object)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test setting an element in an invalid position
	 * @hw.precondition a list
	 * @hw.postcondition IndexOutOfBoundsException thrown
	 * @hw.expectedresults It's not possible to set an element using an invalid index
	 */
	@Test
	public void testSet_1() {
		assertThrows(IndexOutOfBoundsException.class, () -> testList.set(-1, "one"));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#set(int,Object)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test setting with valid index but null element
	 * @hw.precondition a list with one element
	 * @hw.postcondition NullPointerException thrown
	 * @hw.expectedresults It's not possible to set an element using an invalid element
	 */
	@Test
	public void testSet_2() {
		testList.add("one");

		assertThrows(NullPointerException.class, () -> testList.set(0, null));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#set(int,Object)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test setting with valid index and valid element
	 * @hw.precondition a list with one element
	 * @hw.postcondition the returned element is the older one, the list contains one element and has been updated
	 * @hw.expectedresults The element has been setted and the older one returned
	 */
	@Test
	public void testSet_3() {
		testList.add("one");

		assertEquals("one", testList.set(0, "two"));
		Object[] myArray = { "two" };
		assertArrayEquals(myArray, testList.toArray());
		assertEquals(1, testList.size());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#size()} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test getting the size of an empty list
	 * @hw.precondition empty list
	 * @hw.postcondition returned size = 0
	 * @hw.expectedresults The size of an empty list is 0
	 */
	@Test
	public void testSize_1() {
		assertEquals(0, testList.size());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#size()} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test getting the size of a not empty list
	 * @hw.precondition a list with some elements
	 * @hw.postcondition the size returned is = 3 and then, after removing one element, = 2
	 * @hw.expectedresults The size decrease by 1 when removing 1 element
	 */
	@Test
	public void testSize_2() {
		testList.add("one");
		testList.add("two");
		testList.add("three");

		assertEquals(3, testList.size());
		testList.remove(2);
		assertEquals(2, testList.size());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#subList(int,int)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test trying getting a sublist with invalid indexes
	 * @hw.precondition a list
	 * @hw.postcondition IndexOutOfBoundsException thrown
	 * @hw.expectedresults It's not possible to get a sublist using an invalid index
	 */
	@Test
	public void testSubList_1() {
		assertThrows(IndexOutOfBoundsException.class, () -> testList.subList(-1, 0));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#subList(int,int)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test getting a valid sublist and clearing it
	 * @hw.precondition a list with some elements
	 * @hw.postcondition the sublist size is 0 and the element have been removed also from the related list
	 * @hw.expectedresults The part of the list in the sublist has been cleared
	 */
	@Test
	public void testSubList_2() {
		testList.add("one");
		testList.add("two");
		testList.add("three");
		testList.add("four");
		testList.add("five");

		HList mySub = testList.subList(1, 4);
		mySub.clear();
		assertEquals(0, mySub.size());
		Object[] myArray = { "one", "five" };
		assertArrayEquals(myArray, testList.toArray());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#subList(int,int)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test getting a valid sublist adding elements to it
	 * @hw.precondition a list with some elements
	 * @hw.postcondition the sublist size has been incremented and the element have added also in the right position of the related list
	 * @hw.expectedresults The elements added to the sublist are added also to the list (in the correct position)
	 */
	@Test
	public void testSubList_3() {
		testList.add("one");
		testList.add("two");
		testList.add("three");
		testList.add("four");
		testList.add("five");

		HList mySub = testList.subList(1, 4);
		mySub.add("six");
		assertEquals(4, mySub.size());
		Object[] myArray = { "one", "two", "three", "four", "six", "five" };
		assertArrayEquals(myArray, testList.toArray());
		mySub.add(0, "seven");
		assertEquals(5, mySub.size());
		Object[] myArray2 = { "one", "seven", "two", "three", "four", "six", "five" };
		assertArrayEquals(myArray2, testList.toArray());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#subList(int,int)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test getting a complete sublist ad comparing for equality with the related
	 * @hw.precondition a list with some elements
	 * @hw.postcondition returned value true
	 * @hw.expectedresults A sublist from the start to the end of the list is equal to the list and vice versa
	 */
	@Test
	public void testSubList_4() {
		testList.add("one");
		testList.add("two");
		testList.add("three");
		testList.add("four");
		testList.add("five");

		HList mySub = testList.subList(0, testList.size());
		assertEquals(true, mySub.equals(testList));
		assertEquals(true, testList.equals(mySub));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#subList(int,int)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test getting a sublist of all the list and using it
	 * @hw.precondition a list with some elements
	 * @hw.postcondition the changes at the sublist are reflected in the list
	 * @hw.expectedresults The changes made at the sublist are reflected also in the list
	 */
	@Test
	public void testSubList_5() {
		testList.add("one");
		testList.add("two");
		testList.add("three");
		testList.add("four");
		testList.add("five");

		HList mySub = testList.subList(0, testList.size());
		assertEquals(false, mySub.isEmpty());
		assertEquals(testList.hashCode(), mySub.hashCode());
		assertArrayEquals(testList.toArray(), mySub.toArray());
		assertArrayEquals(testList.toArray(new String[5]), mySub.toArray(new String[5]));
		mySub.set(0, "two");
		assertEquals("two", mySub.get(0));
		assertEquals(false, mySub.contains("one"));
		assertEquals(1, mySub.lastIndexOf("two"));
		mySub.remove(0);
		assertEquals(true, mySub.equals(testList));
		mySub.remove("three");
		assertEquals(true, mySub.equals(testList));
		int oldSize = mySub.size();
		mySub.retainAll(testList);
		assertEquals(oldSize, mySub.size());
		mySub.removeAll(testList);
		assertEquals(mySub.size(), testList.size());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#subList(int,int)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test getting a sublist and using addAll on it
	 * @hw.precondition a collection with some elements
	 * @hw.postcondition the changes at the sublist are reflected in the list
	 * @hw.expectedresults The changes made at the sublist are reflected also in the list
	 */
	@Test
	public void testSubList_6() {
		helperCollection.add("one");
		helperCollection.add("two");
		helperCollection.add("three");

		HList mySub = testList.subList(0, testList.size());
		mySub.addAll(helperCollection);
		assertEquals(3, mySub.size(), testList.size());
		assertArrayEquals(helperCollection.toArray(), mySub.toArray());
		mySub.addAll(1, helperCollection);
		assertEquals(6, mySub.size(), testList.size());
		Object[] myArray = { "one", "one", "two", "three", "two", "three" };
		assertArrayEquals(myArray, mySub.toArray());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#subList(int,int)} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test getting a sublist from a sublist
	 * @hw.precondition a list with some elements
	 * @hw.postcondition the partial array and indexes seen by the sublist is correct
	 * @hw.expectedresults The indexes of sublists are correct even when getting sublist from another sublist
	 */
	@Test
	public void testSubList_7() {
		testList.add("one");
		testList.add("two");
		testList.add("three");
		testList.add("four");
		testList.add("five");

		HList mySub = testList.subList(1, 4);
		HList myOtherSub = mySub.subList(1, 2);
		assertEquals(0, myOtherSub.indexOf("three"));
		Object[] myArray = { "three" };
		assertArrayEquals(myArray, myOtherSub.toArray());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#toArray()} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test getting the array for a non empty list
	 * @hw.precondition a list with some elements
	 * @hw.postcondition the returned array has same size and elements of the list
	 * @hw.expectedresults The array has same size and elements of the list
	 */
	@Test
	public void testToArray1_1() {
		testList.add("one");
		testList.add("two");
		testList.add("three");

		Object[] myArray = testList.toArray();
		assertEquals(myArray.length, testList.size());
		for (int i = 0; i < testList.size(); i++)
			assertEquals(myArray[i], testList.get(i));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#toArray(Object[])} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test getting the array for a non empty list with array parameter of the right type and length 0
	 * @hw.precondition a list with some elements
	 * @hw.postcondition list and array have the same size and elements
	 * @hw.expectedresults The array has same size and elements of the list and the type of the given array
	 */
	@Test
	public void testToArray2_1() {
		testList.add("one");
		testList.add("two");
		testList.add("three");

		String[] myArray = (String[]) testList.toArray(new String[0]);
		assertEquals(testList.size(), myArray.length);
		for (int i = 0; i < myArray.length; i++)
			assertEquals(myArray[i], testList.get(i));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#toArray(Object[])} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test getting the array for a non empty list with array parameter of the right type
	 * @hw.precondition a list of size N and an array of the right type of size >=N
	 * @hw.postcondition the first N elements of the array will be the first N of the list, the element at index N in the array will be null
	 * @hw.expectedresults The array has same size and elements of the list and the type of the given array, in the array there is a null
	 * element after the last element of the list
	 */
	@Test
	public void testToArray2_2() {
		testList.add("one");
		testList.add("two");
		testList.add("three");

		String[] myArray = { "a", "b", "c", "d" };
		myArray = (String[]) testList.toArray(myArray);
		for (int i = 0; i < myArray.length; i++) {
			if (myArray[i] == null) {
				assertEquals(i, testList.size());
				break;
			}
			assertEquals(myArray[i], testList.get(i));
		}
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.ListAdapter#toArray(Object[])} method in ListAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test getting the array for a non empty list with array parameter of incompatible type
	 * @hw.precondition a list
	 * @hw.postcondition ArrayStoreException thrown
	 * @hw.expectedresults It's impossible to get the array from a list giving an array type incompatible with the list elements type
	 */
	@Test
	public void testToArray2_3() {
		testList.add("one");
		testList.add("two");
		testList.add("three");

		assertThrows(ArrayStoreException.class, () -> testList.toArray(new Integer[0]));
		assertThrows(ArrayStoreException.class, () -> testList.toArray(new Integer[3]));
	}
}