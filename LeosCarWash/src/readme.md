# Leo's Car Wash Simulator

This package uses a First-In First-Out (FIFO) queue, built from scratch to simulate simple arrivals and departures to a car wash with a single wash bay and a fixed time washing cycle.

## Class `WaitingArea`
Is a basic FIFO data structure based on a String array. The class provided method for adding an element to the queue (`addCar`) ensuring tha that the new element goes to the back of the line if there is room; a method from removing the first element in line (`moveCartoWashingBay`); and various accessors. 

## Class `Simulator`
This class provides an arrival process -- nothing fancy, just Java's `Random` class for generating random numbers; a reporting utility for printing the results at the end of the simulation; and the simulation engine itself in method `simulate`. The simulation engine is protected from other classes and can be invoked only through `report`.

## Class `LeoCarWash`
This is the implementation class. Its `main` method instantiates a `Simulator` object and calls its `report` method to printout the results of the simulation.

## For future development

* `boolean WaitingArea.isEmpty()` method to provide boolean status of queue -- instead of delegating this to other methods asking them to evaluate for `.occupancy > 0`.
* Introduce Poisson distribution in `Simulator.carArriving()` for more realistic scenarios, like "lunch-rush hour", etc.
* Introduce variable-length wash programs, e.g. *basic,* *deluxe,* etc.
* Implement the waiting area as a priority queue for a three-tier customer ranking (gold, silver, bronze) but with guaranteed max waiting time for bottom tier. Achieve that by elevating bottom tier waiting customers to the next tier after a given period, e.g., `if waiting > maxAllowed then tier++`