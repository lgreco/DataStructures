# The Car Wash project

This is a cool project where you get to implement an interface, and then use that implementation in a realistic simulation that you also have to produce! There is quite a bit of coding to be done, though.

We start with a simple interface, `Q.java` (where is it? Look above!)

## First Part

Interface Q contains five methods. Any class that implements this interface must implement all its methods, in addition to any other methods you may wish to include (e.g., a `main()` for testing purposes). Q's methods are very specific: you cannot add a new element anywhere in your data structure. New elements must be added at the back. Departures are always from the front.

The interface does not dictate the underlying data structure mechanism. You may use an array, a List, a radio link to Mars, even a file to store the elements of the queue. There is one restriction however: as line 17 implies, your implementing class must use Strings as data.

Write a class called **BBQ** to implements the Q interface. Your BBQ class should be tested using class `Grill`, provided above.

## Second part

One your BBQ class is ready, you will use it to model a random process, specifically a car wash. Before you start writing code, let's agree on some requirements.

* The car wash simulation should be a class called CarWash.

* A car wash is defined by the following characteristics:
 
  * Its capacity, i.e., how many cars can wait outside the wash bay?
  * The time it takes to wash a car (in minutes) and assumming that there is only one wash option.
  * The rate of arrivals of cars at the car wash, expressed as minutes it takes for a next car to arrive. This is a bit tricky. In reality, arrivals are random events. As such they are easily realized with `Random.nextInt()`. However, to keep things simple in the beginning, you may assume a constant arrival rate, e.g. 2 minutes. This means that a car arrives every two minutes. Such predictable arrival rate may tempt you to use simple arithmetic to simulate the car wash. Do not!
  
* The length of the simulation: how long will you be observing the car wash? Plan for a length that is 250 times longer than the car wash cycle.

  
With these requirements in place -- and any clarifications we will develop during class time -- **write your CarWash.java to compute the minimum, average, and maximum wait time for a car wash of your choice.** Your choice determines the capacity of the car wash and its washing time. The arrival rate will be ultimately obtained from `Random.nextInt()`; initially you may use a constant rate to simplify your coding. 

Again, do not let this initial simplicity trick you into an arithmetic solution to the problem. It is easy to be tempted to think that if a car wash cycle is 3 minutes and a car arrives very 2 minutes and the capacity is 4 cars, the min waiting time is 0, the max is 12, and the average is somewhere in-between. It may work for the initial simplified assuption of constant arrival rate but ultimately you will have to use actual random arrivals. Plan for it.