package com.example.facebooktimeline.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.facebooktimeline.R
import com.example.facebooktimeline.databinding.ActivityFacebookTimelineBinding
import com.example.facebooktimeline.models.posts
import com.example.facebooktimeline.models.stories
import com.example.facebooktimeline.ui.adapters.PostRVAdapter
import com.example.facebooktimeline.ui.adapters.StoryRVAdapter

class FacebookTimelineActivity : AppCompatActivity() {
    val mPostRVAdapter by lazy {
        PostRVAdapter()
    }

    val mStoryRVAdapter by lazy {
        StoryRVAdapter()
    }

    lateinit var mBinding : ActivityFacebookTimelineBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mBinding = ActivityFacebookTimelineBinding.inflate(LayoutInflater.from(this))
        setContentView(mBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setUpPostRV()
        populateDataInPostRV()

        setUpStoryRV()
        populateDataInStoryRV()
    }

    private fun setUpPostRV(){
        mBinding.fbTimelineRv.apply {
            adapter = mPostRVAdapter
            layoutManager = LinearLayoutManager(this@FacebookTimelineActivity , VERTICAL , false)
        }
    }

    private fun setUpStoryRV(){
        mBinding.storyRv.apply {
            adapter = mStoryRVAdapter
            layoutManager = LinearLayoutManager(this@FacebookTimelineActivity , HORIZONTAL , false)
        }
    }

    private fun populateDataInPostRV(){
        mPostRVAdapter.asyncListDiffer.submitList(posts)
    }

    private fun populateDataInStoryRV(){
        mStoryRVAdapter.asyncListDiffer.submitList(stories)
    }
}