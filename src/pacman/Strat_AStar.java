package pacman;

import java.util.*;

public class Strat_AStar implements PacmanStrategy {

	PacmanAgent body;
	PositionAgent target;
	
	PacmanGame world;
	
	Stack<AgentAction> plan;
	
	boolean seekTarget;
	
	public Strat_AStar (PacmanAgent body) {
		this.body=body;
		seekTarget=true; //must find a living pacman to go to
	}
	public Strat_AStar (PacmanAgent body, PositionAgent target) {
		this.body=body;
		this.target=target;
		seekTarget=false; //if you only need to go one place
	}
	
	
	@Override
	public AgentAction action(PacmanGame m) {
		this.world = m;
		
		if(seekTarget) {
			for(PacmanAgent a: m.getAgents()) {
				if(a instanceof Pacman) {
					target = a.getXy();
				}
			}
		}
		System.out.println("Starting Astart");
		plan = new Stack<AgentAction>();
		Astar(body.getXy(), this.target);
		System.out.println("Astar done, plan length:"+plan.size());
		if(plan.size()==0) {
			return new AgentAction(4);
		}
		
		return plan.pop();
	}

	private void Astar (PositionAgent start, PositionAgent target) {
		PositionAgent start0 =start; start0.setDir(0);
		PositionAgent target0=target; target0.setDir(0);
		Queue<AstarNode> closed = new LinkedList<AstarNode>();
		Queue<AstarNode> open = new PriorityQueue<AstarNode>(100, new AstarNodeComparator());
		AstarNode s = new AstarNode(start0, null, null);
		open.add(s);
		while(!open.isEmpty()) {
			AstarNode u = open.poll();
			System.out.println("reStarting Astart, "+ u.pos.getX()+","+ u.pos.getY()+" :: travelled: " + u.travelled + " togo: "+u.togo+" h: "+u.h);
			if(u.equalspos(target0)) {
				getpath(u);
				return;
			}
			for(int i=0;i<4;i++) {
				AgentAction a = new AgentAction(i);
				if(PacmanGame.isLegalMove(u.pos, a)) {
					int x = u.pos.getX()+a.get_vx();
					int y = u.pos.getY()+a.get_vy();
					PositionAgent p = new PositionAgent(x,y,0);
					if(!inQueue(p,open) && !inQueue(p,closed)) {
						AstarNode n = new AstarNode(p,u,a);
						open.add(n);
						System.out.println("Add Node"+ n.pos.getX()+" "+ n.pos.getY());
					}
				}
			}
			closed.add(u); System.out.println("closed: "+u.pos.getX()+","+u.pos.getY());
			System.out.println("open is empty?: "+open.isEmpty());
		}
	}
	
	
	private boolean inQueue(PositionAgent p, Queue<AstarNode> q) {
		Queue<AstarNode> l = q;
		for(AstarNode n : l) {
			if(n.equalspos(p)) return true;
		}
		return false;
	}
	
	private void getpath(AstarNode u) {
		if(u.via != null) {
			System.out.print("stepin back");
			System.out.println(u.via.get_direction());
			plan.push(u.via);	
			getpath(u.from);
		}
	}


	static class AstarNodeComparator implements Comparator<AstarNode>{

		@Override
		public int compare(AstarNode arg0, AstarNode arg1) {
			if(arg0.h < arg1.h) return -1;
			if(arg0.h > arg1.h) return 1;
			return 0;
		}
	}
	
	int distance(PositionAgent a, PositionAgent b) {
		return Math.abs(a.getX()-b.getX()) + Math.abs(a.getY() - b.getY());
	}
	
	class AstarNode {
		PositionAgent pos;
		AstarNode from;
		AgentAction via;
		int travelled, togo, h;
		
		AstarNode(PositionAgent pos, AstarNode from, AgentAction via){
			this.pos = pos;
			this.from = from;
			this.via = via;
			if(from==null || via==null) travelled = 0;
			else travelled = from.travelled+1;
			togo = distance(pos,target);
			updateH();
		}
		
		void updateTravelled(int n) {
			this.travelled = n;
			updateH();
		}
		
		void updateH() {
			this.h = this.travelled + this.togo;
		}
		
		boolean equalspos(AstarNode o) {
			return equalspos(o.pos);
		}
		boolean equalspos(PositionAgent o) {
			return pos.equals(o);
		}
		
		
	}
}
