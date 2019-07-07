let rec print n s =
  if n = 1 then begin
    print_int s;
    print_string "\n"
  end
  else if n > 1 then begin
    print_int s;
    print_string "\n";
    print (n - 1) s
  end

let rec read_lines () =
  try let line = read_line () in
    int_of_string (line) :: read_lines()
  with
    End_of_file -> []

let f n arr = List.iter (fun x -> print n x) arr

let () =
    let n :: arr = read_lines() in f n arr

