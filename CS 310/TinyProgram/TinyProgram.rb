class TinyProgram
    def initialize
        @names = ["World", "Galaxy", "Universe","Infinity and Beyond"]
    end
    
    def hi
        print "Hello "
        @names.each do |name|
        print "#{name} , "
    end
    
        print "and you of course!"
    end
end
tp = TinyProgram.new
tp.hi
#HEY ADAM CHANDLER