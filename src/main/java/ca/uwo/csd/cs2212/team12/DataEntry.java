
public class DataEntry {

		private int calBurned;
		private int distanceTravelled;
		private int floorsClimbed;
		private int stepsTaken;
		
		public DataEntry(int cal, int dist, int floors, int steps){
			 calBurned= cal;
			 distanceTravelled= dist;
			 floorsClimbed= floors;
			 stepsTaken= steps;
	}
		
		public DataEntry(){
			calBurned=0;
			distanceTravelled= 0;
			floorsClimbed= 0;
			stepsTaken= 0;
		}

		public int getCalBurned() {
			return calBurned;
		}

		public void setCalBurned(int calBurned) {
			this.calBurned = calBurned;
		}

		public int getDistanceTravelled() {
			return distanceTravelled;
		}

		public void setDistanceTravelled(int distanceTravelled) {
			this.distanceTravelled = distanceTravelled;
		}

		public int getFloorsClimbed() {
			return floorsClimbed;
		}

		public void setFloorsClimbed(int floorsClimbed) {
			this.floorsClimbed = floorsClimbed;
		}

		public int getStepsTaken() {
			return stepsTaken;
		}

		public void setStepsTaken(int stepsTaken) {
			this.stepsTaken = stepsTaken;
		}
		
		

	}

