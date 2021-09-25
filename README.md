# ArtificialIntelligenceLab1

Wrote analog for prolog code to better understanding it

```
insrtsort([],[]).
insrtsort([Head|Tail], ListSorted) :- insrtsort(Tail,TailSorted),
 insrt(Head,TailSorted,ListSorted).
insrt(X, [Y | ListSorted], [Y | ListSorted1]) :-
 X > Y, !, insrt(X, ListSorted, ListSorted1).
insrt(X,ListSorted, [X | ListSorted]). 


fastsort([],[]).
fastsort([Head | Tail], ListSorted) :-
 split(Head, Tail, TailLess, TailGreater),
 fastsort(TailLess,TailLessSorted),
 fastsort(TailGreater,TailGreaterSorted),
 append(TailLessSorted, [Head | TailGreaterSorted], ListSorted).
split(_, [], [], []).
split(X, [H | T], [H | TL], TG) :- H < X, !, split(X, T, TL, TG).
split(X, [H | T], TL, [H | TG]) :- split(X, T, TL, TG).
```
