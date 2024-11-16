package edu.ws2024.myapplication.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.ws2024.myapplication.R
import edu.ws2024.myapplication.models.Room

class RoomAdapter(private val rooms: List<Room>) : RecyclerView.Adapter<RoomAdapter.RoomViewHolder>() {

    class RoomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val roomTypeTextView: TextView = view.findViewById(R.id.roomTypeTextView)
        val roomPriceTextView: TextView = view.findViewById(R.id.roomPriceTextView)
        val roomFeaturesTextView: TextView = view.findViewById(R.id.roomFeaturesTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_room, parent, false)
        return RoomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        val room = rooms[position]
        holder.roomTypeTextView.text = room.room_type
        holder.roomPriceTextView.text = "€${room.room_price_for_one_night}"
        holder.roomFeaturesTextView.text = room.room_features.joinToString(", ")
    }

    override fun getItemCount() = rooms.size
}
