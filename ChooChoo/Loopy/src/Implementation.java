package ChooChoo.Loopy.src;

public class Implementation {
    public static void main(String[] args) {

        /* All the stations in CTA's Brown Line. */
        LLNode kimball = new LLNode("Kimball"); LLNode kedzie = new LLNode("Kedzie"); LLNode francisco = new LLNode("Francisco");
        LLNode rockwell = new LLNode("Rockwell"); LLNode western = new LLNode("Western"); LLNode damen = new LLNode("Damen");
        LLNode montrose = new LLNode("Montrose"); LLNode irving = new LLNode("Irving Park"); LLNode addison = new LLNode("Addison");
        LLNode paulina = new LLNode("Paulina"); LLNode southport = new LLNode("Southport"); LLNode belmont = new LLNode("Belmont");
        LLNode wellington = new LLNode("Wellington"); LLNode diversey = new LLNode("Diversey"); LLNode fullerton = new LLNode("Fullerton");
        LLNode armitage = new LLNode("Armitage"); LLNode sedgwick = new LLNode("Sedgwick"); LLNode chicago = new LLNode("Chicago");
        LLNode merchantile = new LLNode("Merchantile Mart"); LLNode washingtonWells = new LLNode("Washington/Wells"); LLNode quincy = new LLNode("Quincy");
        LLNode lasalle = new LLNode("LaSalle/Van Buren"); LLNode library = new LLNode("Harold Washington Library"); LLNode adams = new LLNode("Adams/Wabash");
        LLNode washingtonWabash = new LLNode("Washington/Wabash"); LLNode stateLake = new LLNode("State/Lake"); LLNode clark = new LLNode("Clark/Lake");

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
        shorterBrownLine.addNode(adams);
        shorterBrownLine.addNode(washingtonWabash);
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
        clark.next = merchantile; // THIS IS THE OFFENSIVE LINE OF CODE

        System.out.printf("\n\nBrown Line\n\tHas loop? (lazy) %B", shorterBrownLine.hasLoop());
        System.out.printf("\n\tHas loop? (fast/slow) %B\n", shorterBrownLine.hasLoop2());

        // One node list
        LoopyList tinyList = new LoopyList();
        LLNode lonely = new LLNode("Just me!");
        tinyList.addNode(lonely);
        lonely.next = lonely;
        System.out.printf("\n\nTiny List\n\tHas loop? (lazy) %B\n\tHas loop? (fast/slow) %B\n", tinyList.hasLoop(), tinyList.hasLoop2());

        // Two node list
        LoopyList twoNodeList = new LoopyList();
        LLNode LLNodeOne = new LLNode("Node one");
        LLNode LLNodeTwo = new LLNode("Node two");
        twoNodeList.addNode(LLNodeOne);
        twoNodeList.addNode(LLNodeTwo);
        LLNodeTwo.next = LLNodeTwo;
        System.out.printf("\n\nTwo-node List\n\tHas loop? (lazy) %B\n\tHas loop? (fast/slow) %B\n", twoNodeList.hasLoop(), twoNodeList.hasLoop2());
    }
}
