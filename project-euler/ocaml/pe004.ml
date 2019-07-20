(*
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *)

open Math_lib

let rec ff res a b i =
  if a > b then res
  else if Math_lib.is_palindrom (i * a) && (i * a) > res then ff (i * a) (a + 1) b i
  else ff res (a + 1) b i

let rec f res x y =
  if x > y then res
  else if (ff res 100 999 x) > res then f (ff res 100 999 x) (x + 1) y
  else f res (x + 1) y

let () =
  Format.printf "%d\n" (f 0 100 999)

