package com.example.facebooktimeline.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.facebooktimeline.databinding.PostItemBinding
import com.example.facebooktimeline.models.Post

class PostRVAdapter : RecyclerView.Adapter<PostRVAdapter.PostViewHolder>(){

    private val differUtilCallBack = object : DiffUtil.ItemCallback<Post>(){
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem == newItem
        }
    }

    val asyncListDiffer = AsyncListDiffer(this , differUtilCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
       val inflater = LayoutInflater.from(parent.context)
       val postItemBinding = PostItemBinding.inflate(inflater)
       return PostViewHolder(postItemBinding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = asyncListDiffer.currentList[position]
        holder.bind(post)
    }

    override fun getItemCount() = asyncListDiffer.currentList.size

    inner class PostViewHolder(private val mBinding : PostItemBinding) : ViewHolder(mBinding.root){
        fun bind(post : Post){
            mBinding.circlePostImageView.setImageResource(post.userImage)
            mBinding.postUserName.text = post.userName
            mBinding.postTime.text = post.time
            mBinding.postDescription.text = post.content
            mBinding.postImageView.setImageResource(post.image)
            mBinding.likesNoTv.text = post.likesNo.toString()
            mBinding.shareNo.text = post.sharesNo.toString()
            mBinding.circlePostImageViewUnderPost.setImageResource(post.userImage)
        }
    }
}