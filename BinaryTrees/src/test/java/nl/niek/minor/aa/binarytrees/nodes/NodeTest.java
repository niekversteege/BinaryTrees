package nl.niek.minor.aa.binarytrees.nodes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NodeTest
{
	Node defaultNode;

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

	@Test
	public void testGetBigKey()
	{
		defaultNode = new Node();
		defaultNode.addKey(5);
		defaultNode.addKey(7);
		defaultNode.addKey(10);
		
		Assert.assertEquals(5, defaultNode.getSmallKey());
		Assert.assertEquals(7, defaultNode.getBigKey());
	}
}
