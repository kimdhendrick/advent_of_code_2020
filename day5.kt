import java.io.File
import kotlin.math.roundToInt

val input = File("day5_input").readLines()

val seatIds = input.map { line ->
   val rows: String = line.substring(0,7)
   val columns: String = line.substring(7,10)
   var start = 0
   var end = 127
   
   for (rowSplitter in rows) {
     val newRange = search(start, end, rowSplitter)
     start = newRange.first
     end = newRange.second
   }
   
   val rowNumber = start
   
   start = 0
   end = 8
   
   for (colSplitter in columns) {
     val newRange = search(start, end, colSplitter)
     start = newRange.first
     end = newRange.second
   }
   
   val colNumber = start
   
  rowNumber * 8 + colNumber
}

val sortedSeatIds = seatIds.toMutableList()
sortedSeatIds.sort()

var previousSeatId: Int = -1
var mySeatId: Int = 0

for (seatId in sortedSeatIds) {
  if (previousSeatId == -1) {
     previousSeatId = seatId
  } else {
     if (seatId - previousSeatId > 1) {
        mySeatId = seatId -1
     }
     previousSeatId = seatId
  }
}

println(mySeatId)

fun search(start: Int, end: Int, half: Char): Pair<Int, Int> {
   val middle: Int = ((end-start)/2.0+start).roundToInt()
   if (half == 'F' || half == 'L') {
     return Pair(start, middle-1)
   } else {
     return Pair(middle, end)
   }
}
