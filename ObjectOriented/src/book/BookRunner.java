package book;

public class BookRunner {

    public static void main(String[] args) {

        Book book = new Book (123,"Object", "Roxana");
        book.addReview(new Review(10, "Great",10));

        System.out.println(book);
    }
}
