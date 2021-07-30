public class Implementation {
    public static void main(String[] args) {

        /* All the stations in CTA's Brown Line. */
        Node kimball = new Node("Kimball"); Node kedzie = new Node("Kedzie"); Node francisco = new Node("Francisco");
        Node rockwell = new Node("Rockwell"); Node western = new Node("Western"); Node damen = new Node("Damen");
        Node montrose = new Node("Montrose"); Node irving = new Node("Irving Park"); Node addison = new Node("Addison");
        Node paulina = new Node("Paulina"); Node southport = new Node("Southport"); Node belmont = new Node("Belmont");
        Node wellington = new Node("Wellington"); Node diversey = new Node("Diversey"); Node fullerton = new Node("Fullerton");
        Node armitage = new Node("Armitage"); Node sedgwick = new Node("Sedgwick"); Node chicago = new Node("Chicago");
        Node merchantile = new Node("Merchantile Mart"); Node washingtonWells = new Node("Washington/Wells"); Node quincy = new Node("Quincy");
        Node lasalle = new Node("LaSalle/Van Buren"); Node library = new Node("Harold Washington Library"); Node adams = new Node("Adams/Wabash");
        Node washingtonWabash = new Node("Washington/Wabash"); Node stateLake = new Node("State/Lake"); Node clark = new Node("Clark/Lake");

        /* Create a list for a few stations */
        LoopyList shorterBrownLine = new LoopyList();

        /* No need for every single one */
        shorterBrownLine.addNode(kimball);
        shorterBrownLine.addNode(kedzie);
        shorterBrownLine.addNode(francisco);
        shorterBrownLine.addNode(rockwell);
        shorterBrownLine.addNode(western);
        shorterBrownLine.addNode(damen);
        shorterBrownLine.addNode(chicago);
        shorterBrownLine.addNode(merchantile);
        shorterBrownLine.addNode(washingtonWells);
        shorterBrownLine.addNode(quincy);
        shorterBrownLine.addNode(lasalle);
        shorterBrownLine.addNode(library);
        shorterBrownLine.addNode(clark);

        /*
        Write some offending and offensive code! We take the clark object and we alter its next pointer directly.
        Thus we create a loop. This is possible because we made the following design "errors" in this code.

        First, we allowed the programmer-user to create nodes directly. At this level of implementation, a user
        should not be allowed to instantiate nodes (using the Node constructor). The node constructor should be
        used only by the list class (LoopyList), that creates nodes in a very specific manner. This restriction
        should be documented clearly. And if necessary the Implementation class should be used to a different package
        (as in Java package) but that's a topic for s/w engineering.

        Second, we overloaded method addNode() to allow addition of a user-supplied node. Nodes need to be added
        in a specified manner, always at the end of the list, and the last node's next pointer must be null. Now,
        this restriction is relaxed.

        And third, we allow direct access to a node's fields because they are not protected with the private
        modifier. As a result, we can write the following line of code that takes the last node added to the list
        (clark) and changes its next pointer (that was null up until now) to an existing node (merchantile).
         */
        clark.next = merchantile;

        System.out.printf("\n\nHas loop? %B\n", shorterBrownLine.hasLoop());
    }
}
