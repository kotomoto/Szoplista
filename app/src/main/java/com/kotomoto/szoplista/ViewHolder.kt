package com.kotomoto.szoplista

import android.graphics.Typeface
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.shopping_list_item.view.*


class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: Item, listener: (Item) -> Unit) = with(itemView) {
        list_item_title.text = item.name

        //todo get rid of this dummy code

        if (item.checked) {
            list_item_image.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.checked_circle, null))
            list_item_title.setTypeface(null, Typeface.ITALIC)
            list_item_title.setTextColor(resources.getColor(android.R.color.darker_gray))
        } else {
            list_item_image.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.unchecked_circle, null))
            list_item_title.setTypeface(null, Typeface.NORMAL)
            list_item_title.setTextColor(resources.getColor(android.R.color.black))
        }

        setOnClickListener {
            listener(item)
            item.checked = !item.checked
            if (item.checked) {
                list_item_image.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.checked_circle, null))
                list_item_title.setTypeface(null, Typeface.ITALIC)
                list_item_title.setTextColor(resources.getColor(android.R.color.darker_gray))
            } else {
                list_item_image.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.unchecked_circle, null))
                list_item_title.setTypeface(null, Typeface.NORMAL)
                list_item_title.setTextColor(resources.getColor(android.R.color.black))
            }
        }
    }
}