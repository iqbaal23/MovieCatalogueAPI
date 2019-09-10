package com.example.moviecatalogueapi;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

import java.util.ArrayList;

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.MovieViewHolder> {
    private ArrayList<TvItems> mData = new ArrayList<>();

    public void setData(ArrayList<TvItems> items){
        mData.clear();
        mData.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_movie, viewGroup, false);
        return new MovieViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieViewHolder movieViewHolder, int i) {
        movieViewHolder.bind(mData.get(i));
        final TvItems tvItems = mData.get(i);

        movieViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(movieViewHolder.itemView.getContext(), TvDetail.class);

                TvItems tv = new TvItems();
                tv.setName(tvItems.getName());
                tv.setScore(tvItems.getScore());
                tv.setDate(tvItems.getDate());
                tv.setOverview(tvItems.getOverview());
                tv.setPhoto(tvItems.getPhoto());

                intent.putExtra(TvDetail.EXTRA_TV, tv);
                movieViewHolder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        String dd = ""  + mData.size();
        Log.d("mData", dd);
        return mData.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView textViewJudul, textViewScore;
        ImageView imgPhoto;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewJudul = itemView.findViewById(R.id.tv_judul);
            textViewScore = itemView.findViewById(R.id.tv_score);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }

        void bind(TvItems tvItems){
            String imageUrl = "https://image.tmdb.org/t/p/w780/";
            textViewJudul.setText(tvItems.getName());
            textViewScore.setText("Score: "+tvItems.getScore());

            Glide.with(itemView.getContext())
                    .load(imageUrl + tvItems.getPhoto())
                    .transform(new RoundedCorners(45))
                    .into(imgPhoto);
        }
    }
}
