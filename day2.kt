import java.io.File

val passwordPolicies = File("day2_input").readLines()

val numValid = passwordPolicies.filter { passwordPolicy ->
  val (count, letterPattern, password) = passwordPolicy.split(" ")
  val (firstLocation, secondLocation) = count.split("-")
  val (letter) = letterPattern.split(":")
  valid(firstLocation.toInt()-1, secondLocation.toInt()-1, letter[0], password)
}.count()

println(numValid)

fun valid(firstLocation: Int, secondLocation: Int, letter: Char, password: String): Boolean {
  val firstMatch = password[firstLocation] == letter
  val secondMatch = password.length-1 >= secondLocation && password[secondLocation] == letter
  return (firstMatch || secondMatch) && !(firstMatch && secondMatch)
}
