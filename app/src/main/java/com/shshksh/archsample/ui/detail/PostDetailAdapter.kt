package com.shshksh.archsample.ui.detail

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.shshksh.archsample.BR
import com.shshksh.archsample.R
import com.shshksh.archsample.util.ViewBindingHolder
import javax.inject.Inject

class PostDetailAdapter @Inject constructor() : RecyclerView.Adapter<ViewBindingHolder<*>>() {

    val items: MutableList<PostDetailItem> = ArrayList()

    override fun getItemViewType(position: Int): Int {
        return when (PostDetailItem.Type.values()[items[position].getType().ordinal]) {
            PostDetailItem.Type.USER -> R.layout.view_post_detail_user
            PostDetailItem.Type.POST -> R.layout.view_post_detail_post
            PostDetailItem.Type.COMMENT -> R.layout.view_post_detail_comment
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewBindingHolder<*> {
        return ViewBindingHolder<ViewDataBinding>(parent.context, viewType)
    }

    override fun onBindViewHolder(holder: ViewBindingHolder<*>, position: Int) {
        holder.binding.setVariable(BR.item, items[position])
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(items: List<PostDetailItem>) {
        this.items.clear()
        this.items.addAll(items)
        this.notifyDataSetChanged()
    }

}