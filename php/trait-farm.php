<?php

trait Animal
{
	abstract public function noise ();
	
	public function speak () {
		echo $this->noise(), "\n";
	}
}

trait Vehicle
{
	public function go () {
		echo "Brrrrm!", "\n";
	}
}

trait Hitchable
{
	abstract public function go ();
	
	public function pull_plough () {
		echo "Hitching plough", "\n";
		$this->go();
	}
}

class Tractor
{
	use Vehicle;
	use Hitchable;
}

class Horse
{
	use Animal;
	use Hitchable;
	
	public function noise () {
		return "Neigh!";
	}
	
	public function go () {
		echo "Clip-clop", "\n";
	}
}

$tractor = new Tractor;
method_exists($tractor, 'pull_plough') && $tractor->pull_plough();

$horse = new Horse;
method_exists($horse, 'pull_plough') && $horse->pull_plough();
