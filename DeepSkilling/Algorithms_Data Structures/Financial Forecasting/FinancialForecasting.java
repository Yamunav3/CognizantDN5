import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* ================================================================
 *  Exercise 7: Financial Forecasting — Recursive Approach
 * ================================================================
 *
 *  STEP 1: UNDERSTANDING RECURSION
 *  --------------------------------
 *  Recursion is a technique where a method solves a problem by
 *  calling itself with a smaller version of that same problem,
 *  until it reaches a "base case" simple enough to answer directly.
 *
 *  Every recursive method needs two parts:
 *    1. Base case     - the condition that stops the recursion
 *    2. Recursive step - the call that moves toward the base case
 *
 *  Recursion simplifies this problem because compound growth is
 *  naturally self-similar: the value after n years is just the
 *  value after (n-1) years, grown by one more period. Writing the
 *  code this way mirrors the math directly:
 *
 *      FV(n) = FV(n-1) * (1 + growthRate)     [recursive step]
 *      FV(0) = presentValue                    [base case]
 *
 *  which is equivalent to the standard closed-form formula:
 *
 *      FV(n) = PV * (1 + r)^n
 * ================================================================
 */
public class FinancialForecasting {

    // ----------------------------------------------------------
    // STEP 2 & 3: RECURSIVE METHOD TO CALCULATE FUTURE VALUE
    // ----------------------------------------------------------
    // Predicts the future value of an investment based on a past
    // growth rate, using straightforward recursion.
    //
    // Time complexity: O(n) — one recursive call per period
    // Space complexity: O(n) — each call waits on the call stack
    // until the base case returns
    public static double futureValueRecursive(double presentValue,
            double growthRate,
            int periods) {
        if (periods < 0)
            throw new IllegalArgumentException("Periods must be >= 0");

        // Base case: no time has passed, value is unchanged
        if (periods == 0)
            return presentValue;

        // Recursive step: get the value one period earlier,
        // then compound it by one more period
        return futureValueRecursive(presentValue, growthRate, periods - 1)
                * (1 + growthRate);
    }

    // ----------------------------------------------------------
    // STEP 4 (OPTIMIZATION): MEMOIZED RECURSIVE VERSION
    // ----------------------------------------------------------
    // The naive recursive method above recalculates every value
    // from scratch on every call. If the same forecast is queried
    // repeatedly (e.g. building a multi-year table), that's wasted
    // computation. Memoization fixes this by caching each result
    // the first time it's computed, so later calls for the same
    // "periods" value return instantly instead of recursing again.
    //
    // Time complexity: O(n) the first time; O(1) on repeat lookups
    // Space complexity: O(n) — one cache entry per distinct period
    private static Map<Integer, Double> memo = new HashMap<>();

    public static double futureValueMemo(double presentValue,
            double growthRate,
            int periods) {
        if (periods == 0)
            return presentValue;

        if (memo.containsKey(periods))
            return memo.get(periods); // cache hit — skip recursion

        double result = futureValueMemo(presentValue, growthRate, periods - 1)
                * (1 + growthRate);
        memo.put(periods, result); // store for future reuse
        return result;
    }

    // ----------------------------------------------------------
    // BONUS: ITERATIVE VERSION (further optimization)
    // ----------------------------------------------------------
    // Removes recursion entirely, so there's no call-stack growth
    // at all — useful for very large numbers of periods where even
    // memoized recursion could risk a StackOverflowError.
    //
    // Time complexity: O(n)
    // Space complexity: O(1)
    public static double futureValueIterative(double presentValue,
            double growthRate,
            int periods) {
        double value = presentValue;
        for (int i = 0; i < periods; i++) {
            value *= (1 + growthRate);
        }
        return value;
    }

    // ----------------------------------------------------------
    // Demo / Driver
    // ----------------------------------------------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Initial Investment: ");
        double initialInvestment = sc.nextDouble();

        System.out.print("Enter Annual Growth Rate (%): ");
        double annualGrowthRate = sc.nextDouble() / 100;

        System.out.print("Enter Number of Years: ");
        int years = sc.nextInt();

        sc.close();

        System.out.println("\n=== Financial Forecasting Demo ===");
        System.out.printf("  Initial Investment : $%.2f%n", initialInvestment);
        System.out.printf("  Annual Growth Rate : %.1f%%%n%n", annualGrowthRate * 100);

        // --- Forecast Table -----------------------------------
        System.out.println("  Year | Recursive        | Memoized         | Iterative");
        System.out.println("  -----|------------------|------------------|------------------");

        memo.clear(); // clear ONCE before the loop so the cache builds up across years
        for (int year = 0; year <= years; year++) {
            double rv = futureValueRecursive(initialInvestment, annualGrowthRate, year);
            double mv = futureValueMemo(initialInvestment, annualGrowthRate, year);
            double iv = futureValueIterative(initialInvestment, annualGrowthRate, year);
            System.out.printf("  %-4d | $%,14.2f   | $%,14.2f   | $%,14.2f%n",
                    year, rv, mv, iv);
        }

        // --- Complexity & Optimization Summary ----------------
        System.out.println("\n=== Time-Complexity Summary ===");
        System.out.println("  Approach          | Time   | Space  | Notes");
        System.out.println("  ------------------|--------|--------|-----------------------------");
        System.out.println("  Naive Recursive   | O(n)   | O(n)   | Stack overflow risk for n>~10k");
        System.out.println("  Memoized Recursive| O(n)   | O(n)   | Safe; skips duplicate calls");
        System.out.println("  Iterative         | O(n)   | O(1)   | Best for large n in production");
    }
}