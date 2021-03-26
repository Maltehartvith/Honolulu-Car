public class CompanyRental extends Person{

   //Fields
   String companyName;
   String companyAdress;
   int companyPhonenumber;
   int companyCRN;
   
   //Constructor
   public CompanyRental (String s, int id, String nod, String add, int pn, String c, int mp, int p, String em, String cn, String ca, int cpn, int crn){
   super(s, id, nod, add, pn, c, mp, p, em);
   companyName = cn;
   companyAdress = ca;
   companyPhonenumber = cpn;
   companyCRN = crn;
   }
   
   public String toString(){
   return super.toString() + "\nCompany Name: " + companyName+ "\nCompany Adress: " + companyAdress +"\nCompany Phone Number: " + companyPhonenumber + "\nCompany CRN: "+ companyCRN;
   }
   
   @Override
   public String toFileFormat(){
      return "CompanyRental " + super.toFileFormat() + " " +companyName + " " + companyAdress +" "+ companyPhonenumber + " " + companyCRN; 
   
   }
}