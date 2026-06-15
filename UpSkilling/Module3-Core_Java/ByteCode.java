public class ByteCode {

    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {

        ByteCode c = new ByteCode();

        int result = c.add(10, 20);

        System.out.println(result);
    }
}


//o/p

// C:\Users\YAMUNA\Desktop\Projects\CognizantDN5\Module3-Core_Java>javac ByteCode.java

// C:\Users\YAMUNA\Desktop\Projects\CognizantDN5\Module3-Core_Java>java ByteCode
// 30

// C:\Users\YAMUNA\Desktop\Projects\CognizantDN5\Module3-Core_Java>javap -c ByteCode
// Compiled from "ByteCode.java"
// public class ByteCode {
//   public ByteCode();
//     Code:
//        0: aload_0
//        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
//        4: return

//   public int add(int, int);
//     Code:
//        0: iload_1
//        1: iload_2
//        2: iadd
//        3: ireturn

//   public static void main(java.lang.String[]);
//     Code:
//        0: new           #7                  // class ByteCode
//        3: dup
//        4: invokespecial #9                  // Method "<init>":()V
//        7: astore_1
//        8: aload_1
//        9: bipush        10
//       11: bipush        20
//       13: invokevirtual #10                 // Method add:(II)I
//       16: istore_2
//       17: getstatic     #14                 // Field java/lang/System.out:Ljava/io/PrintStream;
//       20: iload_2
//       21: invokevirtual #20                 // Method java/io/PrintStream.println:(I)V
//       24: return
// }

