#!/usr/bin/env perl

use v5.16;
use mop;

role Animal
{
	method noise;
	
	method speak () {
		say $self->noise;
	}
}

role Vehicle
{
	method go () {
		say "Brrrrm!";
	}
}

role Hitchable
{
	method go;
	
	method pull_plough () {
		say "Hitching plough";
		$self->go;
	}
}

class Tractor with Vehicle, Hitchable { }

class Horse with Animal, Hitchable
{	
	method noise () {
		return "Neigh!";
	}
	
	method go () {
		say "Clip-clop";
	}
}

my $tractor = Tractor->new;
$tractor->pull_plough if $tractor->DOES('Hitchable');

my $horse = Horse->new;
$horse->pull_plough if $horse->DOES('Hitchable');
