#!/usr/bin/env python3

from abc import ABCMeta

class Animal:
	__metaclass__ = ABCMeta
	def speak(self):
		print(self.noise())
	def noise(self):
		raise NotImplementedError()

class Vehicle:
	__metaclass__ = ABCMeta
	def go(self):
		print("Brrrrm!")

class Hitchable:
	__metaclass__ = ABCMeta
	def pull_plough(self):
		print("Hitching plough")
		self.go()
	def go(self):
		raise NotImplementedError()

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
