require_relative 'node.rb'

class Tree

  attr_reader :root

  def initialize(node)
    @root = node
  end

  def search(value)
    current_child = @root.children.first_node
    until current_child.next == nil
      search = current_child.search_children(value)
      if search && search.value == value
        return search
      else
        current_child = current_child.next
      end
    end
    return nil
  end
end
