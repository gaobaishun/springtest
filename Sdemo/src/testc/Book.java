package testc;

public class Book {
    private String bookName;

    private String author;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void printBookInfo() {
        System.out.println("Book Name：" + this.bookName + ",Author：" + this.author);
    }
    public void init(){
        System.out.println("book 的初始化方法");
    }
}
