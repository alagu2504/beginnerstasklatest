package threadtask;
import java.util.Scanner;
import java.util.logging.Logger;
public class ThreadRunner {
	public  void printThread(Thread thread,Logger logger) {
		logger.info("-----------------------------------------------------------");
		logger.info("Thread Name before calling start() :"+thread.getName());
		logger.info("priority before calling start() :"+thread.getPriority());
		logger.info("state of the thread before calling start(): "+thread.getState());
	}
	
public static void main(String args[]) throws InterruptedException {
	Logger logger=Logger.getLogger(ThreadRunner.class.getName());
	boolean state=true;
	ThreadRunner threadRunnerObject=new ThreadRunner();
	try(Scanner sc=new Scanner(System.in)){
		while(state) {
			logger.info("-----------------------------------------------------------");
			System.out.println("Enter the caseNo :");
			int caseNo=sc.nextInt();
			if(caseNo!=8) {
				switch(caseNo){
				case 1:{
					Thread thread=new ExtendedThread();
					threadRunnerObject.printThread(thread,logger);
					thread.start();
					thread.join();
					threadRunnerObject.printThread(thread,logger);
					break;
				}
				case 2:{
					Runnable runnableObject=new RunnableThread();
					Thread thread=new Thread(runnableObject);
					threadRunnerObject.printThread(thread,logger);
					thread.start();
					thread.join();
					threadRunnerObject.printThread(thread,logger);
					break;
				}
				case 3:{
					Thread thread=new ExtendedThread();
					thread.setName("ExtendedThread"); 
					threadRunnerObject.printThread(thread,logger);
					thread.start();
					thread.join();
					threadRunnerObject.printThread(thread,logger);
					Runnable runnableObject=new RunnableThread();
					Thread runnableThread=new Thread(runnableObject);
					runnableThread.setName("RunnableThread");
					threadRunnerObject.printThread(runnableThread,logger);
					runnableThread.start();
					runnableThread.join();
					threadRunnerObject.printThread(runnableThread,logger);
					break;
				}
				case 4:{
					Thread thread1=new ExtendedThreadWithSleepMethod();
					thread1.setName("customThread1"); 
					Thread thread2=new ExtendedThreadWithSleepMethod();
					thread2.setName("customThread2"); 
					Thread thread3=new ExtendedThreadWithSleepMethod();
					thread3.setName("customThread3"); 
					Thread thread4=new ExtendedThreadWithSleepMethod();
					thread4.setName("customThread4"); 
					Thread thread5=new ExtendedThreadWithSleepMethod();
					thread5.setName("customThread5"); 

					thread1.start();
					thread2.start();
					thread3.start();
					thread4.start();
					thread5.start();  
					
					Runnable runnableObject=new RunnableThreadWithSleepMethod();
					Thread runnableThread1=new Thread(runnableObject);
					runnableThread1.setName("CustomRunnableThread1");
					Thread runnableThread2=new Thread(runnableObject);
					runnableThread2.setName("CustomRunnableThread2");
					Thread runnableThread3=new Thread(runnableObject);
					runnableThread3.setName("CustomRunnableThread3");
					Thread RunnableThreadInfinityCondition=new Thread(runnableObject);
					RunnableThreadInfinityCondition.setName("CustomRunnableThreadInfinityCondition");
					Thread runnableThread5=new Thread(runnableObject);
					runnableThread5.setName("CustomRunnableThread5");
	                
					runnableThread1.start();
					runnableThread2.start();
					runnableThread3.start();
					RunnableThreadInfinityCondition.start();
					runnableThread5.start();
                    thread1.join();
                    thread2.join();
                    thread3.join();
                    thread4.join();
					thread5.join();
					runnableThread1.join();
					runnableThread2.join();
					runnableThread3.join();
					RunnableThreadInfinityCondition.join();
					runnableThread5.join();
					break;
				}//end of case4
				case 5:{
					logger.info("Enter the sleep time :");
					int thread1SleepTime =sc.nextInt();
					Thread thread1=new ExtendedThreadWithCustomSleep(thread1SleepTime);
					thread1.setName("customThread1"); 
					
					System.out.println("Enter the sleep time :");
					int thread2SleepTime =sc.nextInt();
					Thread thread2=new ExtendedThreadWithCustomSleep(thread2SleepTime);
					thread2.setName("customThread2"); 
					
					System.out.println("Enter the sleep time :");
					int thread3SleepTime =sc.nextInt();
					Thread thread3=new ExtendedThreadWithCustomSleep(thread3SleepTime);
					thread3.setName("customThread3"); 
					
					System.out.println("Enter the sleep time :");
					int thread4SleepTime =sc.nextInt();
					Thread thread4=new ExtendedThreadWithCustomSleep(thread4SleepTime);
					thread4.setName("customThread4"); 
					
					System.out.println("Enter the sleep time :");
					int thread5SleepTime =sc.nextInt();
					Thread thread5=new ExtendedThreadWithCustomSleep(thread5SleepTime);
					thread5.setName("customThread5"); 
					
	                
					System.out.println("Enter the sleep time :");
					int runnableThread1SleepTime=sc.nextInt();
					Runnable runnableObject1=new RunnableThreadWithCustomSleep(runnableThread1SleepTime);
					Thread runnableThread1=new Thread(runnableObject1);
					runnableThread1.setName("CustomRunnableThread1");
					
					System.out.println("Enter the sleep time :");
					int runnableThread2SleepTime=sc.nextInt();
					Runnable runnableObject2=new RunnableThreadWithCustomSleep(runnableThread2SleepTime);
					Thread runnableThread2=new Thread(runnableObject2);
					runnableThread2.setName("CustomRunnableThread2");

					System.out.println("Enter the sleep time :");
					int runnableThread3SleepTime=sc.nextInt();
					Runnable runnableObject3=new RunnableThreadWithCustomSleep(runnableThread3SleepTime);
					Thread runnableThread3=new Thread(runnableObject3);
					runnableThread3.setName("CustomRunnableThread3");
					
					System.out.println("Enter the sleep time :");
					int RunnableThreadInfinityConditionSleepTime=sc.nextInt();
					Runnable runnableObject4=new RunnableThreadWithCustomSleep(RunnableThreadInfinityConditionSleepTime);
					Thread runnableThread4=new Thread(runnableObject4);
					runnableThread4.setName("CustomRunnableThreadInfinityCondition");
					
					System.out.println("Enter the sleep time :");
					int runnableThread5SleepTime=sc.nextInt();
					Runnable runnableObject5=new RunnableThreadWithCustomSleep(runnableThread5SleepTime);
					Thread runnableThread5=new Thread(runnableObject5);
					runnableThread5.setName("CustomRunnableThread5");
					

					thread1.start();
					thread2.start();
					thread3.start();
					thread4.start();
					thread5.start();
	                
					runnableThread1.start();
					runnableThread2.start();
					runnableThread3.start();
					runnableThread4.start();
					runnableThread5.start();

					thread1.join();
					thread2.join();
					thread3.join();
					thread4.join();
					thread5.join();
					
					runnableThread1.join();
					runnableThread2.join();
					runnableThread3.join();
					runnableThread4.join();
					runnableThread5.join();
					break;
				}
				case 6:{
					ExtendedThreadInfinityCondition extendedThreadObject=new ExtendedThreadInfinityCondition(true);
					Thread thread1=new Thread(extendedThreadObject);
					thread1.setName("ExtendedThread");
					RunnableThreadInfinityCondition runnableThreadObject=new RunnableThreadInfinityCondition(true);
					Thread runnableThread1=new Thread(runnableThreadObject);
					runnableThread1.setName("Runnable Thread");
					thread1.start();
					runnableThread1.start();
                    
					Thread.sleep(300000);
					extendedThreadObject.changeState();
					runnableThreadObject.changeState();
					Thread.currentThread().join();
					break;

				}
				case 7:{
					ExtendedThreadInfinityCondition object=new ExtendedThreadInfinityCondition(true);
	                Thread thread1=new Thread(object);
	                thread1.setName("ExtendedThread1");
					ExtendedThreadInfinityCondition object2=new ExtendedThreadInfinityCondition(true);
	                Thread thread2=new Thread(object2);
	                thread2.setName("ExtendedThread2");
					ExtendedThreadInfinityCondition object3=new ExtendedThreadInfinityCondition(true);
	                Thread thread3=new Thread(object3);
	                thread3.setName("ExtendedThread3");
					ExtendedThreadInfinityCondition object4=new ExtendedThreadInfinityCondition(true);
	                Thread thread4=new Thread(object4);
	                thread4.setName("ExtendedThreadInfinityCondition");
					ExtendedThreadInfinityCondition object5=new ExtendedThreadInfinityCondition(true);
	                Thread thread5=new Thread(object5);
	                thread5.setName("ExtendedThread5");

	                

	                RunnableThreadInfinityCondition runnableObject1=new RunnableThreadInfinityCondition(true);
					Thread runnableThread1=new Thread(runnableObject1);
					runnableThread1.setName("RunnableThread1");

					RunnableThreadInfinityCondition runnableObject2=new RunnableThreadInfinityCondition(true);
					Thread runnableThread2=new Thread(runnableObject2);
					runnableThread2.setName("RunnableThread2");

					RunnableThreadInfinityCondition runnableObject3=new RunnableThreadInfinityCondition(true);
					Thread runnableThread3=new Thread(runnableObject3);
					runnableThread3.setName("RunnableThread3");

					RunnableThreadInfinityCondition runnableObject4=new RunnableThreadInfinityCondition(true);
					Thread runnableThread4=new Thread(runnableObject4);
					runnableThread4.setName("RunnableThreadInfinityCondition");

					RunnableThreadInfinityCondition runnableObject5=new RunnableThreadInfinityCondition(true);
					Thread runnableThread5=new Thread(runnableObject5);
					runnableThread5.setName("RunnableThread5");
	                
					thread1.start();
					thread2.start();
					thread3.start();
					thread4.start();
					thread5.start();
					
					runnableThread1.start();
					runnableThread2.start();
					runnableThread3.start();
					runnableThread4.start();
					runnableThread5.start();

					
					Thread.sleep(60000);
					object.changeState();
					Thread.sleep(60000);
					object2.changeState();
					Thread.sleep(60000);
					object3.changeState();
					Thread.sleep(60000);
					object4.changeState();
					Thread.sleep(60000);
					object5.changeState();
					Thread.sleep(60000);
					runnableObject1.changeState();
					Thread.sleep(60000);
					runnableObject2.changeState();
					Thread.sleep(60000);
					runnableObject3.changeState();
					Thread.sleep(60000);
					runnableObject4.changeState();
					Thread.sleep(60000);
					runnableObject5.changeState();
					Thread.sleep(1000);
					if(!thread1.isAlive()&&!thread2.isAlive()&&!thread3.isAlive()&&!thread4.isAlive()&&!thread5.isAlive()&&!runnableThread1.isAlive()&&!runnableThread2.isAlive()&&!runnableThread3.isAlive()&&!runnableThread4.isAlive()&&!runnableThread5.isAlive()) {
		                logger.info("Task completed");
					}			
	                 break;
					}
				default:{
	                logger.info("Enter the valid case!");
				}
				}//end of switch
			}//end of if
			else {
				state=false;
			}
		}//end of while
	}//end of try with resource	
}
}
