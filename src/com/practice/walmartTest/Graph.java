package com.practice.walmartTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Graph {
	
	private static HashMap<Integer, Node> nodeLookUp = new HashMap<Integer,Node>();
	
	public static class Node{
		private int id;
		LinkedList<Node> adjacent = new LinkedList<Node>();
		
		private Node(int id) {
			this.id = id;
		}
	}

	private static Node getNode(int id) {
		return nodeLookUp.get(id);
	}
	
	public static void addEdge(int source, int destination) {
		Node sourceNode = getNode(source);
		Node destinationNode = getNode(destination);
		sourceNode.adjacent.add(destinationNode);
	}
	
	public static boolean hasPathDFS(int source, int destination) {
		Node s = getNode(source);
		Node d = getNode(destination);
		HashSet<Integer> visited = new HashSet<Integer>();
		
		return hasPathDFS(s, d, visited);
	}
	
	private static boolean hasPathDFS(Node source, Node destination, HashSet<Integer> visited) {
		if(source == destination) {
			return true;
		}
		
		if(visited.contains(source.id)) {
			return false;
		}
		visited.add(source.id);
		
		for(Node child:source.adjacent) {
			if(hasPathDFS(child, destination, visited)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean hasPathBFS(int source, int destination) {
		Node s = getNode(source);
		Node d = getNode(destination);
		HashSet<Integer> hasVisited = new HashSet<Integer>();
		return hasPathBFS(s,d, hasVisited);
	}
	
	private static boolean hasPathBFS(Node source, Node destination, HashSet<Integer> visited) {
		
		LinkedList<Node> nodesToVist = new LinkedList<Node>();
		nodesToVist.add(source);
		
		while(!nodesToVist.isEmpty()) {
			
			Node current = nodesToVist.remove();
			if(visited.contains(current.id)) {
				continue;
			}
			
			visited.add(current.id);
			
			if(current == destination) {
				return true;
			}else {
				for(Node child:current.adjacent) {
					nodesToVist.add(child);
				}
			}
			
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		
		for(int i=1;i<=7;i++) {
			Node node = new Node(i);
			nodeLookUp.put(i, node);
		}
		
		addEdge(1, 4);
		addEdge(1, 2);
		addEdge(2, 5);
		addEdge(2, 6);
		addEdge(6, 7);
		addEdge(4, 3);
		
		System.out.println(hasPathBFS(1, 7));
	}

}
