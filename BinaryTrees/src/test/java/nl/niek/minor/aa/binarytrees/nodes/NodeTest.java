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

		Assert.assertEquals(7, defaultNode.getParent().getSmallKey().intValue());
		List<Node> children = defaultNode.getParent().getChildren();
		Assert.assertEquals(5, children.get(0).getSmallKey().intValue());
		Assert.assertEquals(9, children.get(1).getSmallKey().intValue());
	}
	
	@Test
	public void testGetChild()
	{
		fail("Not yet implemented");
	}
}
