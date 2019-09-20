
/*
    Created by Lukas on 20.09.2019
*/


object PatternMatchingSecond extends App {
  val nastedTuple = (1, (2, 3))
  val matchMe = nastedTuple match {
    case(_, (2, v)) => s"I have found $v"
  }

  val myList = List(1,2,3,42)
  val matchList = myList match {
    case List(1, _, _, _) => "List extractor!"
    case List(1, _*) => "List of arbitrary length!"
    case 1 :: List(_) => "Infix pattern :)"
    case List(1,2,3) :+ 42 => "Also infix"
  }

  val unknown: Any = 2
  val idk = unknown match {
    case list: List[Int] => "Explicit type specifier"
    case 1 | 2 => "Its 1 or 2!"
    case _ => "meh"
  }

  val one = 1
  val stopMe = one match {
    case 1 if one % 2 == 0 => "wtf"
  }

  //pattern match is everywhere... try catch etc.

}
