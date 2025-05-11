import java.util.Arrays;

public class Human {
   private String name = "Dima";
  private   int age = 12;
  private   String monthOfBirth = "Октябрь";

    public Human(String name, int age, String monthOfBirth) {
        this.name = name;
        this.age = age;
        this.monthOfBirth = monthOfBirth;
    }

    public void hello(String name) {
        System.out.printf("%s говорит: привет", name);
    }

    public String hunt() {
        if (this.age < 18) {
       return  "gh";
        }
return "hh";
    }
    public void eat(String name, String ...food) {
        System.out.printf("%s съел: %s ", name, Arrays.toString(food));
    }
    public String Name() {
        return "Это" + name;
    }
    public int age() {
        return age;
    }
    public String monthOfBirth() {
        return "Он родился в" + monthOfBirth;
    }
}