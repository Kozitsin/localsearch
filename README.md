# Local Search Comparison
Labs for local searches impl

## Repeated local search
1. randomly choose starting point;
2. if condition met, save solution and rerun from step 1.

### Current Best Result:
#### tai20a
Solution: `[14, 7, 15, 8, 19, 0, 3, 17, 10, 2, 4, 18, 5, 6, 1, 12, 16, 9, 11, 13]`  
Value: `784998`


## Iterated Local Search
1. start with greedy solution.
2. while condition not met: 
    1. find best local solution;
    2. perturb best local solution;
    
    
## Guided Local Search
1. build initial Solution with shuffle;
2. initialize Penalties;
3. while condition not met:
    1. calculate augmented objective function as: h = f(x) + \lambda * \sum p_i * I_i;   
       where h is augmented function, f(x) - cost function, \lambda - metaheuristic parameter, p_i - penalty for i-feature, I_i - indicator, if i-feature exists or not.
    2. run local search, based on previous solution;
    3. calculate utility for each feature as: util_i = I_i * c_i / (1 + p_i);  
       where c_i - cost of feature i in objective function.
    4. increase penalty for feature with maximum utility;