package nl.niek.minor.aa.binarytrees;

/**
 * Is this class necessary? Seems like this functionality is in the ThreeNode
 * class by just having two keys.
 * 
 * @author Niek
 * 
 */
public class TwoNode extends Node {

	static final int TWO_NODES = 2;

	public TwoNode() {
		super(TWO_NODES);
	}

	@Override
	public void addElement(Integer element) {
		// if !isFull
		// add element at correct position
		// else
		// insert as one of the two keys
	}
}
