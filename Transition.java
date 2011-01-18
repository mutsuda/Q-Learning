
public class Transition {
	Action a;
	double reinforcement;
	State destination;
	double q;
	
	public Transition(Action a, double reinforcement, State destination, double q)
	{
		this.a = a;
		this.reinforcement = reinforcement;
		this.destination = destination;
		this.q = q;
	}
}
