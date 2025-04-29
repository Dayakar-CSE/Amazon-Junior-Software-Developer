abstract class AbstractButtonClass {
    String caption;

    public void SetCaption(String caption) {
        this.caption = caption;
    }

    public String getCaption() {
        return this.caption;
    }
}

interface ButtonPress {
    void buttonPress();
}

class SendButtonClass extends AbstractButtonClass implements ButtonPress {
    String sendTo;
    String message;

    @Override
    public void buttonPress() {
        System.out.println("Sending " + this.message
                + " to " + this.sendTo);
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

public class Main {
    public static void main(String[] args) {
        SendButtonClass sendButton = new SendButtonClass();
        sendButton.SetCaption("Send");
        sendButton.setSendTo("a@b.com");
        sendButton.setMessage("This is a test message");
        sendButton.buttonPress();
    }
}
