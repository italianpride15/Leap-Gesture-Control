import java.io.IOException;


public class GestureAction {
	
	public void increaseBrightness() {
		try {
			String[] cmd = {"osascript", "-e", "tell application \"System Events\"", "-e", "key code 113", "-e", "end tell"};
	        Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void decreaseBrightness() {
		try {
			String[] cmd = {"osascript", "-e", "tell application \"System Events\"", "-e", "key code 107", "-e", "end tell"};
	        Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//volume is kinda sketchy
	public double increaseVolume(double currVolume) {
		double volume = (currVolume + 0.3);
		if (volume > 7) {
			volume = 7;
		}
		try {
			String v = "set volume " + Double.toString(volume);
			String[] cmd = {"osascript", "-e", v};
	        Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			e.printStackTrace();
		}
        return volume;
	}

	public double decreaseVolume(double currVolume) {
		double volume = (currVolume - 0.3);
		if (volume < 0) {
			volume = 0;
		}
		try {
			String v = "set volume " + Double.toString(volume);		
			String[] cmd = {"osascript", "-e", v};
	        Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			e.printStackTrace();
		}
        return volume;
	}
	
	public void intoExpose() {
		try {
			String[] cmd = {"osascript", "-e", "tell application \"System Events\"", "-e", "key code 130", "-e", "end tell"};
	        Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void intoLaunchpad() {
		try {
			String[] cmd = {"osascript", "-e", "tell application \"System Events\"", "-e", "key code 160", "-e", "end tell"};
	        Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
