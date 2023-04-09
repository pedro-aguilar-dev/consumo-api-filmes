package com.example.consumoapifilmes.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.consumoapifilmes.R;
import com.example.consumoapifilmes.model.FilmeModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FilmeAdapter extends RecyclerView.Adapter<FilmeAdapter.ViewHolder> {

    private ArrayList<FilmeModel> filmeModelArrayList;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private  TextView textViewTitulo;
        private TextView textViewAno;
        private  ImageView imageViewPoster;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textViewTitulo = (TextView) view.findViewById(R.id.textViewTitulo);
            textViewAno = (TextView) view.findViewById(R.id.textViewAno);
            imageViewPoster = (ImageView) view.findViewById(R.id.imageViewPoster);
        }

        public TextView getTextView() {
            return textViewAno;
        }

        public TextView getTextView2() {
            return textViewTitulo;
        }

        public ImageView getImageViewRange() {
            return imageViewPoster;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public FilmeAdapter(ArrayList<FilmeModel> dataSet) {
        filmeModelArrayList = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_lista_filme, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getTextView2().setText(filmeModelArrayList.get(position).getTitle());
        viewHolder.getTextView().setText(filmeModelArrayList.get(position).getYear());
        Picasso.get().load(filmeModelArrayList.get(position).getPoster()).into(viewHolder.imageViewPoster);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return filmeModelArrayList.size();
    }
}

