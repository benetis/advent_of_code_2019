package me.benetis

object Day2 {

  type State = Vector[Int]

  def stupidInputSearch(): Int = {
    val desiredOutput = 19690720
    val inputA, inputB = 0 until 99
    val cartesian = inputA.flatMap(_a => inputB.map(_b => _a -> _b))

    @scala.annotation.tailrec
    def findDesired(inputTuple: (Int, Int), tail: Seq[(Int, Int)]): (Int, Int) = {
      val finalState = loop(0, input.updated(1, inputTuple._1).updated(2, inputTuple._2))
      if(finalState.head == desiredOutput)
        inputTuple
      else
        findDesired(tail.head, tail.tail)
    }

    val tuple = findDesired(cartesian.head, cartesian.tail)
    100 * tuple._1 + tuple._2
  }

  def compute(): Int = {
    /* .updated(1, 12).updated(2, 2) are part of task instructions */
    val finalState = loop(0, input.updated(1, 12).updated(2, 2))
    finalState.head
  }

  @scala.annotation.tailrec
  private def loop(nextPosition: Int, currentState: State): State = {

    def compute(f: (Int, Int) => Int): Int = {
      f(currentState(currentState(nextPosition+1)), currentState(currentState(nextPosition+2)))
    }

    currentState(nextPosition) match {
      case 1 =>
        loop(nextPosition+4, currentState.updated(currentState(nextPosition+3), compute(_ + _)))
      case 2 =>
        loop(nextPosition+4, currentState.updated(currentState(nextPosition+3), compute(_ * _)))
      case 99 => currentState
      case _ =>
        println("Something went wrong")
        Vector.empty
    }
  }

  private lazy val input = """1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,13,1,19,1,5,19,23,2,10,23,27,1,27,5,31,2,9,31,35,1,35,5,39,2,6,39,43,1,43,5,47,2,47,10,51,2,51,6,55,1,5,55,59,2,10,59,63,1,63,6,67,2,67,6,71,1,71,5,75,1,13,75,79,1,6,79,83,2,83,13,87,1,87,6,91,1,10,91,95,1,95,9,99,2,99,13,103,1,103,6,107,2,107,6,111,1,111,2,115,1,115,13,0,99,2,0,14,0""".split(",").toVector.map(_.toInt)
}