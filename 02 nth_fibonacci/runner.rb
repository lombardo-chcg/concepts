require_relative "recursive_fib.rb"
require_relative "fib_memo.rb"
require 'benchmark'

puts ''
puts '15'
Benchmark.bm do |x|
  x.report('straight recursive:') { fib(15) }
  x.report('with memo:         ') { fib_with_memo(15) }
end

puts ''
puts '35'
Benchmark.bm do |x|
  x.report('straight recursive:') { fib(35) }
  x.report('with memo:         ') { fib_with_memo(35) }
end

puts ''
puts '40'
Benchmark.bm do |x|
  x.report('straight recursive:') { fib(40) }
  x.report('with memo:         ') { fib_with_memo(40) }
end
