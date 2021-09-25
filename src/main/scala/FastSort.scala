object FastSort {
  def sort(list: List[Int]) : List[Int] = {
    list match {
      case Nil => List[Int]() // fastsort([],[]).
      case head :: tail => // fastsort([Head | Tail], ListSorted) :-
      val (tailLess, tailGreater) = split(head, tail) // split(Head, Tail, TailLess, TailGreater),
        val tailLessSorted = sort(tailLess) // fastsort(TailLess,TailLessSorted),
        val tailGreaterSorted = sort(tailGreater) //  fastsort(TailGreater,TailGreaterSorted),
        val listSorted = tailLessSorted ::: (head :: tailGreaterSorted) //  append(TailLessSorted, [Head | TailGreaterSorted], ListSorted).
        listSorted
    }
  }

  private def split(x: Int, tail: List[Int]): (List[Int], List[Int]) = {
    tail match {
      case Nil => (List[Int](), List[Int]()) // split(_, [], [], []).
      case h :: t if h < x => // split(X, [H | T], [H | TL], TG) :- H < X, !, split(X, T, TL, TG).
        val (tl, tg) = split(x, t)
        (h :: tl, tg)
      case h :: t => // split(X, [H | T], TL, [H | TG]) :- split(X, T, TL, TG).
        val (tl, tg) = split(x, t)
        (tl, h :: tg)
    }
  }
}
