object InsertSort {
  def sort(list: List[Int]) : List[Int] = {
    list match {
      case Nil => List[Int]() // insrtsort([],[]).
      case head :: tail => // insrtsort([Head|Tail], ListSorted) :-
        val tailSorted = sort(tail) // insrtsort(Tail,TailSorted),
        val listSorted = insert(head, tailSorted) // insrt(Head,TailSorted,ListSorted).
        listSorted
    }
  }

  private def insert(x: Int, list: List[Int]): List[Int] = {
    list match {
      case y :: listSorted if x > y => // insrt(X, [Y | ListSorted], [Y | ListSorted1]) :-
        val listSorted1 = insert(x, listSorted) // X > Y, !, insrt(X, ListSorted, ListSorted1).
        y :: listSorted1
      case _ => x :: list // insrt(X,ListSorted, [X | ListSorted]).
    }
  }

}
