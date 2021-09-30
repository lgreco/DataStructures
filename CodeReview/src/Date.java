public class Date {

    static final int days[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    int month;
    int day;


    public Date (int month, int day) {
        this.month = month;
        this.day = day;
    }

    public int daysInMonth() {
        return days[this.month-1];
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public void nextDay() {
        if ( this.day == days[this.month-1]) {
            this.month++;
            this.day = 1;
        } else {
            this.day++;
        }
    }

    public String toString() {
        return String.format("%02d/%02d", this.month, this.day);
    }
}