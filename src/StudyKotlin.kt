import java.io.BufferedReader
import java.io.File
import java.io.IOException
import java.io.Reader
import java.util.*

public class Person(
    val name: String, var isMarried: Boolean
)

class rectangle(val hight: Int, val width: Int) {
    val isSquar: Boolean
        get() = hight == width
}

enum class Colors(
    val r: Int, val g: Int, val b: Int
) {
    RED(255, 0, 0), ORANGE(255, 165, 0),
    YELLOW(255, 255, 0), GREEN(0, 255, 0), BLUE(0, 0, 255),
    INDIGO(75, 0, 130), VIOLET(238, 130, 238);

    fun rgb() = (r * 256 + g) * 256 + b

}

fun main(args: Array<String>) {

    println("the smalest " + max(2, 5))

    val age = 25
    //age = 1 can't be reassigned
    val age2: Int
    age2 = 44
//    age2 = 44 //can be assigned only once at execution of the block
    var str = "sfsdfafasf"
    str = "dfd"//mutable can be changed as much as i want, but it's not prefered

    val dataSet = arrayListOf("amr", "mohamed")
    dataSet.add("abo")//it can be add new objects to the same reference because the data that it referee to is
    //mutable but -->

    val newDataSet = arrayListOf("moahmoud", "masoud")

    //dataSet = newDataSet  //--> but it can't be reassigned to refer to a new object,
    // only if changed dataSet to var

    /*********************************************/

    val name = if (args.isNotEmpty()) args[0] else "Amr"

    println("hello $name!")//it can read only the var name after the dollar sign
    println("hello ${args[0]}!") // if it has something more like statment or something it should be included in{}
    println("hello ${args[0]}! ${max(45, 77)}") // another example

    val person = Person("amr", false)
    person.isMarried = false
    println("Name: ${person.name}, Status: ${person.isMarried}")

    //Person(name:String)//not a field in the class
    //Person(val name:String) //field in the class that can't be changed {has getter but not setter}
    //Person(var name:String) //field in the class that can be changed {has getter and setter}
    //person.name // when is used to assign value, the setter property is triggered first, so it's
    // not a directly change to the field and same for getter
    /***********************************************************************/

    print(getColor(Colors.BLUE))

//    for (i in 100 downTo 50 step 3)
//        println(fizzfuzz(i))

    val binaryRep = TreeMap<Char, String>()
    for (c in 'A'..'Z') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryRep[c] = binary
    }

    for ((key, value) in binaryRep)
        println("$key = $value")

    val arr = arrayListOf(1, 2, 3, 5, 4, 7, 8, 9, 3, 6, 8, 7, 4, 9)
    for ((index, element) in arr.withIndex())
        println("arr[$index] = $element")


    println(isletter('a'))
    println(isNotDigit('a'))
    println(isNotDigit('1'))


    println(5 in arrayListOf(1, 54, 5, 87, 748, 85))
    //exception

    tryExcept(110)


    val theInput: String? = try {
        val sc = Scanner(File("input.txt"))
        sc.next()
    } catch (e: IOException) {
        null
    }

    print(theInput)

    println("/********************************************************************************************/")
    //collections
    val strings = listOf("amr", "mohamed")
    println(strings.javaClass)    //can't add anything it's with a fixed size
    val nums = arrayListOf(12, 24, 5, 8, 3)
    println(nums.javaClass)    //can add element to the list

    val hashset = hashMapOf(1 to 1, 2 to "dd", 3 to 1.5)
    println(hashset.toString() + " " + hashset.javaClass)

    val hashtable = hashSetOf(1, 5, 2, 0, 4, 9, 6)
    println(hashtable.toString() + " " + hashtable.javaClass)

    val set = setOf(1, 5, 2, 0, 4, 9, 6)
    print(set.toString() + " " + set.javaClass)

    tryExcept(percentage = 5)// i can specify the name of the arguments sended to the method
    tryExcept()//i can not seding the all argumetns, since they are having diffault values in the signature
    //this can help to avoid overloading

    val (num, stringnum) = 1 to "one"//val oa = Pair("aa",5) another way{ >>oa.first    >>oa.second}
    val (num1, stringnum2) = 1.to("one")//infix way
    println("$num $stringnum")

    println("amr".ff("sss"))
    println("amr" ff "sss" )

    val path = """D:\amro mohamed\downoads\Kotlin in Action.pdf"""
    val regex = """(.+)\\(.+)\.(.+)""".toRegex()
    val match = regex.matchEntire(path)
    if(match!=null){
        val (pathName, nameName, extention) = match.destructured
        println("path $pathName name $nameName extention $extention ")
    }
    println(path)
    //***************************************

    val multilineText ="""$99.9"""
    println(multilineText)
}

infix fun String.ff(ss: String) =
    this+" to "+ss

fun tryExcept(percentage: Int = 5) {
    if (percentage !in 0..100)
    //throw IllegalArgumentException("A percentage value must be between 0 and 100: $percentage")
    else
        print("well done")

    val ggg =
        if (percentage in 0..100)
            percentage
        else
            percentage + 5
    println(ggg)
}


fun isletter(c: Char) = c in 'A'..'Z' || c in 'a'..'z'
fun isNotDigit(c: Char) = c !in '0'..'9'
fun fizzfuzz(i: Int) =
    when {
        i % 15 == 0 -> "fizzfuzz "
        i % 3 == 0 -> "fizz "
        i % 5 == 0 -> "fuzz "
        else -> "$i "
    }

fun max(a: Int, b: Int) = if (a > b) a else b

fun getColor(color: Colors) =
    when (color) {
        Colors.BLUE -> "richard"
        Colors.RED -> "richard"
        Colors.ORANGE -> "richard"
        Colors.YELLOW -> "richard"
        Colors.GREEN -> "richard"
        Colors.INDIGO -> "richard"
        Colors.VIOLET -> "richard"
    }

