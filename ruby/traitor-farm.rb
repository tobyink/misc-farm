#!/usr/bin/env ruby2.0

########
## This seems to fail in my copy of Ruby, but I don't
## really understand why.
########

require 'traitor'

Animal = Trait.new do
	def speak
		puts self.noise
	end
end

Vehicle = Trait.new do
	def go
		puts "Brrrrm!"
	end
end

Hitchable = Trait.new do
	def pull_plough
		puts "Hitching plough"
		self.go
	end
end

class Tractor
	uses Vehicle
	uses Hitchable
end

class Horse
	uses Animal
	uses Hitchable
	
	def noise
		return "Neigh!"
	end
	
	def go
		puts "Clip-clop"
	end
end

tractor = Tractor.new
(tractor.class.traits.include? Hitchable) && tractor.pull_plough

horse = Horse.new
(horse.class.traits.include? Hitchable) && horse.pull_plough
