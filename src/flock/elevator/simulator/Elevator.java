package flock.elevator.simulator;

public class Elevator {

	private int id;
	private int currentFloor;
	private int frequency;

	public Elevator(int id) {
		this.id = id;
		this.currentFloor = 1;
		this.frequency = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	@Override
	public String toString() {
		return "Elevator [id=" + id + ", currentFloor=" + currentFloor + ", frequency=" + frequency + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + currentFloor;
		result = prime * result + frequency;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Elevator other = (Elevator) obj;
		if (currentFloor != other.currentFloor)
			return false;
		if (frequency != other.frequency)
			return false;
		if (id != other.id)
			return false;
		return true;
	}

}
