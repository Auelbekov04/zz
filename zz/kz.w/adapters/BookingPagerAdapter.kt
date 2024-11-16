package edu.ws2024.myapplication.adapters

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import edu.ws2024.myapplication.fragments.GuestReviewsFragment
import edu.ws2024.myapplication.fragments.RoomSelectionFragment

class BookingPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> GuestReviewsFragment() // Фрагмент отзывов
            1 -> RoomSelectionFragment() // Фрагмент выбора комнаты
            else -> throw IllegalArgumentException("Invalid position")
        }
    }
}