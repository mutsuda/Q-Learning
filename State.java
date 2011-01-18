import java.util.ArrayList;


public class State {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	String name;
	ArrayList<Transition> transitions; 
	
	public String getName()
	{
		return name;
	}
	
	public State(String name)
	{
		transitions = new ArrayList<Transition>();
		this.name = name;
	}
	
	public void addTransition(Transition t)
	{
		transitions.add(t);
	}
}
