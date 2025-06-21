
interface PaymentProcessor {
    void processPayment(double amount);
}


class PayPalGateway {
    public void makePayment(double amount) {
        System.out.println("Payment of $" + amount + " processed using PayPal.");
    }
}


class StripeGateway {
    public void pay(double amount) {
        System.out.println("Payment of $" + amount + " processed using Stripe.");
    }
}


class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway payPal;

    public PayPalAdapter(PayPalGateway payPal) {
        this.payPal = payPal;
    }

    @Override
    public void processPayment(double amount) {
        payPal.makePayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripe;

    public StripeAdapter(StripeGateway stripe) {
        this.stripe = stripe;
    }

    @Override
    public void processPayment(double amount) {
        stripe.pay(amount);
    }
}

public class AdapterPatternExample {
    public static void main(String[] args) {
        
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPalGateway());
        paypalProcessor.processPayment(100.50);

        
        PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());
        stripeProcessor.processPayment(250.75);
    }
}
