/*

Delivers Programming Project 2, Chapter 4, from BJP/5e.

Objective: given a date, find what day of the week it falls on.

The essence of  this project is to  count how many days have passed since a base
date whose  day-of-week is known.  The reference date can be any date as long as
we know its day-of-week.  For this project we select January 1, 1601 as our base
date. The base date fell on a Monday.

The problem  now becomes  how to count how many  days have passed from  the base
date until a target date. For example, if the target date is 1/9/1601, there are
8 days. And therefore, 1/9/1601 falls on a Tuesday. T o count the number of days
between  the base and the target dates, we start with the base date.  We add one
day at a time to the base date. Everytime we add a day, we update a counter. And
we also check the new date.  If the new date matches the target date, we end the
additions.  The value of the counter at that point is the number of days between
the base and the target dates.

The pseudocode for this counting is simple:

    counter = 0
    test_date = base_date
    while test_date != target_date:
      test_date = test_date + 1 day
      counter = counter + 1
    return counter

Then we take  this counter's integer remainder by 7,  i.e.,  counter%7  and this
value tells us which day after Monday, the target date falls on. If counter%7 is
0 then the target date is on a Monday,  if counter%7 is 1, the target date is on
a Tuesday, and so on.

In general,
                0 ≤ (counter % 7) ≤ 6

And so,  if we map 0  to the day of the week  for the base date,  we can use the
value of  counter%7 to tell which day of the week is the target date. Simply  by
counting  counter%7  days after Monday  --  the day of the week for Jan 1, 1601.

This seemingly simple pseudocode presents some implementation challenges. First,
let's consider that the test date is December 31, 2020.  And we add 1 day to it.
What will  be the new date?  December  32, 2020?  Of course  not!  We need to be
mindful of  transitions between months and  years. The boundary between years is
clear.  Any December 31st becomes January 1 when we add a day.  And of course we
increment the year by 1.

The problem is the boundaries between months.  Some have 30 days, some 31, and a
beastly one has 28 or 29 days. February 28 + 1 may be February 29 or March 1. It
depends on if it's a leap year. So we need to understand what a leap year is and
how to tell, in Java, is a year is leap.

Which brings us to  the next challenge in this project.  How to represent a date
in Java?  We cannot use  an auxiliary class like  java.util.Date,  so we have to
come up with our own representation. What will that be?
 */

public class Chapter4_ProgrammingProject2 {


}
