package wallpaperapp.newpack.hsn;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;

public class MyPager_draw extends PagerAdapter {
    private Context context;

    int[]  modelforresultcalllogs;

    public MyPager_draw(Context context, int[]  p) {
        this.context = context;
        this.modelforresultcalllogs = p;
    }



    /*
    This callback is responsible for creating a page. We inflate the layout and set the drawable
    to the ImageView based on the position. In the end we add the inflated layout to the parent
    container .This method returns an object key to identify the page view, but in this example page view
    itself acts as the object key
    */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.linear_layout, null);
        ImageView imageView = view.findViewById(R.id.image);



       imageView.setImageResource(modelforresultcalllogs[position]);


        container.addView(view);
        return view;
    }
    /*
    This callback is responsible for destroying a page. Since we are using view only as the
    object key we just directly remove the view from parent container
    */
    @Override
    public void destroyItem(ViewGroup container, int position, Object view) {
        container.removeView((View) view);
    }
    /*
    Returns the count of the total pages
    */
    @Override
    public int getCount() {
        return modelforresultcalllogs.length;
    }
    /*
    Used to determine whether the page view is associated with object key returned by instantiateItem.
    Since here view only is the key we return view==object
    */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return object == view;
    }

}