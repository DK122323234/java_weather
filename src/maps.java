public class maps {
    String element;
    int level;
    public  maps(String element, int level) {
        this.element = element;
        this.level = level;
    }
   public String getElement() {
        return "Стихия: " + element + " Уровень: "+level;

    }
}
