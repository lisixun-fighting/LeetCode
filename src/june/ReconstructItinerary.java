package june;

import java.util.*;

public class ReconstructItinerary {

    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, List<String>> adjacency = new HashMap<>();
        HashMap<String, List<Boolean>> known = new HashMap<>();
        for (List<String> ticket : tickets) {
            String u = ticket.get(0);
            String v = ticket.get(1);
            adjacency.putIfAbsent(u, new ArrayList<>());
            known.putIfAbsent(u, new ArrayList<>());
            adjacency.get(u).add(v);
            known.get(u).add(true);
        }
        PriorityQueue<List<String>> q = new PriorityQueue<>();
        LinkedList<String> route = new LinkedList<>();
        dfs("JFK", route, adjacency, known, q, tickets.size());
        return q.remove();
    }

    private void dfs(String from, LinkedList<String> route, HashMap<String, List<String>> adjacency,
                     HashMap<String, List<Boolean>> known, PriorityQueue<List<String>> q, int restStep) {
        if (restStep == 0) {
            q.add(new LinkedList<>(route));
            return;
        }
        for (int i = 0; i < adjacency.get(from).size(); i++) {
            if (known.get(from).get(i)) {
                continue;
            }
            String u = adjacency.get(from).get(i);
            route.addLast(u);

        }

    }
}
