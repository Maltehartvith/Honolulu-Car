public class LuxuryCar extends Car {

   String hasAirCon;
   String hasCC;
   String interior;
   String CCM;

   public LuxuryCar (String t, String b, String m, String f, String p, String reg, int d,
                  String gt, String hac, String hcc, String i, String ccm ) {
   super(t, b, m, f, p, reg, d, gt);
   hasAirCon = hac;
   hasCC = hcc;
   interior = i;
   CCM = ccm;
   }
}