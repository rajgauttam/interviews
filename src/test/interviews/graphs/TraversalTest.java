package interviews.graphs;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class.
 * @author Francois Rousseau
 */
public class TraversalTest {

  public static Traversal setUpDirected() {
    return new Traversal(DigraphTest.setUp());
  }

  public static Traversal setUpUndirected() {
    return new Traversal(GraphTest.setUp());
  }

  @Test
  public void test_bfs_directed() {
    Traversal trav = setUpDirected();
    trav.bfs(0);
    Assert.assertEquals(-1, trav.parent(0));
    Assert.assertEquals(0,  trav.parent(1));
    Assert.assertEquals(4,  trav.parent(2));
    Assert.assertEquals(4,  trav.parent(3));
    Assert.assertEquals(5,  trav.parent(4));
    Assert.assertEquals(0,  trav.parent(5));
    Assert.assertEquals(-1, trav.parent(6));
    Assert.assertEquals(-1, trav.parent(7));
    Assert.assertEquals(-1, trav.parent(8));
    Assert.assertEquals(-1, trav.parent(9));
    Assert.assertEquals(-1, trav.parent(10));
    Assert.assertEquals(-1, trav.parent(11));
    Assert.assertEquals(-1, trav.parent(12));
    Assert.assertEquals("[3, 4, 5, 0]", trav.pathTo(3).toString());
  }

  @Test
  public void test_bfs_undirected() {
    Traversal trav = setUpUndirected();
    trav.bfs(0);
    Assert.assertEquals(-1, trav.parent(0));
    Assert.assertEquals(0,  trav.parent(1));
    Assert.assertEquals(0,  trav.parent(2));
    Assert.assertEquals(5,  trav.parent(3));
    Assert.assertEquals(6,  trav.parent(4));
    Assert.assertEquals(0,  trav.parent(5));
    Assert.assertEquals(0,  trav.parent(6));
    Assert.assertEquals(-1, trav.parent(7));
    Assert.assertEquals(-1, trav.parent(8));
    Assert.assertEquals(-1, trav.parent(9));
    Assert.assertEquals(-1, trav.parent(10));
    Assert.assertEquals(-1, trav.parent(11));
    Assert.assertEquals(-1, trav.parent(12));
    Assert.assertEquals("[3, 5, 0]", trav.pathTo(3).toString());
    Assert.assertEquals("[4, 6, 0]", trav.pathTo(4).toString());
  }

  @Test
  public void test_dfs_directed() {
    Traversal trav = setUpDirected();
    trav.dfs(0);
    Assert.assertEquals(-1, trav.parent(0));
    Assert.assertEquals(0,  trav.parent(1));
    Assert.assertEquals(4,  trav.parent(2));
    Assert.assertEquals(2,  trav.parent(3));
    Assert.assertEquals(5,  trav.parent(4));
    Assert.assertEquals(0,  trav.parent(5));
    Assert.assertEquals(-1, trav.parent(6));
    Assert.assertEquals(-1, trav.parent(7));
    Assert.assertEquals(-1, trav.parent(8));
    Assert.assertEquals(-1, trav.parent(9));
    Assert.assertEquals(-1, trav.parent(10));
    Assert.assertEquals(-1, trav.parent(11));
    Assert.assertEquals(-1, trav.parent(12));
    Assert.assertEquals("[3, 2, 4, 5, 0]", trav.pathTo(3).toString());
  }

  @Test
  public void test_dfs_undirected() {
    Traversal trav = setUpUndirected();
    trav.dfs(0);
    Assert.assertEquals(-1, trav.parent(0));
    Assert.assertEquals(0,  trav.parent(1));
    Assert.assertEquals(0,  trav.parent(2));
    Assert.assertEquals(5,  trav.parent(3));
    Assert.assertEquals(3,  trav.parent(4));
    Assert.assertEquals(0,  trav.parent(5));
    Assert.assertEquals(4,  trav.parent(6));
    Assert.assertEquals(-1, trav.parent(7));
    Assert.assertEquals(-1, trav.parent(8));
    Assert.assertEquals(-1, trav.parent(9));
    Assert.assertEquals(-1, trav.parent(10));
    Assert.assertEquals(-1, trav.parent(11));
    Assert.assertEquals(-1, trav.parent(12));
    Assert.assertEquals("[3, 5, 0]", trav.pathTo(3).toString());
    Assert.assertEquals("[4, 3, 5, 0]", trav.pathTo(4).toString());
    Assert.assertEquals("[6, 4, 3, 5, 0]", trav.pathTo(6).toString());
  }

  @Test
  public void test_topological() {
    Traversal trav = setUpDirected();
    Assert.assertEquals("[7, 6, 8, 9, 11, 10, 12, 0, 5, 4, 2, 3, 1]", trav.topological().toString());
  }
}