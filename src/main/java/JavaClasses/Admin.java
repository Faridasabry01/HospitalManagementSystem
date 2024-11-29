package JavaClasses;

public class Admin {
    private static Admin admin;
    private static String name;
    private String password;

    private Admin(String name, String password)
    {
        this.name= name;
        this.password=password;
    }
    public static synchronized Admin getInstance(String n,String pass)
    {
        if(admin==null)
            admin=new Admin(n,pass);
        return admin;
    }
}
