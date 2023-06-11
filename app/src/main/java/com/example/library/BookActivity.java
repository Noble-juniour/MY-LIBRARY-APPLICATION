package com.example.library;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    private static final String TAG = "BookActivity";

    private TextView bookName,authorName,Description,pageNumber;
    private ImageView bookImage;
    private Button btnCurReading,btnWantToRead,btnAlreadyReadBooks;
    private Book incomingBook;
    private Util util;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        overridePendingTransition(R.anim.in,R.anim.out);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initWidgets();

        Intent intent = getIntent();
        int id = intent.getIntExtra("bookId",0);
        util = new Util();
        ArrayList<Book> books = util.getAllBooks();
        for(Book b : books)
        {
            if(b.getId() == id)
            {

                incomingBook = b;
                bookName.setText(b.getName());
                authorName.setText(b.getAuthor());
                Description.setText(b.getDescription());
                pageNumber.setText(  "Pages"     +   b.getPagenumber());
                Glide.with(this)
                        .asBitmap()
                        .load(b.getImageurl())
                        .into(bookImage);
            }
        }
        btnCurReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnCurReadingTapped();
            }
        });
        btnAlreadyReadBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAlreadyReadBooksTapped();
            }
        });
        btnWantToRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnWantToReadTapped();
            }
        });
    }
    private void btnWantToReadTapped()
    {
        Log.d(TAG, "btnWantToReadTapped: started");
        ArrayList<Book> WantToReadBooks = util.getWantToReadBooks();

        if(WantToReadBooks.contains(incomingBook))
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setMessage("You Already added this book to your currently Reading List");
            builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.setCancelable(false);
            builder.create().show();
        }
        else
        {
            ArrayList<Book> alreadyReadBooks = util.getAlreadyReadBooks();
            if(alreadyReadBooks.contains(incomingBook))
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("You Already Read This Book");
                builder.setTitle("Error");

                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();

            }
            else
            {
                ArrayList<Book> currentlyReadingBooks = util.getCurrentlyReadingBooks();
                if(currentlyReadingBooks.contains(incomingBook))
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("You have added  it to the books you want to read");
                    builder.setTitle("Error");

                    builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.create().show();
                }
                else
                {
                    util.addWantToReadBook(incomingBook);
                    Toast.makeText(this, "The Book" + incomingBook.getName() + "Added To your Want Read Shelf", Toast.LENGTH_SHORT).show();
                }
            }
             }

    }
    private void btnAlreadyReadBooksTapped()
    {
        Log.d(TAG, "btnAlreadyReadBooksTapped: started");

        ArrayList<Book> AlreadyReadBooks = util.getAlreadyReadBooks();

        if(AlreadyReadBooks.contains(incomingBook))
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setMessage("You Already added this book to your Already Read List");
            builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.setCancelable(false);
            builder.create().show();
        }
        else
        {
            ArrayList<Book>currentlyReadingBooks = util.getCurrentlyReadingBooks();

            if (currentlyReadingBooks.contains(incomingBook))
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Have you finished Reading This Book?");
                builder.setTitle("Error");

                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        util.RemoveCurrentlyReadingBook(incomingBook);
                        util.addAlreadyReadBook(incomingBook);
                        Toast.makeText(BookActivity.this, "The Book" + incomingBook.getName() + "Added To your Already Read Shelf", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();
            }
            else
            {
                util.addAlreadyReadBook(incomingBook);
                Toast.makeText(this, "The Book" + incomingBook.getName() + "Added To your Already Read Shelf", Toast.LENGTH_SHORT).show();
            }
             }

    }
    private void btnCurReadingTapped()
    {
        Log.d(TAG, "btnCurReadingTapped: started");

        ArrayList<Book> CurrentlyReadingBooks = util.getCurrentlyReadingBooks();

        if(CurrentlyReadingBooks.contains(incomingBook))
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setMessage("You Already added this book to your Currently Reading List");
            builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.setCancelable(false);
            builder.create().show();
        }
        else
        {
            ArrayList<Book> WantToReadBooks = util.getWantToReadBooks();

            if(WantToReadBooks.contains(incomingBook))
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                builder.setMessage("Are You Going to start Reading this Book?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        util.RemoveWantToReadBook(incomingBook);
                        util.addCurrentlyReadingBook(incomingBook);
                        Toast.makeText(BookActivity.this, "The Book" + incomingBook.getName() + "Added To your Currently Reading Shelf", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setCancelable(false);
                builder.create().show();

            }
            else
            {
                ArrayList<Book>AlreadyReadBooks = util.getAlreadyReadBooks();
                if(AlreadyReadBooks.contains(incomingBook))
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);

                    builder.setMessage("Do you want to read it again?");
                    builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            util.addCurrentlyReadingBook(incomingBook);
                            Toast.makeText(BookActivity.this, "The Book" + incomingBook.getName() + "Added To your Currently Reading Shelf", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.setCancelable(false);
                    builder.create().show();
                }
                else
                {
                    util.addCurrentlyReadingBook(incomingBook);
                    Toast.makeText(this, "The Book" + incomingBook.getName() + "Added To your Currently Reading Shelf", Toast.LENGTH_SHORT).show();
                }

            }
        }

    }
    private  void  initWidgets()
    {
        bookName = (TextView) findViewById(R.id.bookName);
        authorName = (TextView) findViewById(R.id.authorname);
        Description = (TextView) findViewById(R.id.booksDescription);
        bookImage = (ImageView) findViewById(R.id.bookImage);
        pageNumber = (TextView)findViewById(R.id.bookPages);

        btnCurReading = (Button) findViewById(R.id.btnCurReading);
        btnWantToRead = (Button) findViewById(R.id.btnWantToRead);
        btnAlreadyReadBooks = (Button) findViewById(R.id.btnAlreadyReadBooks);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case android.R.id.home:
                //finish();
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