package nl.niek.minor.aa.binarytrees;

import java.util.ArrayList;
import java.util.List;

public abstract class Node {

	private static final int MAX_NODES = 3;

	private List<Integer> keys;

	private final int nrOfNodes;

	public Node(int nrOfNodes) {

		if (nrOfNodes > MAX_NODES) {
			throw new IllegalArgumentException(
					"Nodes can only have 3 elemements.");
		}

		keys = new ArrayList<Integer>();
		this.nrOfNodes = nrOfNodes;
	}

	protected boolean isFull() {
		return keys.size() >= nrOfNodes;
	}

	
	protected Node getUpperNode(){
		return null;
	}

	protected void addElementAtCorrectPosition(Integer element) {

		if (!isFull()) {
			for (int i = 0; i < keys.size(); i++) {
				if (element < i) {
					keys.add(i, element);
				}
			}
		} else {
			throw new IndexOutOfBoundsException(
					"Cannot add a new elmenent to a full Node.");
		}
	}

	public abstract void addElement(Integer element);
}