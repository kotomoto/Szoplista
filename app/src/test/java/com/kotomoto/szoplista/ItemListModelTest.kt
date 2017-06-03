package com.kotomoto.szoplista

import org.hamcrest.Matchers.`is`
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class ItemListModelTest {
    var list : ItemListModel = ItemListModel(arrayListOf())

    @Before
    fun setUp() {
        list = ItemListModel(arrayListOf())
    }

    @Test
    fun emptyListByDefault() {
        assertThat(list.items.size, `is`(0))
    }

    @Test
    fun addOneItemToEmptyListGivesSizeOfOne() {
        list.addItem(Item("first"))

        assertThat(list.items.size, `is`(1))
    }

    @Test
    fun addingTwoItemsIncreasesSizeByTwo() {
        list.addItem(Item("first"))
        list.addItem(Item("second"))

        assertThat(list.items.size, `is`(2))
    }

    @Test
    fun removingItemFromEmptyListDoesNothing() {
        list.removeItem(0)

        assertThat(list.items.size, `is`(0))
    }

    @Test
    fun removingItemDecreasesListSizeByOne() {
        list.addItem(Item("first"))
        list.addItem(Item("second"))
        list.addItem(Item("third"))

        assertThat(list.items.size, `is`(3))

        list.removeItem(1)

        assertThat(list.items.size, `is`(2))
        assertThat(list.items.get(0).name, `is`("first"))
        assertThat(list.items.get(1).name, `is`("third"))
    }

    @Test
    fun removingLastItemFromEmptyListDoesNothing() {
        list.removeLastItem()

        assertThat(list.items.size, `is`(0))
    }

    @Test
    fun removingLastItemDecreasesSizeByOne() {
        list.addItem(Item("first"))
        list.addItem(Item("second"))

        assertThat(list.items.size, `is`(2))

        list.removeLastItem()

        assertThat(list.items.size, `is`(1))
    }

    @Test
    fun removingAllGivesEmptyList() {
        list.addItem(Item("first"))

        list.removeAllItems()

        assertThat(list.items.size, `is`(0))
    }

    @Test
    fun checkItem() {
        list.addItem(Item("first"))

        list.checkItem(0)

        assertThat(list.items.get(0).checked, `is`(true))
    }

    @Test
    fun uncheckItem() {
        list.addItem(Item("first"))
        list.checkItem(0)

        assertThat(list.items.get(0).checked, `is`(true))

        list.uncheckItem(0)

        assertThat(list.items.get(0).checked, `is`(false))
    }

    @Test
    fun removeAllChecked() {
        list.addItem(Item("first", true))
        list.addItem(Item("second"))
        list.addItem(Item("third", true))

        list.removeAllChecked()

        assertThat(list.items.size, `is`(1))
        assertThat(list.items.get(0).name, `is`("second"))
        assertThat(list.items.get(0).checked, `is`(false))
    }

    @Test
    fun checkAll() {
        list.addItem(Item("first"))
        list.addItem(Item("second"))
        list.addItem(Item("third", true))

        list.checkAll()

        assertThat(list.items.get(0).checked, `is`(true))
        assertThat(list.items.get(1).checked, `is`(true))
        assertThat(list.items.get(2).checked, `is`(true))
    }

    @Test
    fun uncheckAll() {
        list.addItem(Item("first", true))
        list.addItem(Item("second"))
        list.addItem(Item("third", true))

        list.uncheckAll()

        assertThat(list.items.get(0).checked, `is`(false))
        assertThat(list.items.get(1).checked, `is`(false))
        assertThat(list.items.get(2).checked, `is`(false))
    }

    @Test
    fun addMultipleItems() {
        list.addItem(Item("first"))
        list.addItem(Item("second"))

        list.addItems(arrayListOf(Item("third"), Item("fourth")))

        assertThat(list.items.size, `is`(4))
        assertThat(list.items.get(0).name, `is`("first"))
        assertThat(list.items.get(1).name, `is`("second"))
        assertThat(list.items.get(2).name, `is`("third"))
        assertThat(list.items.get(3).name, `is`("fourth"))
    }
}