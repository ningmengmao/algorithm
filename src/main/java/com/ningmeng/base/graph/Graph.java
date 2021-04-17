package com.ningmeng.base.graph;

import java.util.*;

/**
 * @Author ningmengmao
 * @Date 2020-11-26 21:53:20
 * @Version 1.0
 */
public class Graph<T> {

	public static final int MAX = Integer.MAX_VALUE - 10000;

	/**
	 * 邻接矩阵
	 */
	public List<List<Integer>> matrix = new LinkedList<>();

	public List<Vertex<T>> vertexList = new LinkedList<>();

	public final int size;

	public Graph(int size) {
		this.size = size;
		for (int i = 0; i < size; i++) {
			LinkedList<Integer> temp = new LinkedList<>();
			for (int j = 0; j < size; j++) {
				if (i == j) {
					temp.add(0);
				} else {
					temp.add(MAX);
				}
			}
			matrix.add(temp);
		}
	}

	public void addVertex(Vertex<T> vertex) {
		vertexList.add(vertex);
	}

	public void setWeight(int row, int column, int weight) {
		if (row < size && column < size && weight > 0) {
			matrix.get(row).set(column, weight);
			matrix.get(column).set(row, weight);
		}
	}


	public int getIndexOf(T data) {
		for (int i = 0, vertexListSize = vertexList.size(); i < vertexListSize; i++) {
			Vertex<T> v = vertexList.get(i);
			if (v.data.equals(data)) {
				return i;
			}
		}
		return -1;
	}


	public void printMatrix() {
		for (List<Integer> integers : matrix) {
			for (Integer i : integers) {
				if (i == MAX) {
					System.out.print("X" + "  ");
				} else {
					System.out.print(i + "  ");
				}
			}
			System.out.println();
		}
	}


	public Map<String, int[]> getMinPath(T start) {
		int s = getIndexOf(start);

		int[] pathCost = new int[size];
		List<Integer> temp = matrix.get(s);
		// 生成到各顶点的权重
		for (int i = 0; i < temp.size(); i++) {
			pathCost[i] = temp.get(i);
		}

		// 到各顶点的路线
		int[] way = new int[size];
		Arrays.fill(way, s);
		way[s] = -1;

		// 使用过的顶点
		boolean[] used = new boolean[size];
		Arrays.fill(used, false);

		used[s] = true;

		while (true) {
			int index = 0;

			index = getMinWeight(index, pathCost, s, used);

			if (index == -1) {
				break;
			}

			used[index] = true;

			for (int i = 0; i < size; i++) {
				if (!used[i]) {
					// 起始点到此顶点的距离
					int s2vNew = pathCost[i];

					// 起始点到原顶点的距离
					int s2Now = pathCost[index];
					// 原顶点到此顶点的距离
					int now2new = matrix.get(index).get(i);

					if (s2vNew > s2Now + now2new) {
						pathCost[i] = s2Now + now2new;
						way[i] = index;
					}
				}
			}
		}

		HashMap<String, int[]> result = new HashMap<>();
		result.put("pathCost", pathCost);
		result.put("way", way);
		return result;
	}

	/**
	 * 返回最小权值的顶点的位置
	 * @param index
	 * @param pathCost
	 * @return 位置
	 */
	public int getMinWeight(int index, int[] pathCost, int start, boolean[] used) {
		int weight = MAX;
		int result = -1;

		if (index == start) {
			for (int i = 0; i < pathCost.length; i++) {
				if (!used[i] && pathCost[i] > 0 && pathCost[i] < weight) {
					weight = pathCost[i];
					result = i;
				}
			}
		} else {
			for (int i = 0; i < pathCost.length; i++) {
				Integer target = matrix.get(index).get(i);
				if (!used[i] && target > 0 && target < weight ) {
					weight = target;
					result = i;
				}
			}
		}
		return result;
	}




}
