package com.example.workclass.Class

//class variable {
//}

fun main (){
    //Numeric variables
    val age:Int = 20 /*  Para definir constantes*/
    val long_number:Long = 3513446164
    val temperature:Float = 27.33f
    val weight:Double = 64.125

    //String variables
    val gender:Char = 'M'
    val name:String = "Geovanni Mercz"

    //Bool variables
    val isGreater:Boolean = false

    //Collection variables
    val names = arrayOf("Josue","Mariana","Marco","Humberto")

    println(age)

    println("Welcome $name, to your first Kotlin Project")
    println( add())

    println(product(5,8))

    printArray(names)

}
fun add():Int{
    val x = 10
    val y = 5
    return (x+y)
}

fun product(x:Int,y:Int):Int{ //Funcion con variables con parametros desde el main
    return (x*y)
}

fun printArray(names:Array<String>){
    for (name in names){ //Ciclo for y nos dice que por cada elemento del array va tomar la variable name
        println("Hello $name, ")

    }
}