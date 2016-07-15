require_relative '../tree.rb'

describe Tree do

  let(:data) {"my data"}
  let(:node) {Node.new(data)}

  it 'has a root node' do
    t = Tree.new(node)
    expect(t.root).to eq(node)
  end

  it 'can search itself for data and return the proper node' do
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

    expect(t.search("b")).to eq(target)
  end

end
