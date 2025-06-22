
output:
Recursive Future Value after 10 years: $1,967.15 (Time: 24500 ns)
Memoized Recursive Future Value: $1,967.15 (Time: 12300 ns)
Iterative Future Value: $1,967.15 (Time: 8500 ns)

--- Recursion Concepts ---
What is Recursion?
- A method that calls itself to solve smaller instances of the same problem
- Consists of:
  1. Base case: simple case that stops the recursion
  2. Recursive case: breaks problem into smaller subproblems

--- Algorithm Analysis ---
Basic Recursive Solution:
- Time Complexity: O(n) where n is number of periods
- Space Complexity: O(n) due to call stack
- Potential Issues: Stack overflow for large n, redundant calculations

--- Optimization Strategies ---
1. Memoization:
- Cache previously computed results to avoid redundant calculations
- Particularly useful when recursive calls overlap
