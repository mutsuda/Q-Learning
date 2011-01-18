import java.util.ArrayList;
import java.util.Iterator;


public class Environment {

	ArrayList<State> states;
	double gamma;
	
	public Environment(double gamma)
	{
		states = new ArrayList<State>();
		this.gamma = gamma;
	}
	
	public void addState(State a)
	{
		states.add(a);
	}
	
	public void removeState(String stateName)
	{
	
	}
	
	public void Train(State ini, ArrayList<Action> actions)
	{
		State currentState = ini;
		boolean found = false;
		Iterator<Action> itr = actions.iterator();
		while (itr.hasNext()) 
	    {
			Action a = itr.next();
			Iterator<Transition> itr2 = currentState.transitions.iterator();
			while (itr2.hasNext()&&!found)
			{
				Transition t = itr2.next();
				if (t.a.name == a.name)
				{	
					t.q = t.reinforcement + gamma*max(t.destination);
					currentState = t.destination;
					found = true;
				}	
			}
			found = false;
	    }
	}
	
	
	public double max(State s)
	{
		Iterator<Transition> itr = s.transitions.iterator();
		double max = 0.0;
		while (itr.hasNext())
		{
			Transition t = itr.next();
			if (t.q > max) max = t.q ;
		}
		return max;
	}
	
	
	public void Print()
	{
		Iterator<State> itr = states.iterator();
		while (itr.hasNext())
		{
			State s = itr.next();
			Iterator<Transition> itr2 = s.transitions.iterator();
			while (itr2.hasNext())
			{
				Transition t = itr2.next();
				System.out.println(s.name + " " + t.a.name + " " + t.q);
			}
		}
	}
	
	public void Play(State ini)
	{
		State current = ini;
		Transition t;
		System.out.print(current.name + " -> ");
		while(true)
		{
			t=pickBest(current.transitions);
			System.out.print(t.destination.name + " -> ");
			current = t.destination;
		}
	}
	
	public Transition pickBest(ArrayList<Transition> transitions)
	{
		Transition best = transitions.get(0);
		Transition t;
		Iterator<Transition> it = transitions.iterator();
		while (it.hasNext())
		{
			t = (Transition) it.next();
			if (t.q > best.q)
			{
				best = t;
			}
		}
		return best;
	}
	
}
