package com.example.facebooktimeline.models

import androidx.annotation.DrawableRes
import com.example.facebooktimeline.R

data class Post(
   val id : Int,
   @DrawableRes val userImage : Int,
    val userName : String,
    val time : String,
    val content : String,
   @DrawableRes val image : Int,
   val likesNo : Int,
   val sharesNo : Int
)

val posts : List<Post> =  listOf(
    Post(
        id = 1,
        userImage = R.drawable.user1,
        userName = "Alice Johnson",
        time = "2h ago",
        content = "Just finished reading a great book! #ReadingTime",
        image = R.drawable.post1,
        likesNo = 120,
        sharesNo = 30
    ),
    Post(
        id = 2,
        userImage = R.drawable.user2,
        userName = "Bob Smith",
        time = "5h ago",
        content = "Had an amazing dinner at the new Italian place. #Yummy",
        image = R.drawable.post2,
        likesNo = 75,
        sharesNo = 12
    ),
    Post(
        id = 3,
        userImage = R.drawable.user5,
        userName = "Diana Prince",
        time = "1d ago",
        content = "Exploring new places and capturing memories. #TravelDiaries",
        image = R.drawable.post3,
        likesNo = 300,
        sharesNo = 80
    ),
    Post(
        id = 4,
        userImage = R.drawable.user4,
        userName = "Eve Adams",
        time = "2d ago",
        content = "Had a great workout session this morning. #FitnessGoals",
        image = R.drawable.post4,
        likesNo = 150,
        sharesNo = 25
    ),

    Post(
        id = 5,
        userImage = R.drawable.user3,
        userName = "Charlie Brown",
        time = "10h ago",
        content = "Can't believe how beautiful the weather is today. #SunnyDay",
        image = R.drawable.post5,
        likesNo = 200,
        sharesNo = 45
    ),
)
