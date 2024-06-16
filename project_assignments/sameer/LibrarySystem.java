import java.util.ArrayList;
import java.util.List;


class Book {
    public String mTitle;
    public String mAuthor;
    public String mISBN;
    public boolean mInLibrary;

    public Book(String title, String author, String ISBN, boolean inLibrary) {
        mTitle = title;
        mAuthor = author;
        mISBN = ISBN;
        mInLibrary = inLibrary;
    }

    public String getDetails() {
        return "Title: "+ mTitle+" Author: " + mAuthor +" ISBN: " + mISBN+" Is it available: "+mInLibrary;
    }
}


class Member {
    private String mName;
    private int mMId;

    public Member(String name, int MId) {
        mName = name;
        mMId = MId;
    }

    public String getDetails() {
        return "Name: "+mName+"MembershipID: "+mMId;
    }
}

class Library {
    private Book[] books = new Book[100];
    private Member[] members = new Member[100];
    int bookCount = 0;
    int memberCount = 0;


    public void addBook(Book book) {
        if(book!=null && bookCount < books.length)
        {
            books[bookCount]=book;
            bookCount++;
        }        
    }

    // public void removeBook(String ISBN)
    // {
    //     if(ISBN != null && !ISBN.isEmpty())
    //     {
    //         for(int i=0;i<bookCount;i++)
    //         {
    //             if(ISBN.equals(books[i].mISBN))
    //             {
    //                 books[i]==null;
                    
    //             }
    //         }
    //     }
    // }

    public void addMember(Member member) {
        if(member!=null && memberCount<members.length)
        {
            members[memberCount]=member;
            memberCount++;
        }
    }

    public void printBooks() {
        for (int k=0;k<books.length;k++) {
            if(books[k]!=null)
            {
                System.out.println(books[k].getDetails());
            }
        }
    }

    public void printMembers() {
        for (int l=0;l<members.length;l++) {
            if(members[l]!=null)
            {
                System.out.println(members[l].getDetails());
            }
        }
    }

    public void lendBooks(String ISBN)
    {
        for(int m=0;m<books.length;m++)
        {
            if(books[m]!=null && books[m].mISBN.equals(ISBN))
            {
                System.out.println("The book " + books[m].mTitle +" is successfully taken");
                books[m].mInLibrary = false;
            }
        }
    }

    public void returnBooks(String ISBN)
    {
        for(int m=0;m<books.length;m++)
        {
            if(books[m]!=null && books[m].mISBN.equals(ISBN))
            {
                System.out.println("The book " + books[m].mTitle +" is successfully returned");
                books[m].mInLibrary = true;
            }
        }
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book("Harry Potter", "JK Rowling", "1234567890",true));
        library.addBook(new Book("RRR", "Rajamouli", "2345678901",true));

        library.addMember(new Member("Sameer", 101));
        library.addMember(new Member("Namburi", 103));

        library.lendBooks("1234567890");
        
        System.out.println("Library Books:");
        library.printBooks();

        System.out.println("\nLibrary Members:");
        library.printMembers();

        library.returnBooks("1234567890");

        System.out.println("Library Books:");
        library.printBooks();
    }
}
