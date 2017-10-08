# Local Search Comparison
Lab for local searches impl

## Repeated local search
1. randomly choose starting point;
2. if condition met, save solution and rerun from step 1.

### Current Best Result:
#### tai20a
Solution: `[1, 6, 2, 3, 19, 8, 12, 18, 13, 10, 16, 15, 14, 11, 7, 9, 17, 0, 4, 5]`  
Value: `782952`

#### tai80a
Solution: `[59, 66, 77, 50, 51, 44, 75, 20, 5, 27, 57, 36, 14, 3, 17, 38, 34, 79, 29, 30, 15, 18, 73, 9, 22, 1, 33, 42, 13, 62, 67, 47, 21, 4, 71, 11, 54, 35, 56, 64, 25, 19, 43, 63, 48, 74, 72, 78, 65, 24, 52, 37, 0, 28, 70, 76, 31, 6, 7, 10, 68, 8, 26, 16, 23, 53, 61, 69, 40, 46, 58, 2, 45, 55, 39, 49, 60, 32, 12, 41]`  
Value: `15145328`

#### tai100a
Solution: `[31, 98, 64, 58, 42, 5, 40, 84, 34, 35, 23, 55, 82, 9, 1, 81, 75, 59, 11, 2, 48, 14, 7, 32, 44, 4, 69, 88, 39, 37, 29, 56, 63, 52, 25, 90, 6, 53, 91, 86, 57, 33, 95, 87, 47, 92, 22, 24, 46, 83, 67, 8, 45, 72, 27, 99, 85, 38, 73, 19, 13, 20, 3, 12, 66, 93, 28, 79, 30, 80, 51, 43, 61, 71, 17, 16, 96, 62, 10, 0, 26, 74, 18, 21, 65, 49, 60, 78, 89, 70, 50, 68, 97, 54, 41, 15, 76, 94, 36, 77]`  
Value: `23582306`

## Iterated Local Search
1. start with greedy solution.
2. while condition not met: 
    1. find best local solution;
    2. perturb best local solution;

### Current Best Result:
#### tai20a
Solution: `[15, 10, 11, 7, 3, 9, 18, 16, 13, 19, 1, 12, 2, 17, 14, 0, 6, 5, 4, 8]`
Value: `760740`
    
    
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
### Current Best Result:
#### tai20a
Solution: `[0, 1, 11, 3, 4, 5, 13, 19, 8, 9, 17, 15, 12, 6, 10, 18, 16, 7, 2, 14]`  
Value: `757400`

#### tai40a
Solution: `[23, 1, 4, 3, 2, 37, 9, 5, 8, 11, 16, 36, 12, 13, 35, 20, 10, 17, 18, 19, 15, 34, 22, 0, 14, 21, 26, 27, 28, 29, 30, 24, 32, 33, 6, 25, 31, 7, 38, 39]`  
Value: `3386346`

#### tai60a
Solution: `[0, 24, 2, 3, 11, 23, 6, 7, 8, 9, 58, 18, 12, 54, 14, 15, 16, 46, 21, 57, 32, 50, 22, 5, 1, 34, 52, 27, 4, 47, 30, 19, 28, 33, 31, 35, 38, 36, 37, 39, 40, 41, 42, 43, 44, 20, 17, 29, 48, 49, 13, 51, 26, 53, 25, 55, 56, 45, 10, 59]`  
Value: `7805588`

#### tai80a
Solution: `[54, 6, 2, 75, 4, 5, 3, 12, 8, 70, 71, 73, 7, 13, 14, 15, 17, 72, 18, 45, 20, 21, 22, 23, 24, 66, 67, 27, 33, 29, 30, 32, 26, 10, 34, 40, 36, 37, 38, 39, 52, 41, 42, 47, 31, 65, 79, 74, 48, 49, 50, 51, 60, 53, 19, 55, 35, 58, 16, 59, 56, 61, 62, 63, 43, 64, 25, 44, 68, 69, 9, 28, 11, 57, 0, 1, 76, 77, 78, 46]`  
Value: `14475326`

---
### Best Results: 
`https://books.google.ru/books?id=ZCu7BQAAQBAJ&pg=PA34&lpg=PA34&dq=tai20a+result&source=bl&ots=q_6tEmUoML&sig=H6st6LU13rwYhVhXH_jkfbPUymE&hl=ru&sa=X&ved=0ahUKEwjuw52V7dzWAhXqKJoKHTOtCWUQ6AEIMzAC#v=onepage&q=tai20a%20result&f=false`