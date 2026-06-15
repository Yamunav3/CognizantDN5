package DeCompilation;
public class Student {

    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void display() {
        System.out.println("ID: " + this.id);
        System.out.println("Name: " + this.name);
    }

    public static void main(String[] args) {
        Student s = new Student(101, "Yamuna");
        s.display();
    }
}

//o/p

// C:\Users\YAMUNA\Desktop\Projects\CognizantDN5\Module3-Core_Java\DeCompilation>java -jar cfr-0.152.jar Student.class
// /*
//  * Decompiled with CFR 0.152.
//  */
// package DeCompilation;

// public class Student {
//     private int id;
//     private String name;

//     public Student(int n, String string) {
//         this.id = n;
//         this.name = string;
//     }

//     public void display() {
//         System.out.println("ID: " + this.id);
//         System.out.println("Name: " + this.name);
//     }

//     public static void main(String[] stringArray) {
//         Student student = new Student(101, "Yamuna");
//         student.display();
//     }
// }
