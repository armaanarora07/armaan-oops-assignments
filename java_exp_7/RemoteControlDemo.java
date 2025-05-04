// Interface Remote
interface Remote {
    void powerOn();
    void powerOff();
    void changeChannel(int channel);
}

// Concrete class Television
class Television implements Remote {
    @Override
    public void powerOn() {
        System.out.println("TV is now on");
    }

    @Override
    public void powerOff() {
        System.out.println("TV is off");
    }

    @Override
    public void changeChannel(int channel) {
        System.out.println("Channel changed to " + channel);
    }
}

// Main class
public class RemoteControlDemo {
    public static void main(String[] args) {
        Remote tv = new Television();
        tv.powerOn();
        tv.changeChannel(10);
        tv.powerOff();
    }
}
