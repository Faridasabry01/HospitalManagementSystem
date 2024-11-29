package JavaClasses;

public class Doctor extends Staff{
    String speciality;
    int roomNumber;
    int numOfOperations;
    int numofAppointments;


    public Doctor(Person info, int hrd, int yrsOfExp, double salary, String speciality, int roomNumber, int numOfOperations, int numofAppointments) {
        super(info, hrd, yrsOfExp, salary);
        this.speciality = speciality;
        this.roomNumber = roomNumber;
        this.numOfOperations = numOfOperations;
        this.numofAppointments = numofAppointments;
    }

    @Override
    public double getSalary() {

        return (yrsOfExp*800 + salary+numOfOperations*1500+numofAppointments*250);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "speciality='" + speciality + '\'' +
                ", roomNumber=" + roomNumber +
                ", numOfOperations=" + numOfOperations +
                ", numofAppointments=" + numofAppointments +
                ", info=" + info +
                ", hrd=" + hrd +
                ", yrsOfExp=" + yrsOfExp +
                ", salary=" + salary +
                '}';
    }

    public void incnumofop()
    {
        numOfOperations++;
    }
    public void incnumofapp()
    {
        numofAppointments++;
    }
}
