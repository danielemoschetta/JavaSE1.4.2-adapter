package myTest;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThrows;
import myAdapter.*;

/**
 * Test class for {@link myAdapter.MapAdapter}
 * 
 * @safe.testsuitesummary This test suite is in charge of testing the {@link myAdapter.MapAdapter} class. The target of this test suite is
 * to verify that the adapter class {@link myAdapter.MapAdapter} behaves as described in the {@link myAdapter.HMap} interface.
 * @safe.testsuitedesign Each individual method will be tested in multiple scenarios to verify that the behavior is the one expected. Both
 * standard and exceptional situations will be tested to verify that unconventional operation are managed correctly without compromising the
 * execution.
 * @safe.testsuiteprecondition An initially empty {@link myAdapter.HMap} (the subject of the tests) and {@link myAdapter.HCollection} (that
 * will help checking the functionalities) that will be manipulated in the test cases. Execution variables are initialized in
 * {@link before()}.
 * @safe.testsuitepostcondition The behavior of {@link myAdapter.MapAdapter} is expected to be the same as described in the
 * {@link myAdapter.HMap} interface.
 * @safe.testsuitetestcases See Test cases in Method Summary below.
 * 
 * @see myAdapter.HMap
 * @see myAdapter.MapAdapter
 */

public class MapAdapterTest {

	/*
	 * TEST SUITE EXECUTION VARIABLES
	 */
	private HMap testMap;
	private HCollection helperCollection;

	/**
	 * In this section the execution variables are initialized before each test to ensure that the tests run on a newly initialized variables
	 * and that tests do not interfere with each other.
	 */
	@Before
	public void before() {
		testMap = new MapAdapter();
		helperCollection = new ListAdapter();
	}

	/*
	 * TEST SUITE TEST CASES
	 */

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#put(Object, Object)} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test the attempt to put an element with null key/value in a map.
	 * @hw.precondition a map
	 * @hw.postcondition NullPointerException thrown
	 * @hw.expectedresults It's not possible to put an element with invalid key/value
	 */
	@Test
	public void testPut_1() {
		assertThrows(NullPointerException.class, () -> testMap.put(1, null));
		assertThrows(NullPointerException.class, () -> testMap.put(null, "one"));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#put(Object, Object)} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test the attempt to put two valid elements in a map
	 * @hw.precondition a map
	 * @hw.postcondition map size = 2
	 * @hw.expectedresults The elements have been added
	 */
	@Test
	public void testPut_2() {
		testMap.put(0, "zero");
		testMap.put(1, "one");

		assertEquals(2, testMap.size());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#clear()} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test clearing an empty
	 * @hw.precondition an empty map
	 * @hw.postcondition at first map size = 0, then 0
	 * @hw.expectedresults The map continues to be empty
	 */
	@Test
	public void testClear_1() {
		assertEquals(0, testMap.size());
		testMap.clear();
		assertEquals(0, testMap.size());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#clear()} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test clearing an empty
	 * @hw.precondition a non empty map
	 * @hw.postcondition at first map size = 2, then 0
	 * @hw.expectedresults The map becomes empty
	 */
	@Test
	public void testClear_2() {
		testMap.put(0, "zero");
		testMap.put(1, "one");

		assertEquals(2, testMap.size());
		testMap.clear();
		assertEquals(0, testMap.size());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#containsKey(Object)} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test checking if the map contains a null key
	 * @hw.precondition a map
	 * @hw.postcondition NullPointerException thrown
	 * @hw.expectedresults It's not possible to check if an invalid key is present
	 */
	@Test
	public void testContainsKey_1() {
		testMap.put(0, "zero");

		assertThrows(NullPointerException.class, () -> testMap.containsKey(null));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#containsKey(Object)} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test checking if the map contains a valid key that is contained
	 * @hw.precondition a non empty map
	 * @hw.postcondition returned value true
	 * @hw.expectedresults The key was contained in the map
	 */
	@Test
	public void testContainsKey_2() {
		testMap.put(0, "zero");

		assertEquals(true, testMap.containsKey(0));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#containsKey(Object)} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test checking if the map contains a valid key that is not contained
	 * @hw.precondition a non empty map
	 * @hw.postcondition returned value false
	 * @hw.expectedresults The key was not contained in the map
	 */
	@Test
	public void testContainsKey_3() {
		testMap.put(0, "zero");

		assertEquals(false, testMap.containsKey(1));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#containsValue(Object)} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test checking if the map contains a null value
	 * @hw.precondition a map
	 * @hw.postcondition NullPointerException thrown
	 * @hw.expectedresults It's not possible to check if the map contains an invalid value
	 */
	@Test
	public void testContainsValue_1() {
		testMap.put(0, "zero");

		assertThrows(NullPointerException.class, () -> testMap.containsValue(null));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#containsValue(Object)} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test checking if the map contains a valid value that is contained
	 * @hw.precondition a non empty map
	 * @hw.postcondition returned value true
	 * @hw.expectedresults The value is contained in the map
	 */
	@Test
	public void testContainsValue_2() {
		testMap.put(0, "zero");

		assertEquals(true, testMap.containsValue("zero"));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#containsValue(Object)} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription Test checking if the map contains a valid value that is not contained
	 * @hw.precondition a non empty map
	 * @hw.postcondition returned value false
	 * @hw.expectedresults The value was not contained in the map
	 */
	@Test
	public void testContainsValue_3() {
		testMap.put(0, "zero");

		assertEquals(false, testMap.containsValue("one"));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter.Entry#setValue(Object)} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test setting the value for an entry
	 * @hw.precondition an entry
	 * @hw.postcondition the value has been updated
	 * @hw.expectedresults The entry value has been changed
	 */
	@Test
	public void testSetValue() {
		HMap.Entry myEntry = new MapAdapter.Entry(1, "one");

		myEntry.setValue("first");
		assertEquals("first", myEntry.getValue());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#entrySet()} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test checking that the entrySet contains the correct elements
	 * @hw.precondition a map with elements
	 * @hw.postcondition the elements are contained and the sizes of entrySet and map are the same
	 * @hw.expectedresults The entrySet contains the entries added to the map before
	 */
	@Test
	public void testEntrySet_1() {
		testMap.put(1, "one");
		testMap.put(2, "two");
		testMap.put(3, "three");

		HSet myEntries = testMap.entrySet();
		assertEquals(true, myEntries.contains(new MapAdapter.Entry(1, "one")));
		assertEquals(true, myEntries.contains(new MapAdapter.Entry(2, "two")));
		assertEquals(true, myEntries.contains(new MapAdapter.Entry(3, "three")));
		assertEquals(testMap.size(), myEntries.size());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#entrySet()} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test removing one entry via entrySet remove
	 * @hw.precondition a map with elements
	 * @hw.postcondition the size of map and entrySet are = 2 and the removed element is not contained in the map
	 * @hw.expectedresults The entry has been removed from the map
	 */
	@Test
	public void testEntrySet_2() {
		testMap.put(1, "one");
		testMap.put(2, "two");
		testMap.put(3, "three");

		HSet myEntries = testMap.entrySet();
		myEntries.remove(new MapAdapter.Entry(3, "three"));
		assertEquals(false, testMap.containsKey(3));
		assertEquals(2, testMap.size());
		assertEquals(testMap.size(), myEntries.size());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#entrySet()} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test removing one entry via entrySet iterator remove
	 * @hw.precondition a map with elements
	 * @hw.postcondition the size of map and entrySet are = 2 and the removed element is not contained in the map
	 * @hw.expectedresults The entry has been removed from the map
	 */
	@Test
	public void testEntrySet_3() {
		testMap.put(1, "one");
		testMap.put(2, "two");
		testMap.put(3, "three");

		HSet myEntries = testMap.entrySet();
		HIterator myIterator = myEntries.iterator();
		myIterator.next();
		myIterator.remove();
		assertEquals(false, testMap.containsKey(3));
		assertEquals(2, testMap.size());
		assertEquals(testMap.size(), myEntries.size());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#entrySet()} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test removing entry via entrySet removeAll
	 * @hw.precondition a map with elements
	 * @hw.postcondition the size of map and entrySet are = 1 and the removed elements are not contained in the map
	 * @hw.expectedresults The entries in the collection have been removed from the map
	 */
	@Test
	public void testEntrySet_4() {
		testMap.put(1, "one");
		testMap.put(2, "two");
		testMap.put(3, "three");

		helperCollection.add(new MapAdapter.Entry(3, "three"));
		helperCollection.add(new MapAdapter.Entry(2, "two"));
		HSet myEntries = testMap.entrySet();
		myEntries.removeAll(helperCollection);
		assertEquals(false, testMap.containsKey(3));
		assertEquals(false, testMap.containsKey(2));
		assertEquals(1, testMap.size());
		assertEquals(testMap.size(), myEntries.size());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#entrySet()} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test removing entry via entrySet retainAll
	 * @hw.precondition a map with elements
	 * @hw.postcondition the size of map and entrySet are = 2 and the not retained element is not contained in the map
	 * @hw.expectedresults Only the entries in the collection have been retained in the map
	 */
	@Test
	public void testEntrySet_5() {
		testMap.put(1, "one");
		testMap.put(2, "two");
		testMap.put(3, "three");
		helperCollection.add(new MapAdapter.Entry(3, "three"));
		helperCollection.add(new MapAdapter.Entry(2, "two"));

		HSet myEntries = testMap.entrySet();
		myEntries.retainAll(helperCollection);
		assertEquals(false, testMap.containsKey(1));
		assertEquals(2, testMap.size());
		assertEquals(testMap.size(), myEntries.size());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#entrySet()} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test clearing entries via entrySet clear
	 * @hw.precondition a map with elements
	 * @hw.postcondition the size of map and entrySet are = 0
	 * @hw.expectedresults The map and the entrySet have been cleared
	 */
	@Test
	public void testEntrySet_6() {
		testMap.put(1, "one");
		testMap.put(2, "two");
		testMap.put(3, "three");

		HSet myEntries = testMap.entrySet();
		myEntries.clear();
		assertEquals(0, testMap.size());
		assertEquals(testMap.size(), myEntries.size());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#entrySet()} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test adding via entrySet add
	 * @hw.precondition a map
	 * @hw.postcondition UnsupportedOperationException thrown
	 * @hw.expectedresults It's not possible to add elements via the entrySet
	 */
	@Test
	public void testEntrySet_7() {
		assertThrows(myAdapter.UnsupportedOperationException.class,
				() -> testMap.entrySet().add(new MapAdapter.Entry(1, "one")));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#entrySet()} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test adding via entrySet addAll
	 * @hw.precondition a map
	 * @hw.postcondition UnsupportedOperationException thrown
	 * @hw.expectedresults It's not possible to add collection's elements via the entrySet
	 */
	@Test
	public void testEntrySet_8() {
		helperCollection.add(new MapAdapter.Entry(1, "one"));

		assertThrows(myAdapter.UnsupportedOperationException.class, () -> testMap.entrySet().addAll(helperCollection));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#entrySet()} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test for equality two entrySets of identical maps
	 * @hw.precondition two maps
	 * @hw.postcondition returned value true
	 * @hw.expectedresults The entrySets are identical
	 */
	@Test
	public void testEntrySet_9() {
		HMap otherMap = new MapAdapter();
		otherMap.put(1, "one");
		testMap.put(1, "one");

		assertEquals(true, testMap.entrySet().equals(otherMap.entrySet()));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#entrySet()} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test for equality two entrySets of different maps
	 * @hw.precondition two maps
	 * @hw.postcondition returned value false
	 * @hw.expectedresults The entrySets are different
	 */
	@Test
	public void testEntrySet_10() {
		HMap otherMap = new MapAdapter();
		otherMap.put(1, "one");
		testMap.put(2, "two");

		assertEquals(false, testMap.entrySet().equals(otherMap.entrySet()));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#equals(Object)} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test comparing two identical maps for equality
	 * @hw.precondition two maps with some elements
	 * @hw.postcondition returned value true
	 * @hw.expectedresults The map are equal
	 */
	@Test
	public void testEquals_1() {
		testMap.put(1, "one");
		HMap otherMap = new MapAdapter();
		otherMap.put(1, "one");

		assertEquals(true, testMap.equals(otherMap));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#equals(Object)} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test comparing two not identical maps for equality
	 * @hw.precondition two maps with some elements
	 * @hw.postcondition returned value false
	 * @hw.expectedresults The maps are different
	 */
	@Test
	public void testEquals_2() {
		testMap.put(1, "one");
		HMap otherMap = new MapAdapter();
		otherMap.put(1, "first");

		assertEquals(false, testMap.equals(otherMap));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#get(Object)} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test getting value for a null key
	 * @hw.precondition a map
	 * @hw.postcondition NullPointerException thrown
	 * @hw.expectedresults It's not possible to get the value for an invalid key
	 */
	@Test
	public void testGet_1() {
		assertThrows(NullPointerException.class, () -> testMap.get(null));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#get(Object)} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test getting value for a valid key
	 * @hw.precondition a map
	 * @hw.postcondition correct value returned
	 * @hw.expectedresults The returned value is the one corresponding to the given key
	 */
	@Test
	public void testGet_2() {
		testMap.put(1, "one");

		assertEquals("one", testMap.get(1));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#get(Object)} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test getting value for a non present valid key
	 * @hw.precondition a map
	 * @hw.postcondition null returned
	 * @hw.expectedresults The returned value is null because the key was not contained in the map
	 */
	@Test
	public void testGet_3() {
		testMap.put(1, "one");

		assertEquals(null, testMap.get(2));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#hashCode()} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test comparing hashcodes for two identical maps
	 * @hw.precondition two maps
	 * @hw.postcondition two hashcodes are the same
	 * @hw.expectedresults The hashcodes are the equal
	 */
	@Test
	public void testHasCode_1() {
		testMap.put(1, "one");
		HMap otherMap = new MapAdapter();
		otherMap.put(1, "one");

		assertEquals(testMap.hashCode(), otherMap.hashCode());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#hashCode()} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test comparing hashcodes for two different maps
	 * @hw.precondition two maps
	 * @hw.postcondition two hashcodes are the different
	 * @hw.expectedresults The hashcodes are different
	 */
	@Test
	public void testHasCode_2() {
		testMap.put(1, "one");
		HMap otherMap = new MapAdapter();
		otherMap.put(2, "two");

		assertEquals(false, testMap.hashCode() == otherMap.hashCode());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#isEmpty()} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test checking if an empty map is empty
	 * @hw.precondition an empty map
	 * @hw.postcondition returned value true
	 * @hw.expectedresults The map is empty
	 */
	@Test
	public void testIsEmpty_1() {
		assertEquals(true, testMap.isEmpty());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#isEmpty()} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test checking if a not map is empty
	 * @hw.precondition a not empty map
	 * @hw.postcondition returned value false
	 * @hw.expectedresults The map is not empty
	 */
	@Test
	public void testIsEmpty_2() {
		testMap.put(1, "one");

		assertEquals(false, testMap.isEmpty());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#keySet()} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test checking that the keySet contains the correct keys
	 * @hw.precondition a map with elements
	 * @hw.postcondition the keys are contained and the sizes of keySet and map are the same
	 * @hw.expectedresults The keySet contains the keys added to the map before
	 */
	@Test
	public void testKeySet_1() {
		testMap.put(1, "one");
		testMap.put(2, "two");
		testMap.put(3, "three");

		HSet myKeys = testMap.keySet();
		assertEquals(true, myKeys.contains(1));
		assertEquals(true, myKeys.contains(2));
		assertEquals(true, myKeys.contains(3));
		assertEquals(testMap.size(), testMap.keySet().size());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#keySet()} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test removing one key via keySet remove
	 * @hw.precondition a map with elements
	 * @hw.postcondition the size of map and keySet are = 2 and the removed key is not contained in the map
	 * @hw.expectedresults The key has been removed from the map
	 */
	@Test
	public void testKeySet_2() {
		testMap.put(1, "one");
		testMap.put(2, "two");
		testMap.put(3, "three");

		HSet myKeys = testMap.keySet();
		myKeys.remove(3);
		assertEquals(false, testMap.containsKey(3));
		assertEquals(2, testMap.size());
		assertEquals(testMap.size(), myKeys.size());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#keySet()} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test removing one key via keySet iterator remove
	 * @hw.precondition a map with elements
	 * @hw.postcondition the size of map and keySet are = 2 and the removed key is not contained in the map
	 * @hw.expectedresults The key has been removed from the map
	 */
	@Test
	public void testKeySet_3() {
		testMap.put(1, "one");
		testMap.put(2, "two");
		testMap.put(3, "three");

		HSet myKeys = testMap.keySet();
		HIterator myIterator = myKeys.iterator();
		myIterator.next();
		myIterator.remove();
		assertEquals(false, testMap.containsKey(3));
		assertEquals(2, testMap.size());
		assertEquals(testMap.size(), myKeys.size());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#keySet()} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test removing key via keySet removeAll
	 * @hw.precondition a map with elements
	 * @hw.postcondition the size of map and keySet are = 1 and the removed keys are not contained in the map
	 * @hw.expectedresults The keys in the collection have been removed from the map
	 */
	@Test
	public void testKeySet_4() {
		testMap.put(1, "one");
		testMap.put(2, "two");
		testMap.put(3, "three");
		helperCollection.add(3);
		helperCollection.add(2);

		HSet myKeys = testMap.keySet();
		myKeys.removeAll(helperCollection);
		assertEquals(false, testMap.containsKey(3));
		assertEquals(false, testMap.containsKey(2));
		assertEquals(1, testMap.size());
		assertEquals(testMap.size(), myKeys.size());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#keySet()} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test removing key via keySet retainAll
	 * @hw.precondition a map with elements
	 * @hw.postcondition the size of map and keySet are = 2 and the not retained key is not contained in the map
	 * @hw.expectedresults Only the keys in the collection have been retained in the map
	 */
	@Test
	public void testKeySet_5() {
		testMap.put(1, "one");
		testMap.put(2, "two");
		testMap.put(3, "three");
		helperCollection.add(3);
		helperCollection.add(2);

		HSet myKeys = testMap.keySet();
		myKeys.retainAll(helperCollection);
		assertEquals(false, testMap.containsKey(1));
		assertEquals(2, testMap.size());
		assertEquals(testMap.size(), myKeys.size());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#keySet()} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test clearing keys via keySet clear
	 * @hw.precondition a map with elements
	 * @hw.postcondition the size of map and keySet are = 0
	 * @hw.expectedresults The map and the keySet have been cleared
	 */
	@Test
	public void testKeySet_6() {
		testMap.put(1, "one");
		testMap.put(2, "two");
		testMap.put(3, "three");

		HSet myKeys = testMap.keySet();
		myKeys.clear();
		assertEquals(0, testMap.size(), myKeys.size());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#keySet()} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test adding via keySet add
	 * @hw.precondition a map
	 * @hw.postcondition UnsupportedOperationException thrown
	 * @hw.expectedresults It's not possible to add keys via the keySet
	 */
	@Test
	public void testKeySet_7() {
		assertThrows(myAdapter.UnsupportedOperationException.class, () -> testMap.keySet().add(1));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#keySet()} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test adding via keySet addAll
	 * @hw.precondition a map
	 * @hw.postcondition UnsupportedOperationException thrown
	 * @hw.expectedresults It's not possible to add collection's keys via the keySet
	 */
	@Test
	public void testKeySet_8() {
		helperCollection.add(new MapAdapter.Entry(1, "one"));

		assertThrows(myAdapter.UnsupportedOperationException.class, () -> testMap.keySet().addAll(helperCollection));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#keySet()} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test for equality two keysets of identical maps
	 * @hw.precondition two maps
	 * @hw.postcondition returned value true
	 * @hw.expectedresults The keySets are equal
	 */
	@Test
	public void testKeySet_9() {
		HMap otherMap = new MapAdapter();
		otherMap.put(1, "one");
		testMap.put(1, "one");

		assertEquals(true, testMap.keySet().equals(otherMap.keySet()));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#keySet()} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test for equality two keysets of different maps
	 * @hw.precondition two maps
	 * @hw.postcondition returned value false
	 * @hw.expectedresults The keySets are different
	 */
	@Test
	public void testKeySet_10() {
		HMap otherMap = new MapAdapter();
		otherMap.put(1, "one");
		testMap.put(2, "two");

		assertEquals(false, testMap.keySet().equals(otherMap.keySet()));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#putAll(HMap)} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test putting elements from a null map
	 * @hw.precondition a map
	 * @hw.postcondition NullPointerException thrown
	 * @hw.expectedresults It's not possible to put other map's elements from a null map
	 */
	@Test
	public void testPutAll_1() {
		assertThrows(NullPointerException.class, () -> testMap.putAll(null));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#putAll(HMap)} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test putting elements from a valid map with different keys
	 * @hw.precondition two maps
	 * @hw.postcondition the keys of the second map are added to the first
	 * @hw.expectedresults The other map's elements have benn added to the map
	 */
	@Test
	public void testPutAll_2() {
		testMap.put(1, "one");
		HMap otherMap = new MapAdapter();
		otherMap.put(2, "two");

		testMap.putAll(otherMap);
		assertEquals(2, testMap.size());
		HMap.Entry[] myArray = { new MapAdapter.Entry(2, "two"), new MapAdapter.Entry(1, "one") };
		assertArrayEquals(myArray, testMap.entrySet().toArray());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#putAll(HMap)} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test putting elements from a valid map with same keys
	 * @hw.precondition a map
	 * @hw.postcondition the values corresponding to the keys present also in the second map will be modified
	 * @hw.expectedresults The values of the entries with same key have been updated
	 */
	@Test
	public void testPutAll_3() {
		testMap.put(1, "one");
		HMap otherMap = new MapAdapter();
		otherMap.put(1, "first");

		testMap.putAll(otherMap);
		assertEquals(1, testMap.size());
		HMap.Entry[] myArray = { new MapAdapter.Entry(1, "first") };
		assertArrayEquals(myArray, testMap.entrySet().toArray());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#remove(Object)} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test removing a null key
	 * @hw.precondition a map
	 * @hw.postcondition NullPointerException thrown
	 * @hw.expectedresults It's not possible to remove a non valid key
	 */
	@Test
	public void testRemove_1() {
		assertThrows(NullPointerException.class, () -> testMap.remove(null));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#remove(Object)} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test removing a valid key that is contained in the map
	 * @hw.precondition a map with elements
	 * @hw.postcondition returned value is the value corresponding to the given key
	 * @hw.expectedresults The key has been removed from the map and the old value has been returned
	 */
	@Test
	public void testRemove_2() {
		testMap.put(1, "one");

		assertEquals("one", testMap.remove(1));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#remove(Object)} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test removing a valid key that is not contained in the map
	 * @hw.precondition a map with elements
	 * @hw.postcondition returned value is null
	 * @hw.expectedresults The key was not contained in the map, so the returned value is null
	 */
	@Test
	public void testRemove_3() {
		testMap.put(1, "one");

		assertEquals(null, testMap.remove(2));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#size()} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test getting the size of an empty map
	 * @hw.precondition an empty map
	 * @hw.postcondition map size = 0
	 * @hw.expectedresults The size of an empty map is 0
	 */
	@Test
	public void testSize_1() {
		assertEquals(0, testMap.size());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#size()} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test getting the size of a non empty map
	 * @hw.precondition a non empty map
	 * @hw.postcondition map size = 2
	 * @hw.expectedresults The size of a map containing two elements is 2
	 */
	@Test
	public void testSize_2() {
		testMap.put(1, "one");
		testMap.put(2, "two");

		assertEquals(2, testMap.size());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#values()} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test checking that the valuesCollection contains the correct values
	 * @hw.precondition a map with elements
	 * @hw.postcondition the values are contained and the sizes of valuesCollection and map are the same
	 * @hw.expectedresults The valuesCollection contains the values added to the map before
	 */
	@Test
	public void testValues_1() {
		testMap.put(1, "one");
		testMap.put(2, "two");
		testMap.put(3, "three");

		HCollection myCollection = testMap.values();
		assertEquals(true, myCollection.contains("one"));
		assertEquals(true, myCollection.contains("two"));
		assertEquals(true, myCollection.contains("three"));
		assertEquals(testMap.size(), myCollection.size());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#values()} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test removing one value via valuesCollection remove
	 * @hw.precondition a map with elements
	 * @hw.postcondition the size of map and valuesCollection are = 2 and the removed value is not contained in the map
	 * @hw.expectedresults The value has been removed from the map
	 */
	@Test
	public void testValues_2() {
		testMap.put(1, "one");
		testMap.put(2, "two");
		testMap.put(3, "three");

		HCollection myCollection = testMap.values();
		myCollection.remove("three");
		assertEquals(false, testMap.containsValue("three"));
		assertEquals(2, testMap.size());
		assertEquals(testMap.size(), myCollection.size());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#values()} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test removing one value via valuesCollection iterator remove
	 * @hw.precondition a map with elements
	 * @hw.postcondition the size of map and valuesCollection are = 2 and the removed value is not contained in the map
	 * @hw.expectedresults The value has been removed from the map
	 */
	@Test
	public void testValues_3() {
		testMap.put(1, "one");
		testMap.put(2, "two");
		testMap.put(3, "three");

		HCollection myCollection = testMap.values();
		HIterator myIterator = myCollection.iterator();
		myIterator.next();
		myIterator.remove();
		assertEquals(false, testMap.containsValue("three"));
		assertEquals(2, testMap.size());
		assertEquals(testMap.size(), myCollection.size());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#values()} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test removing values via valuesCollection removeAll
	 * @hw.precondition a map with elements
	 * @hw.postcondition the size of map and valuesCollection are = 1 and the removed values are not contained in the map
	 * @hw.expectedresults The keys in the collection have been removed from the map
	 */
	@Test
	public void testValues_4() {
		testMap.put(1, "one");
		testMap.put(2, "two");
		testMap.put(3, "three");
		helperCollection.add("three");
		helperCollection.add("two");

		HCollection myValues = testMap.values();
		testMap.values().removeAll(helperCollection);
		assertEquals(false, myValues.containsAll(helperCollection));
		assertEquals(false, testMap.containsValue("three"));
		assertEquals(false, testMap.containsValue("two"));
		assertEquals(1, testMap.size());
		assertEquals(testMap.size(), myValues.size());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#values()} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test removing values via valuesCollection retainAll
	 * @hw.precondition a map with elements
	 * @hw.postcondition the size of map and valuesCollection are = 2 and the not retained value is not contained in the map
	 * @hw.expectedresults Only the keys in the collection have been retained in the map
	 */
	@Test
	public void testValues_5() {
		testMap.put(1, "one");
		testMap.put(2, "two");
		testMap.put(3, "three");
		helperCollection.add("three");
		helperCollection.add("two");

		HCollection myValues = testMap.values();
		myValues.retainAll(helperCollection);
		assertEquals(false, testMap.containsValue("one"));
		assertEquals(2, testMap.size());
		assertEquals(testMap.size(), myValues.size());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#values()} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test clearing values via valuesCollection clear
	 * @hw.precondition a map with elements
	 * @hw.postcondition the size of map and valuesCollection are = 0
	 * @hw.expectedresults The map and the valuesCollection have been cleared
	 */
	@Test
	public void testValues_6() {
		testMap.put(1, "one");
		testMap.put(2, "two");
		testMap.put(3, "three");

		HCollection myValues = testMap.values();
		assertEquals(3, myValues.toArray(new String[0]).length);
		testMap.values().clear();
		assertEquals(true, myValues.isEmpty());
		assertEquals(0, testMap.size());
		assertEquals(testMap.size(), myValues.size());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#values()} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test adding via valuesCollection add
	 * @hw.precondition a map
	 * @hw.postcondition UnsupportedOperationException thrown
	 * @hw.expectedresults It's not possible to add values via the valuesCollection
	 */
	@Test
	public void testValues_7() {
		assertThrows(myAdapter.UnsupportedOperationException.class, () -> testMap.values().add("one"));
		assertEquals(0, testMap.values().toArray(new String[0]).length);
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#values()} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test adding via valuesCollection addAll
	 * @hw.precondition a map
	 * @hw.postcondition UnsupportedOperationException thrown
	 * @hw.expectedresults It's not possible to add collection's values via the valuesCollection
	 */
	@Test
	public void testValues_8() {
		helperCollection.add("one");

		assertThrows(myAdapter.UnsupportedOperationException.class, () -> testMap.values().addAll(helperCollection));
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#values()} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test for equality two valuesCollections of identical maps
	 * @hw.precondition two maps
	 * @hw.postcondition returned value true
	 * @hw.expectedresults The valuesCollections are identical
	 */
	@Test
	public void testValues_9() {
		HMap otherMap = new MapAdapter();
		otherMap.put(1, "one");
		testMap.put(1, "one");

		assertEquals(true, testMap.values().equals(otherMap.values()));
		assertEquals(true, testMap.values().hashCode() == otherMap.values().hashCode());
		assertArrayEquals(testMap.values().toArray(), otherMap.values().toArray());
	}

	/**
	 * <i>Summary:</i> Test {@link myAdapter.MapAdapter#values()} method in MapAdapter
	 * 
	 * @hw.testcasedesign Correctness and possible vulnerability of this method will be tested, checking that the behavior is the one expected.
	 * @hw.testdescription test for equality two valuesCollections of different maps
	 * @hw.precondition two maps
	 * @hw.postcondition returned value false
	 * @hw.expectedresults The valuesCollections are different
	 */
	@Test
	public void testValues_10() {
		HMap otherMap = new MapAdapter();
		otherMap.put(1, "one");
		testMap.put(2, "two");

		assertEquals(false, testMap.values().equals(otherMap.values()));
		assertEquals(false, testMap.values().hashCode() == otherMap.values().hashCode());
	}
}