# Local Search Comparison
Labs for local searches impl

## Repeated local search
1. Randomly choose starting point;
2. if condition met, save solution and rerun from step 1.

### Current Best Result:
Solution: `[14, 7, 15, 8, 19, 0, 3, 17, 10, 2, 4, 18, 5, 6, 1, 12, 16, 9, 11, 13]`  
Value: `784998`


## Iterated Local Search
1. Start with greedy solution.
2. while condition not met: 
    1. find best local solution;
    2. perturb best local solution;