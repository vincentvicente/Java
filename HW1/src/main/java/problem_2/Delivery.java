package problem_2;

public class Delivery {
    private String startLocation;
    private String endLocation;
    private Time startTime;
    private Time endTime;

    public Time getDuration() {
        int startInSec = startTime.helper();
        int endInSec = endTime.helper();
        int durationInSec = endInSec - startInSec;

        if (durationInSec <= 0) {
            throw new IllegalArgumentException("End time must be greater than start time");
        }
        int hours = durationInSec / 3600;
        int minutes = (durationInSec % 3600) / 60;
        int seconds = durationInSec % 60;
        return new Time(hours, minutes, seconds);

    }


    public Delivery(String startLocation, String endLocation, Time startTime, Time endTime) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.startTime = startTime;
        this.endTime = endTime;
    }


    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
}
