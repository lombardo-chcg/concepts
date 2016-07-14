require_relative './linked_list/list.rb'

class Node
  attr_accessor :value, :next
    
  def initialize(value)
    @value = value
    @child_nodes = nil
  end
  
  def children
    if @child_nodes == nil
      return nil
    end
    @child_nodes
  end
  
  def add_child(node)
    if !children
      @child_nodes = List.new(node)
    else
      @child_nodes.insert_after(@child_nodes.last_node, node)      
    end
  end
end