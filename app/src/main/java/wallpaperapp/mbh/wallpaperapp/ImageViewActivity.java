package wallpaperapp.mbh.wallpaperapp;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;


public class ImageViewActivity extends AppCompatActivity {

    ImageView imageView;
    private ViewPager viewPager;
    private InterstitialAd mInterstitialAd;
    private CircleIndicator circleIndicator;
TextView textView;
    private MyPager_url myPager;

    private MyPager_draw myPager2;


    private ArrayList<String> imageUrls1;
    private String foldername;
    private int iindex;
    int cu;
    String ss;
    private String totalsize;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
textView=findViewById(R.id.textView);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }


        final Intent intent = getIntent();
     ss=intent.getStringExtra("path");
      innn=intent.getStringExtra("inn");
        totalsize=intent.getStringExtra("size");
        iindex= Integer.parseInt(ss);
       cu= Integer.parseInt(ss);
      cu= cu+1;


if (innn.equals("1"))
{
    setUPListdraw();
    textView.setText(""+cu+" / "+totalsize);
}
else {
    setUPListurl();
    textView.setText(""+cu+" / "+totalsize);
}



        AdView mAdView ;


        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(String.valueOf(R.string.interstitialid));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

    }

String innn;
    private void setUPListurl() {





        viewPager = findViewById(R.id.view_pager);
        myPager = new MyPager_url(ImageViewActivity.this, MainHome.imglisurl);
        viewPager.setAdapter(myPager);
        circleIndicator = findViewById(R.id.circle);

        circleIndicator.setViewPager(viewPager);
        viewPager.setCurrentItem(iindex,true);
viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
     //   Toast.makeText(ImageViewActivity.this, ""+position, Toast.LENGTH_SHORT).show();


    iindex=position;
    cu=position+1;
        textView.setText(""+cu+" / "+totalsize);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
});
    }
    private void setUPListdraw() {





        viewPager = findViewById(R.id.view_pager);
        myPager2 = new MyPager_draw(ImageViewActivity.this, MainHome.imglisdrawable);
        viewPager.setAdapter(myPager2);
        circleIndicator = findViewById(R.id.circle);

        circleIndicator.setViewPager(viewPager);
        viewPager.setCurrentItem(iindex,true);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //   Toast.makeText(ImageViewActivity.this, ""+position, Toast.LENGTH_SHORT).show();

                iindex=position;
                cu=position+1;
                textView.setText(""+position+" / "+totalsize);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Toast.makeText(this, ""+viewPager.getChildCount(), Toast.LENGTH_SHORT).show();
    }



    public void setaswall(View view) {
        if (innn.equals("1")) {
            Toast.makeText(this, "" + iindex, Toast.LENGTH_SHORT).show();
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), MainHome.imglisdrawable[iindex]);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                loadinterstitial();
                manager.setBitmap(bitmap);

                Toast.makeText(this, "Wallpaper set!", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }

        }
        else {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            WallpaperManager wpm = WallpaperManager.getInstance(ImageViewActivity.this);
            InputStream ins = null;
            try {
                ins = new URL(MainHome.imglisurl[iindex]).openStream();
                wpm.setStream(ins);
                Toast.makeText(this, "Wallpaper set!", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }



        }
    }
    public void  loadinterstitial()
    {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }





}
