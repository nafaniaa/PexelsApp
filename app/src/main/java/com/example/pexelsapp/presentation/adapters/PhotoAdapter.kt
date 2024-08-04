package com.example.pexelsapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pexelsapp.databinding.ItemPhotoBinding
import com.example.pexelsapp.domain.models.PhotoModel

class PhotoAdapter : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {
    // This is the list of PhotoModel instances that the adapter will display
    private var photos: List<PhotoModel> = listOf()

    // This method is called when the adapter needs to create a new ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        // Inflate the ItemPhotoBinding layout and create a new PhotoViewHolder instance
        val binding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(binding)
    }

    // This method is called to bind the data from the PhotoModel to the ViewHolder
    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        // Bind the PhotoModel at the specified position to the ViewHolder
        holder.bind(photos[position])
    }

    // This method returns the number of items in the adapter
    override fun getItemCount(): Int = photos.size

    // This method is used to update the list of photos displayed by the adapter
    fun submitList(photos: List<PhotoModel>) {
        // Update the photos list and notify the RecyclerView of the changes
        this.photos = photos
        notifyDataSetChanged()
    }

    // The PhotoViewHolder class is responsible for holding the UI elements for each item
    class PhotoViewHolder(private val binding: ItemPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        // This method is used to bind the data from a PhotoModel to the UI elements
        fun bind(photo: PhotoModel) {
            // Set the photographer name text
            binding.photographerName.text = photo.photographer
            // Load the medium-sized photo image using the Coil library
            binding.photoImageView.load(photo.src.medium)
        }
    }
}