# Coding Studio for October 6, 2022

## Demolishing Train Stations!

In week 6, we worked on manipulating a sequential entity like the ``TrainLine`` class. The class has, seemingly, a single field: a ``TrainStation`` object called ``head``. And yet, thanks to method ``TrainLine.addStation``, we are able to build a sequence of train stations following the ``head`` station.

The *beauty* of sequential data structures is that we can't see their contents from the outside. All we see in a ``TrainLine`` is its ``head``. To explore the contents of a ``Trainline``, we start at the ``head`` station and follow the object's ``next`` field. There are two possibilities: the ``next`` field points to another ``TrainStation`` object or it is null. If it is null, we are at the end of the train line. If not, we follow it to the next station and try again with that's station's ``next``.

In a naive manner, we can print the name of the third station from the ``head`` station with the following statement:

```java
System.out.println(head.next.next.next.name);
```

In the statement above, ``head.next`` is first station after the ``head`` station, ``head.next.next`` is the second station, and so on. This statement will work if we are 100% certain that there are three stations after the head station. There are no such guarantees, and that's why we need to traverse the train line carefully, one station at a time. At each station, we evaluate its field ``next``. If it is not null, we can proceed to the next station; if it is null, we have reached the end of the line.

One of the methods we developed for the ``TrainLine`` class is the ``delete`` method. This method removes a station from the train line. It works by finding the station before the one we want to delete. Then it changes that previous station's ``next`` to the ``next`` value from the station we want to delete. In terms of station objects,

``
previous.next = stationToDelete
``

And we want to set the ``previous.next`` to the station that comes after the station to delete, so we want

``previous.next = stationToDelete.next``

However, our search has brought us to station ``previous``. We can only reference the station to delete in relation to that previous station. Using the identity ``stationToDelete = previous.next``, we can write the assignment above as

``
previous.next = (previous.next).next
``

The parentheses above are for illustrative purposes and show where we substituted ``stationToDelete`` with ``previous.next``.

Method ``delete`` works ok. We tested it to delete the ``head`` station, the last station, and any station in the middle of a train line. It did so, flawlesly. But it failed, when we asked it to delete a non existing station.

## Your task

Analyze the cause of the ``delete`` method's failure. Why does it fail? Then propose and implement a remedy.