
import java.io.IOException;
import java.lang.Math;
import com.leapmotion.leap.*;
import com.leapmotion.leap.Gesture.State;

public class GestureListener extends Listener{
	
Boolean swipeRight = false;
Boolean swipeLeft = false;
Boolean handUp = false;
Boolean handDown = false;
double currVolume = 3;

	public void onInit(Controller controller) {
        System.out.println("Initialized");
    }

    public void onConnect(Controller controller) {
        System.out.println("Connected");
        controller.enableGesture(Gesture.Type.TYPE_SWIPE);
        controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
        controller.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);
        controller.enableGesture(Gesture.Type.TYPE_KEY_TAP);
    }

    public void onDisconnect(Controller controller) {
        //Note: not dispatched when running in a debugger.
        System.out.println("Disconnected");
    }

    public void onExit(Controller controller) {
        System.out.println("Exited");
    }

    public void onFrame(Controller controller) {
    	
        Frame frame = controller.frame();
    	GestureList gestures = frame.gestures();
        //for (int i = 0; i < gestures.count(); i++) {
        Gesture gesture = gestures.get(0);
		GestureAction action = new GestureAction();
        	
            switch (gesture.type()) {
            	
            	case TYPE_SWIPE:
            		SwipeGesture swipe = new SwipeGesture(gesture);	
            		Vector direction = swipe.direction();
            		
            		/* Potentially abstract this process to just sending data to GestureAction
            		 * class and allowing that class to select correct action
            		 */
            		
            		if (direction.getX() > 0) {
            			action.increaseBrightness(); //send speed
            		}
            		if (direction.getX() < 0) {
            			action.decreaseBrightness(); //send speed
            		}
            		break;
            		
                case TYPE_CIRCLE:
                    CircleGesture circle = new CircleGesture(gesture);
                	/* Potentially abstract this process to just sending data to GestureAction
            		 * class and allowing that class to select correct action
            		 */
                    
                    // Calculate clock direction using the angle between circle normal and pointable
                    if (circle.pointable().direction().angleTo(circle.normal()) <= Math.PI/4) {
                        // Clockwise if angle is less than 90 degrees
                    	currVolume = action.increaseVolume(currVolume); //send speed
                    } else {
                    	//else counterclockwise
                    	currVolume = action.decreaseVolume(currVolume); //send speed
                    }                   
                    break;
                   
                case TYPE_SCREEN_TAP:
                    ScreenTapGesture screenTap = new ScreenTapGesture(gesture);
                    System.out.println("ST");
                    action.intoExpose();
                    break;
                    
                case TYPE_KEY_TAP:
                    KeyTapGesture keyTap = new KeyTapGesture(gesture);
                    System.out.println("KT");
                    action.intoLaunchpad();
                    break;
                default:
                    //System.out.println("Unknown gesture type.");
                    break;
            }
        //}
    }

}
