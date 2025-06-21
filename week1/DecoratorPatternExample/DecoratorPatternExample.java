
interface Notifier {
    void send(String message);
}


class EmailNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    public void send(String message) {
        wrappedNotifier.send(message);
    }
}


class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        System.out.println("Sending SMS: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        System.out.println("Sending Slack Message: " + message);
    }
}

public class DecoratorPatternExample {
    public static void main(String[] args) {
        Notifier baseNotifier = new EmailNotifier();

    
        Notifier smsNotifier = new SMSNotifierDecorator(baseNotifier);

        
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        
        slackNotifier.send("Project deadline at 5 PM");
    }
}
