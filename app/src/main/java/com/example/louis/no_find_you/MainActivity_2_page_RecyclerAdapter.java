package com.example.louis.no_find_you;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Louis on 2018-03-06.
 */

public class MainActivity_2_page_RecyclerAdapter extends RecyclerView.Adapter<MainActivity_2_page_RecyclerAdapter.ViewHolder> {

    private String[] titles = {

            "Chapter one",
            "Chapter two",
            "Chapter three",
            "Chapter four",
            "Chapter five",
            "Chapter six",
            "Chapter seven",
            "Chapter eight",
            "Chapter nine",
            "Chapter ten",

            "Chapter one",
            "Chapter two",
            "Chapter three",
            "Chapter four",
            "Chapter five",
            "Chapter six",
            "Chapter seven",
            "Chapter eight",
            "Chapter nine",
            "Chapter ten",
    };

    private String[] details = {

            "Item one details",
            "Item two details",
            "Item three details",
            "Item four details",
            "Item five details",
            "Item six details",
            "Item eight details",
            "Item nine details",
            "Item ten details",

            "Item one details",
            "Item two details",
            "Item three details",
            "Item four details",
            "Item five details",
            "Item six details",
            "Item eight details",
            "Item nine details",
            "Item ten details",

    };


    private int[] images = {

            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,

            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,

            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,

            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,

            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,



    };


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main_2_cardview_adapter_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.itemImage.setImageResource(images[i]);
        viewHolder.itemTitle.setText(titles[i]);
        viewHolder.itemDetail.setText(details[i]);



    }

    @Override
    public int getItemCount() {

        return titles.length;



    }


    class ViewHolder extends RecyclerView.ViewHolder {

        public int currentItem;

        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemDetail;

        public ViewHolder(View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.cardview_imageview);
            itemTitle = itemView.findViewById(R.id.item_title);
            itemDetail = itemView.findViewById(R.id.item_detail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    Snackbar.make(v, " 사진을 클릭 했습니다. 다른 페이지로 이동합니다. " + position, Snackbar.LENGTH_SHORT).setAction("Action", null).show();
                }
            });



        }



    }


}