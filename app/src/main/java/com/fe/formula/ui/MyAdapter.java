package com.fe.formula.ui;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fe.formula.MainActivity;
import com.fe.formula.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Myholder> implements Filterable {

    List<Item> list;
    Context context;
    List<Item> back;

    public MyAdapter(List<Item> list, Context context) {
        this.list = list;
        this.context = context;
        back = new ArrayList<>(list);

    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.my_card2, parent, false);
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {

        Item item = list.get(position);
        holder.title.setText(item.getTitle());
        Document document = Jsoup.parse(item.getContent());
        holder.decs.setText(document.text());


        Elements element = document.select("img");
        Log.d("CODE", "Image -" + element.get(0).attr("src"));
        Log.d("TEXT", document.text());
        Glide.with(context).load(element.get(0).attr("src")).into(holder.imageView);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Second.class);
                intent.putExtra("title", item.getTitle());
                intent.putExtra("image", element.get(0).attr("src"));
                intent.putExtra("description", document.text());

                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence keyword) {
            ArrayList<Item> filterdata = new ArrayList<>();
            if (keyword.toString().isEmpty())
                filterdata.addAll(back);

            else {
                for (Item obj : back) {
                    if (obj.getTitle().toString().toLowerCase().contains(keyword.toString().toLowerCase()))
                        filterdata.add(obj);
                }
            }
            FilterResults results = new FilterResults();
            results.values = filterdata;
            return results;
        }

        @Override

        protected void publishResults(CharSequence constraint, FilterResults results) {
            list.clear();
            list.addAll((List<Item>) results.values);
            notifyDataSetChanged();
        }
    };

    public class Myholder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title, decs;
        CardView layout;

        public Myholder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            decs = itemView.findViewById(R.id.description);
            imageView = itemView.findViewById(R.id.imageView);
            layout = itemView.findViewById(R.id.cardview_layout);


        }
    }
}
