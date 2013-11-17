public class DelegationFarm
{
	public static interface Animal
	{
		public String noise ();
		public void speak ();
	}
	
	public static class AnimalHelper
	{
		public static void speak (Animal a)
		{
			System.out.println(a.noise());
		}
	}
	
	public static interface Vehicle
	{
		public void go ();
	}
	
	public static class VehicleHelper
	{
		public static void go (Vehicle v)
		{
			System.out.println("Brrrrm!");
		}
	}	
	
	public static interface Hitchable
	{
		public void go ();
		public void pull_plough ();
	}

	public static class HitchableHelper
	{
		public static void pull_plough (Hitchable h)
		{
			System.out.println("Hitching plough");
			h.go();
		}
	}	
	
	public static class Tractor implements Vehicle, Hitchable
	{
		public void go () {
			VehicleHelper.go(this);
		}
		
		public void pull_plough () {
			HitchableHelper.pull_plough(this);
		}
	}
	
	public static class Horse implements Animal, Hitchable
	{
		public String noise () {
			return "Neigh!";
		}
		
		public void speak () {
			AnimalHelper.speak(this);
		}
		
		public void go () {
			System.out.println("Clip-clop");
		}
		
		public void pull_plough () {
			HitchableHelper.pull_plough(this);
		}
	}
	
	public static void main(String[] args) {
		Tractor tractor = new Tractor ();
		if (tractor instanceof Hitchable)
			tractor.pull_plough();
		
		Horse horse = new Horse ();
		if (horse instanceof Hitchable)
			horse.pull_plough();
	}
}
