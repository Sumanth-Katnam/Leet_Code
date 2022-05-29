import collections
import math
import heapq

# V+E
def createAdjacencyList(graph) -> dict:
    adj_list = collections.defaultdict(list)
    for j in graph:
        adj_list[j[0]].append((j[1], j[2]))
    return adj_list

# V
def getMin(min_dists) -> int:
    min_vertex = ''
    min_val = math.inf
    for v in min_dists.keys():
        if min_val >= min_dists[v]:
            min_vertex = v
            min_val = min_dists[v]

    return min_vertex

# E.V
def singleSourceShortestPath (graph, n_nodes, start_vertex) -> int:
    min_dists = {}
    for v in graph:
        min_dists[v[0]] = math.inf
        min_dists[v[1]] = math.inf
    
    adj_list = createAdjacencyList(graph)
    min_dists[start_vertex] = 0
    max_dist = -1

    while min_dists:
        current_vertex = getMin(min_dists)
        
        for i in adj_list[current_vertex]:
            min_dists[i[0]] = min_dists[current_vertex] + i[1]
            max_dist = max(max_dist, min_dists[i[0]])
        
        del min_dists[current_vertex]

    return max_dist

# E.log(V)
def singleSourceShortestPath_Heap (graph, n_nodes, start_vertex) -> int:
    min_dists = []
    
    heapq.heappush(min_dists, (0, start_vertex))
    adj_list = createAdjacencyList(graph)
    max_dist = -1

    while min_dists:
        current_dist, current_vertex = heapq.heappop(min_dists)
        if current_dist != math.inf:
            n_nodes -= 1
        
        for i in adj_list[current_vertex]:
            heapq.heappush(min_dists, (current_dist + i[1], i[0]))
            max_dist = max(max_dist, current_dist + i[1])
        
    return -1 if n_nodes else max_dist

if __name__ == "__main__":
    graph = [(2,1,1), (2,3,1), (3,4,1)]
    time = singleSourceShortestPath(graph, 4, 2)
    time2 = singleSourceShortestPath_Heap(graph, 4, 2)
    print("Time is ", time)
    print("Time2 is ", time2)
