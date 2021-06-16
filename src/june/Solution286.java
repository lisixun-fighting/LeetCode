package june;

import org.junit.Test;

import java.util.*;

public class Solution286 {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> set = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0)
                    set.add(new int[] {i, j});
            }
        }
        int size;
        int step = 0;
        while ((size = set.size()) > 0) {
            System.out.println(size);
            step++;
            for (int i = 0; i < size; i++) {
                int[] room = set.poll();
                System.out.println(Arrays.toString(room));
                avail(room[0], room[1]-1, rooms, step, set);
                avail(room[0], room[1]+1, rooms, step, set);
                avail(room[0]-1, room[1], rooms, step, set);
                avail(room[0]+1, room[1], rooms, step, set);
            }
        }
    }

    private void avail(int i, int j, int[][] rooms, int step, Queue<int[]> queue) {
        if (i >= 0 && i < rooms.length && j >= 0 && j < rooms[i].length
                && rooms[i][j] != -1 && rooms[i][j] > step) {
            queue.add(new int[]{i, j});
            rooms[i][j] = step;
        }
    }

    @Test
    public void test() {
        int[][] rooms = {
                {2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}};
        /*{
            {
                2147483647, 0, 2147483647, 2147483647, 0, 2147483647, -1, 2147483647
            }
        };*/
        wallsAndGates(rooms);
        System.out.println(Arrays.deepToString(rooms));
    }
}
