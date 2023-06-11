package com.example.library;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BooksRecViewAdapter extends RecyclerView.Adapter<BooksRecViewAdapter.ViewHolder>
{
    private static final String TAG = "BooksRecViewAdapter";
    private ArrayList <Book> books = new ArrayList<>();
    private Context context;
    private String type = "";
    private  Util utils;

    public BooksRecViewAdapter(Context context) {
        this.context = context;
        utils = new Util();
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_book_rec_view,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        Log.d(TAG, "onBindViewHolder: called");
        holder.bookName.setText(books.get(position).getName());
        holder.bookcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context , BookActivity.class);
                intent.putExtra("bookId",books.get(position).getId());
                context.startActivity(intent);

            }
        });

        holder.bookcard.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

              final   Book book = books.get(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Deleting" + book.getName())
                        .setMessage("Are you sure you want to delete" + book.getName() + "?")
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                switch (type)
                {
                    case "Want To Read":
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(utils.RemoveWantToReadBook(books.get(position)))
                                {
                                    notifyDataSetChanged();
                                    Toast.makeText(context, book.getName()  +  "Has Succesfully deleted", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }).create().show();
                        break;
                    case "ALready Read":
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(utils.RemoveAlreadyReadBook(books.get(position)))
                                {
                                    notifyDataSetChanged();
                                    Toast.makeText(context, book.getName()  +  "Has Succesfully deleted", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }).create().show();
                        break;
                    case "Currently Reading":
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(utils.RemoveCurrentlyReadingBook(books.get(position)))
                                {
                                    notifyDataSetChanged();
                                    Toast.makeText(context, book.getName()  +  "Has Succesfully deleted", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }).create().show();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        Glide.with(context)
                .asBitmap()
                .load(books.get(position).getImageurl())
                .into(holder.bookImage);
    }
    @Override
    public int getItemCount() {
        return books.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView bookImage;
        private TextView bookName;
        private CardView bookcard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bookImage = (ImageView) itemView.findViewById(R.id.bookimage);
            bookName = (TextView)   itemView.findViewById(R.id.bookname);
            bookcard = (CardView) itemView.findViewById(R.id.bookCard);
        }

    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    public void setType(String type) {
        this.type = type;
    }
}
