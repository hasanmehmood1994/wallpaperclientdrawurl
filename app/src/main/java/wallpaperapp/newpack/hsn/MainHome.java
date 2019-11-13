package wallpaperapp.newpack.hsn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.io.IOException;


public class MainHome extends AppCompatActivity {



    // image array(idr ap ne sari image dalni)
   static int[] imglisdrawable = new int[]{R.drawable.in4, R.drawable.in5,R.drawable.loading,R.drawable.hhh};



    public  static  String[] imglisurl = new String[]{"https://cdn.pixabay.com/photo/2018/10/30/16/06/water-lily-3784022__340.jpg"
            ,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7AUn8-oTWJcaEX-WkNZW20JkQNnfZBpWVuCFQNBvklBKoJfEH&s"
            ,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7AUn8-oTWJcaEX-WkNZW20JkQNnfZBpWVuCFQNBvklBKoJfEH&s"
            ,"https://cdn.pixabay.com/photo/2018/10/30/16/06/water-lily-3784022__340.jpg"


    };
    private ImageView imageView;


    RecyclerView recyclerView;
    private InterstitialAd mInterstitialAd;


    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Flowers");


       // setWallpaper();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewImage);

     fromdrawable();




    // fromurl();



        AdView mAdView ;
//        mAdView.setAdSize(AdSize.BANNER);
//        mAdView.setAdUnitId( String.valueOf(R.string.bannerid));
//        ((ConstraintLayout)adContainer).addView(mAdView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(String.valueOf("ca-app-pub-3940256099942544/1033173712"));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }

    public void fromdrawable() {

        try {
            setUPListfromdrawable();
        }
        catch (Exception e)
        {

        }


    }

    private void setUPListfromdrawable() {


        recyclerView.setLayoutManager(new LinearLayoutManager(MainHome.this));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainHome.this,3);
        ImageAdapter_drawable statusImageAdapter = new ImageAdapter_drawable(imglisdrawable, imglisdrawable.length);
        recyclerView.setAdapter(statusImageAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(MainHome.this, recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                Intent intent =new Intent(MainHome.this, ImageViewActivity.class);
                intent.putExtra("path",""+position);
                intent.putExtra("size",""+imglisdrawable.length);
                intent.putExtra("inn","1");

                startActivity(intent);
loadinterstitial();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

    }
    public void fromurl() {

        try {
            setUPListfromurl();
        }
        catch (Exception e)
        {

        }


    }

    private void setUPListfromurl() {

        recyclerView.setLayoutManager(new LinearLayoutManager(MainHome.this));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainHome.this,3);
        ImageAdapter_url statusImageAdapter = new ImageAdapter_url(imglisurl, imglisdrawable.length, MainHome.this);
        recyclerView.setAdapter(statusImageAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(MainHome.this, recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                Intent intent =new Intent(MainHome.this, ImageViewActivity.class);
                intent.putExtra("path",""+position);
                intent.putExtra("inn","0");
                intent.putExtra("size",""+imglisurl.length);
                startActivity(intent);
                loadinterstitial();

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

    }

    public void  loadinterstitial()
    {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }
    private void setWallpaper() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.in4);
        WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
        try{
            manager.setBitmap(bitmap);

            Toast.makeText(this, "Wallpaper set!", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
        }
    }
}
