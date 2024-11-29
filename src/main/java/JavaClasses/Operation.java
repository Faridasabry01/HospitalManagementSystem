package JavaClasses;

public class Operation extends Appointment{

    Doctor doctor;
    String room;
    Doctor anestheticDoc;


    public void addop(Doctor d)
    {
        d.incnumofop();
    }

}
