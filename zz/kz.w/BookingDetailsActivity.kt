package edu.ws2024.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.ws2024.myapplication.adapters.ReviewAdapter
import edu.ws2024.myapplication.adapters.RoomAdapter
import edu.ws2024.myapplication.models.Hotel
import com.google.gson.Gson
import java.io.InputStreamReader

class BookingDetailsActivity : AppCompatActivity() {

    private lateinit var reviewsRecyclerView: RecyclerView
    private lateinit var roomsRecyclerView: RecyclerView
    private lateinit var hotelNameTextView: TextView
    private lateinit var hotel: Hotel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_details)

        // Инициализация UI
        hotelNameTextView = findViewById(R.id.hotelNameTextView)
        reviewsRecyclerView = findViewById(R.id.reviewsRecyclerView)
        roomsRecyclerView = findViewById(R.id.roomsRecyclerView)

        reviewsRecyclerView.layoutManager = LinearLayoutManager(this)
        roomsRecyclerView.layoutManager = LinearLayoutManager(this)

        // Загрузка данных
        hotel = loadHotelFromJson()

        // Установка данных
        hotelNameTextView.text = hotel.hotel_name
        reviewsRecyclerView.adapter = ReviewAdapter(hotel.guest_reviews.reviews_objects)
        roomsRecyclerView.adapter = RoomAdapter(hotel.rooms)
    }

    private fun loadHotelFromJson(): Hotel {
        val inputStream = assets.open("hotels_details.1000.json") // Указываем имя файла
        val reader = InputStreamReader(inputStream)

        return Gson().fromJson(reader, Hotel::class.java) // Преобразуем в объект
    }
}
