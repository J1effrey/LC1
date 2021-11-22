// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html


class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iter;
    Integer next;
    boolean isDone;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        this.iter = iterator;
	    if (iter.hasNext()) {
            next = iter.next();
        } else {
            next = null;
            isDone = true;
        }
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer res = next;
        if (iter.hasNext()) {
            next = iter.next();
        } else {
            next = null;
            isDone = true;
        }
        return res;
	}
	
	@Override
	public boolean hasNext() {
	    return !isDone;
	}
}

// next
