package com.kotomoto.szoplista

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class SqlHelper(context: Context) : ManagedSQLiteOpenHelper(context, "mydb") {

    companion object {
        val TABLE_NAME = "Items"
        val COLUMN_NAME_ID = "_id"
        val COLUMN_NAME_NAME = "name"
        val COLUMN_NAME_CHECKED = "checked"

        private var instance: SqlHelper? = null

        @Synchronized
        fun getInstance(context: Context): SqlHelper {
            if (instance == null) {
                instance = SqlHelper(context.applicationContext)
            }

            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(
                TABLE_NAME, true,
                COLUMN_NAME_ID to INTEGER + PRIMARY_KEY,
                COLUMN_NAME_NAME to TEXT,
                COLUMN_NAME_CHECKED to INTEGER
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}