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
        Station aln = new Station("ALN", "Alton Amtrak Station", "", "IL");
        Station stl = new Station("STL", "Gateway Multimodal Transportation Center", "Saint Louis", "MO");
        /*
        So far we have 11 Station objects (named chi, smt, jol, ...) but without
        any relation between them. The next thing to do is to create an instance
        of class Route and make chi its head.
         */
        Route lincolnService = new Route();
        lincolnService.addStation(chi); // first station added to Route object becomes head
        // Continue adding objects
        lincolnService.addStation(smt);
        lincolnService.addStation(jol);
        lincolnService.addStation(dwi);
        lincolnService.addStation(pon);
        lincolnService.addStation(bnl);
        lincolnService.addStation(lcn);
        lincolnService.addStation(spi);
        lincolnService.addStation(crv);
        lincolnService.addStation(aln);
        lincolnService.addStation(stl);
        // Route completed
    }
}
