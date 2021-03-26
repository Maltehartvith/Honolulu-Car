import java.util.*;

public class Contract{
   //Fields 
   int costumerid;
   String carid;
   String fromdate;
   String todate;
   int maxkm;
   int km;
   String registrationnumber;
 
 //Constructor
 // Istedet for at tage ID'er med har vi taget hele klassen med ind (person og car) fordi vi ikke har lavet ID  
 public Contract(int costumerid, String carid, String fromdate, String todate, int maxkm, int km, String registrationnumber) {
   this.costumerid = costumerid; //this.costumer peger op på sig selv i fields
   this.carid = carid;
   this.fromdate = fromdate;
   this.todate = todate;
   this.maxkm = maxkm;
   this.km = km;
   this.registrationnumber = registrationnumber;
 }
 
 public String toFileFormat(){
   return (costumerid + " " + carid + " " + fromdate + " " + todate + " " + maxkm + " " + km + " " + registrationnumber);
 }
     
}