package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS<T> {
	
	private final Node<T> startNode;
	private List<Node<T>> visitedNodes;
	
	
	public BFS(Node<T> startNode) {
		 this.startNode = startNode;
	      visitedNodes = new ArrayList<>();
	}
	
	public Node<T> getStartNode() {
		return startNode;
	}

	public List<Node<T>> getVisitedNodes() {
		return visitedNodes;
	}

	public void setVisitedNodes(List<Node<T>> visitedNodes) {
		this.visitedNodes = visitedNodes;
	}
	
	public void traverse() {

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(startNode);
        System.out.println(startNode);
        while (!queue.isEmpty()) {
        	
            Node<T> current = queue.poll();
            System.out.println(current);
            if (!current.isVisited()) {
            	System.out.println("_________"+current);
                current.setVisited(true);
                visitedNodes.add(current);
                queue.addAll(current.getAdjacentNodes().keySet());
            }
        }
    }

	
}
