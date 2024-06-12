import networkx as nx
import matplotlib.pyplot as plt
from collections import deque

def bfs(graph, start, end):
    queue = deque()
    queue.append((start, [start]))
    while queue:
        current_node, path = queue.popleft()
        if current_node == end:
            return path
        for neighbor in graph[current_node]:
            if neighbor not in path:
                queue.append((neighbor, path + [neighbor]))
graph = {
    'Pitesti': ['Bucharest', 'Cra'],
    'Rimn': ['Pitesti', 'Cra'],
    'Arada': ['Zeri','Simbiu','Orades','Timi'],
    'Orades': ['Simbiu',],
    'Simbiu': ['Rimn', 'Faga'],
    'Faga': ['Bucharest'],
    'Timi':['Lugo'],
    'Cra':[],
    'Lugo':['Meha'],
    'Meha':['Dobre'],
    'Dobre':['Cra'],
    'Zeri':['Orades']

}
start_node = 'Arada'
end_node = 'Bucharest'
path = bfs(graph, start_node, end_node)
G = nx.DiGraph()
for node in graph.keys():
    G.add_node(node)
for node, neighbors in graph.items():
    for neighbor in neighbors:
        G.add_edge(node, neighbor)
pos = nx.spectral_layout(G)
nx.draw(G, pos, with_labels=True, node_size=1500, node_color="skyblue")

if path:
    edges = [(path[i], path[i + 1]) for i in range(len(path) - 1)]
    nx.draw_networkx_edges(G, pos, edgelist=edges, edge_color='r', width=2)

plt.show()
