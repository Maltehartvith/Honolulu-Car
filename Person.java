public class Person {
   
   //Fields
   String symbol;
   int id;
   String nameOfDriver;
   String adress;
   int postNumber;
   String city;
   int mobilePhone;
   int phone;
   String eMail;
   
   //Constructor
   public Person(String s, int id, String nod, String add, int pn, String c, int mp, int p, String em){
      symbol = s;
      this.id = id;
      nameOfDriver = nod;
      adress = add;
      postNumber = pn;
      city = c;
      mobilePhone = mp;
      phone = p;
      eMail = em;
   }
   
   //Metoder
   public String toString(){
      return("Costumer ID: " + symbol + id +"\nName of the driver: " + nameOfDriver + "\nAddress: " + adress + "\nPostnumber: " 
      + postNumber + "\nCity: " + city + "\nMobilephone: " + mobilePhone + "\nPhonen: " 
      + phone + "\nE-mail: " + eMail);
   }
   
   public String toFileFormat(){
      return(symbol + id + " " + nameOfDriver + " " + adress + " "+ postNumber + " " + city + " " + mobilePhone + " " + phone + " " + eMail);
   }
   
   
}