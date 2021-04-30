package com.ningmeng.base.graph;

import java.util.*;

/**
 * @Author ningmengmao
 * @Date 2020-11-27 10:39:06
 * @Version 1.0
 */
public class Grid<T> {

	public int weight;
	public int columns;
	public int rows;
	public int size;
	public Point<T>[] pointList;
	public int[][] matrix;
	private final int MAX = Integer.MAX_VALUE - 10000;
	private final boolean[] used4DFS;


	public Grid(List<Point<T>> data, int columns,int weight) {
		if (data.size() % columns != 0) {
			throw new RuntimeException();
		}
		this.size = data.size();
		this.columns = columns;
		this.rows = size / columns;
		this.weight = weight;
		pointList = new Point[size];
		matrix = new int[size][size];
		for (int i = 0; i < data.size(); i++) {
			pointList[i] = data.get(i);
		}
		initGrid();
		used4DFS = new boolean[size];
	}


	private void initGrid() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == j) {
					matrix[i][j] = 0;
				} else {
					matrix[i][j] = MAX;
				}
			}
			int row = i / columns;
			int column = i % columns;
			int left = column - 1;
			int right = column + 1;
			int top = row - 1;
			int bottom = row + 1;
			if (left >= 0) {
				set(i, i - 1);
			}
			if (right < columns) {
				set(i, i + 1);
			}
			if (top >= 0) {
				set(i, i - columns);
			}
			if (bottom < rows) {
				set(i, i + columns);
			}

		}



	}

	private void set(int row, int column) {
		this.matrix[row][column] = weight;
		this.matrix[column][row] = weight;
	}

	public void printMatrix() {
		for (int[] integers : matrix) {
			for (int i : integers) {
				if (i == MAX) {
					System.out.printf("%2d", -1);
				} else {
					System.out.printf("%2d", i);
				}
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	public Map<String, int[]> getMinPath(T start) {
		int s = getIndexOf(start);

		int[] pathCost = new int[size];

		// 生成到各顶点的权重
		if (columns >= 0) {
			System.arraycopy(this.matrix[s], 0, pathCost, 0, columns);
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
					int now2new = this.matrix[index][i];
					if (s2vNew > s2Now + now2new) {
						pathCost[i] = s2Now + now2new;
						way[i] = index;
					}
				}
			}
		}

		HashMap<String, int[]> result = new HashMap<>(2);
		result.put("pathCost", pathCost);
		result.put("way", way);
		return result;
	}

	public Map<String, int[]> getMinPath(int start) {
		int s = start;
		int[] pathCost = new int[size];
		// 生成到各顶点的权重
		if (columns >= 0) {
			System.arraycopy(this.matrix[s], 0, pathCost, 0, size);
		}
		// 到各顶点的路线
		int[] way = new int[size];
		Arrays.fill(way, s);
		way[s] = -1;
		// 使用过的顶点
		boolean[] used = new boolean[size];
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
					int now2new = matrix[index][i];

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
				int target = matrix[index][i];
				if (!used[i] && target > 0 && target < weight ) {
					weight = target;
					result = i;
				}
			}
		}
		return result;
	}

	public int getIndexOf(T data) {
		for (int i = 0; i < pointList.length; i++) {
			Point<T> v = pointList[i];
			if (v.data.equals(data)) {
				return i;
			}
		}
		return -1;
	}


	public Map<String, int[]> getMinPath(int start, int target) {
		int s = start;
		int[] pathCost = new int[size];
		// 生成到各顶点的权重
		if (columns >= 0) {
			System.arraycopy(this.matrix[s], 0, pathCost, 0, size);
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
			if (used[target]) {
				break;
			}
			for (int i = 0; i < size; i++) {
				if (!used[i]) {
					// 起始点到此顶点的距离
					int s2vNew = pathCost[i];
					// 起始点到原顶点的距离
					int s2Now = pathCost[index];
					// 原顶点到此顶点的距离
					int now2new = this.matrix[index][i];
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


	public void BFS(int begin, int target) {
		boolean[] used = new boolean[size];

		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(begin);

		int[] way = new int[size];
		Arrays.fill(way, begin);
		way[begin] = -1;

		while(!queue.isEmpty()) {

			Integer index = queue.removeFirst();
			if (used[index]) {
				continue;
			}
			System.out.println(index);
			used[index] = true;
			for (int i = 0; i < size; i++) {
				if (!used[i] && matrix[index][i] > 0 && matrix[index][i] < MAX) {
					queue.add(i);
					way[i] = index;
				}
			}
			if (index == target) {
				break;
			}
		}

	}

	public void DFS(int start, int target) {
		used4DFS[start] = true;
		System.out.println(start);
		if (start == target) {
			return;
		}

		for (int i = 0; i < matrix[start].length; i++) {
			if ( !used4DFS[i] && matrix[start][i] > 0 && matrix[start][i] < MAX ){
				DFS(i, target);
			}
		}
	}

	public int[] DFS2(int start, int target) {
		boolean[] used = new boolean[size];
		int[] way = new int[size];
		Arrays.fill(way, -MAX);
		int before = -1;

		boolean first = true;
		LinkedList<Integer> stack = new LinkedList<>();
		stack.push(start);
		LinkedList<Integer> temp = new LinkedList<>();
		while(!stack.isEmpty()) {
			start = stack.pop();
			if (used[start]) {
				continue;
			}
			used[start] = true;
			way[start] = before;
			before = start;
			System.out.println(start);
			if (start == target) {
				break;
			}
			for (int i = 0; i < matrix[start].length; i++) {
				if ( !used[i] && matrix[start][i] > 0 && matrix[start][i] < MAX ){
					temp.push(i);
				}
			}
			for (Integer integer : temp) {
				stack.addFirst(integer);
			}
			temp.clear();
		}
		return way;
	}
}


//package graph;
//
//import java.util.*;
//
///**
// * @Author ningmengmao
// * @Date 2020-11-27 10:39:06
// * @Version 1.0
// */
//public class Grid<T> {
//
//	public int weight;
//	public int columns;
//	public int rows;
//	public int size;
//	public List<Point<T>> pointList = new ArrayList<>();
//	public List<List<Integer>> matrix = new ArrayList<>();
//	private final int MAX = Integer.MAX_VALUE - 10000;
//
//	public Grid(List<Point<T>> data, int columns,int weight) {
//		if (data.size() % columns != 0) {
//			throw new RuntimeException();
//		}
//		this.size = data.size();
//		this.columns = columns;
//		this.rows = size / columns;
//		this.weight = weight;
//		this.pointList.addAll(data);
//		initGrid();
//	}
//
//
//	private void initGrid() {
//		for (int i = 0; i < size; i++) {
//			ArrayList<Integer> temp = new ArrayList<>();
//			for (int j = 0; j < size; j++) {
//				if (i == j) {
//					temp.add(0);
//				} else {
//					temp.add(MAX);
//				}
//			}
//			matrix.add(temp);
//		}
//		for (int i = 0; i < size; i++) {
//			int row = i / columns;
//			int column = i % columns;
//			int left = column - 1;
//			int right = column + 1;
//			int top = row - 1;
//			int bottom = row + 1;
//			if (left >= 0) {
//				set(i, i - 1);
//			}
//			if (right < columns) {
//				set(i, i + 1);
//			}
//			if (top >= 0) {
//				set(i, i - columns);
//			}
//			if (bottom < rows) {
//				set(i, i + columns);
//			}
//
//		}
//
//	}
//
//	private void set(int row, int column) {
//		this.matrix.get(row).set(column, weight);
//		this.matrix.get(column).set(row, weight);
//	}
//
//	public void printMatrix() {
//		for (List<Integer> integers : matrix) {
//			for (Integer i : integers) {
//				if (i == MAX) {
//					System.out.printf("%2d", -1);
//					System.out.print("  ");
//				} else {
//					System.out.printf("%2d", i);
//					System.out.print("  ");
//				}
//			}
//			System.out.println();
//		}
//	}
//
//	public Map<String, int[]> getMinPath(T start) {
//		int s = getIndexOf(start);
//
//		int[] pathCost = new int[size];
//		List<Integer> temp = matrix.get(s);
//		// 生成到各顶点的权重
//		for (int i = 0; i < temp.size(); i++) {
//			pathCost[i] = temp.get(i);
//		}
//
//		// 到各顶点的路线
//		int[] way = new int[size];
//		Arrays.fill(way, s);
//		way[s] = -1;
//
//		// 使用过的顶点
//		boolean[] used = new boolean[size];
//		Arrays.fill(used, false);
//
//		used[s] = true;
//
//		while (true) {
//			int index = 0;
//
//			index = getMinWeight(index, pathCost, s, used);
//
//			if (index == -1) {
//				break;
//			}
//
//			used[index] = true;
//
//			for (int i = 0; i < size; i++) {
//				if (!used[i]) {
//					// 起始点到此顶点的距离
//					int s2vNew = pathCost[i];
//
//					// 起始点到原顶点的距离
//					int s2Now = pathCost[index];
//					// 原顶点到此顶点的距离
//					int now2new = matrix.get(index).get(i);
//
//					if (s2vNew > s2Now + now2new) {
//						pathCost[i] = s2Now + now2new;
//						way[i] = index;
//					}
//				}
//			}
//		}
//
//		HashMap<String, int[]> result = new HashMap<>(2);
//		result.put("pathCost", pathCost);
//		result.put("way", way);
//		return result;
//	}
//
//	public Map<String, int[]> getMinPath(int start) {
//		int s = start;
//		int[] pathCost = new int[size];
//		List<Integer> temp = matrix.get(s);
//		// 生成到各顶点的权重
//		for (int i = 0; i < temp.size(); i++) {
//			pathCost[i] = temp.get(i);
//		}
//		// 到各顶点的路线
//		int[] way = new int[size];
//		Arrays.fill(way, s);
//		way[s] = -1;
//		// 使用过的顶点
//		boolean[] used = new boolean[size];
//		Arrays.fill(used, false);
//		used[s] = true;
//
//		while (true) {
//			int index = 0;
//
//			index = getMinWeight(index, pathCost, s, used);
//			if (index == -1) {
//				break;
//			}
//			used[index] = true;
//			for (int i = 0; i < size; i++) {
//				if (!used[i]) {
//					// 起始点到此顶点的距离
//					int s2vNew = pathCost[i];
//					// 起始点到原顶点的距离
//					int s2Now = pathCost[index];
//					// 原顶点到此顶点的距离
//					int now2new = matrix.get(index).get(i);
//
//					if (s2vNew > s2Now + now2new) {
//						pathCost[i] = s2Now + now2new;
//						way[i] = index;
//					}
//				}
//			}
//		}
//
//		HashMap<String, int[]> result = new HashMap<>();
//		result.put("pathCost", pathCost);
//		result.put("way", way);
//		return result;
//	}
//
//	/**
//	 * 返回最小权值的顶点的位置
//	 * @param index
//	 * @param pathCost
//	 * @return 位置
//	 */
//	public int getMinWeight(int index, int[] pathCost, int start, boolean[] used) {
//		int weight = MAX;
//		int result = -1;
//		if (index == start) {
//			for (int i = 0; i < pathCost.length; i++) {
//				if (!used[i] && pathCost[i] > 0 && pathCost[i] < weight) {
//					weight = pathCost[i];
//					result = i;
//				}
//			}
//		} else {
//			for (int i = 0; i < pathCost.length; i++) {
//				Integer target = matrix.get(index).get(i);
//				if (!used[i] && target > 0 && target < weight ) {
//					weight = target;
//					result = i;
//				}
//			}
//		}
//		return result;
//	}
//
//	public int getIndexOf(T data) {
//		for (int i = 0, vertexListSize = pointList.size(); i < vertexListSize; i++) {
//			Point<T> v = pointList.get(i);
//			if (v.data.equals(data)) {
//				return i;
//			}
//		}
//		return -1;
//	}
//
//
//	public Map<String, int[]> getMinPath(int start, int target) {
//		int s = start;
//		int[] pathCost = new int[size];
//		List<Integer> temp = matrix.get(s);
//		// 生成到各顶点的权重
//		for (int i = 0; i < temp.size(); i++) {
//			pathCost[i] = temp.get(i);
//		}
//		// 到各顶点的路线
//		int[] way = new int[size];
//		Arrays.fill(way, s);
//		way[s] = -1;
//		// 使用过的顶点
//		boolean[] used = new boolean[size];
//		Arrays.fill(used, false);
//		used[s] = true;
//
//		while (true) {
//			int index = 0;
//
//			index = getMinWeight(index, pathCost, s, used);
//			if (index == -1) {
//				break;
//			}
//			used[index] = true;
//			for (int i = 0; i < size; i++) {
//				if (!used[i]) {
//					// 起始点到此顶点的距离
//					int s2vNew = pathCost[i];
//					// 起始点到原顶点的距离
//					int s2Now = pathCost[index];
//					// 原顶点到此顶点的距离
//					int now2new = matrix.get(index).get(i);
//
//					if (s2vNew > s2Now + now2new) {
//						pathCost[i] = s2Now + now2new;
//						way[i] = index;
//					}
//				}
//			}
//			if (used[target]) {
//				break;
//			}
//		}
//
//		HashMap<String, int[]> result = new HashMap<>();
//		result.put("pathCost", pathCost);
//		result.put("way", way);
//		return result;
//	}
//}
