package com.example.pexelsapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pexelsapp.databinding.FragmentHomeBinding
import com.example.pexelsapp.presentation.adapters.PhotoAdapter
import com.example.pexelsapp.ui.viewModels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    // The view binding for the fragment's layout
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    // The ViewModel associated with this fragment
    private val viewModel: HomeViewModel by viewModels()

    // This method is called to create the fragment's view hierarchy
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the fragment's layout and store the binding
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    // This method is called after the view hierarchy has been created
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Create a new PhotoAdapter instance
        val adapter = PhotoAdapter()
        // Set the adapter on the RecyclerView
        binding.recyclerView.adapter = adapter
        // Set the layout manager for the RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        // Observe the photos LiveData from the ViewModel
        viewModel.photos.observe(viewLifecycleOwner) { photos ->
            // Update the adapter with the new list of photos
            adapter.submitList(photos)
        }
    }

    // This method is called when the fragment's view hierarchy is about to be destroyed
    override fun onDestroyView() {
        super.onDestroyView()
        // Release the view binding reference
        _binding = null
    }
}