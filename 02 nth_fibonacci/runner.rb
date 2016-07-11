require_relative "recursive_fib.rb"
require_relative "fib_memo.rb"


def benchmark
  start_time = Time.now.to_f
  yield
  end_time = Time.now.to_f
  end_time - start_time
end

puts "straight recursive: #{ benchmark { fib(40) } } seconds"
puts "with memo: #{ benchmark {fib_with_memo(40)} } seconds "
