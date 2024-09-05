package problem_3;

public class Identifier {
    private final String username;
    private final int year;
    private final String country;

    public Identifier(String username, int year, String country) {
        this.username = username;
        this.year = year;
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    public String getUsername() {
        return username;
    }
}
