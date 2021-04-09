package com.ningmeng.base.graph;

/**
 * @Author ningmengmao
 * @Date 2020-11-27 11:16:50
 * @Version 1.0
 */
public class Point<T> {
	public int x;
	public int y;
	public T data;


	public Point(T data) {
		this.data = data;
	}

	public Point(int x, int y, T data) {
		this.x = x;
		this.y = y;
		this.data = data;
	}

	@Override
	public String toString() {
		return "Point{" +
				"x=" + x +
				", y=" + y +
				", data=" + data +
				'}';
	}
}
