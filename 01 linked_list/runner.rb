require_relative "list.rb"

node1 = Node.new('one')
node2 = Node.new('two')
node3 = Node.new('three')

node1.next = node2
node2.next = node3

list = List.new(node1)

puts '  '
puts 'node list'
puts '--------'
puts list.print
puts '  '

node_one_point_five = Node.new('one and one-half')
list.insert_after(node1, node_one_point_five)

puts 'insert new node'
puts '--------'
puts list.print
puts ' '

node_zero = Node.new('zero')
list.insert_beginning(node_zero)

puts 'insert new beginning node'
puts '--------'
puts list.print
puts ' '

prev = list.get_previous_node(node3)

puts 'node 3 previous node is...'
puts '--------'
puts prev.data
puts ' '

puts 'last node'
puts '--------'
puts list.last_node.data
puts ' '

puts 'reverse list...'
puts '--------'
list = list.reverse!
list.print
puts ' '

puts "list length = #{list.length}"
puts 'removing node 2...'
list.remove(node2)
puts "list length = #{list.length}"
puts '--------'
puts list.print
puts ' '
