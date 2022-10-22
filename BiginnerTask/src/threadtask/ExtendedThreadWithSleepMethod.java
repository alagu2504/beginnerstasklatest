package threadtask;

import java.util.logging.Logger;

public class ExtendedThreadWithSleepMethod extends Thread {
	Logger logger=Logger.getLogger(ExtendedThreadWithSleepMethod.class.getName());
	
public void run() {
	logger.info("Going to sleep:  "+Thread.currentThread().getName());
	try {
		Thread.sleep(60000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	logger.info("After sleeping:  "+Thread.currentThread().getName());
}	
}
