package com.example.library2.designpatterns.linkedin.iteratorpattern.zaincodinermerger

class DinerMenu: Menu {
    val MAX_ITEMS = 6
    var numberOfItems = 0
    var menuItems = arrayOf<ZaincoMenuItem>()
init {
    addItem(1,
        "(Fakin') Bacon with lettuce & tomato on whole wheat")
    addItem(2,
        "(Fakin') Bacon with lettuce & tomato on whole wheat")
    addItem(3,
        "(Fakin') Bacon with lettuce & tomato on whole wheat")
    addItem(1,
        "(Fakin') Bacon with lettuce & tomato on whole wheat")
    addItem(1,
        "(Fakin') Bacon with lettuce & tomato on whole wheat")
    addItem(1,
        "(Fakin') Bacon with lettuce & tomato on whole wheat")
}

    fun addItem(id: Int,
        name: String
    ) {
        val menuItem = ZaincoMenuItem(id, name)
        if (numberOfItems >= MAX_ITEMS) {
            System.err.println("Sorry, menu is full!  Can't add item to menu")
        } else {
            menuItems[numberOfItems] = menuItem
            numberOfItems += 1
        }
    }

    override fun createIterator(): Iterator {
        return DinerMenuIterator(this)
    }


}