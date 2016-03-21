
public class ArbreBinaire {
	private Node racine;
	
	public ArbreBinaire(String name) {
		this.racine = new Node(name);
	}
	
	public Node getRacine() {
		return this.racine;
	}
	
	public void parcoursPrefix() {
		Node current = this.getRacine();
		parcoursPrefix(current);
		System.out.println();
	}
	
	public void parcoursPrefix(Node current) {
		System.out.print(current.getName() + " ");
		if(current.getFilsGauche() != null) {
			parcoursPrefix(current.getFilsGauche());
		}
		if(current.getFilsDroit() != null) {
			parcoursPrefix(current.getFilsDroit());
		}
	}
	
	public void parcoursPostfix() {
		Node current = this.getRacine();
		parcoursPostfix(current);
		System.out.println();
	}
	
	public void parcoursPostfix(Node current) {
		if(current.getFilsGauche() != null) {
			parcoursPostfix(current.getFilsGauche());
		}
		if(current.getFilsDroit() != null) {
			parcoursPostfix(current.getFilsDroit());
		}
		System.out.print(current.getName() + " ");
	}
	
	public void parcoursLargeur() {
		Node[] current = {this.getRacine()};
		
		parcoursLargeur(current);
		System.out.println();
	}
	
	public void parcoursLargeur(Node[] current) {
		boolean empty = true;
		for (int i=0; i<current.length; i++) {
		  if (current[i] != null) {
		    empty = false;
		    break;
		  }
		}
		
		if(empty != true) {
			Node[] next = new Node[current.length * 2];
			int j = 0;
			for(int i = 0; i < current.length; i++) {
				if(current[i] != null) {
					System.out.print(current[i].getName() + " ");
					if(current[i].getFilsGauche() != null) {
						next[j] = current[i].getFilsGauche();
						j++;
					}
					if(current[i].getFilsDroit() != null) {
						next[j] = current[i].getFilsDroit();
						j++;
					}
				}
				else {
					break;
				}
			}
			parcoursLargeur(next);
		}
	}
}