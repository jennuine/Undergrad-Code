##
# TinyCalc.rb
# CS 310 - Guo
##

# Tiny program that performs certain math functions
class TinyCalc

    # Returns the factorial of a value
    def factorial(value)
        result = 1
        for i in 1..value
            result = i * result
        end
    return result
    end

    # Prints the base to the power of y
    def pow(base, y)
        result = 1
        for i in 0..(y - 1)
            result = result * base
        end
    puts "\n#{base}^(#{y}) = #{result}\n"
    end

    # Returns the fibonacci of a number using recursion
    def fib(n)
       if n == 0 || n == 1
            return n
        else
            fib(n - 1) + fib(n - 2)
        end
    end

    # Prints the permutations of r in n
    def permutations(n, r)
        result = factorial(n) / factorial(n - r)
        puts "\nP(#{n},#{r}) = #{result}"
    end

    # Prints the combinations of r in n
    def combinations(n, r)
        result = factorial(n) / (factorial(r) * factorial(n - r))
        puts "\nC(#{n},#{r}) = #{result}"
    end

    # Menu prompt that keeps iterating until the user exits
    #   After a function operation, the menu will reappear after 2 seconds
    def main()

        exit = false

        while (!exit)

            puts "\nWhat would you like to do?\n\tEnter 1: To Find the Factorial\n\tEnter 2: To Find the Power"
            puts "\tEnter 3: To Find the Fibonacci\n\tEnter 4: To Find the Permutations of a Number"
            puts "\tEnter 5: To Find the Combinations of a Number\n\tEnter 6: To Exit"

            case gets.to_i

            when 1
                puts "\nPlease enter a value to calculate the factorial"
                result = factorial(value = gets.to_i)
                puts "\n#{value}! = #{result}\n"
                sleep 2

            when 2
                puts "\nPlease enter a base value"
                base = gets.to_i
                puts "Now enter base's power"
                pow(base, gets.to_i)
                sleep 2

            when 3
                puts "\nPlease enter a value to calculate the fibonacci"
                n = gets.to_i
                fib = fib(n)
                puts "\nfibonacci(#{n}) = #{fib}"
                sleep 2

            when 4
                puts "\nPlease enter a value n"
                n = gets.to_i
                puts "Now enter a value r"
                permutations(n, gets.to_i)
                sleep 2

            when 5
                puts "\nPlease enter a value n"
                n = gets.to_i
                puts "Now enter a value r"
                combinations(n, gets.to_i)
                sleep 2

            when 6
                exit = true
                puts "\nGoodbye!"
                break

           else
               puts "\nSorry, that is an invalid menu item"

            end
        end
    end
end
