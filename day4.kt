import java.io.File

val passportLines = File("day4_input").readLines()
var passports = ArrayList<Passport>()

class Passport(line: String) {
    val attributes = HashMap<String, String>()
    init {
        for (l in line.trim().split(" ")) {
          val values = l.split(":")
          attributes.put(values[0], values[1])
        }
      println(attributes)
    }
    fun valid(): Boolean {
      //If cm, the number must be at least 150 and at most 193.
      //If in, the number must be at least 59 and at most 76.
      //hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
      //ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
      //pid (Passport ID) - a nine-digit number, including leading zeroes.

      val allPresent = (attributes.get("byr") != null &&
              attributes.get("iyr") != null &&
              attributes.get("eyr") != null &&
              attributes.get("hgt") != null &&
              attributes.get("hcl") != null &&
              attributes.get("ecl") != null &&
              attributes.get("pid") != null)
      val byr = attributes.get("byr")
      val byrValid = byr != null && byr.toInt() >= 1920 && byr.toInt() <= 2002
      val iyr = attributes.get("iyr")
      val iyrValid = iyr != null && iyr.toInt() >= 2010 && iyr.toInt() <= 2020
      val eyr = attributes.get("eyr")
      val eyrValid = eyr != null && eyr.toInt() >= 2020 && eyr.toInt() <= 2030

      val hgt = attributes.get("hgt")
      
      val hgtValid = hgt != null && hgt.matches("-?\\d+(\\.\\d+)?(cm|in)".toRegex())

      return allPresent && byrValid && iyrValid && eyrValid && hgtValid
    }
}

var passport: Passport? = null
var passportLine = StringBuilder("")

for (line in passportLines) {
  if (line.trim() == "") {
    passports.add(Passport(passportLine.toString()))
    passportLine = StringBuilder("")
  } else {
    passportLine.append(" ${line.trim()}")
  }
}
passports.add(Passport(passportLine.toString()))

println("Num valid: " + passports.filter{ it.valid() }.count())

