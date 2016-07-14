class OutOfBoundsError < StandardError
  def initialize(msg="Index provided is beyond allocated array space")
    super
  end  
end