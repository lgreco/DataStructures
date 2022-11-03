# Coding Studio for November 4, 2022

## Expanding the Hammock Hotel

Modify class HammockHotel to provide the following functionality:

* ``public boolean contains(String guestName)`` returns true if the specified guest is found in one of the rooms; false otherwise.


* ``public boolean addUnique(String guestName)`` will be a method that admits (adds) a guest to the hotel if no other guest with the same name is present. The method returns true if the guest has been successfully added; false otherwise.


* ``public boolean isEmpty()`` that returns true if there are absolutely no guests in the hotel and false otherwise.


* ``public String[] toArray()`` that returns an array with all the hotel guests' names.


* ``public void clear()`` empties the hotel completely.


* ``public int[] stats()`` returns an array with the number of guests in each hotel room.