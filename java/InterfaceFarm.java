public class InterfaceFarm
{
	public static interface Animal
	{
		public String noise ();
		public void speak ();
	}
	
	public static interface Vehicle
	{
		public void go ();
	}
	
	public static interface Hitchable
	{
		public void go ();
		public void pull_plough ();
	}
	
	public static class Tractor implements Vehicle, Hitchable
	{
		public Tractor () {}
		
		public void go () {
			System.out.println("Brrrrm!");
		}
		
		public void pull_plough () {
			System.out.println("Hitching plough");
			this.go();
		}
	}
	
	public static class Horse implements Animal, Hitchable
	{
		public Horse () {}
		
		public String noise () {
			return "Neigh!";
		}
		
		public void speak () {
			System.out.println(this.noise());
		}
		
		public void go () {
			System.out.println("Clip-clop");
		}
		
		public void pull_plough () {
			System.out.println("Hitching plough");
			this.go();
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
