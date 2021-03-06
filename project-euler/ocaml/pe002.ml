(*
 * Each new term in the Fibonacci sequence is generated by adding the previous
 * two terms. By starting with 1 and 2, the first 10 terms will be:
 *
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 *
 * By considering the terms in the Fibonacci sequence whose values do not
 * exceed four million, find the sum of the even-valued terms.
 *)

let rec sum_of_even_fib acc a b limit =
  if b >= limit then acc
  else if b mod 2 = 0 then sum_of_even_fib (acc + b) b (a + b) limit
  else sum_of_even_fib acc b (a + b) limit

let rec fold acc a b limit =
  if b >= limit then acc
  else fold (acc + b) b (a + 4 * b) limit

let () =
  Format.printf "%d\n" (sum_of_even_fib 0 1 1 4000000)

let () =
  Format.printf "%d\n" (fold 0 0 2 4000000)
