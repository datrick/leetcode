package minimumSpanningTree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {
    static class Connection {
        String node1;
        String node2;
        int cost;

        public Connection(final String a, final String b, final int c) {
            node1 = a;
            node2 = b;
            cost = c;
        }
    }

    public static List<Connection> getLowestCostConnections(
            final List<Connection> connections) {
        final List<Connection> rslt = new ArrayList<>();
        if ((connections == null) || (connections.size() == 0)) {
            return rslt;
        }
        final Map<String, List<Connection>> graph = new HashMap<>();
        for (final Connection connection : connections) {
            if (!graph.containsKey(connection.node1)) {
                graph.put(connection.node1, new ArrayList<Connection>());
            }
            if (!graph.containsKey(connection.node2)) {
                graph.put(connection.node2, new ArrayList<Connection>());
            }
            graph.get(connection.node1).add(connection);
            graph.get(connection.node2).add(connection);
        }
        final Set<String> visited = new HashSet<>();
        String node = graph.keySet().iterator().next();
        final int num = graph.size() - 1;
        int n = 0;
        final PriorityQueue<Connection> heap = new PriorityQueue<>(
                connections.size(), new Comparator<Connection>() {
                    @Override
                    public int compare(final Connection o1, final Connection o2) {
                        return o1.cost - o2.cost;
                    }
                });
        do {
            visited.add(node);
            for (final Connection edge : graph.get(node)) {
                final String node2 = edge.node1.compareTo(node) == 0 ? edge.node2
                        : edge.node1;
                if (!visited.contains(node2)) {
                    heap.add(edge);
                }
            }
            if (!heap.isEmpty()) {
                final Connection e = heap.poll();
                node = node.compareTo(e.node1) == 0 ? e.node2 : e.node1;
                rslt.add(e);
                n++;
            }
        } while (n < num);
        return rslt;
    }

    public static void main(final String[] args) {
        final Connection c1 = new Connection("1", "2", 1), c2 = new Connection(
                "2", "3", 2), c3 = new Connection("1", "3", 1);
        final List<Connection> connections = new ArrayList<>();
        connections.add(c1);
        connections.add(c2);
        connections.add(c3);
        final List<Connection> rslt = Solution
                .getLowestCostConnections(connections);
        for (final Connection c : rslt) {
            System.out.println(c.node1 + "-" + c.node2 + ": " + c.cost);
        }
    }

}
