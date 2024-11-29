package JavaClasses;

public class Patient {
    Person info;
    int age;
    String gender;
    String room_num;
    String Room_Type;

    String bloodType;
    int numOfDays;
    double bill=0;
    int room;
    int numofop;
    double otherexp;

    public Patient(Person info, int age, String gender, String room_num, String room_Type, String bloodType, int numOfDays, double bill, int room, int numofop, double otherexp) {
        this.info = info;
        this.age = age;
        this.gender = gender;
        this.room_num = room_num;
        Room_Type = room_Type;
        this.bloodType = bloodType;
        this.numOfDays = numOfDays;
        this.bill = bill;
        this.room = room;
        this.numofop = numofop;
        this.otherexp = otherexp;
    }

    public double totalbill()
    {

        if(Room_Type=="ER"){
            room=500;
        }
        else if(Room_Type=="Regular"){
            room=1000;
        }
        else if(Room_Type=="OR"){
            room=1500;
        }
        else if(Room_Type=="ICU"){
            room=2000;
        }

        else if(Room_Type=="VIP"){
            room=3000;
        }
        bill=numOfDays*room+numofop*2000+otherexp;
        return bill;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "info=" + info +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", room_num='" + room_num + '\'' +
                ", Room_Type='" + Room_Type + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", numOfDays=" + numOfDays +
                ", bill=" + bill +
                ", room=" + room +
                ", numofop=" + numofop +
                ", otherexp=" + otherexp +
                '}';
    }
}
