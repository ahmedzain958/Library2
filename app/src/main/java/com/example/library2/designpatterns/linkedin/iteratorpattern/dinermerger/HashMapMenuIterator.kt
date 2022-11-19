package com.example.library2.designpatterns.linkedin.iteratorpattern.dinermerger

class HashMapMenuIterator(items: LinkedHashMap<Int, MenuItem>) : Iterator {
    var _items :  LinkedHashMap<Int, MenuItem>
    var position = 0
    init {
        _items = items

    }


    override fun next(): MenuItem {
        val menuItem = _items.getValue(position)
        position += 1
        return menuItem
    }

    override fun hasNext(): Boolean {
        return !(position >= _items.size )
    }
}