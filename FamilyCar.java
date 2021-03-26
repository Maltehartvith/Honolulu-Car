public class FamilyCar extends Car {

   String hasAirCon;
   String hasCC;
   String seatNumber;

public FamilyCar (String t, String b, String m, String f, String p, String reg, int d, String gt, String air, String cc, String sn) {
   super (t, b, m, f, p, reg, d, gt);
   
   hasAirCon = air;
   hasCC = cc;
   seatNumber = sn;
   
   }
   
}