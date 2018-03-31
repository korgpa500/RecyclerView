package com.example.yousryelwrdany.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Yousry Elwrdany on 31/03/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<ListItem> listItems;
    private Context context;

    public MyAdapter(List<ListItem> listItems ,Context context){
        this.listItems = listItems;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ListItem listItem = listItems.get(position);
        holder.txtHead.setText(listItem.getHead());
        holder.txtDescription.setText(listItem.getDescription());

        Picasso.with(context)
                .load(listItem.getImageUri())
                .into(holder.imageView);
    }


    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtHead;
        public TextView txtDescription;
        public ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            txtHead = (TextView)itemView.findViewById(R.id.txtHead);
            txtDescription = (TextView)itemView.findViewById(R.id.txtDescription);
            imageView = (ImageView)itemView.findViewById(R.id.imageView);
        }
    }

}
