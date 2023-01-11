package myAdapter;

import java.util.Vector;

public class ListAdapter implements HList, HCollection {

	private Vector myVector = new Vector();

	//Inserts the specified element at the specified position in this list (optional operation).
	public void add(int index, Object element) throws IndexOutOfBoundsException, NullPointerException {
		//NullPointerException - if the specified element is null and this list does not support null elements.
		if (element == null)
			throw new NullPointerException();

		//IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size()).
		if (index < 0 || index > size())
			throw new IndexOutOfBoundsException();

		myVector.insertElementAt(element, index);
	}

	//Appends the specified element to the end of this list (optional operation).
	public boolean add(Object o) throws NullPointerException {
		//NullPointerException - if the specified element is null and this list does not support null elements.
		if (o == null)
			throw new NullPointerException();

		myVector.addElement(o);
		return true;
	}

	//Appends all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection's iterator (optional operation).
	public boolean addAll(HCollection c) throws NullPointerException {
		//NullPointerException - if the specified collection is null
		if (c == null)
			throw new NullPointerException();

		boolean flag = false;
		HIterator myIterator = c.iterator();
		while (myIterator.hasNext()) {
			flag = flag | add(myIterator.next());
		}
		return flag;
	}

	//Inserts all of the elements in the specified collection into this list at the specified position (optional operation).
	public boolean addAll(int index, HCollection c) throws NullPointerException, IndexOutOfBoundsException {
		//NullPointerException - if the specified collection is null
		if (c == null)
			throw new NullPointerException();

		//IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())
		if (index < 0 || index > size())
			throw new IndexOutOfBoundsException();

		boolean flag = false;
		HIterator myIterator = c.iterator();
		while (myIterator.hasNext()) {
			add(index++, myIterator.next());
			flag = true;
		}
		return flag;
	}

	//Removes all of the elements from this list (optional operation).
	public void clear() {
		myVector.removeAllElements();
	}

	//Returns true if this list contains the specified element.
	public boolean contains(Object o) throws NullPointerException {
		//NullPointerException - if the specified element is null and this list does not support null elements (optional).
		if (o == null)
			throw new NullPointerException();

		return myVector.contains(o);
	}

	//Returns true if this list contains all of the elements of the specified collection.
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

	//Compares the specified object with this list for equality.
	public boolean equals(Object o) {
		if (!(o instanceof HList))
			return false;

		if (o instanceof SubList) {
			SubList otherList = (SubList) o;
			return (size() == otherList.size() && otherList.containsAll(this));
		} else {
			ListAdapter otherList = (ListAdapter) o;
			return myVector.equals(otherList.myVector);
		}
	}

	//Returns the element at the specified position in this list.
	public Object get(int index) throws IndexOutOfBoundsException {
		//IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size()).
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException();

		return myVector.elementAt(index);
	}

	//Returns the hash code value for this list.
	public int hashCode() {
		int hashCode = 1;
		HIterator myIterator = iterator();
		while (myIterator.hasNext()) {
			Object obj = myIterator.next();
			hashCode = 31 * hashCode + (obj == null ? 0 : obj.hashCode());
		}
		return hashCode;
	}

	//Returns the index in this list of the first occurrence of the specified element, or -1 if this list does not contain this element.
	public int indexOf(Object o) throws NullPointerException {
		//NullPointerException - if the specified element is null and this list does not support null elements (optional).
		if (o == null)
			throw new NullPointerException();

		return myVector.indexOf(o);
	}

	//Returns true if this list contains no elements.
	public boolean isEmpty() {
		return myVector.isEmpty();
	}

	//Returns an iterator over the elements in this list in proper sequence.
	public HIterator iterator() {
		return listIterator();
	}

	//Returns the index in this list of the last occurrence of the specified element, or -1 if this list does not contain this element.
	public int lastIndexOf(Object o) throws NullPointerException {
		//NullPointerException - if the specified element is null and this list does not support null elements (optional).
		if (o == null)
			throw new NullPointerException();

		return myVector.lastIndexOf(o);
	}

	//Returns a list iterator of the elements in this list (in proper sequence).
	public HListIterator listIterator() {
		return listIterator(0);
	}

	//Returns a list iterator of the elements in this list (in proper sequence), starting at the specified position in this list.
	public HListIterator listIterator(int index) throws IndexOutOfBoundsException {
		//IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size()).
		if (index < 0 || index > size())
			throw new IndexOutOfBoundsException();

		return new ListAdapterListIterator(this, index);
	}

	//Removes the element at the specified position in this list (optional operation).
	public Object remove(int index) throws IndexOutOfBoundsException {
		//IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException();

		Object removed = get(index);
		myVector.removeElementAt(index);
		return removed;
	}

	//Removes the first occurrence in this list of the specified element (optional operation).
	public boolean remove(Object o) throws NullPointerException {
		//NullPointerException - if the specified element is null and this list does not support null elements (optional).
		if (o == null)
			throw new NullPointerException();

		return myVector.removeElement(o);
	}

	//Removes from this list all the elements that are contained in the specified collection (optional operation).
	public boolean removeAll(HCollection c) throws NullPointerException {
		//NullPointerException - if the specified collection is null
		if (c == null)
			throw new NullPointerException();

		boolean flag = false;
		HIterator myIterator = c.iterator();
		while (myIterator.hasNext())
			flag = flag | remove(myIterator.next());
		return flag;
	}

	//Retains only the elements in this list that are contained in the specified collection (optional operation).
	public boolean retainAll(HCollection c) throws NullPointerException {
		//NullPointerException - if the specified collection is null
		if (c == null)
			throw new NullPointerException();

		boolean flag = false;
		HIterator myIterator = iterator();
		while (myIterator.hasNext())
			if (!c.contains(myIterator.next())) {
				myIterator.remove();
				flag = true;
			}
		return flag;
	}

	//Replaces the element at the specified position in this list with the specified element (optional operation).
	public Object set(int index, Object element) throws IndexOutOfBoundsException, NullPointerException {
		//IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException();

		//NullPointerException - if the specified element is null and this list does not support null elements (optional).
		if (element == null)
			throw new NullPointerException();

		Object replaced = myVector.elementAt(index);
		myVector.setElementAt(element, index);
		return replaced;
	}

	//Returns the number of elements in this list.
	public int size() {
		return myVector.size();
	}

	//Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive.
	public HList subList(int fromIndex, int toIndex) throws IndexOutOfBoundsException {
		//IndexOutOfBoundsException - for an illegal endpoint index value (fromIndex < 0 || toIndex > size || fromIndex > toIndex).
		if (fromIndex < 0 || toIndex > size() || fromIndex > toIndex)
			throw new IndexOutOfBoundsException();

		return new SubList(this, fromIndex, toIndex);
	}

	//Returns an array containing all of the elements in this list in proper sequence.
	public Object[] toArray() {
		Object[] myArray = new Object[size()];
		HIterator myIterator = iterator();
		for (int i = 0; myIterator.hasNext(); i++)
			myArray[i] = myIterator.next();
		return myArray;
	}

	//Returns an array containing all of the elements in this list in proper sequence; the runtime type of the returned array is that of the specified array.
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

	private class SubList implements HList {

		private HList parentList = null;
		private int fromIndex;
		private int toIndex;

		public SubList(HList p, int f, int t) throws IndexOutOfBoundsException {
			//IndexOutOfBoundsException - for an illegal endpoint index value (fromIndex < 0 || toIndex > size || fromIndex > toIndex)
			if (f < 0 || t > p.size() || f > t)
				throw new IndexOutOfBoundsException();

			parentList = p;
			fromIndex = f;
			toIndex = t;
		}

		//Inserts the specified element at the specified position in this list (optional operation).
		public void add(int index, Object element) throws IndexOutOfBoundsException {
			//IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())
			if (index < 0 || index > size())
				throw new IndexOutOfBoundsException();

			parentList.add(fromIndex + index, element);
			toIndex++;
		}

		//Appends the specified element to the end of this list (optional operation).
		public boolean add(Object o) throws NullPointerException {
			//NullPointerException - if the specified element is null and this list does not support null elements.
			if (o == null)
				throw new NullPointerException();

			parentList.add(toIndex, o);
			toIndex++;
			return true;
		}

		//Appends all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection's iterator (optional operation).
		public boolean addAll(HCollection c) throws NullPointerException {
			//NullPointerException - if the specified collection is null
			if (c == null)
				throw new NullPointerException();

			boolean flag = false;
			HIterator myIterator = c.iterator();
			while (myIterator.hasNext())
				flag = flag | this.add(myIterator.next());
			return flag;
		}

		//Inserts all of the elements in the specified collection into this list at the specified position (optional operation).
		public boolean addAll(int index, HCollection c) throws NullPointerException, IndexOutOfBoundsException {
			//NullPointerException - if the specified collection is null
			if (c == null)
				throw new NullPointerException();

			//IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())
			if (index < 0 || index > size())
				throw new IndexOutOfBoundsException();

			boolean flag = false;
			HIterator myIterator = c.iterator();
			while (myIterator.hasNext()) {
				this.add(index++, myIterator.next());
				flag = true;
			}
			return flag;
		}

		//Removes all of the elements from this list (optional operation).
		public void clear() {
			HIterator myIterator = iterator();
			while (myIterator.hasNext()) {
				myIterator.next();
				myIterator.remove();
			}
		}

		//Returns true if this list contains the specified element.
		public boolean contains(Object o) {
			//NullPointerException - if the specified element is null and this list does not support null elements (optional).
			if (o == null)
				throw new NullPointerException();

			boolean flag = false;
			for (int i = fromIndex; i < toIndex; i++)
				flag = flag | (o.equals(parentList.get(i)));
			return flag;
		}

		//Returns true if this list contains all of the elements of the specified collection.
		public boolean containsAll(HCollection c) throws NullPointerException {
			//NullPointerException - if the specified collection is null
			if (c == null)
				throw new NullPointerException();

			HIterator myIterator = c.iterator();
			while (myIterator.hasNext())
				if (!this.contains(myIterator.next()))
					return false;
			return true;
		}

		//Compares the specified object with this list for equality.
		public boolean equals(Object o) {
			if (!(o instanceof HList))
				return false;

			HList otherList = (HList) o;
			boolean flag = true;
			HIterator myIterator = iterator();
			for (int i = 0; myIterator.hasNext() && i < size(); i++) {
				if (!(myIterator.next().equals(otherList.get(i))))
					flag = false;
			}
			return flag;
		}

		//Returns the element at the specified position in this list.
		public Object get(int index) throws IndexOutOfBoundsException {
			//IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
			if (index < 0 || index >= this.size())
				throw new IndexOutOfBoundsException();

			return parentList.get(fromIndex + index);
		}

		//Returns the hash code value for this list.
		public int hashCode() {
			int hashCode = 1, i = 0;
			HIterator myIterator = iterator();
			while (myIterator.hasNext() && i < size()) {
				Object obj = myIterator.next();
				hashCode = 31 * hashCode + (obj == null ? 0 : obj.hashCode());
				i++;
			}
			return hashCode;
		}

		//Returns the index in this list of the first occurrence of the specified element, or -1 if this list does not contain this element.
		public int indexOf(Object o) {
			//NullPointerException - if the specified element is null and this list does not support null elements (optional).
			if (o == null)
				throw new NullPointerException();

			for (int i = fromIndex; i < toIndex; i++)
				if (o.equals(parentList.get(i)))
					return i - fromIndex;
			return -1;
		}

		//Returns true if this list contains no elements.
		public boolean isEmpty() {
			return (fromIndex == toIndex);
		}

		//Returns an iterator over the elements in this list in proper sequence.
		public HIterator iterator() {
			return listIterator();
		}

		//Returns the index in this list of the last occurrence of the specified element, or -1 if this list does not contain this element.
		public int lastIndexOf(Object o) {
			//NullPointerException - if the specified element is null and this list does not support null elements (optional).
			if (o == null)
				throw new NullPointerException();

			for (int i = toIndex - 1; i >= fromIndex; i--)
				if (o.equals(parentList.get(i)))
					return i - fromIndex;
			return -1;
		}

		//Returns a list iterator of the elements in this list (in proper sequence).
		public HListIterator listIterator() {
			return listIterator(0);
		}

		//Returns a list iterator of the elements in this list (in proper sequence), starting at the specified position in this list.
		public HListIterator listIterator(int index) throws IndexOutOfBoundsException {
			//IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())
			if (index < 0 || index > size())
				throw new IndexOutOfBoundsException();

			return new ListAdapterListIterator(this, index);
		}

		//Removes the element at the specified position in this list (optional operation).
		public Object remove(int index) throws IndexOutOfBoundsException {
			//IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
			if (index < 0 || index >= size())
				throw new IndexOutOfBoundsException();

			Object removed = this.get(index);
			parentList.remove(fromIndex + index);
			toIndex--;
			return removed;
		}

		//Removes the first occurrence in this list of the specified element (optional operation).
		public boolean remove(Object o) {
			int index = this.indexOf(o);
			if (index == -1)
				return false;

			parentList.remove(fromIndex + index);
			toIndex--;
			return true;
		}

		//Removes from this list all the elements that are contained in the specified collection (optional operation).
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

		//Retains only the elements in this list that are contained in the specified collection (optional operation).
		public boolean retainAll(HCollection c) throws NullPointerException {
			//NullPointerException - if the specified collection is null
			if (c == null)
				throw new NullPointerException();

			int maxPos = size();
			boolean flag = false;
			HIterator myIterator = iterator();
			for (int i = 0; i < maxPos; i++)
				if (!c.contains(myIterator.next())) {
					myIterator.remove();
					flag = true;
				}
			return flag;
		}

		//Replaces the element at the specified position in this list with the specified element (optional operation).
		public Object set(int index, Object element) throws IndexOutOfBoundsException {
			//IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
			if (index < 0 || index >= size())
				throw new IndexOutOfBoundsException();

			return parentList.set(fromIndex + index, element);
		}

		//Returns the number of elements in this list.
		public int size() {
			return toIndex - fromIndex;
		}

		//Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive.
		public HList subList(int fromIndex, int toIndex) throws IndexOutOfBoundsException {
			//IndexOutOfBoundsException - if (fromIndex < 0 || toIndex > size || fromIndex > toIndex)
			if (fromIndex < 0 || toIndex > size() || fromIndex > toIndex)
				throw new IndexOutOfBoundsException();

			return new SubList(this, fromIndex, toIndex);
		}

		//Returns an array containing all of the elements in this list in proper sequence.
		public Object[] toArray() {
			int maxPos = size();
			Object[] myArray = new Object[size()];
			for (int i = 0; i < maxPos; i++)
				myArray[i] = this.get(i);
			return myArray;
		}

		//Returns an array containing all of the elements in this list in proper sequence; the runtime type of the returned array is that of the specified array.
		public Object[] toArray(Object[] a) throws NullPointerException, ArrayStoreException {
			//NullPointerException - if the specified array is null.
			if (a == null)
				throw new NullPointerException();

			if (size() > a.length)
				a = (Object[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size());

			int maxPos = size();
			for (int i = 0; i < maxPos; i++) {
				Object tmp = this.get(i);
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
	}

	private class ListAdapterListIterator implements HListIterator, HIterator {

		private HList parentList = null;
		private int index;
		private boolean nextCalled = false;
		private boolean previousCalled = false;

		public ListAdapterListIterator(HList p, int i) throws IndexOutOfBoundsException {
			if (i < 0 || i > p.size())
				throw new IndexOutOfBoundsException();
			parentList = p;
			index = i;
		}

		//Inserts the specified element into the list (optional operation).
		public void add(Object o) {
			nextCalled = false;
			previousCalled = false;
			parentList.add(index++, o);
		}

		//Returns true if this list iterator has more elements when traversing the list in the forward direction.
		public boolean hasNext() {
			return (index < parentList.size());
		}

		//Returns true if this list iterator has more elements when traversing the list in the reverse direction.
		public boolean hasPrevious() {
			return (index > 0);
		}

		//Returns the next element in the list.
		public Object next() throws java.util.NoSuchElementException {
			//NoSuchElementException - if the iteration has no next element.
			if (!hasNext())
				throw new java.util.NoSuchElementException();

			nextCalled = true;
			previousCalled = false;
			return parentList.get(index++);
		}

		//Returns the index of the element that would be returned by a subsequent call to next.
		public int nextIndex() {
			return index;
		}

		//Returns the previous element in the list.
		public Object previous() throws java.util.NoSuchElementException {
			//NoSuchElementException - if the iteration has no next element.
			if (!hasPrevious())
				throw new java.util.NoSuchElementException();

			nextCalled = false;
			previousCalled = true;
			return parentList.get(--index);
		}

		//Returns the index of the element that would be returned by a subsequent call to previous.
		public int previousIndex() {
			return index - 1;
		}

		//Removes from the list the last element that was returned by next or previous (optional operation).
		public void remove() throws IllegalStateException {
			if (previousCalled) {
				previousCalled = false;
				parentList.remove(index);
			} else {
				//RuntimeException - neither next nor previous have been called, or remove or add have been called after the last call to * next or previous.
				if (!nextCalled)
					throw new IllegalStateException();
				nextCalled = false;
				parentList.remove(--index);
			}
		}

		//Replaces the last element returned by next or previous with the specified element (optional operation).
		public void set(Object o) throws IllegalStateException {
			if (nextCalled) {
				nextCalled = false;
				parentList.set(index - 1, o);
			} else {
				//RuntimeException - if neither next nor previous have been called, or remove or add have been called after the last call to next or previous.
				if (!previousCalled)
					throw new IllegalStateException();
				previousCalled = false;
				parentList.set(index, o);
			}
		}
	}
}
