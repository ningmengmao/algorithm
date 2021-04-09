package com.ningmeng.base.graph;

/**
 * @Author ningmengmao
 * @Date 2020-11-26 21:54:56
 * @Version 1.0
 */
public class Vertex<T> {
	public T data;

	public Vertex(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Vertex{" +
				"data=" + data +
				'}';
	}
}
