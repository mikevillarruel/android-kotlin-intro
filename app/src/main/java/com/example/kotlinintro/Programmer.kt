package com.example.kotlinintro

class Programmer(val name: String,
    /*private*/ var age: Int,
                 val languages: Array<Language>,
                 val friends: Array<Programmer>? = null) {

    enum class Language {
        Kotlin,
        Swift,
        Java,
        Javascript
    } // Con esto seguro que esos son los lenguajes que puede tener el programador y que no le
    // pasemos un string con algo que no es un lenguaje

    /*
    enum class Lang(val num: Int){
        Kotlin(5),
        Java(8)
    }
    */

    fun code(){
        // Lang.Kotlin.num;
        for (lan in languages){
            println(lan)
        }
    }

}