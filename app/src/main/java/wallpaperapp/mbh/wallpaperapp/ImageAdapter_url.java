package wallpaperapp.mbh.wallpaperapp;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class ImageAdapter_url extends RecyclerView.Adapter<ImageAdapter_url.MyViewHolder2> {

// later...

    private String[] images;
    private int name;
Context context;
    public ImageAdapter_url(String[] imglisurl, int name, Context context){
        this.images=imglisurl;
        this.name =name;
        this.context=context;
    }



    @NonNull
    @Override
    public ImageAdapter_url.MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.image_item, null);
        ImageAdapter_url.MyViewHolder2 viewHolder = new ImageAdapter_url.MyViewHolder2(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter_url.MyViewHolder2 myViewHolder2, int i) {


        Glide.with(context)
                .load(images[i])
                .centerCrop()
                .placeholder(R.drawable.loading)
                .into(myViewHolder2.imageView);


    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder2 extends RecyclerView.ViewHolder {

        ImageView imageView;
        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.statusItem_imageView);
        }
    }
}
