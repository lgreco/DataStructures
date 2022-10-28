# Coding Studio for October 28, 2022

## Moving guests into their rooms faster

At the Weird Alphabetical Hotel, guests are assigned to rooms based on their names. Their room number is determined by their name's initial letter, using the following highly advanced formula:

``room number = ASCII value of initial letter % N``

Here, ``N`` is the number of hotel rooms and ``%`` is the modulo operator.

This ingenious assignment is bad for business. Consider a hotel with ``N=100`` rooms and no guests. The first guest to arrival is *Galadriel.* The first initial of her name is ``G``, its ASCII value is ``71``, and ``71%100=71``. So, she is assigned to room 71.

The second guest to arrive is *Gimli.* He should be assigned to room 71. But the room was already given to another guest. Do we really want to turn away a guest when our hotel has 99 empty rooms, just because the *ideal* room is not available?

So we decided to handle *collisions,* i.e., two (or more) guests matched to the same room. Galadrier, the first guest, will keep room 71. And Gimli, the second guest, will be assigned to the room 71+1, if it's available. If room 72 is not available we'll try 71+1+1. And if that is not available either, then we can turn the guest away.

The policy, and technique, to consider nearby rooms is called probing. The probing length is the number of rooms to consider -- in this example 3, including the ideal room.

The code implementing probing is a bit redundant. Can you improve it?