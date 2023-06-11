package com.example.library;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {

    private static final String TAG = "AllBooksActivity";

    private RecyclerView booksRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        overridePendingTransition(R.anim.in,R.anim.out);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Log.d(TAG, "onCreate: started");

        booksRecView = (RecyclerView) findViewById(R.id.booksRecView);

        BooksRecViewAdapter adapter = new BooksRecViewAdapter(this);
        booksRecView.setAdapter(adapter);
        booksRecView.setLayoutManager(new GridLayoutManager(this,2));

        //books.add(new Book("Kidagaa kimemwozea","Ken Walibora", 168,
              //  "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1460815305i/29927098.jpg"
              //  ,"The reality of the Kenyan political and social situation is" +
               // " well captured in Ken Walibora's Swahili novel, Kidagaa Kimemwozea"));
        //books.add(new Book("The River and the source","Margaret A. Ogola", 292,
              //  "https://m.media-amazon.com/images/I/41FH3xY5jEL.jpg",
              //  "The River And The Source - Kindle edition by Ogolla, Margaret"));
       // books.add(new Book("Betrayal in the city","Francis Imbuga",80,
                //"https://m.media-amazon.com/images/I/4166Ea6HM6L._SY291_BO1,204,203,200_QL40_FMwebp_.jpg",
               // "\"It was better while we waited. Now we have nothing to look forward to." +
                 //       " We have killed our past and are busy killing our future\"."));
        //books.add(new Book("Whale Rider","Witi Ihimaera",152,
               // "https://m.media-amazon.com/images/I/41jZbNtYFYL._SY291_BO1,204,203,200_QL40_FMwebp_.jpg",
               // "Eight-year-old Kahu, a member of the Maori tribe of Whangara, New Zealand, fights to prove her love, her leadership, and her destiny. " +
              //  "Her people claim descent from Kahutia Te Rangi, the legendary \"whale rider.\""));
        Util util = new Util();
        ArrayList<Book> books = new ArrayList<>();
        books = util.getAllBooks();
        adapter.setBooks(books);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                super.onBackPressed();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.close_in, R.anim.close_out);
    }
}