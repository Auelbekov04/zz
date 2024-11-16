package edu.ws2024.myapplication.models

data class Hotel(
    val hotel_id: Int,
    val hotel_name: String,
    val hotel_rating: Double,
    val hotel_to_ski_distance: Double,
    val hotel_cover_image: String,
    val guest_reviews: GuestReviews,
    val rooms: List<Room>

)

data class GuestReviews(
    val ratings_categories: List<Map<String, Double>>,
    val reviews_objects: List<Review>
)

data class Review(
    val username: String,
    val country: String,
    val review_text: String
)

data class Room(
    val room_id: Int,
    val room_type: String,
    val room_bed_type: String,
    val room_total_number_of_guests: Int,
    val room_features: List<String>,
    val room_price_for_one_night: Double
)