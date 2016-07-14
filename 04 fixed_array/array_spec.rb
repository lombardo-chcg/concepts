require_relative 'fixed_array'

describe FixedArray do

  let(:x) { FixedArray.new(5) }
  
  it "has a fixed length" do
    expect(x.length).to eq(5)
  end
  
  it "can return elements based on index position" do
    expect(x.get(4)).to be_a(ArrayElement)
  end
  
  it "can set a value based on index position" do
    data = "my data"
    x.set(3, data)
    expect(x.get(3).data).to be(data)
  end
  
  it "raises an error for out of bounds index positions" do
    expect{x.get(30)}.to raise_error OutOfBoundsError
  end
end