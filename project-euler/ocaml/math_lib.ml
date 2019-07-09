let max a b = if a > b then a else b

let rec rev x =
  let rec iter acc x = if x = 0 then acc else iter (10 * acc + (x mod 10)) (x / 10)
  in iter 0 x

let is_palindrom x = x = rev x
