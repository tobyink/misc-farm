#!/usr/bin/env rhino

load('http://joose-js.googlecode.com/files/joose.mini.js');

Role('Animal', {
	requires: ['noise'],
	methods: {
		'speak': function () {
			print(this.noise());
		}
	}
});

Role('Vehicle', {
	methods: {
		'go': function () {
			print("Brrrrm!");
		}
	}
});

Role('Hitchable', {
	requires: ['go'],
	methods: {
		'pull_plough': function () {
			print("Hitching plough");
			this.go();
		}
	}
});

Class('Tractor', {
	does: [Vehicle, Hitchable]
});

Class('Horse', {
	does: [Animal, Hitchable],
	methods: {
		'noise': function () {
			return "Neigh!";
		},
		'go': function () {
			print("Clip-clop");
		}
	}
});


var $tractor = new Tractor;
if ($tractor.meta.does(Hitchable))
	$tractor.pull_plough();

var $horse = new Horse;
if ($horse.meta.does(Hitchable))
	$horse.pull_plough();
