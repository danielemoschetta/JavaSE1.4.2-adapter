package myAdapter;

import java.util.Hashtable;
import java.util.Enumeration;

public class MapAdapter implements HMap {

	private Hashtable myHashtable = new Hashtable();

	//Removes all mappings from this map (optional operation).
	public void clear() {
		myHashtable.clear();
	}

	//Returns true if this map contains a mapping for the specified key.
	public boolean containsKey(Object key) throws NullPointerException {
		//NullPointerException - if the key is null and this map does not not permit null keys (optional).
		if (key == null)
			throw new NullPointerException();

		return myHashtable.containsKey(key);
	}

	//Returns true if this map maps one or more keys to the specified value.
	public boolean containsValue(Object value) throws NullPointerException {
		//NullPointerException - if the key is null and this map does not not permit null keys (optional).
		if (value == null)
			throw new NullPointerException();

		Enumeration valuesEnum = myHashtable.elements();
		while (valuesEnum.hasMoreElements())
			if (valuesEnum.nextElement().equals(value))
				return true;
		return false;
	}

	//Returns a set view of the mappings contained in this map.
	public HSet entrySet() {
		return new EntrySet(this);
	}

	//Compares the specified object with this map for equality.
	public boolean equals(Object o) {
		if (!(o instanceof HMap))
			return false;

		HMap otherMap = (HMap) o;
		return entrySet().equals(otherMap.entrySet());
	}

	//Returns the value to which this map maps the specified key.
	public Object get(Object key) throws NullPointerException {
		//NullPointerException - if the key is null and this map does not not permit null keys (optional).
		if (key == null)
			throw new NullPointerException();

		return myHashtable.get(key);
	}

	//Returns the hash code value for this map.
	public int hashCode() {
		int hashcode = 0;
		HIterator myIterator = entrySet().iterator();
		while (myIterator.hasNext())
			hashcode += myIterator.next().hashCode();
		return hashcode;
	}

	//Returns true if this map contains no key-value mappings.
	public boolean isEmpty() {
		return myHashtable.isEmpty();
	}

	//Returns a set view of the keys contained in this map.
	public HSet keySet() {
		return new KeySet(this);
	}

	//Associates the specified value with the specified key in this map (optional operation).
	public Object put(Object key, Object value) {
		return myHashtable.put(key, value);
	}

	//Copies all of the mappings from the specified map to this map (optional operation).
	public void putAll(HMap t) throws NullPointerException {
		//NullPointerException - if the specified map is null
		if (t == null)
			throw new NullPointerException();

		HIterator myIterator = t.keySet().iterator();
		while (myIterator.hasNext()) {
			Object key = myIterator.next();
			myHashtable.put(key, t.get(key));
		}
	}

	//Removes the mapping for this key from this map if it is present (optional operation).
	public Object remove(Object key) throws NullPointerException {
		//NullPointerException - if the key is null and this map does not not permit null keys (optional).
		if (key == null)
			throw new NullPointerException();

		return myHashtable.remove(key);
	}

	//Returns the number of key-value mappings in this map.   
	public int size() {
		return myHashtable.size();
	}

	//Returns a collection view of the values contained in this map.
	public HCollection values() {
		return new ValuesCollection(this);
	}

	public static class Entry implements HMap.Entry {

		private Object key;
		private Object value;

		public Entry(Object o, Object v) {
			key = o;
			value = v;
		}

		//Compares the specified object with this entry for equality.
		public boolean equals(Object o) {
			if (!(o instanceof HMap.Entry))
				return false;

			Entry other = (Entry) o;
			return (getKey() == null ? other.getKey() == null : getKey().equals(other.getKey()))
					&& (getValue() == null ? other.getValue() == null : getValue().equals(other.getValue()));
		}

		//Returns the key corresponding to this entry.
		public Object getKey() {
			return key;
		}

		//Returns the value corresponding to this entry.
		public Object getValue() {
			return value;
		}

		//Returns the hash code value for this map entry.		
		public int hashCode() {
			return (getKey() == null ? 0 : getKey().hashCode()) ^ (getValue() == null ? 0 : getValue().hashCode());
		}

		// Replaces the value corresponding to this entry with the specified value (optional operation).
		public Object setValue(Object o) throws NullPointerException {
			//NullPointerException - the backing map does not permit null values, and the specified value is null.
			if (o == null)
				throw new NullPointerException();

			Object oldValue = value;
			value = o;
			return oldValue;
		}
	}

	private class ValuesCollection implements HCollection {

		protected HMap parentMap = null; //protected -> accessible to keySet and entrySet that extends this class

		public ValuesCollection(HMap m) {
			parentMap = m;
		}

		//Adds the specified element to this set if it is not already present (optional operation).
		public boolean add(Object o) throws myAdapter.UnsupportedOperationException {
			//UnsupportedOperationException - if the add method is not supported by this set.
			throw new myAdapter.UnsupportedOperationException();
		}

		//Adds all of the elements in the specified collection to this set if they're not already present (optional operation).
		public boolean addAll(HCollection c) throws myAdapter.UnsupportedOperationException {
			//UnsupportedOperationException - if the addAll method is not supported by this set.
			throw new myAdapter.UnsupportedOperationException();
		}

		//Removes all of the elements from this set (optional operation).
		public void clear() {
			parentMap.clear();
		}

		//Returns true if this set contains the specified element.
		public boolean contains(Object o) {
			return parentMap.containsValue(o);
		}

		//Returns true if this set contains all of the elements of the specified collection.
		public boolean containsAll(HCollection c) throws NullPointerException {
			//NullPointerException - if the specified collection is null
			if (c == null)
				throw new NullPointerException();

			HIterator myIterator = c.iterator();
			while (myIterator.hasNext())
				if (!contains(myIterator.next()))
					return false;
			return true;
		}

		//Compares the specified object with this set for equality.
		public boolean equals(Object o) {
			if (!(o instanceof ValuesCollection))
				return false;

			ValuesCollection other = (ValuesCollection) o;
			if (this.size() != other.size())
				return false;

			HIterator myIterator = iterator(), otherIterator = other.iterator();
			while (myIterator.hasNext() && otherIterator.hasNext())
				if (!myIterator.next().equals(otherIterator.next()))
					return false;
			return true;
		}

		//Returns the hash code value for this set.
		public int hashCode() {
			int hashCode = 0;
			HIterator myIterator = iterator();
			while (myIterator.hasNext())
				hashCode += myIterator.next().hashCode();
			return hashCode;
		}

		//Returns true if this set contains no elements.
		public boolean isEmpty() {
			return parentMap.isEmpty();
		}

		//Returns an iterator over the elements in this set.
		public HIterator iterator() {
			return new ValuesCollectionIterator();
		}

		//Removes the specified element from this set if it is present (optional operation).
		public boolean remove(Object o) throws NullPointerException {
			//NullPointerException - if the specified element is null and this collection does not support null elements (optional).
			if (o == null)
				throw new NullPointerException();

			HIterator myIterator = parentMap.keySet().iterator();
			while (myIterator.hasNext()) {
				Object tmpKey = myIterator.next();
				if ((parentMap.get(tmpKey)).equals(o))
					if (parentMap.remove(tmpKey) != null)
						return true;
			}
			return false;
		}

		//Removes from this set all of its elements that are contained in the specified collection (optional operation).
		public boolean removeAll(HCollection c) throws NullPointerException {
			//NullPointerException - if the specified collection is null
			if (c == null)
				throw new NullPointerException();

			boolean flag = false;
			HIterator myIterator = c.iterator();
			while (myIterator.hasNext())
				flag = flag | this.remove(myIterator.next());
			return flag;
		}

		//Retains only the elements in this set that are contained in the specified collection (optional operation).
		public boolean retainAll(HCollection c) throws NullPointerException {
			//NullPointerException - if the specified collection is null
			if (c == null)
				throw new NullPointerException();

			boolean flag = false;
			HIterator myIterator = iterator();
			while (myIterator.hasNext()) {
				if (!c.contains(myIterator.next())) {
					myIterator.remove();
					flag = true;
				}
			}
			return flag;
		}

		//Returns the number of elements in this set (its cardinality).
		public int size() {
			return parentMap.size();
		}

		//Returns an array containing all of the elements in this set.
		public Object[] toArray() {
			Object[] myArray = new Object[size()];
			HIterator myIterator = iterator();
			for (int i = 0; myIterator.hasNext(); i++)
				myArray[i] = myIterator.next();
			return myArray;
		}

		//Returns an array containing all of the elements in this set; the runtime type of the returned array is that of the specified array.
		public Object[] toArray(Object[] a) throws NullPointerException, ArrayStoreException {
			//NullPointerException - if the specified array is null.
			if (a == null)
				throw new NullPointerException();

			if (size() > a.length)
				a = (Object[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size());

			HIterator myIterator = iterator();
			for (int i = 0; myIterator.hasNext(); i++) {
				Object tmp = myIterator.next();
				//ArrayStoreException - the runtime type of the specified array is not a supertype of the runtime type of every element in this collection.
				if (a[i] != null)
					if (!(a[i].getClass().isInstance(tmp)))
						throw new ArrayStoreException();

				a[i] = tmp;
			}
			if (size() < a.length)
				a[size()] = null;
			return a;
		}

		protected class ValuesCollectionIterator implements HIterator {

			protected int index;
			protected boolean nextCalled = false;

			public ValuesCollectionIterator() {
				index = 0;
			}

			//Returns true if the iteration has more elements.
			public boolean hasNext() {
				return (index < myHashtable.size());
			}

			//Returns the next element in the iteration.
			public Object next() throws java.util.NoSuchElementException {
				////NoSuchElementException - if the iteration has no next element.
				if (!hasNext())
					throw new java.util.NoSuchElementException();

				nextCalled = true;
				Enumeration valuesEnum = myHashtable.elements();
				for (int i = 0; valuesEnum.hasMoreElements() && i < index; i++)
					valuesEnum.nextElement();
				index++;
				return valuesEnum.nextElement();
			}

			//Removes from the underlying collection the last element returned by the iterator (optional operation).
			public void remove() throws IllegalStateException {
				//IllegalStateException - if the next method has not yet been called, or the remove method has already been called after the last call to the next method.
				if (!nextCalled)
					throw new IllegalStateException();

				nextCalled = false;
				index--;
				Enumeration keysEnum = myHashtable.keys();
				for (int i = 0; keysEnum.hasMoreElements() && i < index; i++)
					keysEnum.nextElement();

				Object keyToRemove = keysEnum.nextElement();
				myHashtable.remove(keyToRemove);
			}
		}
	}

	private class KeySet extends ValuesCollection implements HSet {

		public KeySet(HMap m) {
			super(m);
		}

		//Returns true if this set contains the specified element.
		public boolean contains(Object o) {
			return parentMap.containsKey(o);
		}

		//Compares the specified object with this set for equality.
		public boolean equals(Object o) {
			if (!(o instanceof KeySet))
				return false;

			KeySet other = (KeySet) o;
			if (this.size() != other.size())
				return false;

			HIterator myIterator = iterator();
			while (myIterator.hasNext())
				if (!(other.contains(myIterator.next())))
					return false;
			return true;
		}

		//Returns an iterator over the elements in this set.
		public HIterator iterator() {
			return new KeySetIterator();
		}

		//Removes the specified element from this set if it is present (optional operation).
		public boolean remove(Object o) {
			return (parentMap.remove(o) != null);
		}

		private class KeySetIterator extends ValuesCollectionIterator implements HIterator {

			//Returns the next element in the iteration.
			public Object next() throws java.util.NoSuchElementException {
				////NoSuchElementException - if the iteration has no next element.
				if (!hasNext())
					throw new java.util.NoSuchElementException();

				nextCalled = true;
				Enumeration keysEnum = myHashtable.keys();
				for (int i = 0; keysEnum.hasMoreElements() && i < index; i++)
					keysEnum.nextElement();
				index++;
				return keysEnum.nextElement();
			}
		}
	}

	private class EntrySet extends ValuesCollection implements HSet {

		public EntrySet(HMap m) {
			super(m);
		}

		//Returns true if this set contains the specified element.
		public boolean contains(Object o) throws ClassCastException {
			//ClassCastException - if the type of the specified element is incompatible with this set (optional).
			if (!(o instanceof HMap.Entry))
				throw new ClassCastException();

			HMap.Entry myEntry = (HMap.Entry) o;
			Object key = myEntry.getKey(), value = myEntry.getValue();
			return (parentMap.get(key) != null && parentMap.get(key).equals(value));
		}

		//Compares the specified object with this set for equality.
		public boolean equals(Object o) {
			if (!(o instanceof EntrySet))
				return false;

			EntrySet other = (EntrySet) o;
			if (this.size() != other.size())
				return false;

			HIterator myIterator = iterator();
			while (myIterator.hasNext())
				if (!(other.contains(myIterator.next())))
					return false;
			return true;
		}

		//Returns an iterator over the elements in this set.
		public HIterator iterator() {
			return new EntrySetIterator();
		}

		//Removes the specified element from this set if it is present (optional operation).
		public boolean remove(Object o) throws ClassCastException {
			//ClassCastException - if the type of the specified element is incompatible with this set (optional).
			if (!(o instanceof HMap.Entry))
				throw new ClassCastException();

			HMap.Entry myEntry = (HMap.Entry) o;
			return (parentMap.remove(myEntry.getKey()) != null);
		}

		private class EntrySetIterator extends ValuesCollectionIterator implements HIterator {

			//Returns the next element in the iteration.
			public Object next() throws java.util.NoSuchElementException {
				////NoSuchElementException - if the iteration has no next element.
				if (!hasNext())
					throw new java.util.NoSuchElementException();

				nextCalled = true;
				Enumeration keysEnum = myHashtable.keys();
				for (int i = 0; keysEnum.hasMoreElements() && i < index; i++) {
					keysEnum.nextElement();
				}
				index++;

				Object rightKey = keysEnum.nextElement();
				return new Entry(rightKey, myHashtable.get(rightKey));
			}
		}
	}
}