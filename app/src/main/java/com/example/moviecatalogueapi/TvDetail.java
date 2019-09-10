package com.example.moviecatalogueapi;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

public class TvDetail extends AppCompatActivity {
    public static final String EXTRA_TV = "extra_tv";
    TextView tvName, tvScore, tvDate, tvOverview;
    ImageView imgPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_detail);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        tvName = findViewById(R.id.tv_judul);
        tvScore = findViewById(R.id.tv_score);
        tvDate = findViewById(R.id.tv_date);
        tvOverview = findViewById(R.id.tv_overview);
        imgPhoto = findViewById(R.id.iv_poster);

        TvItems tvItems = getIntent().getParcelableExtra(EXTRA_TV);

        tvName.setText(tvItems.getName());
        tvScore.setText("Score: "+tvItems.getScore());
        tvDate.setText(tvItems.getDate());
        tvOverview.setText(tvItems.getOverview());

        String imageUrl = "https://image.tmdb.org/t/p/w780/";
        Glide.with(this)
                .load(imageUrl + tvItems.getPhoto())
                .transform(new RoundedCorners(45))
                .into(imgPhoto);

    }

    public boolean onOptionsItemSelected(MenuItem item){
        onBackPressed();
        return true;
    }
}
