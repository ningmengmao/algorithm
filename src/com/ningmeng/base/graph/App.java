package com.ningmeng.base.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * @Author ningmengmao
 * @Date 2020-11-26 22:11:59
 * @Version 1.0
 */
public class App {

	public static void main(String[] args) {

		ArrayList<Point<Integer>> list = new ArrayList<>();
		for (int i = 0; i < 4 * 4; i++) {
			Point<Integer> point = new Point<>(i);
			list.add(point);
		}
		Grid<Integer> grid = new Grid<>(list, 4, 10);
//		grid.BFS(0, 15);
//		grid.DFS(0, 3);
		grid.DFS2(0, 8);

	}

	public static void runGrid() {
		ArrayList<Point<Integer>> list = new ArrayList<>();
		for (int i = 0; i < 200 * 100; i++) {
			Point<Integer> point = new Point<>(i);
			list.add(point);
		}
		Grid<Integer> grid = new Grid<>(list, 200, 10);

		long start = System.currentTimeMillis();
		Map<String, int[]> minPath = grid.getMinPath(0, 80 * 50 - 4);
		long end = System.currentTimeMillis();

		System.gc();
		System.out.println(end - start +"ms");

		start = System.currentTimeMillis();
		Map<String, int[]> minPath1 = grid.getMinPath(0);
		end = System.currentTimeMillis();
		System.out.println(end - start +"ms");
		System.out.println();
	}

	private static void runGraph() {
		Graph<String> graph = buildGraph();
		graph.printMatrix();
		Map<String, int[]> minPath = graph.getMinPath("E");
		System.out.println();
	}


	public static Graph<String> buildGraph() {
		Graph<String> graph = new Graph<>(5);
		Vertex<String> a = new Vertex<>("A");
		Vertex<String> b = new Vertex<>("B");
		Vertex<String> c = new Vertex<>("C");
		Vertex<String> d = new Vertex<>("D");
		Vertex<String> e = new Vertex<>("E");
		Arrays.asList(a, b, c, d, e).forEach(graph::addVertex);

		graph.setWeight(0, 1, 2);
		graph.setWeight(0, 2, 3);
		graph.setWeight(0, 4, 5);

		graph.setWeight(1, 2, 1);
		graph.setWeight(1, 4, 1);

		graph.setWeight(2, 4, 3);
		graph.setWeight(2, 3, 4);

		graph.setWeight(3, 4, 2);

		return graph;
	}
}
