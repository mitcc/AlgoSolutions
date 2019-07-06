let add_3_5_mult acc x =
  if (x mod 3) = 0 || (x mod 5) = 0 then acc + x
  else acc


let rec fold f acc low high =
  if high < low then acc
  else fold f (f acc low) (low + 1) high

let () =
  Format.printf "%d" (fold add_3_5_mult 0 1 1000)

