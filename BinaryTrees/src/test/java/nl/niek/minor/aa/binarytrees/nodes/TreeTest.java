package nl.niek.minor.aa.binarytrees.nodes;

import static org.junit.Assert.*;

import nl.niek.minor.aa.binarytrees.Tree;

import org.junit.Before;
import org.junit.Test;

public class TreeTest
{
	Tree	tree;

	Node	rootNode;

	@Before
	public void setUp() throws Exception
	{
		rootNode = new Node();
		rootNode.addKey(5);

		/* Layer 1 */
		Node child1 = new Node();
		child1.setParent(rootNode);
		child1.addKey(3);
		rootNode.addChild(child1);

		Node child2 = new Node();
		child2.setParent(rootNode);
		child2.addKey(8);
		rootNode.addChild(child2);

		/* Level 2 for child1 */
		Node child3 = new Node();
		child3.setParent(child1);
		child3.addKey(2);
		child1.addChild(child3);

		Node child4 = new Node();
		child4.setParent(child1);
		child4.addKey(4);
		child1.addChild(child4);

		/* Level 2 for child2 */
		Node child5 = new Node();
		child5.setParent(child2);
		child5.addKey(7);
		child2.addChild(child5);

		Node child6 = new Node();
		child6.setParent(child2);
		child6.addKey(9);
		child2.addChild(child6);
		
		tree = new Tree(rootNode);
	}

	@Test
	public void testSearchRight()
	{
		Node result = tree.search(10);
		assertEquals(9, result.getLargestKey().intValue());
	}
	
	@Test
	public void testSearchLeft()
	{
		Node result = tree.search(1);
		assertEquals(2, result.getLargestKey().intValue());
	}
	
	@Test
	public void testSearchMiddle()
	{
		Node result = tree.search(6);
		assertEquals(7, result.getLargestKey().intValue());
	}
	
	
}
