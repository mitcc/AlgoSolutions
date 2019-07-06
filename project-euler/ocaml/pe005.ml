let rec gcd a b = if b = 0 then a else gcd b (a mod b)

let lcm a b = a * b / gcd a b

let rec fold f acc low high =
  if high < low then acc else fold f (f acc low) (low + 1) high

let () =
  Format.printf "%d\n" (fold lcm 1 1 20)
