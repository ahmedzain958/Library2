package com.example.library2.problemsolving.leetcode

fun isSubsequence(s: String, t: String): Boolean {
    if (s.length> t.length) return false
    if (s.isEmpty()) return true
    var valueFound = 0
    for ( i in t.indices){
        if (s[valueFound] == t[i]){
            valueFound++
        }
        if (valueFound == s.length)
            return true
    }
    return false
}