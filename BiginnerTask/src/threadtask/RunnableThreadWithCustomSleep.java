package threadtask;

import java.util.logging.Logger;

public class RunnableThreadWithCustomSleep implements Runnable{
	Logger logger=Logger.getLogger(RunnableThreadWithCustomSleep.class.getName());
	private int time;
	public RunnableThreadWithCustomSleep(int time) {
		this.time=time;
	}
	public void run() {
		logger.info("Going to sleep:  "+Thread.currentThread().getName());
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("After sleeping:  "+Thread.currentThread().getName());
	}
}
