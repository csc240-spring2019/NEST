package edu.ncc.nest.nestapp;

public class GuestFormEntry {
    private long id;
    private String name;
    private String email;
    private String phone;
    private String date;
    private String address;
    private String city;
    private String zipcode;
    private String state;
    private String additionalInfo;
    private String nameOfVolunteer;
    private String nccID;


    public GuestFormEntry() {
    }


    // parameterized constructor
    public GuestFormEntry(String name, String email, String phone, String date, String address, String city, String zipcode,
                          String state, String additionalInfo, String nameOfVolunteer, String nccID) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.date = date;
        this.address = address;
        this.city = city;
        this.zipcode = zipcode;
        this.state = state;
        this.additionalInfo = additionalInfo;
        this.nameOfVolunteer = nameOfVolunteer;
        this.nccID = nccID;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNccID() {
        return nccID;
    }

    public void setNccID(String nccID) {
        this.nccID = nccID;
    }

    public String getNameOfVolunteer() {

        return nameOfVolunteer;
    }

    public void setNameOfVolunteer(String nameOfVolunteer) {
        this.nameOfVolunteer = nameOfVolunteer;
    }

    public String getAdditionalInfo() {

        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getState() {

        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {

        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {

        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {

        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean equals(Object otherEntry) {
        return this.id == ((GuestFormEntry) otherEntry).id;
    }

    // Will be used by the ArrayAdapter in the ListView
    @Override
    public String toString() {
        return id + ": " + name + " - " + email + " - " + phone + " - " + date + " - " + address + " - " + city + " - " + zipcode + " - " + state + " - " + additionalInfo + " - "
                + nameOfVolunteer + " - " + nccID;
    }
}