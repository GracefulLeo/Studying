package samples.gson1.task;

class Address {
    private String city;
    private String country;

    private Address() {
    }

    @Override
    public String toString() {
        return "Country: " + country + "\n" +
                "City: " + city;
    }
}
