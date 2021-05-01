package com.ningmeng.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author ningmengmao
 * @Date 2021-05-01 11:33:59
 * @Version 1.0
 */
public class Number690 {

	/**
	 * 树的bfs遍历
	 */
	public int getImportance(List<Employee> employees, int id) {

		HashMap<Integer, Employee> map = new HashMap<>(employees.size());
		int res = 0;
		employees.forEach(e -> map.put(e.id, e));

		Employee emp =  map.get(id);

		if (emp != null) {
			res += emp.importance;
			List<Integer> list =  map.get(id).subordinates;
			LinkedList<Integer> queue = new LinkedList<>(list);

			while (!queue.isEmpty()) {
				Integer employeeId = queue.pop();
				res += map.get(employeeId).importance;
				List<Integer> l =  map.get(employeeId).subordinates;
				if (l != null) {
					l.forEach(queue::addLast);
				}
			}
		}

		return res;
	}

	class Employee {
		public int id;
		public int importance;
		public List<Integer> subordinates;
	};
}
