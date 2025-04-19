public class Dolphin extends Animal implements Swim{

    private String color;
    private int swimmingSpeed;

    public Dolphin(){
        super("Dolphin");
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public int getSwimmingSpeed() {
        return swimmingSpeed;
    }

    public void setSwimmingSpeed(int swimmingSpeed) {
        this.swimmingSpeed = swimmingSpeed;
    }

    @Override
    public void eatingFood() {
        //super.eatingFood();
        System.out.println("Dolphin: I am eating delicious fish");
    }

    @Override
    public void eatingCompleted() {
       System.out.println("I have eaten fish");
    }
    
    @Override
    public void swimming() {
       System.out.println("Dolphin: I am swimming at the speed of "+swimmingSpeed+" nautical miles per hour");
    }
}
