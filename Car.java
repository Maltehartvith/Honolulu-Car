public class Car {
   String type;
   String brand;
   String model;
   String fuelType;
   String plate;
   String regYearAndMonth;
   int drivenKM;
   String gearType;
   
   public Car (String t, String b, String m, String f, String p, String reg, int d, String gt) {
      type = t;
      brand = b;
      model = m;
      fuelType = f;
      plate = p;
      regYearAndMonth = reg;
      drivenKM = d;
      gearType = gt;
      }
      
      public String toString() {
         return (type + "\nBrand: " + brand + "\nModel: " + model + "\nType of fuel: " + fuelType + "\nPlate number: " + plate + "\nRegistration year and month: " + regYearAndMonth + "\nDistance driven (KM): " + drivenKM + " km \nType of gear: " + gearType + "\n");
         }
         
  }