package com.example.moviecatalogueapi;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

public class MovieDetail extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    TextView tvName, tvScore, tvDate, tvOverview;
    ImageView imgPhoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        tvName = findViewById(R.id.tv_judul);
        tvScore = findViewById(R.id.tv_score);
        tvDate = findViewById(R.id.tv_date);
        tvOverview = findViewById(R.id.tv_overview);
        imgPhoto = findViewById(R.id.iv_poster);

        MovieItems movieItems = getIntent().getParcelableExtra(EXTRA_MOVIE);

        tvName.setText(movieItems.getName());
        tvScore.setText("Score: "+movieItems.getScore());
        tvDate.setText(movieItems.getDate());
        tvOverview.setText(movieItems.getOverview());

        String imageUrl = "https://image.tmdb.org/t/p/w780/";
        Glide.with(this)
                .load(imageUrl + movieItems.getPhoto())
                .transform(new RoundedCorners(45))
                .into(imgPhoto);

    }

    public boolean onOptionsItemSelected(MenuItem item){
        onBackPressed();
        return true;
    }
}
