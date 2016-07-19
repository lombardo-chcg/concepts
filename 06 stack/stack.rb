require_relative './linked_list/list.rb'
require_relative './linked_list/node.rb'

class Stack

  def initialize
    @list = List.new
  end

  def push(node)
    if @list.first_node == nil
      @list.add_first_node(node)
    else
      @list.insert_beginning(node)
    end
    self
  end

  def top
    @list.first_node
  end

  def pop
    node = @list.first_node
    @list.remove_first_node
    node
  end

  def empty?
    return true if @list.length == 0
    false
  end

  def length
    @list.length
  end
end
