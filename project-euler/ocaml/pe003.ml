(*
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 *)

let rec div_all n x = if n mod x <> 0 then n else div_all (n / x) x

let rec fold result low high =
    if low >= high then max result high
    else if high mod low = 0 then fold (max result low) (low + 1) (div_all high low)
    else fold result (low + 1) high

let () =
 Format.printf "%d\n" (fold 1 2 600851475143)

