package com.example.library2.designpatterns.linkedin.iteratorpattern.dinermerger

import kotlin.jvm.JvmStatic
import com.example.library2.designpatterns.linkedin.iteratorpattern.dinermerger.PancakeHouseMenu
import com.example.library2.designpatterns.linkedin.iteratorpattern.dinermerger.HashMapMenu
import com.example.library2.designpatterns.linkedin.iteratorpattern.dinermerger.Waitress
import com.example.library2.designpatterns.linkedin.iteratorpattern.dinermerger.MenuTestDrive
import java.util.ArrayList

object MenuTestDrive {
    @JvmStatic
    fun main(args: Array<String>) {
        val pancakeHouseMenu = PancakeHouseMenu()
        val dinerMenu = DinerMenu()
        val hashMapMenu = HashMapMenu()
        val waitress = Waitress(pancakeHouseMenu, dinerMenu, hashMapMenu)

        // Without iterators
        printMenu()

        // With iterators
        waitress.printMenu()
    }

    /*
	 * Without the Waitress, we need the code below...
	 */
    fun printMenu() {
        val pancakeHouseMenu = PancakeHouseMenu()
        val dinerMenu = DinerMenu()
        val breakfastItems = pancakeHouseMenu.getMenuItems()
        val lunchItems = dinerMenu.getMenuItems()

        // Hiding implementation
        println("USING FOR EACH")
        for (menuItem in breakfastItems) {
            print(menuItem.getName())
            println("\t\t" + menuItem.getPrice())
            println("\t" + menuItem.getDescription())
        }
        for (menuItem in lunchItems) {
            print(menuItem.getName())
            println("\t\t" + menuItem.getPrice())
            println("\t" + menuItem.getDescription())
        }

        // Exposing implementation
        println("USING FOR LOOPS")
        for (i in breakfastItems.indices) {
            val menuItem = breakfastItems[i] as MenuItem
            print(menuItem.getName())
            println("\t\t" + menuItem.getPrice())
            println("\t" + menuItem.getDescription())
        }
        for (i in lunchItems.indices) {
            val menuItem = lunchItems[i]
            print(menuItem.getName())
            println("\t\t" + menuItem.getPrice())
            println("\t" + menuItem.getDescription())
        }
    }
}