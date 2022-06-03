import java.io.File

val input = File("day6_input").readLines().map{ it.trim() }

var groupAnswers : ArrayList<Pair<Int, String>> = ArrayList()
var groupAnswer = ""
var groupCount = 0

for (line in input) {
   if (line == "") {
      groupAnswers.add(Pair(groupCount, groupAnswer))
      groupAnswer = ""
      groupCount = 0
   } else {
      groupAnswer += line
      groupCount++
   }
}
groupAnswers.add(Pair(groupCount, groupAnswer))

println(groupAnswers)

val allMatchingAnswersCounts = groupAnswers.map { groupAnswerPair ->
   val groupAnswerValues = groupAnswerPair.second
   groupAnswerValues.split("").distinct().joinToString(separator = "").filter { answer ->
     groupAnswerPair.first ==  groupAnswerValues.filter { it == answer }.count()
   }.count()
}

println(allMatchingAnswersCounts.sum())

