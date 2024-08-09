package com.example.pexelsapp.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pexelsapp.R
import com.example.pexelsapp.domain.models.PhotoModel

class PopularPhotosAdapter(
    private var photos: MutableList<PhotoModel>
) : RecyclerView.Adapter<PopularPhotosAdapter.PhotoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
        return PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(photos[position])
    }

    override fun getItemCount(): Int = photos.size

    inner class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.photoImageView)

        fun bind(photo: PhotoModel) {
            imageView.load(photo.url)
        }
    }

    fun updatePhotos(newPhotos: List<PhotoModel>) {
        val diffCallback = PhotosDiffCallback(photos, newPhotos)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        photos.clear()
        photos.addAll(newPhotos)
        diffResult.dispatchUpdatesTo(this)
    }


}