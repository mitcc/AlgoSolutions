(*
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 *
 * a^2 + b^2 = c^2
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 *)

let square = fun x -> x * x

let rec find result a low high =
  if low > high then result
  else if square a + square low = square (1000 - a - low) then find (max result (a * low * (1000 - a - low))) a (low + 1) high
  else find result a (low + 1) high

let rec f result low high =
  if low > high then result
  else if find result low low 500 > result then f (find result low low 500) (low + 1) high
  else f result (low + 1) high

let () =
  Format.printf "%d\n" (f 0 1 300)
