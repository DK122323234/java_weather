public class Book {
    String name;
    String author;
    int pages;
    boolean documentary;
    public Book(String name, String author, int pages, boolean documentary) {
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.documentary = documentary;
    }

    public void string(int string) {
        System.out.println(string);
    }
    public void author(int author) {
        System.out.println(author);
    }
    public int pages(int p) {
        if (p < 1){
            return 0;
        }
        int a = p + pages(p - 1);
         return a;
    }
    private int a = 34;
}