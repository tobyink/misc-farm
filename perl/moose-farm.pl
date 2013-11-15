#!/usr/bin/env perl

use v5.14;

package Animal
{
	use Moose::Role;
	requires 'noise';
	
	sub speak {
		my $self = shift;
		say $self->noise;
	}
}

package Vehicle
{
	use Moose::Role;

	sub go {
		say "Brrrrm!";
	}
}

package Hitchable
{
	use Moose::Role;
	requires 'go';
	
	sub pull_plough {
		my $self = shift;
		say "Hitching plough";
		$self->go;
	}
}

package Tractor
{
	use Moose;
	with 'Vehicle', 'Hitchable';
}

package Horse
{
	use Moose;
	with 'Animal', 'Hitchable';
	
	sub noise {
		return "Neigh!";
	}
	
	sub go {
		say "Clip-clop";
	}
}


my $tractor = Tractor->new;
$tractor->pull_plough if $tractor->DOES('Hitchable');

my $horse = Horse->new;
$horse->pull_plough if $horse->DOES('Hitchable');
