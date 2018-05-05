
public class createMap extends linkedData{
	
	private mapInfo myMapInfo;
	
	//createMap constructor
	public createMap(mapInfo myMapInfo){
		this.myMapInfo = myMapInfo;
	}
	
	//create romanian river map and return it as a graph
	public linkedData.Graph riverMap(){
		
		Graph g = new Graph();
		linkedData.Node node;
		linkedData.Edge edge;
		
		//*** add nodes to graph g ***
		node = new Node("Ravenna", myMapInfo.getHRavenna());
		super.addLast(g, node);
		
		node = new Node("Rimini", myMapInfo.getHRimini());
		super.addLast(g, node);
		
		node = new linkedData.Node("Ferrara", myMapInfo.getHFerrara());
		super.addLast(g, node);
		
		node = new linkedData.Node("Forli", myMapInfo.getHForli());
		super.addLast(g, node);
		
		node = new linkedData.Node("Cesena", myMapInfo.getHCesena());
		super.addLast(g, node);
		
		node = new linkedData.Node("Faenza", myMapInfo.getHFaenza());
		super.addLast(g, node);
		
		node = new linkedData.Node("Imola", myMapInfo.getHImola());
		super.addLast(g, node);
		
		node = new linkedData.Node("Emilia", myMapInfo.getHEmilia());
		super.addLast(g, node);
		
		node = new linkedData.Node("Terme", myMapInfo.getHTerme());
		super.addLast(g, node);
		
		node = new linkedData.Node("Carpi", myMapInfo.getHCarpi());
		super.addLast(g, node);
		
		node = new linkedData.Node("Piacenza", myMapInfo.getHPiacenza());
		super.addLast(g, node);
		
		node = new linkedData.Node("Bobbia", myMapInfo.getHBobbia());
		super.addLast(g, node);
		
		
		//*** add the edges to added nodes ***
		//add an edge to node Rimini
		node = super.findNode(g, "Rimini");
		
		edge = new Edge("Ravenna", myMapInfo.getGRiminiToRavenna());
		super.addLast(node, edge);
		
		//add edges to node Ferrara
		node = super.findNode(g, "Ferrara");
		
		edge = new Edge("Imola", myMapInfo.getGFerraraToImola());
		super.addLast(node, edge);
		
		edge = new Edge("Ravenna", myMapInfo.getGFerraraToRavenna());
		super.addLast(node, edge);
		
		//add edges to node Forli
		node = super.findNode(g, "Forli");
		
		edge = new Edge("Cesena", myMapInfo.getGForliToCesena());
		super.addLast(node, edge);
		
		edge = new Edge("Ravenna", myMapInfo.getGForliToRavenna());
		super.addLast(node, edge);
		
		//add an edge to node Cesena
		node = super.findNode(g, "Cesena");
		
		edge = new Edge("Rimini", myMapInfo.getGCesenaToRimini());
		super.addLast(node, edge);
		
		//add edges to node Faenza
		node = super.findNode(g, "Faenza");
		
		edge = new Edge("Forli", myMapInfo.getGFaenzaToForli());
		super.addLast(node, edge);
		
		edge = new Edge("Cesena", myMapInfo.getGFaenzaToCesena());
		super.addLast(node, edge);
		
		//add edges to node Imola
		node = super.findNode(g, "Imola");
		
		edge = new Edge("Faenza", myMapInfo.getGImolaToFaenza());
		super.addLast(node, edge);
		
		edge = new Edge("Forli", myMapInfo.getGImolaToForli());
		super.addLast(node, edge);
		
		//add an edge to node Emilia
		node = super.findNode(g, "Emilia");
		
		edge = new Edge("Imola", myMapInfo.getGEmiliaToImola());
		super.addLast(node, edge);
		
		//add edges to node Terme
		node = super.findNode(g, "Terme");
		
		edge = new Edge("Emilia", myMapInfo.getGTermeToEmilia());
		super.addLast(node, edge);
		
		edge = new Edge("Faenza", myMapInfo.getGTermeToFaenza());
		super.addLast(node, edge);
		
		//add edges to node Carpi
		node = super.findNode(g, "Carpi");
		
		edge = new Edge("Emilia", myMapInfo.getGCarpiToEmilia());
		super.addLast(node, edge);
		
		edge = new Edge("Ferrara", myMapInfo.getGCarpiToFerrara());
		super.addLast(node, edge);
		
		//add edges to node Piacenza
		node = super.findNode(g, "Piacenza");
		
		edge = new Edge("Carpi", myMapInfo.getGPiacenzaToCarpi());
		super.addLast(node, edge);
		
		edge = new Edge("Terme", myMapInfo.getGPiacenzaToTerme());
		super.addLast(node, edge);
		
		//add edges to node Bobbia
		node = super.findNode(g, "Bobbia");
		
		edge = new Edge("Piacenza", myMapInfo.getGBobbiaToPiacenza());
		super.addLast(node, edge);
		
		edge = new Edge("Terme", myMapInfo.getGBobbiaToTerme());
		super.addLast(node, edge);
		
		edge = new Edge("Cesena", myMapInfo.getGBobbiaToCesena());
		super.addLast(node, edge);
		
		return g;
	}
	
	public String printData(linkedData.Graph g){
		
		String data = "MAP\n\n";
		linkedData.Node node = g.first;
		linkedData.Edge edge;
		
		while (node != null){
			data = data + node.name + "(h=" + node.h + ") ";
			if ( super.hasEdge(node) ) {
				edge = node.edge;
				while(edge != null){
					data = data + "-> " + edge.name + "(g=" + edge.g + ") ";
					edge = edge.next;
				}
			}
			
			
			data = data + "\n\n";
			node = node.next;
		}
		
		data = data + "\n";
		
		return data;
	}
}
