package com.kotomoto.szoplista

import android.content.Context
import android.content.res.Resources
import android.support.v4.content.res.ResourcesCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast


fun ViewGroup.inflate(layoutRes: Int): View =
        LayoutInflater.from(context).inflate(layoutRes, this, false)

fun Context.toast(message: CharSequence) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

fun Resources.getDrawable(drawableId: Int) = ResourcesCompat.getDrawable(this, drawableId, null)

val Context.database: SqlHelper
    get() = SqlHelper.getInstance(applicationContext)