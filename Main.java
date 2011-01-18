import java.util.ArrayList;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		/*We create the environment*/
		Environment env = new Environment(0.9);
			
		Action up = new Action("up");
		Action down = new Action("down");
		
		State A = new State("A");
		State B = new State("B");
		State C = new State("C");
		
		Transition Aup = new Transition(up, 0,B,0);
		Transition Adown = new Transition(down, 0, C, 0);
		
		Transition Bup = new Transition(up, 100, A, 0);
		Transition Bdown = new Transition(down, 0, C, 0);
		
		Transition Cup = new Transition(up, 25, A, 0);
		Transition Cdown = new Transition(down, 50, B, 0);
		
		A.addTransition(Aup);
		A.addTransition(Adown);
		
		B.addTransition(Bup);
		B.addTransition(Bdown);
		
		C.addTransition(Cup);
		C.addTransition(Cdown);
		
		env.addState(A);
		env.addState(B);
		env.addState(C);
		
		
		/*We design the training sequence*/
		
		ArrayList<Action> actionsA = new ArrayList<Action>();
		actionsA.add(up);
		actionsA.add(up);
		actionsA.add(up);
		
		ArrayList<Action> actionsB = new ArrayList<Action>();
		actionsB.add(down);
		actionsB.add(up);
		actionsB.add(down);
		
		ArrayList<Action> actionsC = new ArrayList<Action>();
		actionsC.add(down);
		actionsC.add(down);
		actionsC.add(up);
		
		
		/*We train it*/
		env.Train(A,actionsA);
		env.Train(B, actionsB);
		env.Train(C, actionsC);
		
		env.Print();
		
		
		
		//env.Play(A);
		
	}
	
	

	
}
