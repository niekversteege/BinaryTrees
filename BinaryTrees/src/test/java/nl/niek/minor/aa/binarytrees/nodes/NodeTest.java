package nl.niek.minor.aa.binarytrees.nodes;

import static org.junit.Assert.fail;

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

		Assert.assertTrue(defaultNode.isFull());
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

		Assert.assertEquals(7, defaultNode.getBigKey().intValue());
	}

	@Test
	public void testGetSmallKey()
	{
		defaultNode = new Node();
		defaultNode.addKey(5);
		defaultNode.addKey(7);

		Assert.assertEquals(5, defaultNode.getSmallKey().intValue());
	}

	@Test
	public void testParentlessSplitNullCheck()
	{
		defaultNode = new Node();
		defaultNode.addKey(5);
		defaultNode.addKey(7);
		defaultNode.addKey(9);

		Assert.assertNotNull(defaultNode.getParent());
	}

	@Test
	public void testParentLessSplit()
	{
		defaultNode = new Node();
		defaultNode.addKey(5);
		defaultNode.addKey(7);
		defaultNode.addKey(9);

		Assert.assertEquals(7, defaultNode.getParent().getLargestKey().intValue());
		List<Node> children = defaultNode.getParent().getChildren();
		Assert.assertEquals(5, children.get(0).getLargestKey().intValue());
		Assert.assertEquals(9, children.get(1).getLargestKey().intValue());
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
		Assert.assertNotNull(testNode);
		Assert.assertEquals(1, testNode.getLargestKey().intValue());
		
		testNode = defaultNode.getChild(6);
		Assert.assertNotNull(testNode);
		Assert.assertEquals(7, testNode.getLargestKey().intValue());
		
		testNode = defaultNode.getChild(20);
		Assert.assertNotNull(testNode);
		Assert.assertEquals(12, testNode.getLargestKey().intValue());
	}
}
