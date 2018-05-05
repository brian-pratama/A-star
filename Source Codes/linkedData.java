public abstract class linkedData {
	//*** Graph structure ***

	//Edge
	public class Edge{
		public String name;
		public double h;
		public double g;
		public Edge next;
		
		//Edge constructor to create map
		public Edge(String name, double g){
			this.name = name;
			this.g = g;
		}
		
		//Edge constructor to create route
		public Edge(String name, double h, double g){
			this.name = name;
			this.h = h;
			this.g = g;
		}
	}
	
	//Node
	public class Node{
		public String name;
		public double f = 0;
		public double h;
		public Node next;
		public Edge edge;
		public Edge edge_last;
		
		//Node constructor to create map
		public Node(String name, double h){
			this.name = name;
			this.h = h;
		}
		
		//Node constructor to create route
		public Node(String name){
			this.name = name;
		}
	}
	
	//Graph
	public class Graph{
		public Node first = null;
		public Node last = null;
			
		//Default graph constructor
		public Graph(){}
	}
	
	//--------------------------------------------------------------------------------------------
	
	//Graph method
	//find node based on its name
	public Node findNode(Graph g, String name){
		
		Node seeker = g.first;
		
		while (seeker.name != name && seeker != null){
			seeker = seeker.next;
		}
		if(seeker.name == name){
			return seeker;
		}
		else {
			return null;
		}
		
	}
	
	//add node to the first on graph
	public void addFirst(Graph g, Node node){
	if(g.first == null){
			g.first = node;
			g.last = node;
		}
		else {
			node.next = g.first;
			g.first = node;
		}
		}
	
	//add node to the next of an index on graph
	public void add(Graph g, String idx_name, Node node){
		Node idx = findNode(g, idx_name);
		if (idx != null){
			node.next = idx.next;
			idx.next = node;
		}
	}
	
	//add node to the last on graph
	public void addLast(Graph g, Node node)
	{
		if (g.first == null){
			g.first = node;
			g.last = node;
		}
		else{
			g.last.next = node;
			g.last = node;
			g.last.next = null;
		}
	}

	//find edge of a node based on its name
	public Edge findEdge(Node node, String name){
		if (node.edge == null) {
			return null;
		}
		else{
			Edge seeker = node.edge;
			while (seeker.name != name && seeker != null){
				seeker = seeker.next;
			}
			if (seeker.name == name){
				return seeker;
			}
			else {
				return null;
			}
		}
	}
	
	//check if the node has edge
	public boolean hasEdge(Node node){
		if (node.edge != null) {
			return true;
		}
		else{
			return false;
		}
	}
	
	//check if next edge exist;
	public boolean hasNextEdge(Edge edge){
		if(edge.next != null){
			return true;
		}
		else{
			return false;
		}
	}
		
	//add edge on the first
	public void addFirst(Node node, Edge edge){
		if(node.edge == null){
			node.edge = edge;
			node.edge_last = edge;
		}
		else{
			edge.next = node.edge.next;
			node.edge = edge;
		}
	}
	
	//add edge after the index
	public void add(Node node, String idx_name, Edge edge){
		if(findEdge(node, idx_name) != null){
			edge.next = findEdge(node, idx_name).next;
			findEdge(node, idx_name).next = edge;
		}
	}
	
	//add edge on the last
	public void addLast(Node node, Edge edge){
		if(node.edge == null){
			node.edge = edge;
			node.edge_last = edge;
		}
		else {
			node.edge_last.next = edge;
			node.edge_last = edge;
			node.edge_last.next = null;
		}
	}
	
	//return all map data as String
	public String showMapData(Graph g){
		Node seeker = g.first;
		Edge seeker_edge;
		String data = "";
		if(seeker == null){
			return data;
		}
		else {
			while (seeker != null){
				data = data + seeker.name + " ";
				if (hasEdge(seeker)){
					seeker_edge = seeker.edge;
					while(seeker_edge != null) {
						data = data + seeker_edge.name + " ";
					}
					data = data + "\n";
				}
				seeker = seeker.next;
			}
			
		}
		return data;
	}
	
}
