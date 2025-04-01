import java.util.*;

class Kriterijs {
    String nosaukums;
    double svars; // procentos (piem., 50 nozīmē 50%)

    public Kriterijs(String nosaukums, double svars) {
        this.nosaukums = nosaukums;
        this.svars = svars / 100; // Pārvēršam decimāldaļās
    }
}

class Student {
    String vards;
    Map<String, Integer> vertesanasKriteriji;

    public Student(String vards) {
        this.vards = vards;
        this.vertesanasKriteriji = new HashMap<>();
    }

    public void pievienotVertejumu(String kriterijs, int vertejums) {
        vertesanasKriteriji.put(kriterijs, vertejums);
    }
}

class GradeCalculator {
    List<Kriterijs> kriteriji;
    
    public GradeCalculator(List<Kriterijs> kriteriji) {
        this.kriteriji = kriteriji;
    }

    public double aprekinatGalaVertejumu(Student student) {
        double galaVertejums = 0;
        for (Kriterijs k : kriteriji) {
            Integer vertejums = student.vertesanasKriteriji.get(k.nosaukums);
            if (vertejums != null) {
                galaVertejums += vertejums * k.svars;
            }
        }
        return Math.round(galaVertejums * 100.0) / 100.0; // Noapaļošana līdz 2 cipariem
    }
}

public class StudentuVertejums {
    public static void main(String[] args) {
        // Definējam vērtēšanas kritērijus
        List<Kriterijs> kriteriji = Arrays.asList(
            new Kriterijs("Eksāmens", 50),
            new Kriterijs("Mājasdarbi", 30),
            new Kriterijs("Projekts", 20)
        );

        // Izveidojam studentus un pievienojam vērtējumus
        Student anna = new Student("Anna");
        anna.pievienotVertejumu("Eksāmens", 8);
        anna.pievienotVertejumu("Mājasdarbi", 9);
        anna.pievienotVertejumu("Projekts", 10);

        Student janis = new Student("Jānis");
        janis.pievienotVertejumu("Eksāmens", 7);
        janis.pievienotVertejumu("Mājasdarbi", 6);
        janis.pievienotVertejumu("Projekts", 9);

        // Aprēķinam gala vērtējumu
        GradeCalculator kalkulators = new GradeCalculator(kriteriji);
        System.out.println("Anna - Gala vērtējums: " + kalkulators.aprekinatGalaVertejumu(anna));
        System.out.println("Jānis - Gala vērtējums: " + kalkulators.aprekinatGalaVertejumu(janis));
    }
}
