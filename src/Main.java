import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] arrOfOrder = new String[5];
        HashSet<String> orderMatch = new HashSet<>();
        // Create List property of Laptop [instanceName, valRAM, valSSD, typeOfOS, color]
        Laptop Laptop1 = new Laptop("HomeServer", "16", "1000", "Linux", "black");
        Laptop Laptop2 = new Laptop("HomeLaptop", "8", "512", "Windows", "black");
        Laptop Laptop3 = new Laptop("WorkLaptop", "8", "512", "macOS", "white");
        HashMap<String, Laptop> allLaptop = new HashMap<>();
        // Adding Laptop in Map
        allLaptop.put("Laptop1", Laptop1);
        allLaptop.put("Laptop2", Laptop2);
        allLaptop.put("Laptop3", Laptop3); 
        
        boolean flagPeek = true;
        boolean flagWithoutFilter = true;
        while (flagPeek){
            System.out.println("Input number according to the choising:\r\n" + //
            "1 - Volume RAM\r\n" + //
            "2 - Volume SSD\r\n" + //
            "3 - Version OS\r\n" + //
            "4 - Color\r\n" + //
            "5 - Peek");

            Scanner s = new Scanner(System.in);
            String ss = s.nextLine();
            if (ss.equals("1")){
                System.out.println("Specify minimum of a value (prompt: 8, 16, 32)");
                String sss = s.nextLine();
                arrOfOrder[1] = sss; 
                flagWithoutFilter = false;
            }    

            else if (ss.equals("2")) {
                System.out.println("Specify minimum of a value (prompt: 256, 512, 1024)");
                String sss = s.nextLine();
                arrOfOrder[2] = sss;
                flagWithoutFilter = false;
            }
               
            else if (ss.equals("3")) {
                System.out.println("Specify version of OS (prompt: Windows, Linux or macOS)");
                String sss = s.nextLine();
                arrOfOrder[3] = sss;
                flagWithoutFilter = false;    
            }
            
            else if (ss.equals("4")) {
                System.out.println("Specify color of Laptop (prompt: black or white)");
                String sss = s.nextLine();
                arrOfOrder[4] = sss;
                flagWithoutFilter = false;
            }
            
            else if (ss.equals("5")) {
                System.out.println("\nPeeking......\n");
                flagPeek = false;    
            }
        }

        for (String j: allLaptop.keySet())  {
            ArrayList<String> jj = allLaptop.get(j).filList();
            for (int i = 1; i < jj.size(); i++) {
                    if (i < 3) {
                        if ((arrOfOrder[i] != null) && (Integer.parseInt(jj.get(i)) >= (Integer.parseInt(arrOfOrder[i])))){
                        orderMatch.add(j);              
                        } else if ((arrOfOrder[i] != null))
                        {orderMatch.remove(arrOfOrder[i]);
                        i = Integer.MAX_VALUE - 1; }
                        }

                    else if (i != Integer.MAX_VALUE - 1) {
                        if ((arrOfOrder[i] != null) && (arrOfOrder[i].equals(jj.get(i)))){
                            orderMatch.add(j);
                        } else if ((arrOfOrder[i] != null))
                        {orderMatch.remove(arrOfOrder[i]);
                        i = Integer.MAX_VALUE - 1; }
                    }
                        
            }

        } 
        boolean flagBreakPrint = false;
        while (!flagWithoutFilter && !flagBreakPrint) {
            if (orderMatch.isEmpty()){
                System.out.println("Laptop is out of stock in this time \n");
            } else {        
                for(String g : orderMatch) {
                    ArrayList<String> m = allLaptop.get(g).filList();
                    printProduct(m);             
                }
            }
            flagBreakPrint = true;
        }
        while (flagWithoutFilter) {  
            for(Laptop m : allLaptop.values()){
                ArrayList<String> mm = m.filList();
                printProduct(mm);
            }
            flagWithoutFilter = false;
        }
        
    }

    public static void printProduct(ArrayList<String> m){
        System.out.println("       Our prefer:\r\n" + //
    "Model name:  " + m.get(0) + " \r\n" + //   
    "Volume RAM:  " + m.get(1) + " GB \r\n" + //
    "Volume SSD:  " + m.get(2) + " GB \r\n" + //
    "Version OS:  " + m.get(3) + "\r\n" +  //
    "Color:       " + m.get(4)+ "\r\n"); 
    }
}

    