package me.benetis

object Main extends App {
  val programs = Vector(
    Day1.fuelCounterUpperSum(),
    Day1.fuelCounterAccountedForFuelSum(),
  )

  programs.foreach(println)
}
