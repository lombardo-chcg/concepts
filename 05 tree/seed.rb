require_relative 'tree.rb'

def seed
  root = Node.new("body")
  second1 = Node.new("div")
  second2 = Node.new("div")
  second3 = Node.new("div")
  third1 = Node.new("p")
  third2 = Node.new("p")
  target = Node.new("b")

  t = Tree.new(root)

  root.add_child(second1)
  root.add_child(second2)
  root.add_child(second3)

  second2.add_child(third1)
  second2.add_child(third2)

  third2.add_child(target)

  return t
end
