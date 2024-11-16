package edu.ws2024.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import edu.ws2024.myapplication.adapters.HotelAdapter
import edu.ws2024.myapplication.models.Hotel
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    private lateinit var hotelList: RecyclerView
    private lateinit var hotels: List<Hotel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Инициализация RecyclerView
        hotelList = findViewById(R.id.hotelList)
        hotelList.layoutManager = LinearLayoutManager(this)

        // Загрузка данных из JSON
        hotels = loadHotelsFromJson()

        // Установка адаптера
        hotelList.adapter = HotelAdapter(hotels) { hotel ->
            // Переход на экран "Детали бронирования"
            val intent = Intent(this, BookingDetailsActivity::class.java)
            intent.putExtra("HOTEL_ID", hotel.hotel_id)
            intent.putExtra("HOTEL_NAME", hotel.hotel_name)
            startActivity(intent)
        }
    }

    private fun loadHotelsFromJson(): List<Hotel> {
        val inputStream = assets.open("hotels.json")
        val reader = InputStreamReader(inputStream)
        val type = object : TypeToken<List<Hotel>>() {}.type
        return Gson().fromJson(reader, type)
    }
}


