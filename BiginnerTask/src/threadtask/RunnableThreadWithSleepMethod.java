package threadtask;

import java.util.logging.Logger;

public class RunnableThreadWithSleepMethod implements Runnable {
	Logger logger=Logger.getLogger(RunnableThreadWithSleepMethod.class.getName());

	public void run() {
		logger.info("Going to sleep:  "+Thread.currentThread().getName());
		try {
			Thread.sleep(45000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("After sleeping:  "+Thread.currentThread().getName());
	}

}
