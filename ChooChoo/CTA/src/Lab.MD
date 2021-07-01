# Lab session of July 1, 2021

For this session we will explore and reinvent doubly linked lists. To make 
things interesting, we'll try to connect a singly-linked list that forms a 
circle to a doubly-linked list. Then find how to traverse the whole thing. 
This is an interesting problems -- in algorithms it involves the study of 
_directed cyclical graphs_. Today, we'll focus on a more realistic paradigm: 
**Chicago's  Brown Line.**

Brown line trains begin and end at the Kimball Station. The train starts at 
Kimball, travels south to the Loop area, circles the Loop, and returns to 
Kimball. Trains enter the Loop area after the Merchandise Mart (Merc) stop. 
After 
they go around the loop, trains return to the Merc, and travel towards 
Kimball, where their run ends.

<img src="BrownLine.png" alt="drawing" width="500" align="right" />
A simpified map of the Brown Line is shown to the Lab (you may click on the 
image for a larger version). 
The dotted lines 
indicate stations we are omitting for simplicity. The path colors indicate 
direction of travel. The orange path shows the outbound travel. The blue 
path shows the route once the train returns to the Merc station and start 
the inbound trip back to Kimball. Some stations, like Kedzie, are traversed by 
trains 
going in both directions (outbound and inbound). Other stations, like Quincy,
are traversed only by outbound trains.