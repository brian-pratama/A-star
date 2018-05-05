
public class searchingMethod extends linkedData{
	
	private linkedData.Graph m;
	private String data;
	private double optimum_cost = 0;
	private double total_cost = 0;
	
	//get data value
	public String getData() {
		return this.data;
	}
	
	//searchingMethod constructor
	public searchingMethod(linkedData.Graph m){
		this.m = m;
	}
	
	//----------------------------------------------------------------------------
	
	//get total cost
	public double getTotalCost() {
		return this.total_cost;
	}
	
	//get optimum cost
	public double getOptimumCost() {
		if ( this.optimum_cost <= this.total_cost ) {
			return this.optimum_cost;
		}
		else {
			return 9999;
		}
	}
	
	//calculate total cost of a node
	public double calcTotalCost(Node node) {
		
		double total_cost;
		Edge edge;
		
		total_cost = 0;
		
		if ( hasEdge(node) ) {
			
			edge = node.edge;
			
			while ( edge != null ) {
				total_cost = total_cost + edge.g;
				
				edge = edge.next;
			}
		}
		
		return total_cost;
	}
	
	//update value of f of a node
	public void updateF(Node node){
		
		Edge edge;
		
		node.f = 0;
		
		if ( hasEdge(node) ) {
			
			edge = node.edge;
			
			while ( edge.next != null ) {
				node.f = node.f + edge.g;
				edge = edge.next;
			}
			node.f = node.f + edge.g + edge.h;
			
		}
	}
	
	//find node with minimum f on a graph
	public Node findNode(Graph g, double f) {
		
		if (g.first == null) {
			return null;
		}
		else {
			Node minNode = g.first;
			Node node = g.first;
			while (node != null) {
				if ( minNode.f > node.f ) {
					minNode = node;
				}
			}
			return minNode;
		}
	}
	
	//find a node with minimum f value
	public Node findMinFNode(Graph g) {
		Node minNode = g.first;
		Node seeker = g.first;
		
		while ( seeker != null ) {
			if ( seeker.f < minNode.f ) {
				minNode = seeker;
			}
			seeker = seeker.next;
		}
		
		return minNode;
	}
	
	public String printData(linkedData.Graph g, int step){
		
		data = "Step " + step + "\n\n";
		linkedData.Node node = g.first;
		linkedData.Edge edge;
		
		while (node != null){
			data = data + "(f=" + node.f + ") " + node.name + " ";
			if ( super.hasEdge(node) ) {
				edge = node.edge;
				while(edge.next != null){
					data = data + "-> " + edge.name + "(g=" + edge.g + ") ";
					edge = edge.next;
				}
				data = data + "-> " + edge.name + "(g=" + edge.g + ")" + "(h=" + edge.h + ")";
			}
			
			
			data = data + "\n\n";
			node = node.next;
		}
		
		return data;
	}
	
	public String printSolution(Node node) {
		Edge edge;
		
		data = "Solusi" + "\n";
		
		data = data + "(f=" + node.f + ") " + node.name + " ";
		if ( super.hasEdge(node) ) {
			edge = node.edge;
			while(edge.next != null){
				data = data + "-> " + edge.name + "(g=" + edge.g + ") ";
				edge = edge.next;
			}
			data = data + "-> " + edge.name + "(g=" + edge.g + ")" + "(h=" + edge.h + ")";
		}
		
		data = data + "\n\n";
		
		return data;
	}
	
	//------------------------------------------------------------------------------------------------
	
	public void A_star(){
		
		data = "ROUTE \n\n";
		
		int step;
		
		Graph r = new Graph();
		
		Node nodeM;
		Node nodeR;
		
		Edge edgeM;
		Edge edgeR;
		
		nodeR = null;
		nodeM = null;
		step = 1;
		
		if (step == 1) {
			nodeM = findNode(m, "Bobbia");
			nodeR = new Node(nodeM.name);
			addLast(r, nodeR);
			updateF(r.first);
			
			if ( nodeM.edge != null ) {
				edgeM = nodeM.edge;
				edgeR = new Edge( edgeM.name, findNode(m, edgeM.name).h, edgeM.g );
				addLast(r.first, edgeR);
				edgeM = edgeM.next;
				updateF(r.first);
				
				while (edgeM != null) {
					nodeR = new Node(nodeM.name);
					edgeR = new Edge(edgeM.name, findNode(m, edgeM.name).h, edgeM.g);
					addLast(nodeR, edgeR);
					updateF(nodeR);
					addLast(r, nodeR);
					
					edgeM = edgeM.next;
				}
			}
			
			nodeR = findMinFNode(r);
			nodeM = findNode( m, nodeR.edge_last.name );
			
			data = data + printData(r, step) + "Minimum F = " + nodeR.f + "\n\n";
			
			step++;
		}
		
		if (step > 1) {
			
			Node tempNodeR;
			Node newNodeR = null;
			Edge tempEdgeR;
			Edge newEdge;
			
			while (findMinFNode(r).edge_last.name != "Ravenna") {
				
				tempNodeR = new Node(nodeR.name);
				edgeM = nodeM.edge;
				edgeR = new Edge( edgeM.name, findNode(m, edgeM.name).h, edgeM.g );
				addLast( nodeR, edgeR );
				updateF (nodeR);
				
				edgeM = edgeM.next;
				
				while (edgeM != null) {
					
					newNodeR = new Node(tempNodeR.name);
					edgeR = nodeR.edge;
					
					while (edgeR.next != null) {
						tempEdgeR = new Edge(edgeR.name, findNode(m, edgeR.name).h, edgeR.g);
						addLast(newNodeR, tempEdgeR);
						
						edgeR = edgeR.next;
					}
					
					newEdge = new Edge( edgeM.name, findNode(m, edgeM.name).h, edgeM.g );
					addLast(newNodeR, newEdge);
					updateF(newNodeR);
					addLast(r, newNodeR);
					
					edgeM = edgeM.next;
					
				}
				
				nodeR = findMinFNode(r);
				nodeM = findNode( m, nodeR.edge_last.name );
				
				data = data + printData(r, step) + "Minimum F = " + nodeR.f + "\n\n";
				
				step = step + 1;
				
			}
		}
		
		this.total_cost = calcTotalCost( findMinFNode(r) );
		this.optimum_cost = findMinFNode(r).f;
		
		data = data + printSolution(findMinFNode(r));
		data = data + "\n";
	}
}
