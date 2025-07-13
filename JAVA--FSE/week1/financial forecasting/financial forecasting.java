public class FinancialForecasting {

    public static double calculateFutureValue(double currentValue, double growthRate, int periods) {
       
        if (periods == 0) {
            return currentValue;
        }
        
    
        double nextValue = currentValue * (1 + growthRate);
        return calculateFutureValue(nextValue, growthRate, periods - 1);
    }

 
    public static double calculateFutureValueMemoized(double currentValue, double growthRate, int periods) {
       
        double[] memo = new double[periods + 1];
        memo[0] = currentValue; // Base case
        
        return futureValueHelper(currentValue, growthRate, periods, memo);
    }
    
    private static double futureValueHelper(double currentValue, double growthRate, int periods, double[] memo) {
   
        if (memo[periods] != 0) {
            return memo[periods];
        }
        
  
        memo[periods] = currentValue * Math.pow(1 + growthRate, periods);
        return memo[periods];
    }


    public static double calculateFutureValueIterative(double currentValue, double growthRate, int periods) {
        for (int i = 0; i < periods; i++) {
            currentValue *= (1 + growthRate);
        }
        return currentValue;
    }

    public static void main(String[] args) {
        double initialInvestment = 1000.0; // $1000 initial investment
        double annualGrowthRate = 0.07;    // 7% annual growth
        int years = 10;                   // 10 year projection
        
  
        long startTime = System.nanoTime();
        double futureValue = calculateFutureValue(initialInvestment, annualGrowthRate, years);
        long endTime = System.nanoTime();
        System.out.printf("Recursive Future Value after %d years: $%,.2f (Time: %d ns)\n", 
                years, futureValue, endTime - startTime);
        
      
        startTime = System.nanoTime();
        double memoizedValue = calculateFutureValueMemoized(initialInvestment, annualGrowthRate, years);
        endTime = System.nanoTime();
        System.out.printf("Memoized Recursive Future Value: $%,.2f (Time: %d ns)\n", 
                memoizedValue, endTime - startTime);
        
        startTime = System.nanoTime();
        double iterativeValue = calculateFutureValueIterative(initialInvestment, annualGrowthRate, years);
        endTime = System.nanoTime();
        System.out.printf("Iterative Future Value: $%,.2f (Time: %d ns)\n", 
                iterativeValue, endTime - startTime);
      
        System.out.println("\n--- Recursion Concepts ---");
        System.out.println("What is Recursion?");
        System.out.println("- A method that calls itself to solve smaller instances of the same problem");
        System.out.println("- Consists of:");
        System.out.println("  1. Base case: simple case that stops the recursion");
        System.out.println("  2. Recursive case: breaks problem into smaller subproblems");
        
        System.out.println("\nHow Recursion Simplifies Financial Forecasting:");
        System.out.println("- Naturally models compounding growth (each period builds on previous)");
        System.out.println("- Mathematically elegant representation of the problem");
        System.out.println("- Can be more intuitive than iterative solutions for certain problems");
        

        System.out.println("\n--- Algorithm Analysis ---");
        System.out.println("Basic Recursive Solution:");
        System.out.println("- Time Complexity: O(n) where n is number of periods");
        System.out.println("- Space Complexity: O(n) due to call stack");
        System.out.println("- Potential Issues: Stack overflow for large n, redundant calculations");
        
        System.out.println("\nOptimized Recursive Solution (Memoization):");
        System.out.println("- Time Complexity: O(n) but with reduced constant factors");
        System.out.println("- Space Complexity: O(n) for memoization table");
        System.out.println("- Benefits: Avoids redundant calculations, faster execution");
        
        System.out.println("\nIterative Solution:");
        System.out.println("- Time Complexity: O(n)");
        System.out.println("- Space Complexity: O(1)");
        System.out.println("- Benefits: No stack overflow risk, often most efficient");
        
        // Optimization techniques
        System.out.println("\n--- Optimization Strategies ---");
        System.out.println("1. Memoization:");
        System.out.println("- Cache previously computed results to avoid redundant calculations");
        System.out.println("- Particularly useful when recursive calls overlap");
        
        System.out.println("\n2. Convert to Iterative:");
        System.out.println("- Use loops instead of recursion to avoid stack overhead");
        System.out.println("- Often more memory efficient");
        
        System.out.println("\n3. Tail Recursion Optimization:");
        System.out.println("- Structure recursion so the recursive call is the last operation");
        System.out.println("- Some compilers can optimize this to iterative code");
        
        System.out.println("\n4. Mathematical Optimization:");
        System.out.println("- For financial forecasting, use the formula FV = PV*(1+r)^n");
        System.out.println("- Achieves O(1) time complexity with Math.pow()");
        
        // When to use recursion
        System.out.println("\nWhen to Use Recursion:");
        System.out.println("- When the problem naturally breaks into similar subproblems");
        System.out.println("- When the recursive solution is more intuitive/readable");
        System.out.println("- For tree/graph traversals, divide-and-conquer algorithms");
        
        System.out.println("\nWhen to Avoid Recursion:");
        System.out.println("- When iterative solution is straightforward and efficient");
        System.out.println("- For very large input sizes (risk of stack overflow)");
        System.out.println("- When performance is absolutely critical");
    }
}
