import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;


public class TestGraph {
	private static MyGraph g;
	
	public static void main(String[] args) {
		g = readGraph(args[0],args[1]);
		testVertices();
		testEdges(args[1]);
		testShortestPath();
	}
	
	public static MyGraph readGraph(String f1, String f2) {
		Scanner s = null;
		try {
			s = new Scanner(new File(f1));
		} catch(FileNotFoundException e1) {
			System.err.println("FILE NOT FOUND: "+f1);
			System.exit(2);
		}

		Collection<Vertex> v = new ArrayList<Vertex>();
		while(s.hasNext())
			v.add(new Vertex(s.next()));

		try {
			s = new Scanner(new File(f2));
		} catch(FileNotFoundException e1) {
			System.err.println("FILE NOT FOUND: "+f2);
			System.exit(2);
		}

		Collection<Edge> e = new ArrayList<Edge>();
		while(s.hasNext()) {
			try {
				Vertex a = new Vertex(s.next());
				Vertex b = new Vertex(s.next());
				int w = s.nextInt();
				e.add(new Edge(a,b,w));
			} catch (NoSuchElementException e2) {
				System.err.println("EDGE FILE FORMAT INCORRECT");
				System.exit(3);
			}
		}

		return new MyGraph(v,e);
	}

	private static void testShortestPath() {
		System.out.println("*****************TESTING SHORTEST PATH*****************");
		Vertex sea = new Vertex("SEA");
		Vertex mkc = new Vertex("MKC");
		Vertex lax = new Vertex("LAX");
		Vertex ind = new Vertex("IND");
		Vertex atl = new Vertex("ATL");
		Vertex den = new Vertex("DEN");
		Path seaToMkc = g.shortestPath(sea, mkc);
		Path laxToInd = g.shortestPath(lax, ind);
		Path atlToDen = g.shortestPath(atl, den);
		
		if (seaToMkc.cost == 391) {
			System.out.println("SEA to MKC cost test passed!");
		} else {
			System.out.println("SEA to MKC cost test passed!");
		}
		if (laxToInd.cost == 581) {
			System.out.println("SEA to MKC cost test passed!");
		} else {
			System.out.println("SEA to MKC cost test failed!");
		}
		if (atlToDen.cost == 370) {
			System.out.println("SEA to MKC cost test passed!");
		} else {
			System.out.println("SEA to MKC cost test failed!");
		}
	}

	private static void testEdges(String f2) {
		System.out.println("*****************TESTING EDGES*****************");
		Scanner s = null;
		try {
			s = new Scanner(new File(f2));
		} catch(FileNotFoundException e1) {
			System.err.println("FILE NOT FOUND: "+f2);
			System.exit(2);
		}
		Collection<Edge> e = new ArrayList<Edge>();
		while(s.hasNext()) {
			try {
				Vertex a = new Vertex(s.next());
				Vertex b = new Vertex(s.next());
				int w = s.nextInt();
				e.add(new Edge(a,b,w));
			} catch (NoSuchElementException e2) {
				System.err.println("EDGE FILE FORMAT INCORRECT");
				System.exit(3);
			}
		}
		if (e.equals(g.edges())) {
			System.out.println("Edges test passed!");
		} else {
			System.out.println("Edges test failed!");
		}
	}

	private static void testVertices() {
		System.out.println("*****************TESTING VERTICES*****************");
		String[] arr = {"ATL", "ORD", "DEN", "IAH", "IAD", "MKC", 
				"LAX", "JFK", "SFO", "SEA", "IND"};
		Set<Vertex> set = new HashSet<Vertex>();
		for (String s: arr) {
			Vertex v = new Vertex(s);
			set.add(v);
		}
		if (set.equals(g.vertices())) {
			System.out.println("Vertices test passed!");
		} else {
			System.out.println("Vertices test failed!");
		}
	}

}
