package com.example.workclass.Class

//class variable {
//}
//

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

    val numbers = arrayOf(1,2,3,4,5,6,7,8,9,10)

    isEven(numbers)

    println(getDay(1))
    println(getDay(8))

    val person = Person("Geovanni",20)
    person.displayInformation()

    println(person.name)
    println(person.age)



}

fun add():Int{
    val x = 10
    val y = 5
    return (x+y)
}

fun product(x:Int,y:Int):Int{ //Funcion con variables con parametros desde el main
    return (x*y)
}

fun printArray(names:Array<String>) {
    for (name in names) { //Ciclo for y nos dice que por cada elemento del array va tomar la variable name
        println("Hello $name, ")

    }
}
fun isEven(numbers: Array<Int>) {
        for (number in numbers) {
            if (number % 2 == 0) {
                println("The number $number is even")
            } else {
                println("The number $number is odd")
            }
        }
    }
fun getDay(day:Int):String{
    var name = ""

    when(day){ //Es un caso como switch
        1 -> name = "Monday" //Si tenemos funciones mas complejas se abren llaves despues de (->)
        2 -> name = "Tuesday"
        3 -> name = "Wednesday"
        4 -> name = "Thursday"
        5 -> name = "Friday"
        6 -> name = "Saturday"
        7 -> name = "Sunday"
        else -> name = "Incorrect Value"

    }
    return name
}

class Person (val name:String,val age:Int){
    fun displayInformation(){
        println("Name: $name Age: $age")

    }

}


