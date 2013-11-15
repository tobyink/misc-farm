#!/usr/bin/env ruby2.0

module Animal
	def speak
		puts self.noise
	end
end

module Vehicle
	def go
		puts "Brrrrm!"
	end
end

module Hitchable
	def pull_plough
		puts "Hitching plough"
		self.go
	end
end

class Tractor
	include Vehicle
	include Hitchable
end

class Horse
	include Animal
	include Hitchable
	
	def noise
		return "Neigh!"
	end
	
	def go
		puts "Clip-clop"
	end
end

tractor = Tractor.new
(tractor.class.ancestors.include? Hitchable) && tractor.pull_plough

horse = Horse.new
(horse.class.ancestors.include? Hitchable) && horse.pull_plough
