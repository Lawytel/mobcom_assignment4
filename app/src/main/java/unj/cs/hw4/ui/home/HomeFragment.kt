package unj.cs.hw4.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import unj.cs.hw4.R
import unj.cs.hw4.adapter.ItemAdapter
import unj.cs.hw4.data.Datasource
import unj.cs.hw4.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val myDataset = Datasource().loadDataset()
        val recyclerView = binding.homeRecyclerView
        recyclerView.adapter = ItemAdapter(requireContext(), myDataset)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}