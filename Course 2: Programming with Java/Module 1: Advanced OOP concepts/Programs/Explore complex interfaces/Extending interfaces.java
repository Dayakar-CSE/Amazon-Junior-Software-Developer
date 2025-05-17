interface ActionController {
    void start();
    void pause();
    void stop();
}

interface ValueController {
    void increase(int value);
    void decrease(int value);
}

interface MediaController extends ActionController, ValueController {

}

class MediaPlayer implements MediaController {

    public void start() {
        System.out.println("Player has started");
    }

    public void pause() {
        System.out.println("player paused");
    }

    public void stop() {
        System.out.println("player stopped");
    }

    public void increase(int value) {
        System.out.println("volume level increased to "+value+"");
    }

    public void decrease(int value) {
        System.out.println("volume level decreased to "+value+"");
    }

}
public class Main {
    public static void main(String[] args) {
        MediaPlayer player=new MediaPlayer();
        player.start();
        player.pause();
        player.increase(50);
        player.decrease(30);
    }
}
