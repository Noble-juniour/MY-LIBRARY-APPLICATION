package com.example.library;

import java.util.ArrayList;

public class Util {
    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> wantToReadBooks;
    private static ArrayList<Book> AlreadyReadBooks;

    private static int id = 0;

    public Util() {
        if (allBooks == null) {
            allBooks = new ArrayList<>();
            initAllBooks();
        }
        if (currentlyReadingBooks == null) {
            currentlyReadingBooks = new ArrayList<>();
        }
        if (wantToReadBooks == null) {
            wantToReadBooks = new ArrayList<>();
        }
        if (allBooks == null) {
            allBooks = new ArrayList<>();
        }
        if (AlreadyReadBooks == null) {
            AlreadyReadBooks = new ArrayList<>();
        }
    }


    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return AlreadyReadBooks;
    }

    public boolean addCurrentlyReadingBook(Book book) {
        return currentlyReadingBooks.add(book);
    }

    public boolean addWantToReadBook(Book book) {
        return wantToReadBooks.add(book);
    }

    public boolean addAlreadyReadBook(Book book) {
        return AlreadyReadBooks.add(book);
    }

    public boolean RemoveCurrentlyReadingBook(Book book) {
        return currentlyReadingBooks.remove(book);
    }

    public boolean RemoveWantToReadBook(Book book) {
        return wantToReadBooks.remove(book);
    }

    public boolean RemoveAlreadyReadBook(Book book) {
        return AlreadyReadBooks.remove(book);
    }

    private static void initAllBooks() {
        String name = "";
        String author = "";
        int pages =   0   ;
        String imageurl = "";
        String description = "";

        id++;
        name = "kidagaa kimemwozea";
        author = "Ken walibora";
        pages   =   168;
        imageurl = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1460815305i/29927098.jpg";
        description = "The story is told using a journey motif of two characters, Imani and Amani. The two leave their homes and set out for Sokomoko town to look for jobs so as to earn a decent living.\n" +
                "\n" +
                "However, during their journey, they come across River Kiberenge whose water is avoided by the natives of that region like a plague because they associate it with death. Amani and Imani defy all the odds and decide to partake of the water.\n" +
                "\n" +
                "River Kiberenge provides the author with another kernel to continue narrating the story. Using this kernel, the reader learns that it is only those who drink from the river that are able to pursue the liberation struggle.\n" +
                "\n" +
                "This comes to pass because, once in Sokomoko Imani and Amani get menial jobs where they work for two brothers – Nasaba Bora and Majisifu who are both oppressors.";
        allBooks.add(new Book(id, name, author, pages, imageurl, description));

        id++;
        name = "River and the source";
        author = "Margret Ogolla";
        pages =    292   ;
        imageurl = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1648581300i/60716209.jpg";
        description = "\"The River and the Source\" vividly portrays the grace and strength of a family matriarch - the wife of a tribal chief - in precolonial Kenya. " +
                "It follws her and her family through the colonial years, shows the family's conversion to Christianity, and follows the family for several generations to the present.\n";
        allBooks.add(new Book(id, name, author, pages, imageurl, description));

        id++;
        name = "Betrayal in the city";
        author = "Francis Imbuga";
        pages =    80   ;
        imageurl = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1348027810i/3541753.jpg";
        description = "Betrayal in the City is a play by Francis Imbuga. " +
                "First published in 1976, the play's powerful indictments of government corruption in post-colonial Africa, the cost to voiceless citizens, and the numbing effects of daily violence make it both an important work of art and an act of extreme courage by its author.\n";
        allBooks.add(new Book(id, name, author, pages, imageurl, description));

        id++;
        name = "Kill Mockingbird";
        author = "Harper Lee";
        pages =    324   ;
        imageurl = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1553383690i/2657.jpg";
        description = "To Kill a Mockingbird is both a young girl's coming-of-age story and a darker drama about the roots and " +
                "consequences of racism and prejudice, probing how good and evil can coexist within a single community or individual";
        allBooks.add(new Book(id, name, author, pages, imageurl, description));

        id++;
        name = "Things Fall Apart";
        author = "Chinua Achebe";
        pages =   209   ;
        imageurl = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1352082529i/37781.jpg";
        description = "A simple story of a \"strong man\" whose life is dominated by fear and anger, Things Fall Apart is written with remarkable economy and subtle irony. " +
                "Uniquely and richly African, at the same time it reveals Achebe's keen awareness of the human qualities common to men of all times and places.\n";
        allBooks.add(new Book(id, name, author, pages, imageurl, description));


        id++;
        name = "An Image of Africa";
        author = "Chinua Achebe";
        pages =    112    ;
        imageurl = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1356445369i/9227004.jpg";
        description = "Beautifully written yet highly controversial, An Image of Africa asserts Achebe's belief in Joseph Conrad as a 'bloody racist' and his conviction that Conrad's novel Heart of Darkness only serves to perpetuate damaging stereotypes of black people. Also included is The Trouble with Nigeria, Achebe's searing outpouring of his frustrations with his country. GREAT IDEAS. Throughout history, some books have changed the world. They have transformed the way we see ourselves - and each other. They have inspired debate, dissent, war and revolution. They have enlightened, outraged, provoked and comforted. They have enriched lives - and destroyed them. Now Penguin brings you the works of the great thinkers, pioneers, radicals and visionaries whose ideas shook civilization and helped make us who we are.";
        allBooks.add(new Book(id, name, author, pages, imageurl, description));

        id++;
        name = "Anthills of the Savannah";
        author = "Chinua Achebe";
        pages =   240   ;
        imageurl = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1348603127i/80213.jpg";
        description = "Chris, Ikem and Beatrice are like-minded friends working under the military regime of His Excellency, the Sandhurst-educated President of Kangan. In the pressurized atmosphere of oppression and intimidation they are simply trying to live and love - and remain friends. But in a world where each day brings a new betrayal, hope is hard to cling on to. Anthills of the Savannah (1987), Achebe's candid vision of contemporary African politics, is a powerful fusion of angry voices. It continues the journey that Achebe began with his earlier novels, tracing the history of modern Africa through colonialism and beyond, and is a work ultimately filled with hope.";
        allBooks.add(new Book(id, name, author, pages, imageurl, description));

        id++;
        name = "Kill me quick";
        author = "Meja Mwangi";
        pages =    156   ;
        imageurl = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1405292614i/2871815.jpg";
        description = "Meja and Maina arrive in the city confident their high school diplomas will lead to employment and a better life. However, they are unable to find jobs and end up living in the streets, among other unemployed and homeless youth. Brutally separated, they meet later behind prison bars.This novel displays Mwangi's talent for writing lively stories depicting societal problems in Kenya";
        allBooks.add(new Book(id, name, author, pages, imageurl, description));

        id++;
        name = "Kintu";
        author = "Jennifer Nansubuga Makumbi";
        pages =    442    ;
        imageurl = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1412026037i/23286828.jpg";
        description = "Uganda’s history reimagined through the cursed bloodline of the Kintu clan in an award-winning debut.In 1750, Kintu Kidda unleashes a curse that will plague his family for generations. In this ambitious tale of a clan and of a nation, Makumbi weaves together the stories of Kintu’s descendants as they seek to break from the burden of their shared past and reconcile the inheritance of tradition and the modern world that is their future.";
        allBooks.add(new Book(id, name, author, pages, imageurl, description));

        id++;
        name = "Oidipus Rex";
        author = "Karel Jerie";
        pages =    72    ;
        imageurl = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1381228191i/18641886.jpg";
        description = "The comic adaptation of a classic Greek myth is based on Sophocles' tragedy and tells the story of a man who unknowingly killed his father and married his own mother. These sins turned his life into a continuous chain of remorse and suffering";
        allBooks.add(new Book(id, name, author, pages, imageurl, description));

        id++;
        name = "Fourth Wing";
        author = "Rebecca Yarros";
        pages =    528    ;
        imageurl = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1666994927i/61431922.jpg";
        description = "Twenty-year-old Violet Sorrengail was supposed to enter the Scribe Quadrant, living a quiet life among books and history. " +
                "Now, the commanding general—also known as her tough-as-talons mother—has ordered Violet to joi    }\nn the hundreds of candidates striving to become the elite of Navarre: dragon riders.\n";
        allBooks.add(new Book(id, name, author, pages, imageurl, description));

    }
}