public class PrivateRental extends Person {
   
   //Fields
   String driversLN;
   String driverSD;
   
   //Constructor

   public PrivateRental(String s, int id, String nod, String add, int pn, String c, int mp, int p, String em, String dln, String dsd) {
      super(s, id, nod, add, pn, c, mp, p, em);
      driversLN = dln;
      driverSD = dsd;
      }
  

      
      
   public String toString(){
      return super.toString() + "\nLicense number: "+ driversLN + "\nDriver Since: " + driverSD;
   }
   
   @Override
   public String toFileFormat(){
      return "PrivateRental " + super.toFileFormat() +" "+ driversLN + " "+ driverSD;
   }
}