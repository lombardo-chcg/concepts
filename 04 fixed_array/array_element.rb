class ArrayElement
  
  attr_accessor :position, :data, :next
  
  def initialize(attrs)
    @position = attrs[:position]
    @next     = attrs[:next]
    @data     = attrs[:data]
  end
end