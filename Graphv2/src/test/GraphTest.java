package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.BFS;
import model.Graph;
import model.Node;

class GraphTest {

	Graph graph = new Graph<>(6);
	
	@Test
	void test() {
		Node<String > nodeA = new Node<>("A");
        Node<String> nodeB = new Node<>("B");
        Node<String> nodeC = new Node<>("C");
        Node<String> nodeD = new Node<>("D");
        Node<String> nodeE = new Node<>("E");
        Node<String> nodeF = new Node<>("F");

        nodeA.addDestination(nodeB, 6);
        nodeA.addDestination(nodeC, 90);
        nodeA.addDestination(nodeF, 70);

        nodeB.addDestination(nodeD, 41);

        nodeC.addDestination(nodeB, 12);
        nodeC.addDestination(nodeF, 10);

        nodeD.addDestination(nodeC, 12);

        nodeE.addDestination(nodeA, 2);
        nodeE.addDestination(nodeB, 22);
        nodeE.addDestination(nodeC, 60);
        nodeE.addDestination(nodeD, 50);

        nodeF.addDestination(nodeE, 15);

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);
        
        assertEquals("A",nodeA.getData());
        assertEquals("B",nodeB.getData());
        assertEquals("C",nodeC.getData());
        assertEquals("D",nodeD.getData());
        assertEquals("E",nodeE.getData());
        
       
	}
	@Test
	void bfsTest() {
		Node<String > nodeA = new Node<>("A");
        Node<String> nodeB = new Node<>("B");
        Node<String> nodeC = new Node<>("C");
        Node<String> nodeD = new Node<>("D");
        Node<String> nodeE = new Node<>("E");
        Node<String> nodeF = new Node<>("F");

        nodeA.addDestination(nodeB, 6);
        nodeA.addDestination(nodeC, 90);
        nodeA.addDestination(nodeF, 70);

        nodeB.addDestination(nodeD, 41);

        nodeC.addDestination(nodeB, 12);
        nodeC.addDestination(nodeF, 10);

        nodeD.addDestination(nodeC, 12);

        nodeE.addDestination(nodeA, 2);
        nodeE.addDestination(nodeB, 22);
        nodeE.addDestination(nodeC, 60);
        nodeE.addDestination(nodeD, 50);

        nodeF.addDestination(nodeE, 15);

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);
        
        assertEquals("A",nodeA.getData());
        assertEquals("B",nodeB.getData());
        assertEquals("C",nodeC.getData());
        assertEquals("D",nodeD.getData());
        assertEquals("E",nodeE.getData());
        
        BFS<String> bfs = new BFS<>(nodeA);
        bfs.traverse();
        
        assertEquals(6,bfs.getVisitedNodes().size());

	}
	
	

}
