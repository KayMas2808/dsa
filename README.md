# dsa

# 2 pointers
## same direction
## opposite directions

# sliding window
## start and end pointer

### substring, max substring something -> think 2 pointer, sliding windows

# binary search
## o(logn), only on sorted lists though

# trees and graphs

## bfs - queue, for shortest paths
## dfs - stack, for exploring all paths
### backtracking - dfs extensions

## priority queue - heaps o(logn) instertion, o(1) access
### min heap - parent less than children (find k largest values)
### max heap - parent more than children (find k smallest values)

## DP
### bottom up
### top down - backtracking with memoization

![alt text](image.png)
![alt text](image-1.png)

## 1. read question twice
## 2. rough, brute force idea
## 3. hand draw/wrtie

# SORTINGS
 ## 1. Selection sort - get minimum and swap.
 ## 2. Bubble sort - push max to end using adjacent swapping.
 ## 3. Insertion sort - take element and put it in correct position.
 ## 4. Merge sort - divide-sort-merge
 ### a. Divide array into left and right using mid
 ### b. Merge left and right
 ## 5. Quick sort - pick pivot - all to left of pivot smaller than it, right ones larger.
 ### a. take first elt as pivot
 ### b. while (left pt < right pt){
 #### b. find first elt on left that is greater than pivot
 #### c. find first elt on right that is lesser than pivot
 #### d. swap these 2.
 ### e. }
