package me.benetis

object Main extends App {
  val programs = Vector(
//    Day1.fuelCounterUpperSum(),
//    Day1.fuelCounterAccountedForFuelSum(),
    Day2.compute(),
    Day2.stupidInputSearch()
  )

  programs.foreach(println)
}
