package unj.cs.hw4.ui.details;

import android.os.Bundle;
import android.util.Log;
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

import unj.cs.hw4.MainActivity;
import unj.cs.hw4.R;
import unj.cs.hw4.adapter.FavoriteAdapter;
import unj.cs.hw4.data.Datasource;
import unj.cs.hw4.data.FavoriteCoffee;
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

    //    public DetailsFragment() {
    //      Required empty public constructor
    //    }

//    public static DetailsFragment newInstance(String param1, String param2) {
//        DetailsFragment fragment = new DetailsFragment();
//        Bundle args = new Bundle();
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle arguments = getArguments();
        // Log.d("ARG", arguments.get(POSITION).toString());
        coffeeId = (int) arguments.get(POSITION);
        item = new Datasource().loadDataset().get(coffeeId);

        // Log.d("ARG", String.valueOf(coffeeId));
        // Log.d("COFFEE", item.toString());
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
        return root;
        // return inflater.inflate(R.layout.fragment_details, container, false);
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
                if(dataset.add(item)){
                    Toast.makeText(getContext(), "Added to favorite!", Toast.LENGTH_SHORT).show();
                }
                // Log.d("FAV", String.valueOf(coffeeId));
//                favCoffees.addFavoriteCoffee(item);
//                Log.d("LIST FAV", favCoffees.getFavoriteCoffee().toString());
            }
        });
        // title.setText(getString(R.string.coffee_name, "Americano"));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        BottomNavigationView navBar = getActivity().findViewById(R.id.nav_view);
        navBar.setVisibility(View.VISIBLE);
    }
}