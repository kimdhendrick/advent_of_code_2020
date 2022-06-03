import java.io.File
import java.math.BigInteger

val map = File("day3_input").readLines()

val a: BigInteger = calc(1, 1, map).toBigInteger()
val b: BigInteger = calc(3, 1, map).toBigInteger()
val c: BigInteger = calc(5, 1, map).toBigInteger()
val d: BigInteger = calc(7, 1, map).toBigInteger()
val e: BigInteger = calc(1, 2, map).toBigInteger()

println(a.toString())
println(b.toString())
println(c.toString())
println(d.toString())
println(e.toString())
println(a*b*c*d*e)

fun calc(run: Int, rise: Int, map: List<String>): Int { 
  var right = 0
  var treeCount = 0

  for (rowIndex in rise..map.size-1 step rise) {
    val row = map[rowIndex]
    right += run
    if (right >= row.length) {
       right = right - row.length
    }
    var char = if (row[right] == '.') 'O' else 'x'
    if (row[right] != '.') treeCount++
    val newRow = row.substring(0, right) + char + row.substring(right + 1)
  }
  
  return treeCount
}



