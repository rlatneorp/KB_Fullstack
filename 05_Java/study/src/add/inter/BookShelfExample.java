package add.inter;

public class BookShelfExample {
    public static void main(String[] args) {
        Queue bookQueue = new BookShelf();
        
        bookQueue.enQueue("오이");
        bookQueue.enQueue("당근");
        bookQueue.enQueue("김치");

        System.out.println(bookQueue.deQueue());
        System.out.println(bookQueue.deQueue());
        System.out.println(bookQueue.deQueue());

    }
}
