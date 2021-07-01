package june;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String,Double>> adjacency = new HashMap<>();
        Map<String, Map<String,Boolean>> known = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            adjacency.putIfAbsent(u, new HashMap<>());
            known.putIfAbsent(u, new HashMap<>());
            adjacency.putIfAbsent(v, new HashMap<>());
            known.putIfAbsent(v, new HashMap<>());
            adjacency.get(u).put(v, values[i]);
            known.get(u).put(v, false);
            adjacency.get(v).put(u, 1/values[i]);
            known.get(v).put(u, false);
        }
        System.out.println(adjacency);
        double[] result = new double[queries.size()];
        for (int i = 0; i < result.length; i++) {
            String u = queries.get(i).get(0);
            String v = queries.get(i).get(1);

            if (!adjacency.containsKey(u) || !adjacency.containsKey(v)) {
                result[i] = -1;
                continue;
            }
            if (u.equals(v)) {
                result[i] = 1;
                continue;
            }
            result[i] = dfs(u,v,adjacency,known);
        }
        return result;
    }

    private double dfs(String divisor, String divided, Map<String, Map<String, Double>> adjacency,
                       Map<String, Map<String, Boolean>> known) {
        Map<String, Double> map = adjacency.get(divisor);
        if (map.containsKey(divided)) {
            return map.get(divided);
        }
        for (String tmp : map.keySet()) {
            System.out.println(divisor + " " + tmp);
            if (!known.get(divisor).get(tmp)) {
                known.get(divisor).put(tmp, true);
                double res = dfs(tmp, divided, adjacency, known);
                known.get(divisor).put(tmp, false);
                if (res != -1) {
                    return res * map.get(tmp);
                }
            }
        }
        return -1;
    }

    @Test
    public void test() {
        List<List<String>> equations = List.of(List.of("a", "b"), List.of("b", "c"), List.of("c", "d"), List.of("d", "e"));
        double[] values = {2.0d, 3.0d, 4d, 5d};
        List<List<String>> queries = List.of(List.of("a", "e"));
        double[] res = calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(res));

    }
}
