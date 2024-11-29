package JavaClasses;

public class Person {
     String name;
     private int id;
     private String address;
     String email;
     private String phone_num;

     public Person(String name, int id, String address, String email, String phone_num) {
          this.name = name;
          this.id = id;
          this.address = address;
          this.email = email;
          this.phone_num = phone_num;
     }


     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public String getAddress() {
          return address;
     }

     public void setAddress(String address) {
          this.address = address;
     }

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }

     public String getPhone_num() {
          return phone_num;
     }

     public void setPhone_num(String phone_num) {
          this.phone_num = phone_num;
     }
}
