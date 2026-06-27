public class StrategyPatternTest {
    public static void main(String[] args) {
        PaymentStrategy creditCardPayment = new CreditCardPayment();

        PaymentContext context = new PaymentContext(creditCardPayment);

        context.executePayment(5000);

        PaymentStrategy payPalPayment = new PayPalPayment();

        context = new PaymentContext(payPalPayment);
        
        context.executePayment(4599);
    }
}