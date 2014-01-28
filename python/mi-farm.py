#!/usr/bin/env python3

class Animal:
	def speak(self):
		print(self.noise())

class Vehicle:
	def go(self):
		print("Brrrrm!")

class Hitchable:
	def pull_plough(self):
		print("Hitching plough")
		self.go()

class Tractor(Vehicle,Hitchable):
	1

class Horse(Animal,Hitchable):	
	def noise(self):
		return "Neigh!"
	def go(self):
		print("Clip-clop")

tractor = Tractor()
if isinstance(tractor, Hitchable):
	tractor.pull_plough()

horse = Horse()
if isinstance(horse, Hitchable):
	horse.pull_plough()
