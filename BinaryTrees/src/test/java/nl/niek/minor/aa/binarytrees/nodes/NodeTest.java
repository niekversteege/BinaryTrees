package nl.niek.minor.aa.binarytrees.nodes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NodeTest
{
	Node	defaultNode;

	@Before
	public void setUp() throws Exception
	{

	}

	@Test
	public void testIsFull()
	{
		defaultNode = new Node();
		defaultNode.addKey(5);
		defaultNode.addKey(7);

		assertTrue(defaultNode.isFull());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testZeroKey()
	{
		defaultNode = new Node();
		defaultNode.addKey(0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDoubleKey()
	{
		defaultNode = new Node();
		defaultNode.addKey(5);
		defaultNode.addKey(5);
	}

	@Test
	public void testGetBigKey()
	{
		defaultNode = new Node();
		defaultNode.addKey(5);
		defaultNode.addKey(7);

		assertEquals(7, defaultNode.getBigKey().intValue());
	}

	@Test
	public void testGetSmallKey()
	{
		defaultNode = new Node();
		defaultNode.addKey(5);
		defaultNode.addKey(7);

		assertEquals(5, defaultNode.getSmallKey().intValue());
	}

	@Test
	public void testParentlessSplitNullCheck()
	{
		defaultNode = new Node();
		defaultNode.addKey(5);
		defaultNode.addKey(7);
		defaultNode.addKey(9);

		assertNotNull(defaultNode.getParent());
	}

	@Test
	public void testParentLessSplit()
	{
		defaultNode = new Node();
		defaultNode.addKey(5);
		defaultNode.addKey(7);
		defaultNode.addKey(9);

		assertEquals(7, defaultNode.getParent().getLargestKey().intValue());
		List<Node> children = defaultNode.getParent().getChildren();
		assertEquals(5, children.get(0).getLargestKey().intValue());
		assertEquals(9, children.get(1).getLargestKey().intValue());
	}
	
	@Test
	public void testGetChild()
	{
		defaultNode = new Node();
		defaultNode.addKey(5);
		defaultNode.addKey(10);
		
		Node child1 = new Node();
		child1.setParent(defaultNode);
		child1.addKey(1);
		defaultNode.addChild(child1);
		
		Node child2 = new Node();
		child2.setParent(defaultNode);
		child2.addKey(7);
		defaultNode.addChild(child2);
		
		Node child3 = new Node();
		child3.setParent(defaultNode);
		child3.addKey(12);
		defaultNode.addChild(child3);
		
		Node testNode = defaultNode.getChild(2);
		assertNotNull(testNode);
		assertEquals(1, testNode.getLargestKey().intValue());
		
		testNode = defaultNode.getChild(6);
		assertNotNull(testNode);
		assertEquals(7, testNode.getLargestKey().intValue());
		
		testNode = defaultNode.getChild(20);
		assertNotNull(testNode);
		assertEquals(12, testNode.getLargestKey().intValue());
	}
}
