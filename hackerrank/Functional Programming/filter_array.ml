let print_int_with_endline x = begin
  print_int x;
  print_string "\n";
end

let rec read_lines () =
  try let line = read_line () in
    int_of_string (line) :: read_lines()
  with
    End_of_file -> []

let f n arr = List.iter (fun x -> if x < n then print_int_with_endline x) arr

let () =
    let n :: arr = read_lines() in f n arr
