function mixin(destination, source) {
    for (var fn in source) {
        if (source.hasOwnProperty(fn)) {
            destination[fn] = source[fn];
        }
    }
    return destination;
}
 
var HitchableMixin = {
    pull_plough: function() {
        console.log("Hitching plough");
        this.go();
    }
};
 
var Vehicle = function() {
};
Vehicle.prototype.go = function() {
    console.log("Brrrrm!");
};
 
var Tractor = function() {
};
Tractor.prototype = new Vehicle();
mixin(Tractor.prototype, HitchableMixin);

var Animal = function() {
};
Animal.prototype.speak = function() {
    console.log(this.noise());
}

var Horse = function() {
};
Horse.prototype.noise = function() {
    return "Neigh!";
};
Horse.prototype.go = function() {
    console.log("Clip clop");
};
mixin(Horse.prototype, HitchableMixin);
 

var tractor = new Tractor();
if (tractor.pull_plough) {
    tractor.pull_plough();
}

var horse = new Horse();
if (horse.pull_plough) {
    horse.pull_plough();
}


