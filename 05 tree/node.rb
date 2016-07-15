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

  def search_children(value)
    return self if self.children == nil

    current_child = self.children.first_node

    return current_child if current_child.value == value

    if current_child.children != nil
      puts 'not here? :('
      search_children(current_child)
    end

    until current_child.next == nil
      puts 'here'
      if current_child.value == value
        return current_child
      else
        current_child = current_child.next
      end
    end
  end
end
