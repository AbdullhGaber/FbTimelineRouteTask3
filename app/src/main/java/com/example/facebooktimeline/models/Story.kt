package com.example.facebooktimeline.models

import androidx.annotation.DrawableRes
import com.example.facebooktimeline.R

data class Story(
    val id : Int,
    @DrawableRes val userImage : Int,
    @DrawableRes val storyThumbnailImage : Int
)

val stories : List<Story> = listOf(

    Story(
        id = 1,
        userImage = R.drawable.user1,
        storyThumbnailImage = R.drawable.story1
    ),

    Story(
        id = 2,
        userImage = R.drawable.user2,
        storyThumbnailImage = R.drawable.story2
    ),

    Story(
        id = 3,
        userImage = R.drawable.user3,
        storyThumbnailImage = R.drawable.story3
    ),

    Story(
        id = 4,
        userImage = R.drawable.user4,
        storyThumbnailImage = R.drawable.story4
    ),

    Story(
        id = 5,
        userImage = R.drawable.user5,
        storyThumbnailImage = R.drawable.story5
    )
)
