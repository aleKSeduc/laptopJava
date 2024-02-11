import java.util.ArrayList;

public class Laptop {
    String instanseName; // a
    String valDRAM;      // b
    String valSSD;       // c
    String typeOS;       // d
    String color;        // e
    

    public Laptop(String a, String b, String c, String d, String e) {
            this.instanseName = a;
            this.valDRAM = b;
            this.valSSD = c;
            this.typeOS = d;
            this.color = e;
    }

    public ArrayList<String> filList() {
        ArrayList<String> rawLaptop = new ArrayList<>();
        rawLaptop.add(instanseName);
        rawLaptop.add(valDRAM);
        rawLaptop.add(valSSD);
        rawLaptop.add(typeOS);
        rawLaptop.add(color);
        return rawLaptop;
    }  
}

