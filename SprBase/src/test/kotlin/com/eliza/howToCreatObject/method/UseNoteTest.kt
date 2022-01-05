package com.eliza.howToCreatObject.method

import com.eliza.howToCreatObject.note.Student
import org.junit.jupiter.api.Test

/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 1/5/22
 * @Software: IntelliJ IDEA
 */
internal class UseNoteTest {
    var un: UseNote = UseNote()

    @Test
    fun getSpringInfo() {
        un.getSpringInfo()
    }
    @Test
    fun useNote() {
        val st = un.useNote("student") as Student
        println(st.toString())
    }
}