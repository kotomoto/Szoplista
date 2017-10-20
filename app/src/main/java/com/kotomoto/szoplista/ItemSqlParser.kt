package com.kotomoto.szoplista

import org.jetbrains.anko.db.RowParser
import org.jetbrains.anko.db.rowParser

val itemSqlParser = rowParser { id: Int, name: String, checked: Boolean -> Item(id, name, checked) }

class ItemSqlParser: RowParser<Item> {
    override fun parseRow(columns: Array<Any?>): Item = Item(columns[0] as Int, columns[1] as String, columns[2] as Boolean)
}
