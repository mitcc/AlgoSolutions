(*
 * 2520 is the smallest number that can be divided by each of the numbers from
 * 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the
 * numbers from 1 to 20?
 *)

let rec gcd a b = if b = 0 then a else gcd b (a mod b)

let lcm a b = a * b / gcd a b

let rec fold f acc low high =
  if low > high then acc else fold f (f acc low) (low + 1) high

let () =
  Format.printf "%d\n" (fold lcm 1 1 20)
