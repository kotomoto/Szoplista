package com.kotomoto.szoplista

data class Item(val id: Int, val name : String, var checked : Boolean = false) {
    constructor(name: String) : this(0, name)
    constructor(name: String, checked: Boolean) : this(0, name, checked)
}