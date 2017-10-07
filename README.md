# Local Search Comparison
Lab for local searches impl

## Repeated local search
1. randomly choose starting point;
2. if condition met, save solution and rerun from step 1.

### Current Best Result:
#### tai20a
Solution: `[1, 6, 2, 3, 19, 8, 12, 18, 13, 10, 16, 15, 14, 11, 7, 9, 17, 0, 4, 5]`  
Value: `782952`


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

Note: we assume, that feature i means, that at place i we put i factory.
So it's cost might be calculated as follows:  
`
    for (int j = 0; j < n; j++) {  
        costOfFeatureI += p.distance[i][j] * p.flow[location[i]][location[j]];  
    }  
`  