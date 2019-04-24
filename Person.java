public class Person {
 private String name;
 private String second;
 private String dni;
 private String phone;
 private String address;
 private String locality;
 private String zip;
 public Person() {
  // Nothing to do...
 }
 public Person(String name, String second, String dni, String phone, String address, String locality, String zip){
   this.name = name;
   this.second = second;
   this.dni = dni;
   this.phone = phone;
   this.address = address;
   this.locality = locality;
   this.zip = zip;
 }
 @Override
 public String toString() {
    String all = name + " * " + second + " * " + dni + " * " + phone + " * " + address + " * " + locality + " * " + zip + " * ";
    return all;
 }

 public void setName(String n) {
     name = n;
 }
 public String getName() {
     return name;
 }

 public void setSecond(String s) {
    this.second = s;
 }
 public String getSecond() {
     return second;
 }

 public String getDNI() {
     return dni;
 }
 public void setDNI(String dni) {
     this.dni = dni;
 }

 public void setPhone(String t) {
     this.phone = t;
 }
 public String getPhone() {
     return phone;
 }

 public void setAddress(String d) {
     this.address = d;
 }
 public String getAddress() {
    return address;
 }

 public void setLocality(String l) {
     this.locality = l;
 }
 public String getLocality() {
    return locality;
 }

 public void setZip(String z) {
     zip = z;
 }
 public String getZip() {
     return zip;
 }
}
