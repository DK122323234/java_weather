public class dg {
  static int s = 1;
   static int b = 2;
    public static void df () {
        if (s > 0 && b > 1) {
            System.out.println("Хот дог приготовлен");
            s = s - 1;
            b = b - 2;
        }
        else {
            System.out.println("На складе не хватает запасов");
        }
    }
}
