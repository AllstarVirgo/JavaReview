package com.potato.extendtest;

/**
 * Created by allstarvirgo on 17-3-13.
 */
public class SameReturnTypeTest {

}

class Book{
    private int pageNum;

    private String author;

    public Book(int pageNum, String author) {
        this.pageNum = pageNum;
        this.author = author;
    }

    public int getPageNum() {
        return pageNum;
    }

    public String getAuthor() {
        return author;
    }
}

class LinuxOfBird extends Book{
    private String linuxStudy;

    public LinuxOfBird(int pageNum, String author,String linuxStudy) {
        super(pageNum, author);
        this.linuxStudy=linuxStudy;
    }

    public int getPageNum(Book book){
        return book.getPageNum();
    }

    public int getPageNUm(LinuxOfBird book){
        return book.getPageNum();
    }

    public LinuxOfBird get(){
        return this;
    }

    public static void main(String[] args) {
        LinuxOfBird linuxOfBird=new LinuxOfBird(100,"v_Bird","hard harf study");

        System.out.println(linuxOfBird.getPageNum());
    }
}
