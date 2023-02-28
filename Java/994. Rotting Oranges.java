package Java;

import java.util.*;

class Solution {
  public int orangesRotting(int[][] grid) {
    Queue<int[]> queue = new LinkedList<>();

    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 2) {
          queue.add(new int[] { i, j });
          // -1 means visisted
          grid[i][j] = -1;
        }
        if (grid[i][j] == 1) {
          count++;
        }
      }
    }

    int day = 0;
    if (count == 0) {
      return day;
    }

    int[][] dirs = new int[][] { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int[] top = queue.poll();
        for (int[] dir : dirs) {
          int x = top[0] + dir[0];
          int y = top[1] + dir[1];
          if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
            count--;
            queue.offer(new int[] { x, y });
            grid[x][y] = -1;
          }

        }

        if (count == 0) {
          return day + 1;
        }
      }
      day++;
    }

    return -1;
  }
}