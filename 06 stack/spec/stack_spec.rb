require_relative "../stack.rb"

describe Stack do

  let(:stack) {Stack.new}
  let(:node1) {Node.new(value: 'data')}
  let(:node2) {Node.new(value: 'mode data')}

  def stack_some_nodes
    stack.push(node1)
    stack.push(node2)
  end

  it "#push can add an element to the stack" do
    stack.push(node1)
    length = stack.length
    expect(stack.length).to be(1)
  end

  it "#top returns the top item in the stack" do
    stack_some_nodes
    expect(stack.top).to be(node2)
  end

  it "#pop removes and returns the top element in the stack" do
    stack_some_nodes
    expect(stack.pop).to be(node2)
  end

  it "#empty? returns true when empty" do
    expect(stack.empty?).to be(true)
  end

  it "#empty? returns false when has elements" do
    stack_some_nodes
    expect(stack.empty?).to be(false)
  end
end
