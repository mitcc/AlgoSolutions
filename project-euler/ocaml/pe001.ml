(*
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we
 * get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 *)

let add_3_5_mult acc x =
  if x mod 3 = 0 || x mod 5 = 0 then acc + x
  else acc

let rec fold f acc low high =
  if high < low then acc
  else fold f (f acc low) (low + 1) high

let () =
  Format.printf "%d\n" (fold add_3_5_mult 0 1 1000)
