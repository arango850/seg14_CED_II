package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.BFS;
import model.Graph;
import model.Node;

public class Main {

	private static Scanner scanner;
	private static Main main;
	private static Graph graph;
	
	public Main() {
		scanner = new Scanner(System.in);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setMain(new Main());
		Main.menu();
	}

	private static void setMain(Main main) {
		// TODO Auto-generated method stub
		
	}

	private static void menu() {
		// TODO Auto-generated method stub
		System.out.println("Digita el total de nodos\n");
		String totalNodos = scanner.nextLine();
		int totalNodosI = Integer.parseInt(totalNodos);
		
		graph = new Graph<>(totalNodosI);
		
		System.out.println("Digite los nodos separelos usando un ;");
		String nodes = scanner.nextLine();
		
		String[] nodeValues = nodes.split(";");
		
		List<Node<String>> nodeList = new ArrayList<>();
		
		for (String s: nodeValues) {
			Node<String> newNode= new Node<>(s);
			System.out.println(newNode.getData());
			nodeList.add(newNode);
		}
		
		
		System.out.println("\n(Adjacency List format: Destino;Distancia Destino;Distancia...)");
        System.out.println("En caso de no haber distancia, digite '-')");
		
		for (Node<String> node : nodeList) {
            System.out.print("\nLista para el nodo " + node.getData() + ": ");
            String line = scanner.nextLine();
            String[] array = line.split(" ");
            for(String s: array) {
            	String[] subLine = s.split(";");
            	if(!s.isEmpty()) {
            		String data = subLine[0];
            		double distance = Double.parseDouble(subLine[1]);
                	Node<String> destino= graph.getNodeFromList(nodeList, data);
                	node.addDestination(destino, distance);
            	}
            }
        }
        graph.getNodes().addAll(nodeList);
     
        System.out.println("Hacer el BFS\n"+
        "(1) Sí\n"+
        "(2) No");
        String option = scanner.nextLine();
        int optionn = Integer.parseInt(option);
        switch(optionn) {
        case 1:
         bfs(totalNodosI);
        break;
        case 0:
         System.exit(0);	
        break;
        }
        
	}

	
	public static void bfs(int total) {
		// TODO Auto-generated method stub
		graph.resetNodes();

        System.out.print("\nSource Node: ");
        String data = scanner.nextLine();

//        Node<String> sourceNode = graph.getSpecificNode(graph.getNodes(), data);
        Node<String> sourceNode = graph.getSpecificNode(data);

        if (sourceNode != null){

            BFS<String> bfs = new BFS<>(sourceNode);
            bfs.traverse();

            System.out.println("\nNode List: ");

            for (Node<String> node : bfs.getVisitedNodes()) {

                System.out.println("-" + node);
            }
            
            if(bfs.getVisitedNodes().size()==total){
            	System.out.println("Es fuertemente conexo");
            }else {
            	System.out.println("No es fuertemente conexo");
            }

        } else {

            System.out.println("--Node " + data + " doesn't exist");
        }	
		
	}

}
