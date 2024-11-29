package JavaClasses;

public class Appointment implements Availability{
    String date;
    String time;
    Doctor doc;

    public boolean isAvailable()
    {
        if(date==null)
            return true;
        else
            return false;
    }
    public void addapp(Doctor d)
    {
        d.incnumofapp();
    }


}
