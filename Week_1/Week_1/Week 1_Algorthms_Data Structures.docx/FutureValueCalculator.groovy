public class FutureValueCalculator {

    /**
     * Calculates the future value using a recursive approach.
     * 
     * @param presentValue the present value
     * @param growthRate   the growth rate
     * @param years        the number of years
     * @return the future value
     */
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        // Base case: if there are no more years, return the present value
        if (years == 0) {
            return presentValue;
        } else {
            // Recursive case: calculate the future value for the next year
            // and then call the method again with the updated present value
            // and the remaining years
            double nextYearValue = presentValue * (1 + growthRate);
            return calculateFutureValue(nextYearValue, growthRate, years - 1);
        }
    }

    public static void main(String[] args) {
        double presentValue = 1000; // initial investment
        double growthRate = 0.05; // 5% annual growth rate
        int years = 10; // number of years

        double futureValue = calculateFutureValue(presentValue, growthRate, years);
        System.out.println("Future value after " + years + " years: " + futureValue);
    }
}