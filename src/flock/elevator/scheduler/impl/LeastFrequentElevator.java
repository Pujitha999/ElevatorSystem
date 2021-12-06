package flock.elevator.scheduler.impl;

import java.util.List;

import flock.elevator.scheduler.Scheduler;
import flock.elevator.simulator.Elevator;

import java.lang.Math;

public class LeastFrequentElevator implements Scheduler {
	
	public void schedule(int requestFloor,int destinationFloor, List<Elevator> elevators ) {
		
		int leastFrequency = Integer.MAX_VALUE;
		Elevator leastFrequencyElevator = null;
		
		for (Elevator elevator: elevators) {
			
			if (elevator.getFrequency() < leastFrequency) {
				leastFrequency = elevator.getFrequency(); 
				leastFrequencyElevator = elevator;
			}
		}
		leastFrequencyElevator.setFrequency(leastFrequencyElevator.getFrequency() + 1);
		leastFrequencyElevator.setCurrentFloor(destinationFloor);
		
	}

}
