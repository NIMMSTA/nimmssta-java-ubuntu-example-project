package demo.nimmsta.core;
import com.nimmsta.core.jvm.framework.ConnectionManager;
import com.nimmsta.core.shared.device.NIMMSTADevice;
import com.nimmsta.core.shared.device.NIMMSTAEventHandler;

@FunctionalInterface
interface QRDisplay {
	void run();
}

public class Connection {

	private ConnectionManager manager;

	public Connection() {
		manager = new ConnectionManager();
	}

	void addEvent(NIMMSTAEventHandler event) {
		manager.startReceivingEvents(event);
	}

	void removeEvent(NIMMSTAEventHandler event) {
		manager.stopReceivingEvents(event);
	}

	private QRDisplay display = () -> manager.displayConnectionActivity(false);

	public void startEvent(DemoEventHandler event) {
		this.addEvent(event);
		display.run();
	}

	public void close() {
		manager.close();
	}
}

