# Coding Studio for October 21, 2022

## Simple Interfaces

Consider class ``Building`` that is extended by classes ``CommercialBuilding`` and ``SingleFamilyHome``. These subclasses implement interfaces ``CommercialUse`` and ``ResidentialUse`` respectively.

Interface ``CommercialUse`` determines what methods should be present in any class that implements it. Consequently, clas ``CommercialBuilding`` implements that interface by offering the prescribed methods. The methods use the class fields to produce the required behavior.

Drawing from your own experience around residential spaces (family home, university dorm, etc) propose **at least 5** behaviors you expect from a residential space (for example, and you **cannot use** this one in your work, does the property have a *fenced* yard?).

Write these behaviors as abstract methods (i.e., just method signatures) in the ``ResidentialUse`` interface.

Then add methods to class ``SingleFamilyHouse`` to comply with the implemented interface. As you write these methods in ``SingleFamilyHouse``, you may also want to add some class fields to use in the methods.