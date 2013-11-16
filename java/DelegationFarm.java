public class DelegationFarm
{
	public static interface Animal
	{
		public String noise ();
		public void speak ();
	}
	
	public static class AnimalDelegations
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
	
	public static class VehicleDelegations
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

	public static class HitchableDelegations
	{
		public void pull_plough (Hitchable h)
		{
			System.out.println("Hitching plough");
			h.go();
		}
	}	
	
	public static class Tractor implements Vehicle, Hitchable
	{
		private VehicleDelegations vehicle_delegations;
		private HitchableDelegations hitchable_delegations;
		
		public Tractor () {
			vehicle_delegations = new VehicleDelegations ();
			hitchable_delegations = new HitchableDelegations ();
		}
		
		public void go () {
			vehicle_delegations.go(this);
		}
		
		public void pull_plough () {
			hitchable_delegations.pull_plough(this);
		}
	}
	
	public static class Horse implements Animal, Hitchable
	{
		private AnimalDelegations animal_delegations;
		private HitchableDelegations hitchable_delegations;
		
		public Horse () {
			animal_delegations = new AnimalDelegations ();
			hitchable_delegations = new HitchableDelegations ();
		}
		
		public String noise () {
			return "Neigh!";
		}
		
		public void speak () {
			animal_delegations.speak(this);
		}
		
		public void go () {
			System.out.println("Clip-clop");
		}
		
		public void pull_plough () {
			hitchable_delegations.pull_plough(this);
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
