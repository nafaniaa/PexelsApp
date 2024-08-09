package com.example.pexelsapp.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.pexelsapp.domain.models.PhotoModel

class PhotosDiffCallback(
    private val oldList: List<PhotoModel>,
    private val newList: List<PhotoModel>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}
