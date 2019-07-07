let rec read_lines () =
  try let line = read_line () in
    int_of_string (line) :: read_lines()
  with
    End_of_file -> []

let print_int_with_endline x = begin
  print_int x;
  print_string "\n";
end

let rec is_odd = function
  | 0 -> false
  | n -> is_even (n - 1)
and is_even = function
  | 0 -> true
  | n -> is_odd (n - 1)

let f arr = for i = 0 to List.length arr do
    if (is_odd i) then print_int_with_endline (List.nth arr i);
  done

let () =
  let arr = read_lines() in f arr

