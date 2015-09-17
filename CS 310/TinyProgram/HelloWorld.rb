##
# HelloWorld.rb
# CS 310 - Guo
##

require "./TinyCalc.rb"
require "./TinyGame.rb"

print "Hello World what would you like to do?\n\tPlay or Work?\n"
input = gets.chomp

if input.casecmp("play") == 0
    TinyGame.new.main()
    
elsif input.casecmp("work") == 0
    TinyCalc.new.main()

else
    puts "\nSorry, that is an invalid entry. Goodbye."
end