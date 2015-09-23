import java.util.AbstractList;

public class MyArrayList<AnyType> extends AbstractList<AnyType> {

    /**
     * @author Julia Pyke
     * @date 9/15/15 I have adhered to the Honor Code in this assignment.
     */

    private int length;
    private int size = 0;
    private AnyType[] data;

    @SuppressWarnings("unchecked")

    MyArrayList(int startSize) {
	length = 2;
	while (length < startSize) {
	    length *= 2;
	}
	data = (AnyType[]) new Object[length];

    }

    MyArrayList() { // call other constructor with startSize=2
	this(2);
    }

    public AnyType get(int index) {
	if (index < 0 || index >= size) {// index must be >=0 and <size()
	    throw new IndexOutOfBoundsException("Index out of bounds! Size is "
		    + size + ". Capacity is " + length
		    + ". You tried to access index " + index + ".");
	}
	return data[index];// return element at index
    }

    public int size() { // return size count
	return size;
    }

    public void add(int index, AnyType element) {
	AnyType temp = null;
	if (index < 0 || index > size)
	    // index must be >= 0 and <= size()
	    throw new IndexOutOfBoundsException("Index out of bounds! Size is "
		    + size + ". Capacity is " + data.length
		    + ". You tried to add at index " + index + ".");
	if (size == data.length)
	    // if adding an element to the end of an array that is at capacity,
	    // resize
	    resize();
	if (index < size) {
	    for (int i = size - 1; i >= index; i--) {
		temp = data[i];
		data[i + 1] = temp;
		// push all values one toward the end of arraylist
	    }
	}
	data[index] = element;
	size++;// increment size for added element
    }

    public boolean add(AnyType element) {
	add(size, element);
	// call other add method with size() to add to end of array
	return true;// elements was in fact added
    }

    @SuppressWarnings("unchecked")
    private void resize() {
	AnyType[] resize = (AnyType[]) new Object[data.length * 2];
	// make new array with double length as data
	for (int i = 0; i < length; i++) {
	    resize[i] = data[i];
	    // copy all elements of data into new array
	}
	this.data = resize;
	this.length = data.length;
	// set data to new array
    }

    public AnyType set(int index, AnyType element) {
	AnyType previous = data[index];
	// store original value to return later
	if (index < 0 || index >= size)
	    throw new IndexOutOfBoundsException("Index out of bounds! Size is "
		    + size + ". Capacity is " + length
		    + ". You tried to add at index " + index + ".");
	data[index] = element;// set value
	return previous;
    }

    public AnyType remove(int index) {
	AnyType removed = data[index];
	// store original value to return later
	if (index < 0 || index >= size)
	    throw new IndexOutOfBoundsException("Index out of bounds! Size is "
		    + size() + ". Capacity is " + length
		    + ". You tried to add at index " + index + ".");
	if (index < size()) {
	    int i = index;
	    data[index] = null;
	    while (i < size() - 1) {
		data[i] = data[i + 1];
		data[i + 1] = null;
		i++;
		// push all values one toward front of array
	    }
	}
	size--;// decrement size for removed element
	return removed;
    }

    public boolean isEmpty() {
	for (AnyType a : data) {
	    if (a != null)
		return false;
	}
	return true;
    }

    public void clear() {
	for (int i = 0; i < length; i++)
	    data[i] = null;
	size = 0;
	// set all values to null, size is now 0
    }
}
