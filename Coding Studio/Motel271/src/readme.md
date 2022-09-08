# Coding Studio for August 9, 2022

## Motels and dressers



![](../images/motel271.png)

During our last meeting we designed a simple class for a small motel.
[`Class Motel`](https://github.com/lgreco/DataStructures/blob/master/ClassroomCoding/src/Motel.java) comprises just three variables and four methods, including `main`. 

The three variables are `CAPACITY` which tells how many rooms are in the motel; `guestBook`, an array for the names of the guests, and `COUNT_OCCUPIED`, the number of rooms that are occupied. We expect`0 < COUNT_OCCUPIED <= CAPACITY` at any time.
* Method `arrival` allows a new guest to register at the motel, *if* there are rooms available. Room availability is determined by the condition<br/> `COUNT_OCCUPIED < CAPACITY`<br/> If rooms are available, the guest is admitted: we add the guest's name the motel's `guestBook` and we increment the count of occupied rooms (`COUNT_OCCUPIED`) by 1).
* Method `departure` allows a guest to leave the motel. The checks first that there are guess at the motel (`COUNT_OCCUPIED > 0`). If so, the most recent-to-arrive guest is checked out, the guest's name is removed from the `guestbook`, and the `COUNT_OCCUPIED` is decreased by 1.
* Method `displayGuests` shows a list of all rooms along with the names of the guest staying in each room, or an indication that the room is empty.
* Finally, method `main` provides a brief demonstration of arrivals and departures.