import java.io.File

val input = File("day1_input").readLines().map { it:String -> it.toInt() }

println("PART 1 **************************")

val (left, right, product) = partOne(input)
println("left: " + left)
println("right: " + right)
println("product: " + product)


println("PART 2 **************************")

val (a, b, c, product2) = partTwo(input)
println("a: " + a)
println("b: " + b)
println("c: " + c)
println("product: " + product2)

fun partOne(input: List<Int>): Triple<Int, Int, Int> {
  val left = input.find { 
     input.find { right -> it + right == 2020 } != null
  }
  val right = input.find { it + left!! == 2020 }
  
  return Triple(left!!, right!!, left!! * right!!)
}

fun partTwo(input: List<Int>): List<Int> {
  val sums = input.flatMap { a ->
    input.map { b ->
       Triple(a, b, a+b)
    }
  }


  var a: Int = -1
  var b: Int = -1
  var c: Int = -1
  for(i in input) {
     val candidate = sums.find{ it.third + i == 2020 }
     if (candidate != null) {
       a = candidate.first
       b = candidate.second
       c = i
     }
  }

  return listOf(a, b, c, (a*b*c))
}

