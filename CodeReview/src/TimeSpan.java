

public class TimeSpan {

    static final int MIN_PER_HOUR = 60;

    int hours;
    int minutes;

    public TimeSpan(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    void add(int hours, int minutes) {
        this.hours = (this.hours + hours) + (this.minutes + minutes) / MIN_PER_HOUR;
        this.minutes = (this.minutes + minutes) % MIN_PER_HOUR;
    }

    void add(TimeSpan timeSpan) {
        this.hours = (this.hours + timeSpan.hours) + (this.minutes + timeSpan.minutes) / MIN_PER_HOUR;
        this.minutes = (this.minutes + timeSpan.minutes) % MIN_PER_HOUR;
    }

    void subtractTimeSpan(TimeSpan timeSpan) {

    }

    double getTotalHours() {
        return (double) hours + ((double) minutes)/ MIN_PER_HOUR;
    }

    public String toString() {
        return String.format("%dh%dm", this.hours, this.minutes);
    }
}
