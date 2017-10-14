package com.kotomoto.szoplista

import android.graphics.Paint
import android.graphics.Typeface
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.shopping_list_item.view.*


class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: Item, listener: (Item) -> Unit) = with(itemView) {
        list_item_title.text = item.name

        adjustItemState(item)

        setOnClickListener {
            listener(item)
            item.checked = !item.checked
            adjustItemState(item)
        }
    }

    private fun View.adjustItemState(item: Item) {
        if (item.checked) {
            adjustItemChecked()
        } else {
            adjustItemUnchecked()
        }
    }

    private fun View.adjustItemChecked() {
        list_item_image.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.checked_circle, null))
        list_item_title.setTypeface(null, Typeface.ITALIC)
        list_item_title.setTextColor(resources.getColor(R.color.shopping_list_item_text_checked))
        list_item_title.paintFlags = list_item_title.paintFlags.or(Paint.STRIKE_THRU_TEXT_FLAG)
    }

    private fun View.adjustItemUnchecked() {
        list_item_image.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.unchecked_circle, null))
        list_item_title.setTypeface(null, Typeface.NORMAL)
        list_item_title.setTextColor(resources.getColor(R.color.shopping_list_item_text_unchecked))
        list_item_title.paintFlags = list_item_title.paintFlags.xor(Paint.STRIKE_THRU_TEXT_FLAG)
    }
}