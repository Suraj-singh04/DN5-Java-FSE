public class ForecastTest {

    public static void main(String[] args) {

        double currentValue = 10000;

        double growthRate = 0.10;

        int years = 3;

        double result =
                FinancialForecast.futureValue(
                        currentValue,
                        growthRate,
                        years
                );

        System.out.printf(
                "Future Value = %.2f%n",
                result
        );
    }
}