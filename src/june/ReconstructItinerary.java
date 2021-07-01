package june;

import org.junit.Test;

import java.util.*;

public class ReconstructItinerary {

    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> tmpAdjacency = new HashMap<>();
        HashMap<String, List<String>> adjacency = new HashMap<>();
        HashMap<String, List<Boolean>> known = new HashMap<>();
        for (List<String> ticket : tickets) {
            String u = ticket.get(0);
            String v = ticket.get(1);
            tmpAdjacency.putIfAbsent(u, new PriorityQueue<>());
            tmpAdjacency.get(u).add(v);
        }
        for (String key : tmpAdjacency.keySet()) {
            PriorityQueue<String> q = tmpAdjacency.get(key);
            adjacency.put(key, new ArrayList<>());
            known.put(key, new ArrayList<>());
            while (!q.isEmpty()) {
                adjacency.get(key).add(q.poll());
                known.get(key).add(false);
            }
        }
        // System.out.println(adjacency);
        LinkedList<String> route = new LinkedList<>();
        route.add("JFK");
        dfs("JFK", route, adjacency, known, tickets.size());
        return route;
    }

    private boolean dfs(String from, LinkedList<String> route, HashMap<String, List<String>> adjacency,
                        HashMap<String, List<Boolean>> known, int restStep) {
        // System.out.println(from);
        if (restStep == 0) {
            return true;
        }
        if (!adjacency.containsKey(from)) {
            return false;
        }
        for (int i = 0; i < adjacency.get(from).size(); i++) {
            if (known.get(from).get(i)) {
                continue;
            }
            String next = adjacency.get(from).get(i);
            // System.out.println("next: " + next);
            route.addLast(next);
            known.get(from).set(i, true);
            if (dfs(next, route, adjacency, known,restStep-1))
                return true;
            route.removeLast();
            known.get(from).set(i, false);
        }
        return false;
    }

    @Test
    public void test() {
        List<List<String>> tickets = new LinkedList<>();
        tickets.add(List.of("JFK", "AFO"));
        tickets.add(List.of("JFK", "ATL"));
        tickets.add(List.of("SFO", "ATL"));
        tickets.add(List.of("ATL", "JFK"));
        tickets.add(List.of("ATL", "SFO"));
        List<String> res = findItinerary(tickets);
        System.out.println(res);
    }
}
