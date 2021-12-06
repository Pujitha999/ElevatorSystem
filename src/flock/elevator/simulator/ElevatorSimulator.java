package flock.elevator.simulator;

import java.util.ArrayList;
import java.util.List;

import flock.elevator.scheduler.Scheduler;

public class ElevatorSimulator {

	private int totalFloors;
	private int totalElevators;
	private List<Elevator> elevators;

	private Scheduler scheduler;

	public ElevatorSimulator(int totalFloors, int totalElevators, Scheduler scheduler) {

		if (totalFloors > Constants.MAX_FLOORS || totalFloors < 1) {
			throw new IllegalArgumentException("Invalid number of Floors");
		}
		if (totalElevators > Constants.MAX_ELEVATORS || totalElevators < 1) {
			throw new IllegalArgumentException("Invalid number of Elevators");
		}
		this.totalFloors = totalFloors;
		this.totalElevators = totalElevators;
		this.scheduler = scheduler;

		elevators = new ArrayList<Elevator>(totalElevators);

		for (int i = 0; i < totalElevators; i++) {
			elevators.add(new Elevator(i));
		}

	}

	public int getTotalFloors() {
		return totalFloors;
	}

	public int getTotalElevators() {
		return totalElevators;
	}

	public List<Elevator> getElevators() {
		return elevators;
	}
	
	public Scheduler getScheduler() {
		return scheduler;
	}

	public void setScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;
	}

	public void setTotalFloors(int totalFloors) {
		this.totalFloors = totalFloors;
	}

	public void setTotalElevators(int totalElevators) {
		this.totalElevators = totalElevators;
	}

	public void setElevators(List<Elevator> elevators) {
		this.elevators = elevators;
	}

	public void schedule(int requestFloor, int destinationFloor) {

		if (requestFloor > totalFloors || requestFloor < 0) {
			throw new IllegalArgumentException("Invalid Floor Number");
		}
		scheduler.schedule(requestFloor,destinationFloor, this.elevators);
	}
	
	public void printElevatorsStatus() {
		
		for (Elevator elevator: elevators) {
			System.out.println(elevator);
		}
	}

}
