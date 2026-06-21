public class AdapterPatternTest {

    public static void main(String[] args) {

        PaymentProcessor paytm = new PaytmAdapter();

        PaymentProcessor razorpay = new RazorpayAdapter();

        paytm.processPayment(1000);
        razorpay.processPayment(2500);
    }
}