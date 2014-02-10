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

public class Vehicle : IGo {
    public void Go() {
        Console.WriteLine("Brrrrm!");
    }
}

public class Tractor : Vehicle {
}

public class Program {

    public static void Main() {
        new Tractor().PullPlough();
    }
}
