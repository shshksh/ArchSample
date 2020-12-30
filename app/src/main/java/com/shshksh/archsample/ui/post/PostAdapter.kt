package com.shshksh.archsample.ui.post

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.shshksh.archsample.BR
import com.shshksh.archsample.util.ViewBindingHolder
import java.util.*
import javax.inject.Inject

class PostAdapter @Inject constructor() : RecyclerView.Adapter<ViewBindingHolder<*>>() {

    private val items: MutableList<PostItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewBindingHolder<*> {
        return ViewBindingHolder<ViewDataBinding>(parent.context, viewType)
    }

    override fun onBindViewHolder(holder: ViewBindingHolder<*>, position: Int) {
        holder.binding.setVariable(BR.item, items[position])
        holder.binding.executePendingBindings()
    }

    fun setItems(items: List<PostItem>?) {
        this.items.clear()
        this.items.addAll(items!!)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }
}