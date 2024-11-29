package com.example.hms;

public class ModelTableDoctors {
    String doctorName, doctorId, Address, Email, PhoneNumber, Age, Specialty, Hours, Salary, YOE, Room;

    public ModelTableDoctors(String doctorName, String doctorId, String address, String email, String phoneNumber, String age, String specialty, String hours, String salary, String YOE, String room) {
        this.doctorName = doctorName;
        this.doctorId = doctorId;
        this.Address = address;
        this.Email = email;
        this.PhoneNumber = phoneNumber;
        this.Age = age;
        this.Specialty = specialty;
        this.Hours = hours;
        this.Salary = salary;
        this.YOE = YOE;
        this.Room = room;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getDoctorId() {
        return doctorId;
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

    public String getSpecialty() {
        return Specialty;
    }

    public String getHours() {
        return Hours;
    }

    public String getSalary() {
        return Salary;
    }

    public String getYOE() {
        return YOE;
    }

    public String getRoom() {
        return Room;
    }
}
