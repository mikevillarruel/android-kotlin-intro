package com.example.kotlinintro

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // private var text : TextView? = null
    private lateinit var text : TextView // promise to initialize before use if isn't the app will fail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("Lifecycle", "onCreate")

        text = findViewById<TextView>(R.id.txtOutput)
        val button = findViewById<Button>(R.id.btnAction)

        button.setOnClickListener {
            navigateToSecondActivity()
        }


        // Lección 1
        // variablesYConstantes()

        // Lección 2
        //tiposDeDatos()

        // Lección 3
        // sentenciaIf()

        // Lección 4
        // sentenciaWhen()

        // Lección 5
        // arrays()

        // Lección 6
        // maps()

        // Lección 7
        // loops()

        // Lección 8
        // nullSafety()

        // Lección 9
        // funciones()

        // Lección 10
        // clases()

        // Data Class
        // dataClass()
    }

    private fun navigateToSecondActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("name", "New value from main")
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                val result = data?.getStringExtra("result")
                text.text = result
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("Lifecycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Lifecycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Lifecycle", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Lifecycle", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifecycle", "onDestroy")
    }

    /*
    Aquí vamos a hablar de variables y constantes
     */
    private fun variablesYConstantes() {
        // VARIABLES

        var myFirstVariable = "Hello People!"
        var myFirstNumber = 1

        println(myFirstVariable)
        myFirstVariable = "Bienvenidos"
        println(myFirstVariable)

        var mySecondVariable = "Say Hi"
        println(mySecondVariable)
        mySecondVariable = myFirstVariable
        println(mySecondVariable)

        // CONSTANTES
        val myFirstConstant = "Say Bye"
        println(myFirstConstant)
        // myFirstConstant = "Say Hi"
        val mySecondConstant = myFirstVariable
        println(mySecondConstant)
    }

    /*
    Aqui vamos a hablar de tipos de datos (data types)
     */
    private fun tiposDeDatos() {
        // String
        val myString: String = "Hola Mike"
        val myString2 = "Hola"
        val myString3 = myString + " " + myString2
        println(myString3)

        // Enteros (Byte, Short, Int, Long)
        val myInt: Int = 1
        val myInt2 = 2
        val myInt3 = myInt + myInt2
        println(myInt3)

        // Decimales (Float, Double)
        val myFloat: Float = 1.5f
        //Nota: Por defecto siempre son double o int en caso de enteros
        val myDouble: Double = 1.5
        val myDouble2 = 2.3
        val myDouble3 = 1 //En realidad es Int a menos que ponga 1.0
        val myDouble4 = myDouble + myDouble2 + myDouble3
        println(myDouble4)

        // Boolean (Bool)
        val myBool: Boolean = true
        val myBool2 = false
        println(myBool == myBool2)
        println(myBool && myBool2)
        println(myBool || myBool2)
    }

    /*
    Aquí vamos a hablar de la sentencia if
     */
    private fun sentenciaIf() {
        val myNumber = 10

        /*
        Operadores condicionales
        <   >
        >=  <=
        ==  !=
         */
        /*
        Operadores Lógicos
        &&  Y
        ||  O
        !   No
         */
        if (myNumber < 10) {
            println("$myNumber es menor que 10")
        } else if (myNumber == 10) {
            println("$myNumber es igual que 10")
        } else {
            println("$myNumber es mayor que 10")
        }
    }

    private fun sentenciaWhen() {
        val country = "Ecuador"

        when (country) {
            "España", "Ecuador", "Colombia" -> {
                println("Español")
            }
            "USA" -> {
                println("Inglés")
            }
            else -> {
                println("No conocemos el idioma")
            }
        }

        val age = 15

        when (age) {
            0, 1, 2 -> {
                println("Bebé")
            }
            in 3..10 -> {
                println("Niño")
            }
            else -> {
                println(":)")
            }
        }
    }

    private fun arrays() {
        val name = "Brice"
        val surname = "Vega"
        val company = "Dev"
        val age = "24"
        // Creación de un Array
        val myArray = arrayListOf<String>()
        myArray.add(name)
        myArray.add(surname)
        myArray.add(company)
        myArray.add(age)
        // myArray.add(age)

        println(myArray)

        // Añadir conjunto de datos
        myArray.addAll(listOf("Hola", "Hello", company))

        println(myArray)

        // Acceso
        println(myArray[0])

        // Modificar
        myArray[2] = "Cambio"

        println(myArray)

        // Eliminar
        myArray.removeAt(1)

        println(myArray)

        // Recorrer
        myArray.forEach {
            println(it)
        }

        // Otras
        println(myArray.count())

        myArray.first()
        myArray.last()

        myArray.add("13")
        myArray.sort()
        println(myArray)

        myArray.sortBy { it.last() }
        println(myArray)

        myArray.clear()

        println(myArray)
    }

    private fun maps() {
        var myMap: Map<String, Int> = mapOf()
        println(myMap)
        // Añadir elementos
        myMap = mapOf("Mike" to 1, "Pedro" to 2, "Sara" to 5) // No es mutable
        myMap = mutableMapOf("Mike" to 1, "Pedro" to 2)
        println(myMap)

        // Añadir un solo elemento
        myMap["Ana"] = 7
        myMap["Lola"] = 7
        println(myMap)

        myMap.put("Julio", 12)
        println(myMap)

        // Actualizar
        myMap.put("Mike", 11)
        myMap["Mike"] = 4
        println(myMap)

        // Acceso
        println(myMap["Mike"])

        // Eliminar
        myMap.remove("Mike")
        println(myMap)
    }

    fun loops() {
        // Bucles
        val myArray = listOf("Hola", "Hello", "company")
        var myMap = mutableMapOf("Mike" to 1, "Pedro" to 2)

        // For
        for (myString in myArray) {
            println(myString)
        }

        for (myElement in myMap) {
            println("${myElement.key}-${myElement.value}")
        }

        for (x in 0..10) {
            println(x)
        }
        // until excluyente al final
        for (x in 0 until 10) {
            println(x)
        }
        // salto
        for (x in 0..10 step 2) {
            println(x)
        }

        for (x in 10 downTo 0 step 3) {
            println(x)
        }

        val myNumericArray = (0..20)

        for (item in myNumericArray) {
            println(item)
        }

        for ((index, item) in myNumericArray.withIndex()) {
            println(item)
        }

        myNumericArray.forEach {
            println(it)
        }

        myNumericArray.forEach { item ->
            println(item)
        }

        myNumericArray.forEachIndexed { index, item ->
            println(item)
        }

        // While
        var x = 0
        while (x < 10) {
            println(x)
            x++
        }
    }

    /*
    Seguridad contra nulos
     */
    fun nullSafety() {

        var myString = "Mike"
        // Error de compilación
        // myString = null
        println(myString)

        // Variable null safety
        var mySafetyString: String? = "Mike null"
        mySafetyString = null
        println(mySafetyString)

        val c = mySafetyString?.length
            ?: "Es nulo".length // Puedo devolver un valor especifico si es nulo es lugar de que imprima null
        println(c)

        mySafetyString?.length?.let {
            println(it) // se ejecuta solo si no es null
        }

        mySafetyString = "Hola"
        // println(mySafetyString)

        // println(mySafetyString!!)

        /*if (mySafetyString!=null){
            // println(mySafetyString!!) // Obliga a que la variable no sea null
        } else {
            println(mySafetyString)
        }*/

        // Safe call
        println(mySafetyString?.length)

        mySafetyString?.let {
            // println(mySafetyString!!)
            // println(mySafetyString!!) == println(it)
            println(it)
        } ?: run {
            // Cuando sea nulo se ejecuta esta sección
            println(mySafetyString)
        }
    }

    fun funciones() {

        sayHello()
        sayHello()

        sayMyName("Mike", 24)

        println(sum(5, 8))

        // extension functions
        println("Hola".removeFirstCharacter())

    }

    fun String.removeFirstCharacter(): String = this.substring(1 /*,this.length*/)

    // Función Simple
    fun sayHello() {
        println("Hola")
    }

    // Funciones con parametros
    fun sayMyName(name: String, age: Int) {
        println("Hola $name y mi edad es $age")
    }

    // Funciones con valor de retorno
    fun sum(num1: Int, num2: Int): Int {
        val result = num1 + num2
        return result
    }

    fun clases() {
        val mike = Programmer(
            "Michael",
            24,
            arrayOf(Programmer.Language.Kotlin, Programmer.Language.Swift)
        )
        println(mike.name)
        mike.age = 30
        mike.code()
        println(mike)

        val sara = Programmer(
            "Michael",
            24,
            arrayOf(Programmer.Language.Kotlin, Programmer.Language.Swift),
            arrayOf(mike)
        )
        sara.code()
        println("${sara.friends?.first()?.name}")
    }

    fun dataClass() {
        val usuario = User("Juan", 25);
        val usuario2 = usuario.copy(age = 18)
        println(usuario2.toString())
        println("Are equal?: ${usuario == usuario2}")
        println(Constantes.address)
    }

    data class User(val name: String, val age: Int)

    class Constantes {
        companion object {
            const val address = "Ecuador"
        }
    }
}

const val address = "Ecuador"

