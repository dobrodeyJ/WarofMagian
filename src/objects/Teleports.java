package objects;

public enum Teleports {
		IN(300),
		OUT(400);
		private final int id;
		
		Teleports(int id) {
			this.id = id;
		}
		public int getId() {
			return id; 
		}
}
