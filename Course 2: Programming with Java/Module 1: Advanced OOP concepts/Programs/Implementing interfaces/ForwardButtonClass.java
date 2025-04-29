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

class ForwardButtonClass extends AbstractButtonClass implements ButtonPress {
    String forwardTo;
    String message;

    @Override
    public void buttonPress() {
        System.out.println("Forwarding " + this.message
                + " to " + this.forwardTo);
    }

    public void setForwardTo(String forwardTo) {
        this.forwardTo = forwardTo;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

public class Main {
    public static void main(String[] args) {
        ForwardButtonClass forwardButton = new ForwardButtonClass();
        forwardButton.SetCaption("Forward");
        forwardButton.setForwardTo("x@y.com");
        forwardButton.setMessage("Hello World");
        forwardButton.buttonPress();
    }
}
