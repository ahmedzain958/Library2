package com.example.library2.designpatterns.linkedin.iteratorpattern.zaincodinermerger

class DinerMenuIterator(val dinerMenu: DinerMenu) : Iterator {
    var position = 0
    var _dinerMenu: DinerMenu = dinerMenu
    override fun next(): ZaincoMenuItem {
        val menuItem = _dinerMenu.menuItems[position]
        return menuItem
    }

    override fun hasNext(): Boolean {
        if (position >= _dinerMenu.menuItems.size) {
            return false
        }
        return true
    }
}