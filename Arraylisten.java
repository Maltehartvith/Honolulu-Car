import java.util.*;

public class Arraylisten{
   public static void main(String[] args){
   Scanner scan = new Scanner(System.in);
   ArrayList<String> s = new ArrayList<>();
   s.add("Billy");
   s.add("Thomas");
   s.add("Karen");
   ArrayListen(scan, s);
   }
   public static void ArrayListen(Scanner scan, ArrayList<String> s){
   int i = 0;
   System.out.println("Vaelg et nummmer af listen");
   for (i = 0; i < s.size(); i++){
      System.out.println(i + " " + s.get(i));
   }
   int j = scan.nextInt();
         if(j <= s.size()){
      System.out.print(s.get(j));
   }
   }
   }
   
