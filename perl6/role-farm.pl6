#!/usr/bin/env perl6

role Animal
{
	method noise {
		...;
	}
	
	method speak {
		say self.noise;
	}
}

role Vehicle
{
	method go {
		say "Brrrrm!";
	}
}

role Hitchable
{
	method go {
		...;
	}
	
	method pull_plough {
		say "Hitching plough";
		self.go;
	}
}

class Tractor does Vehicle does Hitchable { }

class Horse does Animal does Hitchable
{
	method noise {
		return "Neigh!";
	}
	
	method go {
		say "Clip-clop";
	}
}


my $tractor = Tractor.new;
$tractor.pull_plough if $tractor.does(Hitchable);

my $horse = Horse.new;
$horse.pull_plough if $horse.does(Hitchable);
