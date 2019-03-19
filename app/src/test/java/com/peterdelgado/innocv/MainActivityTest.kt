package com.peterdelgado.innocv
import assertk.Assert
import assertk.assertions.support.expected
import org.junit.Test
import com.peterdelgado.model.User



class MainActivityTest {
    val User: User = User("4444", "peter", "test")


    fun Assert<User>.hasValidId() {
        if (actual.name.isBlank()) return
        expected("Id must not be blank")
    }



    fun Assert<User>.hasValidName() {
        if (actual.name.isBlank()) return
        expected("Name must not be blank")


    }

    @Test
    fun Assert<User>.toGet(){

        hasValidId()
        hasValidName()

    }


    @Test
    fun toDelete() {
    }

    @Test
    fun toPost() {
    }

    @Test
    fun toUpdate() {
    }




}