(*
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *)

open Math_lib

let rec ff res a b i =
  if a > b || (i * b) < res then res
  else if Math_lib.is_palindrom (i * b) then ff (i * b) a (b - 1) i
  else ff res a (b - 1) i

let rec f res x y =
  if x > y then res
  else if (ff res 100 999 y) > res then f (ff res 100 999 y) x (y - 1)
  else f res x (y - 1)

let () =
  Format.printf "%d\n" (f 0 100 999)

