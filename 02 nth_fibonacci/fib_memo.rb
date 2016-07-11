def fib_with_memo(n)
  if n == 0 then return 0 end
  if n == 1 then return 1 end

  fib_numbers = [0,1]
  index = 2

  while index < n
    fib_numbers << fib_numbers[index-1] + fib_numbers[index-2]
    index += 1
  end

  return fib_numbers[n-1] + fib_numbers[n-2]
end
