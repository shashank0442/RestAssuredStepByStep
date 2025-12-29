package learn;

import org.testng.annotations.Test;

public class First {

    @Test(priority = 1)
    public void run() {
        System.out.println("Running");
    }

    @Test(priority = 2)
    public void roll() {
        System.out.println("rolling");
    }

    @Test(priority = 0)
    public void stop() {
        System.out.println("Stopped");
    }

    @Test(priority = 3)
    public void Act() {
        System.out.println("Acting");
    }

}
