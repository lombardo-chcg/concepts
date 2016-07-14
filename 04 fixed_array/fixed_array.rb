require_relative 'array_element'
require_relative 'array_error'

class FixedArray
  
  attr_reader :length, :first_element
  
  def initialize(length)
    @length = length
    @first_element = ArrayElement.new(position: 1)
    create_array
  end
  
  def get(index)
    raise OutOfBoundsError if index > @length 
    element = @first_element
    until element.position == index
      element = element.next
    end
    return element
  end
  
  def set(index, data)
    raise OutOfBoundsError if index > @length 
    element = @first_element
    until element.position == index
      element = element.next
    end
    element.data = data
  end
  
  private
  def create_array
    element = @first_element
    for x in (2..@length)
      element.next = ArrayElement.new(position: x)
      element = element.next
    end
  end
end