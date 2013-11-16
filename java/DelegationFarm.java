public class DelegationFarm
{
	public static interface Animal
	{
		public String noise ();
		public void speak ();
	}
	
	public static class AnimalHelper
	{
		public void speak (Animal a)
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
		public void go (Vehicle v)
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
		public void pull_plough (Hitchable h)
		{
			System.out.println("Hitching plough");
			h.go();
		}
	}	
	
	public static class Tractor implements Vehicle, Hitchable
	{
		private VehicleHelper vh;
		private HitchableHelper hh;
		
		public Tractor () {
			vh = new VehicleHelper ();
			hh = new HitchableHelper ();
		}
		
		public void go () {
			vh.go(this);
		}
		
		public void pull_plough () {
			hh.pull_plough(this);
		}
	}
	
	public static class Horse implements Animal, Hitchable
	{
		private AnimalHelper ah;
		private HitchableHelper hh;
		
		public Horse () {
			ah = new AnimalHelper ();
			hh = new HitchableHelper ();
		}
		
		public String noise () {
			return "Neigh!";
		}
		
		public void speak () {
			ah.speak(this);
		}
		
		public void go () {
			System.out.println("Clip-clop");
		}
		
		public void pull_plough () {
			hh.pull_plough(this);
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
