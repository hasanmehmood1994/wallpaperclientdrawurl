package wallpaperapp.newpack.hsn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class ImageAdapter_drawable extends RecyclerView.Adapter<ImageAdapter_drawable.MyViewHolder> {

// later...

    private int[] images;
    private int name;

    public ImageAdapter_drawable(int[] images, int name){
        this.images=images;
        this.name =name;
    }

    @NonNull
    @Override
    public ImageAdapter_drawable.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.image_item, null);
        ImageAdapter_drawable.MyViewHolder viewHolder = new ImageAdapter_drawable.MyViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter_drawable.MyViewHolder myViewHolder, int i) {



        myViewHolder.imageView.setImageResource(images[i]);

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.statusItem_imageView);
        }
    }
}
