require_relative "node.rb"

describe Node do
  
  let(:data) {"my data"}
  let(:node) {Node.new(data)}
  
  it 'has a value' do
    expect(node.value).to be(data)
  end
  
  it 'knows its children' do
    n = Node.new("more data")
    node.add_child(n)
    expect(node.children.first_node).to be(n)
  end
  
end
