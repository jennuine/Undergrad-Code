##
# TinyGame.rb
# CS 310 - Guo
##

#The enemies within the adventure game
class Enemy
    #creates an instance of an enemy
	def initialize(name, attack, defense, res, health)
		@attack = attack
		@defense = defense
		@res = res
		@health = health
		@name = name
	end
    attr_accessor :attack
    attr_accessor :defense
    attr_accessor :res
    attr_accessor :health
    attr_accessor :name
    #uses the enemies attack to lower the health of the player
	def attackPlayer(player)
	    player.health -= attack - player.defense
	end

end
#The player of the adventure game
class Player
    #creates an instance of the Player
	def initialize(name)
	    @name = name
		@attack = 5
		@defense = 5
		@mag = 5
		@health = 50
		@maxHealth = 50
		@potions = 5
		@mana = 100
	end
	attr_accessor :name
    attr_accessor :attack
    attr_accessor :defense
    attr_accessor :mag
    attr_accessor :health
    attr_accessor :maxHealth
    attr_accessor :potions
    attr_accessor :mana
    #uses the players attack to hurt the enemy
	def attackPhys(enemy)
	    enemy.health -= (attack - enemy.defense)
	end
	#uses the players magic to hurt the enemy
	def attackMag(enemy)
	    if (@mana > 0)
	        enemy.health -= (mag - enemy.res)
	        @mana -= 10
	   else
	       puts "You tried to cast but you had no mana!"
	   end
	end
	    #uses one of the players potions to restore health
	def heal
	    if @potions >= 0
	        @health = @maxHealth
	        @mana += 5
	        @potions -= 1
	        puts "You have healed! #{@name}'s health is now #{@health}"
	    else
	        puts "You are out of potions!!!"
	    end
	end
	#increases defense of the Player
	def shieldUp
	    @defense += @defense*3/5
	end
	#increases each of the players attributes
	def levelUp
	    @attack += 5
	    @mag += 5
	    @defense += 1
	    @maxHealth += 5
	    @health += 5
	    @mana += 5
	end
end
class TinyGame
#Aloows the user to play the adventure game
def main()
        puts "Please input your name"
        name = gets.chomp.to_s
        player = Player.new(name)
        puts "oh no a Goblin attacks!"
        enemies = [Enemy.new("Barbarian",12,7,4,15), Enemy.new("Troll",20,10,2,25), Enemy.new("Glass Golem",35,10,20,20), Enemy.new("Lion Turtle",18,20,15,35), Enemy.new("Gryphon",35,25,20,50)]
        enemy = Enemy.new("Goblin",6,1,1,10)
        defeated = false
        i = 0
        timer = -1
        begin
            begin
                moved= false
                puts "Player health: #{player.health} Enemy health: #{enemy.health} Potions: #{player.potions} Mana: #{player.mana}"
                puts "Please input a command attack, magic, shield, or heal"
                input= gets.chomp.to_s
                if (input== "attack")
                    player.attackPhys(enemy)
                    puts "You attack the enemy"
                    moved= true
                elsif (input== "magic")
                    player.attackMag(enemy)
                    puts "You cast magic at the enemy"
                    moved= true
                elsif (input== "heal")
                    player.heal
                    moved= true
                elsif (input== "shield")
                    if player.mana >0
                        timer= 5
                        player.shieldUp
                        player.mana -= 20
                        puts "You have created a magic shield!"
                        moved= true
                    else
                        puts "You don't have enough mana!"
                    end
                end
            end while !moved
            if (enemy.health <= 0)
                puts "#{player.name} defeated the #{enemy.name}!"
                player.levelUp
                puts "#{player.name} leveled up!"
                if i < enemies.length
                    enemy= enemies[i]
                    puts "A new Enemy appeared! It is a #{enemy.name}"
                    i += 1
                    next
                else
                    defeated= true
                    next
                end
            end
                puts "#{enemy.name} attacks!"
                enemy.attackPlayer(player)
            if (player.health <= 0)
                puts "#{player.name}, you have lost!"
                exit
            end
            timer -=1
            if timer== 0
                player.defense -= (player.defense * 3 / 5)
            end
        end while !defeated
        puts "levelUp!!!"
        puts "#{player.name} wins the game!!!"
    end
end
