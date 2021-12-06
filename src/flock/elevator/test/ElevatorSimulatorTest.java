package flock.elevator.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import flock.elevator.scheduler.impl.DefaultScheduler;
import flock.elevator.scheduler.impl.LeastFrequentElevator;
import flock.elevator.simulator.Constants;
import flock.elevator.simulator.Elevator;
import flock.elevator.simulator.ElevatorSimulator;


public class ElevatorSimulatorTest {
	
	
	 public static void main(String args[]) {	
		
		int requestedFloor = 2;
		int destinationFloor = -1;
		int val = 0;
		Scanner myObj = new Scanner(System.in);
		
		System.out.print("Enter Total Floors and Total Elevators");
		
		int totalFloors = myObj.nextInt();
		int totalElevators = myObj.nextInt();
		ElevatorSimulator simulator = new ElevatorSimulator(totalFloors,totalElevators,new DefaultScheduler());
		
		while (true) {
		
		System.out.println("1. Schedule with default scheduler which selects the nearest elevator"
				+ "\n"
				+ "2. Schedule with least frequent scheduler algorithm which selects the least frequently used elevator"
				+ "\n"
				+ "3. Print the status of all elevators \n"
				+ "4. Reset the status of all elevators \n"
				+ "5. Exit on any other entry \n");
			
		val = myObj.nextInt();
		switch (val) {
        case 1:
        	System.out.print("Enter request Floor and Destination Floor");
        	requestedFloor = myObj.nextInt();
        	destinationFloor = myObj.nextInt();
        	if (requestedFloor > Constants.MAX_FLOORS || totalFloors < 1) {
    			throw new IllegalArgumentException("Invalid Requested Floor");
    		}
        	
        	if (destinationFloor > Constants.MAX_FLOORS || totalFloors < 1) {
    			throw new IllegalArgumentException("Invalid Destination Floor");
    		}
        	
        	scheduleElevatorWithDefaultScheduler(simulator,requestedFloor, destinationFloor);
        	System.out.println("Scheduling Successful \n");
        	System.out.println("Below is the status of all elevators \n");
        	printElevatorStatus(simulator);
            break;
        case 2:  
        	System.out.print("Enter request Floor and Destination Floor");
        	requestedFloor = myObj.nextInt();
        	destinationFloor = myObj.nextInt();
        	scheduleLeastFrequentElevator(simulator,requestedFloor, destinationFloor);
        case 3:  
        	System.out.println("Below is the status of all elevators \n");
        	printElevatorStatus(simulator);
            break;
        case 4:  
        	System.out.println("Resetting the status of all elevators3 \n");
        	resetElevators(simulator,totalElevators);
            break;
        default:  
        	System.out.println("Exiting out of the elevator simulator");
        	System.exit(0);
            break;
	         
	   }
		
	   }
	}	
		
	private static void scheduleElevatorWithDefaultScheduler(ElevatorSimulator simulator,int requestedFloor,int destinationFloor) {
		
		simulator.setScheduler(new DefaultScheduler());
		simulator.schedule(requestedFloor,destinationFloor);
		
	}
	
	private static void scheduleLeastFrequentElevator(ElevatorSimulator simulator,int requestedFloor,int destinationFloor) {
		
		simulator.setScheduler(new LeastFrequentElevator());
		simulator.schedule(requestedFloor,destinationFloor);
		
	}
	
	private static void printElevatorStatus(ElevatorSimulator simulator) {
		
		simulator.printElevatorsStatus();
	}
	
	private static void resetElevators(ElevatorSimulator simulator, int totalElevators) {
		
		List<Elevator> elevators = new ArrayList<Elevator>(totalElevators);

		for (int i = 0; i < totalElevators; i++) {
			elevators.add(new Elevator(i));
		}
		simulator.setElevators(elevators);
	}
	
}
