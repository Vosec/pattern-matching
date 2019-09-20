
/*
    Created by Lukas on 20.09.2019
*/


object PatternMatchingOne extends App {
  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(el: Expr, e2: Expr) extends Expr
  case class Prod(el: Expr, e2: Expr) extends Expr

  def showNicely(e: Expr): String = e match {
    case Number(n) => s"$n"
    case Sum(e1, e2) => showNicely(e1) + " + " + showNicely(e2)
    case Prod(e1, e2) => {
      def parentheses(expr: Expr) = expr match {
        case Prod(_, _) => showNicely(expr)
        case Number(_) => showNicely(expr)
        case _ => "(" + showNicely(expr) + ")"
      }

      parentheses(e1) + " * " + parentheses(e2)
    }
  }
  println(showNicely(Sum(Number(1), Number(3))))
  println(showNicely(Prod(Sum(Number(1), Number(3)), Number(5))))

}
