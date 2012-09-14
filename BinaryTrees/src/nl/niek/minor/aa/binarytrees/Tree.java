package nl.niek.minor.aa.binarytrees;

import java.util.ArrayList;
import java.util.List;

/**
 * Tree class which contains the root node and keeps track of the tree
 * structure.
 * 
 * @author Niek
 * 
 */
public class Tree
{

	private List<Node>	nodes;
	
	private Node rootNode;

	public Tree()
	{
		nodes = new ArrayList<Node>();
		rootNode = new ThreeNode(0);
		nodes.add(0, rootNode);
	}

	public void addNode(Node newNode)
	{
		nodes.add(newNode);
	}
	
	public void addElement(Integer element)
	{
		search(element).addElement(element);
	}

	public Node search(Integer element)
	{
		return null;
	}
}

