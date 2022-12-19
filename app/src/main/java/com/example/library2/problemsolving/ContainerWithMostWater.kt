package com.example.library2.problemsolving

class ContainerWithMostWater {
    fun maxArea(height: IntArray): Int {
        var max_area = 0
        var a_pointer = 0
        var b_pointer = height.size - 1
        while (b_pointer > a_pointer) {
            if (height[a_pointer] < height[b_pointer]) {
                max_area = max_area.coerceAtLeast((b_pointer - a_pointer) * height[a_pointer])
                a_pointer++
            } else {
                max_area = max_area.coerceAtLeast((b_pointer - a_pointer) * height[b_pointer])
                b_pointer--
            }
        }
        return max_area
    }
}