import java.util.*; 
import java.io.*;

public class Honolulu {
   public static void main (String [] args)throws FileNotFoundException{
    
    boolean stop = true;
    Scanner scan = new Scanner(System.in);
        
    ArrayList<Person> list = readFromFile();
    ArrayList<Car> car = readFromCarFile();
    ArrayList<Contract> contracts = new ArrayList<>();
  
    System.out.println("Heeelllo friend! There is " + list.size() + " Costumer and " + car.size() + " Cars in our data-sheet.. ");
    while(stop){
    boolean stopcase = true;
    System.out.println("The Menu:\n1. Create private or company rental \n2. Create fam, sport or luxury car  \n3. Print car or person \n4. Make Contract \n5. Quit...");
      
      switch(scan.next()){
      case "1":
         while(stopcase){
         System.out.println("Private or company");
            String svar = scan.next();
            if(svar.equalsIgnoreCase("Private")){
               createPrivateRental(scan, list);
               stopcase = false;
            }else if(svar.equalsIgnoreCase("Company")){
               createCompanyRental(scan, list);
               stopcase = false;            
            }else if(svar.equalsIgnoreCase("Quit")){
               stopcase = false;
            }else{ 
               System.out.println("Sorry something wrent wrong - Try again my friend !!");               
            } 
         }
      break;
      
      case "2": 
         System.out.println("Create Sports car, Family car or Luxury car");   
         
         while(stopcase){ 
            String svar = scan.nextLine(); 
                     
            if(svar.equalsIgnoreCase("Family Car")){
               createFamilyCar(scan, car);
               stopcase = false;
            }else if(svar.equalsIgnoreCase("Sports Car")){
               createSportCar(scan, car);
               stopcase = false;
            }else if(svar.equalsIgnoreCase("Luxury Car")){
               createLuxuryCar(scan, car);
               stopcase = false;                        
            }else if(svar.equalsIgnoreCase("Quit")){
               stopcase = false;
            }else{ 
               System.out.println("Sorry something wrent wrong - Try again my friend !!");               
            } 
         }
      break;
      
            
      case "3":
      System.out.println("What do you want to print? \"Person\" or \"Car\"?");
      while(stopcase){
         
         String svar = scan.next();
         if(svar.equalsIgnoreCase("Person")){        
            System.out.println("Select what you want to print:\n1. All persons\n2. All private persons\n3. All company persons");
            printPerson(list, scan);
            stopcase = false;
         }else if(svar.equalsIgnoreCase("Car")){
            System.out.println("Select what you want to print:\n1. All Cars\n2. All Family Cars\n3. All Sports Cars\n4. All Luxury Cars");
            printCars(car, scan);
            stopcase = false;
         }else{
            System.out.println("You typed something wrong, try again");
         }
      }
         

      break;
      
      case "4":        
         while(stopcase){
         System.out.println("Create Conctarct Yes/No");
         String svar = scan.next();
            if(svar.equalsIgnoreCase("Yes")){
               makeContract(scan, list, car, contracts);
               stopcase = false;
            }else if(svar.equalsIgnoreCase("No")){
               stopcase = false;            
            }else if(svar.equalsIgnoreCase("Quit")){
               stopcase = false;
             
         }}

      break;
   
      
      case "5":
         System.out.println("Programmet lukkes");
         writeToFile(list);
         writeToCarFile(car);
         stop = false;
      break;
      
      default:
         System.out.println("Sorry something wrent wrong - Try again my friend !!");
      break;          
    }
    }
     
     /*System.out.println("Create private rentale enter 1, for company enter 2 or 3 to quit");
      int choise = scan.nextInt();
      while(choise != 3){
         if(choise == 1){
            createPrivatRental(scan, list);
         }else if(choise == 2){
            createCompanyRental(scan, list);
         } 
         writeToFile(list);
         System.out.println("Create private rental enter 1, company rental enter 2, 3 to quit");
         choise = scan.nextInt();*/


     
   }

   
   //Metoder
   public static void makeContract(Scanner scan, ArrayList<Person> costumerlist, ArrayList <Car> carmodellist, ArrayList<Contract> contraclist)throws FileNotFoundException{
      //PERSON
      System.out.println("Choose Costumer by number");
      
      for(int i = 0; i < costumerlist.size(); i++){
         System.out.println(i + ". " + costumerlist.get(i).nameOfDriver);
      }
      
      int costumerchoise = scan.nextInt();
      int costumerid = costumerlist.get(costumerchoise).id;
      
      //CAR
      System.out.println("Choose Car by number");
      
      for(int i = 0; i < carmodellist.size(); i++){
         Car car = carmodellist.get(i);
         System.out.println(i + ". " + car.brand + " - " + car.model);
      }
      
      int carchoise = scan.nextInt();
      String carmodel = carmodellist.get(carchoise).model;
      
      System.out.println("Enter from-date & -time ");
      String fromdate = scan.next();
      
      System.out.println("Enter to-date & -time ");
      String todate = scan.next();
      
      System.out.println("Enter max km. ");
      int maxkm = scan.nextInt();
   
      System.out.println("Enter km. ");
      int km = scan.nextInt();
      
      System.out.println("Enter registration number ");
      String registrationnumber = scan.next();
      
      Contract newContract = new Contract (costumerid, carmodel, fromdate, todate, maxkm, km, registrationnumber);
      contraclist.add(newContract);
      writeToFileContract(contraclist);
            
   }
   
   public static void createPrivateRental(Scanner scan, ArrayList<Person> pr1)throws FileNotFoundException{
      System.out.println("Remember to exchange space with \"-\" ");
      
      System.out.println("Enter name of driver: ");
      String nameOfDriver = scan.next();
      
      System.out.println("Enter address: ");
      String adress = scan.next();
      
      System.out.println("Enter postnumber: ");
      int postNumber = scan.nextInt();
      
      System.out.println("Enter city: ");
      String city = scan.next();
      
      System.out.println("Enter mobilenumber: ");
      int mobilenumber = scan.nextInt();
      
      System.out.println("Enter phone number: ");
      int phone = scan.nextInt();
      
      System.out.println("Enter e-mail: ");
      String eMail = scan.next();
      
      System.out.println("Enter drivers licence number; ");
      String dln = scan.next();
      
      System.out.println("Enter driver since date");
      String dsd = scan.next();
      
      //laver et kunde ID her:
      String symbol = "P"; 
      int id = pr1.size() +1;
      
      PrivateRental pr = new PrivateRental(symbol, id, nameOfDriver, adress, postNumber, city, mobilenumber, phone, eMail, dln, dsd);
      pr1.add(pr);
      writeToFile(pr1);
      }
      
   
    public static void createCompanyRental(Scanner scan, ArrayList<Person> cr1)throws FileNotFoundException{
      System.out.println("Remember to exchange space with \"-\" "); 
      System.out.println("Enter name of driver: ");
      String nameOfDriver = scan.next();
      
      System.out.println("Enter address: ");
      String adress = scan.next();
      
      System.out.println("Enter postnumber: ");
      int postNumber = scan.nextInt();
      
      System.out.println("Enter city: ");
      String city = scan.next();
      
      System.out.println("Enter mobilenumber: ");
      int mobilenumber = scan.nextInt();
      
      System.out.println("Enter phone number: ");
      int phone = scan.nextInt();
      
      System.out.println("Enter e-mail: ");
      String eMail = scan.next();
      
      System.out.println("Enter company name: ");
      String cn = scan.next();
      
      System.out.println("Enter company address: ");
      String ca = scan.next();
      
      System.out.println("Enter company phone number: ");
      int cnr = scan.nextInt();
      
      System.out.println("Enter company CRN: ");
      int crn = scan.nextInt();
      
      //laver et kunde ID her: 
      String symbol = "C";
      int id = cr1.size();
      
      CompanyRental cr = new CompanyRental(symbol, id, nameOfDriver, adress, postNumber, city, mobilenumber, phone, eMail, cn, ca, cnr, crn);
      cr1.add(cr); // Her tilføjes objectet cr som er af typen companyrental som er subclass til superclassen Person til arraylisten
      writeToFile(cr1);//Her gemmes Arraylisten til filen 

      }
   
   public static void createSportCar(Scanner scan, ArrayList<Car> car) {
      System.out.println("Remember to exchange space with \"-\" ");
      String type = "SportsCar";
      System.out.println("Enter what brand you want: ");   
      String brand = scan.next();
  
      System.out.println("Enter what model you want: ");
      String model = scan.next();
   
      System.out.println("Enter what fueltype you want: ");
      String fuelType = scan.next();
      
      System.out.println("Enter licens plate number:");
      String licensPlate = scan.next();
      
       
      System.out.println("Enter registration month/year: ");
         String regYearAndMonth = scan.next();
   
      System.out.println("Enter distance driven: ");
      int drivenKM = scan.nextInt();
   
      System.out.println("Enter the geartype: ");
      String gearType = scan.next();
   
      System.out.println("Enter amount of horsepower: ");
      String horsePower = scan.next();

   SportCar sc = new SportCar(type, brand, model, fuelType, licensPlate, regYearAndMonth, drivenKM, gearType, horsePower);
   car.add(sc);

   }

   public static void createFamilyCar(Scanner scan, ArrayList<Car> car){
      System.out.println("Remember to exchange space with \"-\" "); 
         String type = "FamilyCar";
      System.out.println("Enter what brand you want: ");
         String brand = scan.next();

      System.out.println("Enter what model you want: ");
         String model = scan.next();

      System.out.println("Enter what fueltype you want: ");
         String fuelType = scan.next();
      
      System.out.println("Enter license plate number: ");  
         String plate = scan.next();
      
         
      System.out.println("Enter registration month/year: ");
         String regYearAndMonth = scan.next();

      System.out.println("Enter distance driven: ");
         int drivenKM = scan.nextInt();

      System.out.println("Enter the geartype: ");
         String gearType = scan.next();     
      
      System.out.println("Does the car have Air Con?: ");   
         String hasAirCon = scan.next();

      System.out.println("Does the car have Cruise Control: "); 
         String hasCC = scan.next();
      
      
      System.out.println("Enter the amount of seats: "); 
         String seatNumber = scan.next();
   
      FamilyCar fc = new FamilyCar(type, brand, model, fuelType, plate, regYearAndMonth, drivenKM, gearType, hasAirCon, hasCC, seatNumber);
      car.add(fc);
      System.out.println(brand + " " + model + " have been created");
   }
   
   public static void createLuxuryCar(Scanner scan, ArrayList<Car> car2){
      System.out.println("Remember to exchange space with \"-\" ");
         String type = "LuxuryCar";
      System.out.println("Enter what brand you want: ");
         String brand = scan.next();

      System.out.println("Enter what model you want: ");
         String model = scan.next();

      System.out.println("Enter what fueltype you want: ");
         String fuelType = scan.next();

      System.out.println("Enter license plate number: ");
         String licensePlate = scan.next();

         
      System.out.println("Enter registration month/year: ");
         String regYearAndMonth = scan.next();

      System.out.println("Enter distance driven: ");
         int drivenKM = scan.nextInt();

      System.out.println("Enter the geartype: ");
         String gearType = scan.next();

      System.out.println("Does the car have aircorndition? ");
         String airCon = scan.next();
      
      System.out.println("Enter CC size: ");
         String hasCC = scan.next();

      System.out.println("Enter type of interior: ");
         String interior = scan.next();

      System.out.println("Enter CCM size: ");
         String CCM = scan.next();
   
      LuxuryCar lc = new LuxuryCar(type, brand, model, fuelType, licensePlate, regYearAndMonth, drivenKM, gearType, airCon, hasCC, interior, CCM);
      car2.add(lc);
   }
      
   //tager alle værdierne ud af en person og gemmer det på en linje, hvert field er sepererret af en "|"
   public static void writeToFile(ArrayList<Person> list)throws FileNotFoundException{
      PrintStream write = new PrintStream(new File("Customers.txt"));//Printstream sætter det over i filen
            
         for(Person per:list){
           write.println(per.toFileFormat());
         
         } 
         write.close();
   }
   
   public static void writeToFileContract(ArrayList<Contract> list)throws FileNotFoundException{
      PrintStream write = new PrintStream(new File("Contracts.txt"));
            
         for(Contract contract:list){
           write.println(contract.toFileFormat());
         
         } 
         write.close();
   }

    // Starter programmet op i den state som den sluttede i
    //Først tager den hele filen ind i en scanner. Har den en linje vil vi godt tage fat i den   
    public static ArrayList<Person> readFromFile()throws FileNotFoundException{
      
      Scanner scan = new Scanner(new File("Customers.txt"));
      ArrayList<Person> list = new ArrayList<>();
      while(scan.hasNextLine()){
         String line = scan.nextLine();
         Scanner lineScan = new Scanner(line);//tager hele linjen ind i en ny scanner
         
         String type = lineScan.next();
         int id = lineScan.nextInt();
         String nameOfDriver = lineScan.next();
         String adress = lineScan.next();
         int postNumber = lineScan.nextInt();
         String city = lineScan.next();
         int mobilePhone = lineScan.nextInt();
         int phone = lineScan.nextInt();
         String eMail = lineScan.next();
         
         if(type.equals("PrivateRental")){
            String s = "P";
            String driversLN = lineScan.next();
            String driverSD = lineScan.next();
            PrivateRental per = new PrivateRental(s, id, nameOfDriver, adress, postNumber, city, mobilePhone, phone, eMail, driversLN, driverSD);
            list.add(per);
         }
         else if(type.equals("CompanyRental")){
            String s = "C";
            String companyName = lineScan.next();
            String companyAdress = lineScan.next();
            int companyPhonenumber = lineScan.nextInt();
            int companyCRN = lineScan.nextInt();
            CompanyRental compy = new CompanyRental(s, id, nameOfDriver, adress, postNumber, city, mobilePhone, phone, eMail, companyName, companyAdress , companyPhonenumber , companyCRN );
            list.add(compy);
         } else{
            System.out.println("Sorry! Something went wrong my friend... ");
         }
        
      }
      return list;

  }
  
   public static void writeToCarFile(ArrayList<Car> list)throws FileNotFoundException{
      PrintStream write = new PrintStream(new File("Cars.txt"));//Printstream sætter det over i filen
            
         for(Car per : list){
           write.println(per.type + " " + per.brand + " " + per.model + " "+ per.fuelType + " " + per.plate + " " + per.regYearAndMonth + " " + per.drivenKM + " " + per.gearType);
          
         } 
         write.close();

   } 
   public static ArrayList<Car> readFromCarFile()throws FileNotFoundException{
      Scanner scan = new Scanner(new File("Cars.txt"));
      ArrayList<Car> list = new ArrayList<>();
      while(scan.hasNextLine()){
         String line = scan.nextLine();
         Scanner lineScan = new Scanner(line);//tager hele linjen ind i en ny scanner
         
         String type = lineScan.next();
         String brand = lineScan.next();
         String model = lineScan.next();
         String fuelType = lineScan.next();
         String plate = lineScan.next();
         String regYearAndMonth = lineScan.next();
         int drivenKM = lineScan.nextInt();
         String gearType = lineScan.next();
         

         Car car = new Car(type, brand, model, fuelType, plate, regYearAndMonth, drivenKM, gearType);
         list.add(car);
      }
      return list;

  }   
/*   public static void printMyCar(ArrayList<Car> l1){
      for(int i = 0; i < l1.size(); i++){
         System.out.println(l1.get(i));
         System.out.println("\n---------------------\n");
      }    
   }
   public static void printMyPerson(ArrayList<Person> l1){
      for(int i = 0; i < l1.size(); i++){
         System.out.println(l1.get(i));
         System.out.println("\n---------------------\n");
      }    
   }*/
   
         public static void printPerson(ArrayList<Person> p, Scanner scan){
      String svar = scan.next();
      if(svar.equals("1")){
         for(int i = 0; i < p.size(); i++){
            System.out.println(p.get(i));
            System.out.println("\n---------------------\n");
         }
      }if(svar.equals("2")){
         for(Person st : p){
            if(st.symbol.startsWith("P")){
               System.out.println(st);
               System.out.println("\n---------------------\n");
            }
         }
      }else if(svar.equalsIgnoreCase("3")){
         for(Person st : p){
            if(st.symbol.startsWith("C")){
               System.out.println(st);
               System.out.println("\n---------------------\n");
            }
            
         }
      }else{
         System.out.println("You typed something wrong, try again.");
      }
   }
   
   public static void printCars(ArrayList<Car> c, Scanner scan){
      String svar = scan.next();
      if(svar.equals("1")){
         for(int i = 0; i < c.size(); i++){
            System.out.println(c.get(i));
            System.out.println("\n---------------------\n");
         }
      }if(svar.equals("2")){
         for(Car st : c){
            if(st.type.startsWith("Family")){
               System.out.println(st);
               System.out.println("\n---------------------\n");
            }
         }
      }if(svar.equals("4")){
        for(Car st : c){
           if(st.type.startsWith("Luxury")){
              System.out.println(st);
              System.out.println("\n---------------------\n");
           }
        }     
      }else if(svar.equalsIgnoreCase("3")){
         for(Car st : c){
            if(st.type.startsWith("Sports")){
               System.out.println(st);
               System.out.println("\n---------------------\n");
            }
            
         }
      }else{
         System.out.println("You typed something wrong, try again.");
      }
   }   
}