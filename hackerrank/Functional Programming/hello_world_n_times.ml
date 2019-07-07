let rec print n s =
  if n = 1 then (print_string (s ^ "\n"))
  else if n > 1 then begin
    print_string (s ^ "\n");
    print (n - 1) s
  end

let () =
  let n = read_int() in (print n "Hello World")
