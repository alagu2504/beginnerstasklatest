package threadtask;

import java.util.logging.Logger;

public class ExtendedThreadInfinityCondition extends Thread{
	private boolean state;
	Logger logger=Logger.getLogger(ExtendedThreadInfinityCondition.class.getName());
	public ExtendedThreadInfinityCondition(boolean state) {
		this.state=state;
	}
		public void run() {
	        		while(state) {
	        			logger.info("Extended Thread Running....");
	        			try {
							Thread.sleep(20000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
	        		}//end of while	
	        		logger.info(Thread.currentThread().getName()+" is stop");
		}
		public void changeState() {
			state=false;
		}
}
