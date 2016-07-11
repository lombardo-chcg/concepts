def fib_with_memo(n, memo = [0,1])
  if n == 0 then return 0 end
  if n == 1 then return 1 end
  if memo.length == n then return memo[-1] + memo[-2] end

  if memo.length < n
    memo << memo[-1] + memo[-2]
  end

  fib_with_memo(n, memo)
end
