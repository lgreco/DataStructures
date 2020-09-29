# The Car Wash project

This is a cool project where you get to implement an interface, and then use that implementation in a realistic simulation that you also have to produce! There is quite a bit of coding to be done, though.

We start with a simple interface, `Q.java` (where is it? Look above!)

## First Part

Interface Q contains five methods. Any class that implements this interface must implement all its methods, in addition to any other methods you may wish to include (e.g., a `main()` for testing purposes). Q's methods are very specific: you cannot add a new element anywhere in your data structure. New elements must be added at the back. Departures are always from the front.

The interface does not dictate the underlying data structure mechanism. You may use an array, a List, a radio link to Mars, even a file to store the elements of the queue. There is one restriction however: as line 21 implies, your implementing class must use Strings as data.

Write a class called **BBQ** to implements the Q interface. Your BBQ class should be tested using class `Grill`, provided above.

## Second part

Once your BBQ class is ready, you will use it to model a random process, specifically a car wash. Before you start writing code, let's agree on some requirements.

* The car wash simulation should be a class called CarWashNotForAssignment.

* A car wash is defined by the following characteristics:
 
  * Its capacity, i.e., how many cars can wait outside the wash bay?
  * The number of cars in the queue.
  * The time it takes to wash a car (in minutes) and assuming that there is only one wash option.
  * The rate of arrivals of cars at the car wash, expressed as minutes it takes for a next car to arrive. This is a bit tricky. In reality, arrivals are random events. As such they are easily realized with `Random.nextInt()`. However, to keep things simple in the beginning, you may assume a constant arrival rate, e.g. 2 minutes. This means that a car arrives every two minutes. Such predictable arrival rate may tempt you to use simple arithmetic to simulate the car wash. Do not!
  
* The length of the simulation: how long will you be observing the car wash? Plan for a length that is between 250 and 500 times longer than the car wash cycle.

  
With these requirements in place -- and any clarifications we will develop during class time -- **write your CarWashNotForAssignment.java to compute the minimum, average, and maximum wait time for a car wash of your choice.** The capacity of the car wash and its washing time, should be parameters that you determine when you start the simulation. The arrival rate will be ultimately obtained from `Random.nextInt()`; initially you may use a constant rate to simplify your coding. 

Again, do not let this initial simplicity trick you into an arithmetic solution to the problem. It is easy to be tempted to think that if a car wash cycle is 3 minutes and a car arrives every 2 minutes and the capacity is 4 cars, the min waiting time is 0, the max is 12, and the average is somewhere in-between. It may work for the initial simplified assumption of constant arrival rate but ultimately you will have to use actual random arrivals. Plan for it.

Your simulation will be based on *event-driven computing*. An example of such program is provided as class `Landings` above. This programming paradigm uses a main loop to mark time, and checks at every discrete point of time to determine if an event has occurred and take the necessary action.

## Implementation notes

Leo's versions of BBQ and CarWash are now available on the repository. Class BBQ offers two ways to add and remove items from the queue. One way is the pair of `arrival()` and `departure()` methods. The other way is the pair of `efficientArrival()` and `efficientDeparture()` methods. The efficient methods are listed at the bottom of class BBQ.

The different between the two pairs is the performance of the method for adding an item to the queue. Method `arrival()` completes in O(n) time. Method `efficientArrival()` completes in constant time (let's call it O(1)). For relatively small queues the performance difference is negligible. But even a negligible difference matters when we repeat an inefficient task thousands of times.

There was some confusion as to why we need to compute minimum and maximum waiting times. Why, for example, the minimum waiting time is not always 0. This may be the minimum time experienced by some cars, but not all. There is always a possibility that a car arriving to an empty queue may have to wait for a carwash-in-progress, to complete. This time is calculated as:

`int waitingTime = (myQ.getSize()-1) * carWashDuration + timeUntilWashEnds;`

For a car joining an empty queue, .getSize() is 1, so the first term in the sum above is zero, reducing the waiting time to

`waitingTime = 0 + timeUntilWashEnds;`

So the waiting time for a car at an empty queue is not always zero, but up to `timeUntilWashEnds`, i.e., the time remaining for the current wash, when the new car arrived at the queue. This remaining time is very easy to compute. To appreciate how easy it is, consider the following example: your favorite course starts at 11 AM and lasts 50 minutes. (Therefore you know what time it ends, 11:50 AM). One day you arrive at the classroom 15 minutes late. How much time remains in that day's course?

Given the facts above, it makes sense to compute an *average*  minimum time for the duration of the simulation.

When it comes to the maximum waiting time, you may think that it's trivial:

`int maxWaitingTime = capacity * carWashDuration;`

This is certainly true in a saturation case, i.e., a car wash whose queue is constantly full. But such a scenario is just one possibility. Consider the opposite: a carwash during a very rainy day, when the queue is almost empty. In this case, the maximum waiting time may be just 0. So between the two extreme scenarios, there may be other situations that can be uncovered with the simulation.