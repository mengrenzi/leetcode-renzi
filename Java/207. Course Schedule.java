package Java;

import java.util.*;

class Solution {
  public boolean canFinish(int n, int[][] prerequisites) {
    // build graph
    // Key: prerequisite course
    Map<Integer, List<Integer>> preToCourse = new HashMap<>();
    int[] indegree = new int[n];
    Queue<Integer> queue = new LinkedList<>();
    for (int[] prep : prerequisites) {
      preToCourse.putIfAbsent(prep[1], new ArrayList<>());
      preToCourse.get(prep[1]).add(prep[0]);
      indegree[prep[0]]++;
    }

    for (int i = 0; i < n; i++) {
      if (indegree[i] == 0) {
        queue.offer(i);
      }
    }

    while (!queue.isEmpty()) {
      int top = queue.poll();
      List<Integer> list = preToCourse.getOrDefault(top, new ArrayList<>());
      for (int current : list) {
        indegree[current]--;
        if (indegree[current] == 0) {
          queue.offer(current);
        }
      }
      n--;
    }
    return n == 0;
  }
}