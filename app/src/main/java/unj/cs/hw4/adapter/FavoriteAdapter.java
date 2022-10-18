package unj.cs.hw4.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import unj.cs.hw4.R;
import unj.cs.hw4.data.Datasource;
import unj.cs.hw4.model.Coffee;
import unj.cs.hw4.ui.dashboard.DashboardFragmentDirections;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder> {

    private final Context context;
    public static ArrayList<Coffee> dataset = new ArrayList<>();
    public static class FavoriteViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final ImageView imageView;
        private final TextView descView;
        private final LinearLayout card;
        public FavoriteViewHolder(@NonNull View view) {
            super(view);
            this.textView = view.findViewById(R.id.item_title);
            this.imageView = view.findViewById(R.id.item_image);
            this.descView = view.findViewById(R.id.item_desc);
            this.card = view.findViewById(R.id.card);
        }
    }

    public FavoriteAdapter(Context context) {
        this.context = context;
    }
    @NonNull
    @Override
    public FavoriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View adapterLayout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new FavoriteViewHolder(adapterLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteViewHolder holder, int position) {
        Coffee item = dataset.get(position);
        holder.textView.setText(context.getResources().getString(item.getTitleResourceId()));
        holder.imageView.setImageResource(item.getImageResourceId());
        String[] descPreview = (context.getResources().getString(item.getDescResourceId())).split("\\.");
        holder.descView.setText(descPreview[0] + ".");
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int coffeeId = new Datasource().loadDataset().indexOf(item);
                NavDirections action = DashboardFragmentDirections.actionNavigationDashboardToDetailsFragment(coffeeId);
                Navigation.findNavController(view).navigate(action);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
