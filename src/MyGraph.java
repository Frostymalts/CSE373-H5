import java.util.*;

/**
 * A representation of a graph. Assumes that we do not have negative cost edges
 * in the graph.
 */
public class MyGraph implements Graph {
	private HashMap<Vertex, ArrayList<Vertex>> adj;
	private List<Edge> edges;

	/**
	 * Creates a MyGraph object with the given collection of vertices and the
	 * given collection of edges.
	 * 
	 * @param v
	 *            a collection of the vertices in this graph
	 * @param e
	 *            a collection of the edges in this graph
	 */
	public MyGraph(Collection<Vertex> v, Collection<Edge> e) {
		if (v == null || e == null || v.size() == 0 || e.size() == 0)
			throw new IllegalArgumentException();
		for(Vertex vertex: v) {
			if (!adj.containsKey(vertex))
				adj.put(vertex, null);
		}
		for (Edge edge: e) {
			if (!adj.containsKey(edge.getSource()) ||
					!adj.containsKey(edge.getDestination()))
				throw new IllegalArgumentException();
			if (edge.getWeight() < 0)
				throw new IllegalArgumentException();
			for (Edge checkEdge: edges) {
				if (edge.getSource().equals(checkEdge.getSource()) && 
						edge.getDestination().equals(checkEdge.getDestination()) &&
						edge.getWeight() != checkEdge.getWeight()) {
					throw new IllegalArgumentException();
				}
			}
			if (!edges.contains(edge)) {
				edges.add(edge);
				adj.get(edge.getSource()).add(edge.getDestination());
			}
		}
	}

	/**
	 * Return the collection of vertices of this graph
	 * 
	 * @return the vertices as a collection (which is anything iterable)
	 */
	@Override
	public Collection<Vertex> vertices() {
		return adj.keySet();
	}

	/**
	 * Return the collection of edges of this graph
	 * 
	 * @return the edges as a collection (which is anything iterable)
	 */
	@Override
	public Collection<Edge> edges() {
		return edges;
	}

	/**
	 * Return a collection of vertices adjacent to a given vertex v. i.e., the
	 * set of all vertices w where edges v -> w exist in the graph. Return an
	 * empty collection if there are no adjacent vertices.
	 * 
	 * @param v
	 *            one of the vertices in the graph
	 * @return an iterable collection of vertices adjacent to v in the graph
	 * @throws IllegalArgumentException
	 *             if v does not exist.
	 */
	@Override
	public Collection<Vertex> adjacentVertices(Vertex v) {
		return adj.get(v);
	}

	/**
	 * Test whether vertex b is adjacent to vertex a (i.e. a -> b) in a directed
	 * graph. Assumes that we do not have negative cost edges in the graph.
	 * 
	 * @param a
	 *            one vertex
	 * @param b
	 *            another vertex
	 * @return cost of edge if there is a directed edge from a to b in the
	 *         graph, return -1 otherwise.
	 * @throws IllegalArgumentException
	 *             if a or b do not exist.
	 */
	@Override
	public int edgeCost(Vertex a, Vertex b) {
		if (!adj.containsKey(a))
			return -1;
		if (!adj.get(a).contains(b))
			return -1;
		return 1;
	}

	/**
	 * Returns the shortest path from a to b in the graph, or null if there is
	 * no such path. Assumes all edge weights are nonnegative. Uses Dijkstra's
	 * algorithm.
	 * 
	 * @param a
	 *            the starting vertex
	 * @param b
	 *            the destination vertex
	 * @return a Path where the vertices indicate the path from a to b in order
	 *         and contains a (first) and b (last) and the cost is the cost of
	 *         the path. Returns null if b is not reachable from a.
	 * @throws IllegalArgumentException
	 *             if a or b does not exist.
	 */
//	public Path shortestPath(Vertex a, Vertex b) {
//
//		// YOUR CODE HERE (you might comment this out this method while doing
//		// Part 1)
//
//	}

}
