package edu.ws2024.myapplication.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.ws2024.myapplication.R
import edu.ws2024.myapplication.models.Review

class ReviewAdapter(private val reviews: List<Review>) : RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>() {

    class ReviewViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val usernameTextView: TextView = view.findViewById(R.id.usernameTextView)
        val reviewTextView: TextView = view.findViewById(R.id.reviewTextView)
        val countryTextView: TextView = view.findViewById(R.id.countryTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_review, parent, false)
        return ReviewViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        val review = reviews[position]
        holder.usernameTextView.text = review.username
        holder.reviewTextView.text = review.review_text
        holder.countryTextView.text = review.country
    }

    override fun getItemCount() = reviews.size
}

