package com.example.kittapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ViewHolder  extends RecyclerView.ViewHolder {
    View mView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        mView = itemView;

        //item click
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListener.onItemClick(view, getAdapterPosition());
            }
        });

        //item long click
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mClickListener.onItemLongClick(view, getAdapterPosition());
                return true;
            }
        });

        //detail data

        public void setDetail(Context ctx , String name, String description, String species, String image){

            //View

            TextView mName = mView.findViewById(R.id.txt_name);
            TextView mSpecies = mView.findViewById(R.id.txt_species);
            TextView mDescription = mView.findViewById(R.id.txt_description);
            ImageView mImage = mView.findViewById(R.id.img_cat);

            // set data

            mName.setText(name);
            mSpecies.setText(species);
            mDescription.setText(description);
            Picasso.get().load(image).into(mImage);
        }
    }
    private ViewHolder.ClickListener mClickListener;

    //interface to send callbacks
    public interface ClickListener{
        void onItemClick(View view, int position);
        void onItemLongClick(View  view, int position);
    }

    public void setOnClickListener(ViewHolder.ClickListener clickListener){
        mClickListener = clickListener;
    }

}
