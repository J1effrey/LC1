// T: O(1)
// S: O(1)

class PeekingIterator implements Iterator<Integer> {
    private int temp = 0;
    private boolean flag = false;
    private Iterator<Integer> iterator;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    this.iterator = iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (flag) {
            return temp;
        }
        
        flag = true;
        temp = iterator.next();
        
        return temp;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if (flag) {
            flag = false;
            return temp;
        }
        return this.iterator.next();
	}
	
	@Override
	public boolean hasNext() {
	    if (flag) {
            return true;
        }
        return this.iterator.hasNext();
	}
}


===============

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
