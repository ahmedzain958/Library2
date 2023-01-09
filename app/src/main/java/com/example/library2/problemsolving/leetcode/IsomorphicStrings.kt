package com.example.library2.problemsolving.leetcode

fun isIsomorphic(s: String, t: String): Boolean {
    val stMap = mutableMapOf<Char, Char>()
    val tsMap = mutableMapOf<Char, Char>()

    for (i in s.indices){
        val sChar = s[i]
        val tChar = t[i]
        if (!stMap.contains(sChar)){
            stMap[sChar] = tChar
        }else{
            if (stMap[sChar] != tChar)
                return false
        }

        if (!tsMap.contains(tChar)){
            tsMap[tChar] = sChar
        }else{
            if (tsMap[tChar] != sChar)
                return false
        }
    }
    return true
}