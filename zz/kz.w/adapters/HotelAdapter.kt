package edu.ws2024.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.ws2024.myapplication.R
import edu.ws2024.myapplication.models.Hotel
import java.io.InputStream

class HotelAdapter(
    private val hotels: List<Hotel>,
    private val onBookClick: (Hotel) -> Unit
) : RecyclerView.Adapter<HotelAdapter.HotelViewHolder>() {

    class HotelViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.hotelName)
        val rating: RatingBar = view.findViewById(R.id.hotelRating)
        val distance: TextView = view.findViewById(R.id.hotelDistance)
        val bookButton: Button = view.findViewById(R.id.bookButton)
        val coverImage: ImageView = view.findViewById(R.id.hotelCoverImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_hotel, parent, false)
        return HotelViewHolder(view)
    }

    override fun onBindViewHolder(holder: HotelViewHolder, position: Int) {
        val hotel = hotels[position]
        holder.name.text = hotel.hotel_name
        holder.rating.rating = (hotel.hotel_rating / 2).toFloat()
        holder.distance.text = "${hotel.hotel_to_ski_distance} km from Alps' ski lift"

        // Настройка изображения
        val inputStream: InputStream = holder.itemView.context.assets.open(hotel.hotel_cover_image)
        holder.coverImage.setImageBitmap(android.graphics.BitmapFactory.decodeStream(inputStream))

        // Обработка кнопки "Забронировать"
        holder.bookButton.setOnClickListener {
            onBookClick(hotel)
        }
    }

    override fun getItemCount(): Int = hotels.size
}


