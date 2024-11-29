package JavaClasses;

public abstract class Staff {
    Person info;
    int hrd;
    int yrsOfExp;
    double salary;

    public Staff(Person info,int hrd,int yrsOfExp,double salary) {
        this.info = info;
        this.hrd = hrd;
        this.yrsOfExp = yrsOfExp;
        this.salary = salary;
    }



    public abstract double getSalary();
}
