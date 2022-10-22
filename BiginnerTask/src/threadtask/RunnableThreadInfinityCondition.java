package threadtask;

import java.util.logging.Logger;

public class RunnableThreadInfinityCondition  implements Runnable{
private boolean state;
Logger logger=Logger.getLogger(RunnableThreadInfinityCondition.class.getName());

public RunnableThreadInfinityCondition(boolean state) {
	this.state=state;
}
	public void run() {
        		while(state) {
        			logger.info("Runnable Thread Running......");
        			try {
						Thread.sleep(20000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
        		}//end of while
        		logger.info(Thread.currentThread().getName()+" is stop");
	}//end of run
	public void changeState() {
		state=false;
	}
	
}
