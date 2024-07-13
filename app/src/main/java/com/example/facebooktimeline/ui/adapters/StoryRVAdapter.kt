package com.example.facebooktimeline.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.facebooktimeline.databinding.FbStoryItemBinding
import com.example.facebooktimeline.models.Post
import com.example.facebooktimeline.models.Story

class StoryRVAdapter : RecyclerView.Adapter<StoryRVAdapter.StoryViewHolder>() {

    private val differUtilCallBack = object : DiffUtil.ItemCallback<Story>(){
        override fun areItemsTheSame(oldItem: Story, newItem: Story): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Story, newItem: Story): Boolean {
            return oldItem == newItem
        }
    }

    val asyncListDiffer = AsyncListDiffer(this , differUtilCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val fbStoryBinding = FbStoryItemBinding.inflate(inflater)
        return StoryViewHolder(fbStoryBinding)
    }

    override fun getItemCount() = asyncListDiffer.currentList.size

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val story = asyncListDiffer.currentList[position]
        holder.bind(story)
    }

    inner class StoryViewHolder(private val mBinding : FbStoryItemBinding) : ViewHolder(mBinding.root){
        fun bind(story : Story){
            mBinding.storyIv.setImageResource(story.storyThumbnailImage)
            mBinding.userStoryIv.setImageResource(story.userImage)
        }
    }
}