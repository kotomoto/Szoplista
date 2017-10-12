package com.kotomoto.szoplista

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup


class ShoppingListAdapter(val items: List<Item>, val listener: (Item) -> Unit) : RecyclerView.Adapter<ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent.inflate(R.layout.shopping_list_item))
}