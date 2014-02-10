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
 
 
var tractor = new Tractor();
tractor.pull_plough();
