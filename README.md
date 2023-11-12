# Live-Long-Prosper-Agent

# Search Tree Node ADT:

- **State (state):** Represents the current state of the problem, including prosperity, food, materials, and energy levels.
  
- **Parent Node (parentNode):** Reference to the node in the search tree that this node was generated from.

- **Operator (operator):** Represents the action applied to the parent node to generate this node.

- **Depth (depth):** Depth of this node in the search tree.

- **Path Cost (pathCost):** Total cost of the path from the initial state to this node, based on applied actions.

- **Heuristic Values (heuristicValue1, heuristicValue2):** Estimates of the cost from this state to a goal state, used by some search algorithms.

The class includes getter and setter methods for each attribute and a `toString` method for a string representation.

# Search Problem ADT:

- **Operators (operators):** List of possible actions that can be applied to a state in the problem, instances of the Operator class.

- **Initial State (initialState):** Starting point of the problem, an instance of the State class.

- **Goal Test (goalTest):** Value defining the goal state, e.g., 100 for prosperity.

The class includes getter and setter methods for each attribute.

# LLAPSearch Problem:

- **Constructor (`LLAPSearch(Problem problem, SearchStrategy searchStrategy)'):** Takes a Problem and a SearchStrategy as arguments.

- **`solve(String initialState, String searchStrategy, boolean visualize):`** Solves the search problem with initial state, search strategy, and visualization flag.

- **`reconstruction(Node goal) and reconstructionVisualization(Node goal):`** Reconstructs the solution from the goal node back to the initial state.

- **`parseInitialState(String initialState):`** Parses the initial state from a string representation to a State object.

- **`public static String solve(String initialState, String searchStrategy, boolean visualize):`** Main entry point for problem-solving, returns formatted solution.

- **`public Node SolveGenericSearch():`** Initiates the problem-solving process based on the chosen search strategy.

- **`private LinkedList<Node> expand(Node current):`** Generates successor nodes for a given node, representing possible actions.

- **`private boolean goalTest(Node testNode):`** Checks whether a given node satisfies the goal conditions.

- **Action methods (`requestFood`, `requestMaterials`, `requestEnergy`, `wait`, `build1`, `build2`):** Represent actions, validate feasibility, and generate new state and node.

# Search Strategies:

- **Breadth-First Search (BF) and Depth-First Search (DF):** Utilize a queue for BFS or DFS based on the chosen strategy.

- **Iterative Deepening (ID):** Implements Iterative Deepening, gradually increasing the depth limit.

- **Uniform Cost Search (UC):** Uses a priority queue, prioritizing nodes with lower path costs.

- **Greedy Search (GR1 and GR2):** Utilizes priority queues with different heuristics.

- **A Search (AS1 and AS2):** Uses priority queues with the sum of path cost and heuristic value as the priority.

# Heuristic Functions:

- **`h1(n)`:** Admissible heuristic estimating the minimum number of actions required to reach the goal.

- **`h2(n)`:** Admissible heuristic estimating the cost to reach the target prosperity level.

# Performance Comparison of Search Algorithms

This README provides a comparison of the performance of different search algorithms in terms of completeness, optimality, RAM usage, CPU utilization, and the number of expanded nodes.

## Performance Metrics

The performance of the algorithms is evaluated based on the following metrics:

- **Completeness**: Whether the algorithm is guaranteed to find a solution if one exists.
- **Optimality**: Whether the algorithm is guaranteed to find the best solution.
- **Number of Expanded Nodes**: The number of nodes that the algorithm expands during the search process.
- **CPU Utilization (%):** The percentage of CPU resources used by the algorithm.
- **Used Memory (MB):** The amount of RAM used by the algorithm (in megabytes).

## Performance Comparison

The performance of the algorithms for two different initial states is shown below:

### Initial State 0

| Algorithm | Num of Expanded Nodes | CPU Utilization (%) | Used Memory (MB) |
|-----------|----------------------|---------------------|------------------|
| DFS       | 4                    | 8.14                | 5                |
| BFS       | 25                   | 8.68                | 5                |
| IDS       | 35                   | 7.66                | 5                |
| UC        | 94376                | 15.32               | 104              |
| GR1       | 5                    | 4.33                | 5                |
| GR2       | 502                  | 8.68                | 6                |
| AS1       | 94413                | 16.8                | 104              |
| AS2       | 94376                | 17.39               | 103              |

### Initial State 4

| Algorithm | Num of Expanded Nodes | CPU Utilization (%) | Used Memory (MB) |
|-----------|----------------------|---------------------|------------------|
| DFS       | 459                  | 6.85                | 6                |
| BFS       | 673003               | 6.19                | 338              |
| IDS       | 8246906              | 13.06               | 529              |
| UC        | 1305994              | 8.96                | 620              |
| GR1       | 1355                 | 10.85               | 7                |
| GR2       | 16359                | 8.14                | 8                |
| AS1       | 1305994              | 10.88               | 627              |
| AS2       | 1305994              | 5.21                | 645              |

Certainly, here's a summarized table of observations:

### Initial State 0 Observations:

| Algorithm           | Number of Expanded Nodes | CPU Utilization | Used Memory  | Remarks                                          |
|---------------------|--------------------------|------------------|--------------|--------------------------------------------------|
| DFS                 | Moderate                 | Low              | Low          | Lightweight but may not guarantee optimality     |
| BFS                 | High                     | Moderate         | High         | Thorough but resource-intensive                  |
| IDS                 | Moderate                 | Moderate         | Moderate     | Combines advantages of DFS and BFS               |
| UC                  | High                     | High             | High         | Explores based on path cost, substantial memory |
| GR1 (Greedy)        | Low                      | Low              | Low          | Efficient but not guaranteed optimal            |
| GR2 (Greedy)        | Moderate                 | Moderate         | Moderate     | More exploration than GR1                       |
| AS1 (A* Search)     | High                     | High             | High         | Considers both path cost and heuristic, demanding|
| AS2 (A* Search)     | High                     | Moderate         | High         | Another heuristic, similar characteristics     |

### Initial State 4 Observations:

| Algorithm           | Number of Expanded Nodes | CPU Utilization | Used Memory  | Remarks                                           |
|---------------------|--------------------------|------------------|--------------|---------------------------------------------------|
| DFS                 | Moderate                 | Low              | Moderate     | More nodes explored, slightly higher memory usage |
| BFS                 | Very High                | Moderate         | Very High    | Extremely high number of nodes, highly memory-intensive |
| IDS                 | Very High                | Moderate         | High         | Extensive node exploration, better memory efficiency compared to BFS |
| UC                  | High                     | Moderate         | High         | Explores based on cost, high memory usage         |
| GR1 (Greedy)        | Low                      | Moderate         | Low          | Consistently efficient with a low number of nodes explored |
| GR2 (Greedy)        | Moderate                 | Low              | Moderate     | More exploration than GR1 but remains efficient   |
| AS1 (A* Search)     | High                     | Moderate         | High         | Similar characteristics to the first set, demanding |
| AS2 (A* Search)     | High                     | Low              | High         | Lower CPU utilization but similar memory usage    |

### General Observations:

- **Number of Expanded Nodes:**
  - BFS tends to expand an exceptionally large number of nodes.
  - Greedy approaches (GR1 and GR2) are more efficient in terms of the number of nodes expanded.
  
- **CPU Utilization:**
  - A* searches (AS1 and AS2) and UC have higher CPU utilization.
  - DFS and Greedy approaches have lower CPU utilization.

- **Used Memory:**
  - BFS consistently uses a significant amount of memory.
  - IDS maintains better memory efficiency compared to BFS.
  - A* and UC tend to use higher memory due to their exploration strategies based on path cost and heuristic values.

## Algorithm Descriptions

Here's a brief explanation of the completeness and optimality of the algorithms:

1. **Depth-First Search (DFS)**: DFS is not complete in infinite state spaces or in spaces with loops. It is also not optimal as it does not guarantee that the solution found is the best one.

2. **Breadth-First Search (BFS)**: BFS is complete, meaning it will find a solution if one exists. It is also optimal as long as the costs of all edges are equal.

3. **Iterative Deepening Depth-First Search (IDS)**: IDS is complete in finite state spaces. It is also optimal, meaning it finds the shallowest goal.

4. **Uniform Cost Search (UCS)**: UCS is complete and optimal. It explores options in every direction and does not have any information about the goal location.

5. **Greedy Best-First Search (GR1 and GR2)**: The completeness and optimality of these algorithms depend on the heuristic used. If the heuristic is admissible and consistent, the algorithm is both complete and optimal.

6. **A\* Search (AS1 and AS2)**: A* is complete and optimal if the heuristic used is admissible (never overestimates the cost) and consistent (the estimated cost from node n to the goal is no greater than the cost from n to any successor node n', plus the cost from n' to the goal).

Please note that the performance of these algorithms can vary depending on the specific problem and conditions. For example, while BFS is optimal for problems with equal step costs, it may not be the best choice for problems with varying step costs, where UCS might perform better. Similarly, while DFS is not complete in general, it can be complete in problems without loops or with a finite state space. These differences highlight the trade-offs between the different search strategies in terms of resource usage and search efficiency.

