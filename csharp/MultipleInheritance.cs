using System;

public interface IGo {
    void Go();
}

public static class Hitchable {

    public static void PullPlough(this IGo go) {
        Console.WriteLine("Hitching plough");
        go.Go();
    }

}

public class Vehicle {
    public void Go() {
        Console.WriteLine("Brrrrm!");
    }
}

public class Tractor : Vehicle, IGo {
}


public abstract class Animal {
    public void Speak() {
        Console.WriteLine(Noise());
    }

    public abstract string Noise();
}

public class Horse : Animal, IGo {
    public override string Noise() {
        return "Neigh!";
    }

    public void Go() {
        Console.WriteLine("Clip clop");
    }
}



public class Program {

    public static void Main() {
        var tractor = new Tractor();
        if (tractor is IGo) {
            tractor.PullPlough();
        }

        var horse = new Horse();
        if (horse is IGo) {
            horse.PullPlough();
        }
    }
}
