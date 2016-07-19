require_relative 'node.rb'

class List
  attr_accessor :first_node

  def initialize
    @first_node = nil
  end

  def add_first_node(node)
    @first_node = node
  end

  def print
    node = first_node
    while node
      puts node.data
      node = node.next
    end
  end

  def insert_after(node, new_node)
    new_node.next = node.next
    node.next = new_node
  end

  def insert_beginning(node)
    node.next = first_node
    @first_node = node
  end

  def get_previous_node(node)
    current_node = first_node
    until current_node.next == node
      current_node = current_node.next
    end
    previous_node = current_node
  end

  def remove_first_node
    old_first_node = first_node
    @first_node = old_first_node.next
  end

  def remove(node)
    if node == @first_node && self.length == 1
      return @first_node = nil
    else
      previous_node = self.get_previous_node(node)
      previous_node.next = node.next
    end
    # delete removed node?  garbage collector...go to work!
    GC.start
  end

  def length
    counter = 0
    node = first_node
    while node
      counter += 1
      node = node.next
    end
    counter
  end

  def last_node
    if self.length == 0
      return nil
    end

    node = first_node
    until node.next == nil
      node = node.next
    end
    last_node = node
  end

  # returns a new list object and destructively modifies the pointers in the previous list
  # the previous list no longer exists after this method runs
  def reverse!
    old_list = self
    new_list = List.new(self.last_node)
    previous_node = self.get_previous_node(self.last_node)
    old_list.remove(old_list.last_node)
    reverse_util(old_list, new_list, previous_node)
  end

  # recursive.  takes an old list, removes the last item, and puts it next in the new list until the old list is empty
  def reverse_util(old_list, new_list, previous_node)
    if previous_node == nil
      return new_list
    end

    current_node = new_list.last_node
    next_node = old_list.last_node
    new_list.insert_after(current_node, next_node)
    old_list.remove(old_list.last_node)

    reverse_util(old_list, new_list, old_list.last_node)
  end
end
