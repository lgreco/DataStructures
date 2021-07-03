/**
 * Implementation class modeling Amtrak's Lincoln Service
 */
public class LincolnService {
    public static void main(String[] args) {
        Station chi = new Station("CHI", "Chicago Union Station", "Chicago", "IL");
        Station smt = new Station("SMT", "Summit Amtrak Station", "Summit", "IL");
        Station jol = new Station("JOL", "Joliet Transportation Center", "Joliet", "IL");
        Station dwi = new Station("DWI", "Dwight Amtrak Station", "Dwight", "IL");
        Station pon = new Station("PON", "Pontiac Amtrak Station", "Pontiac", "IL");
        Station bnl = new Station("BNL", "Bloomington-Normal Station", "Normal", "IL");
        Station lcn = new Station("LCN", "Lincoln Amtrak Station", "Lincoln", "IL");
        Station spi = new Station("SPI", "Springfield Amtrak Station", "Springfield", "IL");
        Station crv = new Station("CRV", "Carlinville Amtrak Station", "Carlinville", "IL");
        Station aln = new Station("ALN", "Alton Amtrak Station", "Alton", "IL");
        Station stl = new Station("STL", "Gateway Multimodal Transportation Center", "Saint Louis", "MO");
        /*
        So far we have 11 Station objects (named chi, smt, jol, ...) but without
        any relation between them. The next thing to do is to create an instance
        of class Route and make chi its head.
         */
        Route lincolnService = new Route();
        lincolnService.addElement(chi); // first station added to Route object becomes head
        /*
        Now, every time we add a new Station to the Route we call lincolnService,
        the station goes to the end of the line and becomes its last station. In
        other words, method addStation goes to the beginning of the Route and moves
        along until it finds its last station. This is quite easy to implement
        since the beginning Station has a special name "head". The we follow the
        chain of station (along the path indicated by the Station object's "next"
        field) until we encounter an object whose "next" is null. That's the end
        of the line and that's where the new station will be added.
         */

        lincolnService.addElement(smt);
        lincolnService.addElement(jol);
        lincolnService.addElement(dwi);
        lincolnService.addElement(pon);
        lincolnService.addElement(bnl);
        lincolnService.addElement(lcn);
        lincolnService.addElement(spi);
        lincolnService.addElement(crv);
        lincolnService.addElement(aln);
        lincolnService.addElement(stl);
        // Route completed

        System.out.println(lincolnService.contains("CHI"));
    }
}
