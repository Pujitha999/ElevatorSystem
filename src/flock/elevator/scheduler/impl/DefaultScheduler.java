package flock.elevator.scheduler.impl;

import java.util.List;

import flock.elevator.scheduler.Scheduler;
import flock.elevator.simulator.Elevator;

import java.lang.Math;

public class DefaultScheduler implements Scheduler {
	
	
	
	public void schedule(int requestFloor,int destinationFloor, List<Elevator> elevators ) {
		
		int shortestDistance = Integer.MAX_VALUE;
		Elevator nearestElevator = null;
		
		for (Elevator elevator: elevators) {
			
			if (Math.abs(elevator.getCurrentFloor() - requestFloor) < shortestDistance) {
				shortestDistance = Math.abs(elevator.getCurrentFloor() - requestFloor);
				nearestElevator = elevator;
			}
		}
		nearestElevator.setFrequency(nearestElevator.getFrequency() + 1);
		nearestElevator.setCurrentFloor(destinationFloor);
		
	}

}
