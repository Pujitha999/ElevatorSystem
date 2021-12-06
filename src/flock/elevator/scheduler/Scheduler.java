package flock.elevator.scheduler;

import java.util.List;

import flock.elevator.simulator.Elevator;

public interface Scheduler {
	

	public void schedule(int requestFloor,int destinationFloor, List<Elevator> elevators);

}
