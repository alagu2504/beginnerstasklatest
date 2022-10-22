package inheritance;
import java.util.Scanner;
public class RunnerClass {
public  String runnerMethod(Car carObject) {
	String output="";
	if(carObject instanceof Swift) {
		output= "Hatch";
	}
	else if(carObject instanceof Xuv) {
		output= "SUV";
	}
	else if(carObject instanceof SCross) {
		output= "Sedan";
	}
	return output;
	}//end of runnerMethod
public static String method6(Swift swiftObject) {
	String name="Sedan";
	return name;
	}
public static void main(String[]args) {
	boolean ready=true;
	Scanner sc=new Scanner(System.in);
   RunnerClass runnerObject=new RunnerClass();
	while(ready) {
		System.out.println("Enter the case no :");
		int caseNo=sc.nextInt();
		if(caseNo!=11) {
			switch(caseNo) {
			case 2:{
			     Swift swift=new Swift();
				System.out.println("Enter the seat number :");
				int seatNo=sc.nextInt();
				swift.setSeats(seatNo);
				System.out.println("Enter the no of Airbags :");
				int airBagsNo=sc.nextInt();
				swift.setAirBags(airBagsNo);
				System.out.println("Enter the model name :");
				String modelName=sc.next();
				swift.setModel(modelName);
				System.out.println("Enter the color name :");
				String colorName=sc.next();
				swift.setColor(colorName);
				System.out.println("No of Seats :"+swift.getSeats());
				System.out.println("No of air bags :"+swift.getAirBags());
				System.out.println("Model name :"+swift.getModel());
				System.out.println("car color :"+swift.getColor());
				break;
			}
			case 3:{
				 SCross scross=new SCross();
				System.out.println("Enter the year of make :");
				int yearOfMake=sc.nextInt();
				scross.setYearOfMake(yearOfMake);
				System.out.println("Enter the Engine No :");
				String engineNo=sc.next();
				scross.setEngineNumber(engineNo);
				System.out.println("Enter the type of the car :");
				String typeOfCar=sc.next();
				scross.setType(typeOfCar);
				System.out.println("Enter the seats No :");
				int numberOfSeats=sc.nextInt();
				scross.setSeats(numberOfSeats);
				System.out.println("Enter the no of air bags :");
				int numberOfAirBags=sc.nextInt();
				scross.setAirBags(numberOfAirBags);
				System.out.println("Enter the Model name:");
				String modelName=sc.next();
				scross.setModel(modelName);
				System.out.println("Enter the color name :");
				String colorName=sc.next();
				scross.setColor(colorName);
				System.out.println("Manufacture year :"+scross.getYearOfMake());
				System.out.println("Engine NUmber :"+scross.getEngineNumber());
				System.out.println("car type :"+scross.getType());
				System.out.println("No of seats :"+scross.getSeats());
				System.out.println(" No of Airbags :"+scross.getAirBags());
				System.out.println("Model :"+scross.getModel());
				System.out.println("car color :"+scross.getColor());
				break;
			}
			case 4:
			case 5:{
			     Swift swift=new Swift();
				 SCross scross=new SCross();
				 Xuv xuvObject=new Xuv();
				System.out.println("type :"+runnerObject.runnerMethod(swift));
				System.out.println("Type :"+runnerObject.runnerMethod(scross));
				System.out.println("Type :"+runnerObject.runnerMethod(xuvObject));
				break;
			}
			case 6:{
				Car car=new Car();
			     Swift swift=new Swift();
                System.out.println("Name :"+method6(swift));
               // System.out.println("name :"+method6(car));
                //System.out.println("name :"+method6(xuvObject));
                //System.out.println("name :"+method6(scross));
				break;
			}//end of case6
			case 7:{
				 SCross scross=new SCross();
                 System.out.println(" Report :"+scross.maintenance());
                 Car carObject=new SCross();
                 System.out.println("Report :"+carObject.maintenance());
                 Car carObject2=new Car();
                 System.out.println("Report :"+carObject2.maintenance());
			     Swift swift=new Swift();
                 System.out.println("Report :"+swift.maintenance());
                 break;
			}
			case 8:{
				 Xuv xuvObject=new Xuv();
				// Xuv xuvObject2=new Xuv("Xuv overloaded constructor");
				 break;
			}
			case 9:{
				//BirdAbstract birdobject=new BirdAbstract();
				ParrotMod parrotObject=new ParrotMod();
				parrotObject.fly();
				parrotObject.speak();
				break;
			}
			case 10:{
				Duck duckObject=new Duck();
				duckObject.fly();
				duckObject.speak();
				break;
			}
			
			default:{
				System.out.println("Enter the valid case no");
			}
			}
		}
		else {
			ready=false;
		}
	}//enf of while	
sc.close();
}
}

