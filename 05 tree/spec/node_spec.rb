require_relative "../node.rb"

describe Node do

  let(:data) {"my data"}
  let(:node) {Node.new(data)}

  it 'has a value' do
    expect(node.value).to be(data)
  end

  it 'can add a new child' do
    n = Node.new("more data")
    node.add_child(n)
    expect(node.children.first_node).to be(n)
  end

  it 'knows its children' do
    n = Node.new("more data")
    n2 = Node.new("even more data")
    node.add_child(n)
    node.add_child(n2)
    expect(node.children.last_node).to be(n2)
  end

  it 'knows when it does not have children' do
    expect(node.children).to be(nil)
  end
end
