public class CurrencyConversion {
    public static void main(String args[]) {

       // TODO  your code here
       // Initial amount in USD
        double amountInUSD = 100.0;
        double exchangeRateUSDToEUR = 0.85; // 1 USD = 0.85 EUR

        System.out.println("Initial amount in USD: " + amountInUSD);

        // Convert USD to EUR
        amountInUSD *= exchangeRateUSDToEUR; // Equivalent to amountInUSD = amountInUSD * exchangeRateUSDToEUR;
        System.out.println("Amount in EUR after conversion: " + amountInUSD);

        // Expenditure of 55 EURO
        amountInUSD -= 55;
        System.out.println("Amount in EUR after expenditure: " + amountInUSD);

        // Convert EUR back to USD
        amountInUSD /= exchangeRateUSDToEUR; // Equivalent to amountInUSD = amountInUSD / exchangeRateEURToUSD;
        System.out.printf("Amount in USD after converting back: %.2f", amountInUSD);
        
    }
}
