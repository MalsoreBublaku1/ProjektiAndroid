package com.example.hp.projektiandroid.explore;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.projektiandroid.R;

import java.util.ArrayList;


//adapteri i lidh te dhenat tona me recyclerView edhe e percakton ViewHolderin per ti shfaqur keto te dhena(renderin ma shpejt)

/**
 * Created by HP on 5/9/2018.
 */

public class ExploreAdapter extends RecyclerView.Adapter<ExploreAdapter.ImageViewHolder> {
    Context c;//
    ArrayList<ExploreModel> fotot_texti;//

    //private int[] images;//deklarimi i arrayt korrnspondues te fotove

    public ExploreAdapter(Context c, ArrayList<ExploreModel> fotot_texti)//konstruktori me ni parameter array
    {
        this.c = c;
        this.fotot_texti = fotot_texti;//asocimi i vlerave
    }
//https://willowtreeapps.com/ideas/android-fundamentals-working-with-the-recyclerview-adapter-and-viewholder-pattern/

    @Override
    //thirret kur krijohet Adaapteeri perodret per me inicializu ViewHolder qe perdoret per shfaqeje te te dhenave(per me bo render ma shpejt)
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //per me bo inflate album_layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.explore_item, parent, false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view);

        return imageViewHolder;

    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
//kjo metode mundeson lidhjen e adapterit me viewHolderin. ketu pasohen te dhenat te ViewHolderi
        // int image_id=images[position];
        //holder.Album.setImageResource(image_id);
        //holder.AlbumTitle.setText("Image"+position);
        ExploreModel ft = fotot_texti.get(position);
        holder.Album.setImageResource(ft.getImage());
        holder.AlbumTitle.setText(ft.getName());
        holder.Location.setText(ft.getLocation());
        holder.Cmimi.setText(ft.getCmimi());


    }

    @Override
    public int getItemCount() {
        return fotot_texti.size();
    }


//krjimi i ViewHolderit

    public static class ImageViewHolder extends RecyclerView.ViewHolder {

        /*This constructor will take the parent View of the item layout allowing you to
         setup any views you will need to use when displaying your data. */
        ImageView Album;
        TextView AlbumTitle;
        TextView Location;
        TextView Cmimi;

        public ImageViewHolder(View itemView) {
            super(itemView);
            Album = itemView.findViewById(R.id.album);
            Location = itemView.findViewById(R.id.location);
            AlbumTitle = itemView.findViewById(R.id.album_titulli);
            Cmimi = itemView.findViewById(R.id.cmimi);


        }
    }
}

