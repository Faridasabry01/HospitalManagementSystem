package com.example.hms;

public class ModelTablePatients {

   public String patientName, patientId, Address, Email, PhoneNumber;
    public String Age;
    public String Gender;
    public String Room;
    public String BloodType, Bill;

    public ModelTablePatients(String patientName, String patientId, String Address, String Email, String PhoneNumber, String Age, String Gender, String Room, String BloodType, String Bill) {
        this.patientName = patientName;
        this.patientId = patientId;
        this.Address = Address;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
        this.Age = Age;
        this.Gender = Gender;
        this.Room = Room;
        this.BloodType = BloodType;
        this.Bill=Bill;

    }

    public String getBill() {
        return Bill;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getAddress() {
        return Address;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getAge() {
        return Age;
    }

    public String getGender() {
        return Gender;
    }

    public String getRoom() {
        return Room;
    }

    public String getBloodType() {
        return BloodType;
    }
}
