#!/bin/sh
exec scala "$0" "$@"
!#

trait Animal
{
	def noise: String;
	def speak = println(noise);
}

trait Vehicle
{
	def go = println("Brrrrm!");
}

trait Hitchable
{
	def go;
	def pull_plough =
		go;
		println("Hitching plough");
}

class Tractor
	extends Vehicle
	with Hitchable {}

class Horse
	extends Animal
	with Hitchable
{
	def noise: String = "Neigh!";
	def go = println("Clip-clop");
}

val tractor = new Tractor;
if (tractor.isInstanceOf[Hitchable])
	tractor.pull_plough;

val horse = new Horse;
if (horse.isInstanceOf[Hitchable])
	horse.pull_plough;

