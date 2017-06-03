package com.kotomoto.szoplista

class ItemListModel(val items: ArrayList<Item>) {

    fun addItem(item: Item) {
        items.add(item)
    }

    fun removeItem(index: Int) {
        if (items.size > index) {
            items.removeAt(index)
        }
    }

    fun removeLastItem() {
        if (items.size > 0) {
            items.removeAt(items.size - 1)
        }
    }

    fun removeAllItems() {
        items.clear()
    }

    fun checkItem(index: Int) {
        if (items.size > index) {
            items.get(index).checked = true
        }
    }

    fun uncheckItem(index: Int) {
        if (items.size > index) {
            items.get(index).checked = false
        }
    }

    fun removeAllChecked() {
        items.removeIf { item -> item.checked }
    }

    fun checkAll() {
        items.filter { item -> !item.checked }.map { item -> item.checked = true }
    }

    fun uncheckAll() {
        items.filter { item -> item.checked }.map { item -> item.checked = false }
    }

    fun addItems(newItems: ArrayList<Item>) {
        items.addAll(newItems)
    }
}