import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TrafficTicket {

    /** This will be the object's key */
    protected int ticketSerialNumber;
    protected String driverLicenseNumber;
    protected String licensePlate;
    protected int violationCode;
    protected String address;
    protected Date date;


    /** Full constructor */
    public TrafficTicket(int ticketSerialNumber, String driverLicenseNumber,
                         String licensePlate, int violationCode, String address,
                         Date date) {
        this.ticketSerialNumber = ticketSerialNumber;
        this.driverLicenseNumber = driverLicenseNumber;
        this.licensePlate = licensePlate;
        this.violationCode = violationCode;
        this.address = address;
        this.date = date;
    }  // full constructor


    /**
     * String representation of the object, suitable for naive serialization.
     * @return CSV-friendly string with all object values separated by commas.
     */
    public String toString() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hhmm");
        return String.format("%d,%s,%s,%d,%s,%s\n",
                this.ticketSerialNumber,
                this.driverLicenseNumber,
                this.licensePlate,
                this.violationCode,
                this.address,
                df.format(this.date));
    }  // method toString
}  // class TrafficTicket
