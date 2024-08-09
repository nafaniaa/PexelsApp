package com.example.pexelsapp.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.pexelsapp.R

class CustomNetworkStatusView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val textView: TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.custom_network_status_view, this, true)
        textView = findViewById(R.id.networkStatusTextView)
    }

    fun showStatus(message: String, isCritical: Boolean) {
        textView.text = message
        textView.setBackgroundColor(
            if (isCritical) resources.getColor(R.color.red, null)
            else resources.getColor(R.color.dark_grey, null)
        )
        visibility = View.VISIBLE
    }

    fun hideStatus() {
        visibility = View.GONE
    }
}