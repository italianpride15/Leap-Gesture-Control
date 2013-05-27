
import java.io.IOException;
import com.leapmotion.leap.*;

public class LeapGestureControl {
	 public static void main(String[] args) {
	        // Create a gesture listener and controller
	        GestureListener listener = new GestureListener();
	        Controller controller = new Controller();

	        // Have the gesture listener receive events from the controller
	        controller.addListener(listener);

	        // Keep this process running until Enter is pressed
	        System.out.println("Press Enter to quit...");
	        try {
	            System.in.read();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        // Remove the gesture listener when done
	        controller.removeListener(listener);
	    }
}
