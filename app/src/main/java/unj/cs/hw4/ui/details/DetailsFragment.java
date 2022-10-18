package unj.cs.hw4.ui.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;
import unj.cs.hw4.R;
import unj.cs.hw4.adapter.FavoriteAdapter;
import unj.cs.hw4.data.Datasource;
import unj.cs.hw4.databinding.FragmentDetailsBinding;
import unj.cs.hw4.model.Coffee;

public class DetailsFragment extends Fragment {
    private static String POSITION = "position";
    private FragmentDetailsBinding binding = null;
    List<Coffee> dataset = FavoriteAdapter.dataset;
    private Coffee item;
    public int coffeeId;
    public FragmentDetailsBinding getBinding() {
        return binding;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle arguments = getArguments();
        coffeeId = (int) arguments.get(POSITION);
        item = new Datasource().loadDataset().get(coffeeId);
        BottomNavigationView navBar = getActivity().findViewById(R.id.nav_view);
        navBar.setVisibility(View.GONE);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater, container, false);
        View root = getBinding().getRoot();
        setIcon(getBinding().favoriteFab);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        // super.onViewCreated(view, savedInstanceState);
        TextView title = getBinding().titleCoffeeDetail;
        ImageView imgCoffee = getBinding().imageCoffeeDetail;
        TextView desc = getBinding().descCoffeeDetail;
        title.setText(item.getTitleResourceId());
        imgCoffee.setImageResource(item.getImageResourceId());
        desc.setText(item.getDescResourceId());
        FloatingActionButton fav = getBinding().favoriteFab;
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!dataset.contains(item)) {
                    addFavoriteCoffee(item);
                } else {
                    removeFavoriteCoffee(item);
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        BottomNavigationView navBar = getActivity().findViewById(R.id.nav_view);
        navBar.setVisibility(View.VISIBLE);
    }

    private void setIcon(FloatingActionButton floatingActionButton) {
        if(floatingActionButton == null){
            return;
        }

        if (!dataset.contains(item)) {
            floatingActionButton.setImageResource(R.drawable.ic_favorite);
        } else {
            floatingActionButton.setImageResource(R.drawable.ic_delete);
        }
    }

    private void addFavoriteCoffee(Coffee c) {
        if(dataset.add(c)){
            Toast.makeText(getContext(), "Added to favorite!", Toast.LENGTH_SHORT).show();
            setIcon(getBinding().favoriteFab);
        } else {
            Toast.makeText(getContext(), "Failed to add to favorite!", Toast.LENGTH_SHORT).show();
        }
    }

    private void removeFavoriteCoffee(Coffee c) {
        if(dataset.remove(c)){
            Toast.makeText(getContext(), "Removed from favorite!", Toast.LENGTH_SHORT).show();
            setIcon(getBinding().favoriteFab);
        } else {
            Toast.makeText(getContext(), "Failed to remove from favorite!", Toast.LENGTH_SHORT).show();
        }
    }
}