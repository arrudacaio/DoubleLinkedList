
public class DoubleLinkedList {

	private Node begin;
	private Node last;

	public DoubleLinkedList() {
		this.begin.setData(null);
		this.last.setData(null);
	}

	public boolean isEmpty() {
		return this.begin == null;
	}

	public void addLast(int element) {
		if (isEmpty()) { // Caso a estrutura esteja vazia
			this.begin = new Node(element, null, null);
		} else {
			this.addLast(this.begin, element);
		}
	}

	public void addLast(Node node, int element) {
		if (node.getNext() == null) {
			Node newNode = new Node(element, null, null);
			node.setNext(newNode);
			newNode.setPrev(node);
		} else {
			addLast(node.getNext(), element); // Procurando uma posição válida
		}
	}

	public int size() {
		if (isEmpty()) {
			return 0;
		} else {
			return size(this.begin);
		}
	}

	public int size(Node node) {
		if (isEmpty()) {
			return 0;
		} else {
			return 1 + size(node.getNext());
		}
	}

	public int soma() {
		if (isEmpty()) {
			return 0;
		} else {
			return soma(this.begin);
		}
	}

	public int soma(Node node) {
		if (isEmpty()) {
			return 0;
		} else {
			return node.getData() + soma(node.getNext());
		}
	}

	public boolean isSorted() {
		return isSorted(this.begin);
	}

	public boolean isSorted(Node node) {
		if (node.getData() == null || node.getNext() == null) {
			return true;
		} else if (node.getData() < node.getNext().getData()) {
			return isSorted(node.getNext());
		}
		return false;
	}

	public void add(int index, int element) {
		if (isEmpty()) {
			this.begin = new Node();
			this.last = new Node();
		}
		if (index == 0) {
			Node newNode = new Node(element, null, null);
			this.begin.setPrev(newNode);
			this.begin = newNode;
			this.begin = new Node();
		}
		if (index == this.size()) { // Se for igual ao tamanho da linked list, criamos um novo nó que vai para
									// depois do ultimo elemento.
			Node newNode = new Node(element, null, null);
			newNode.setPrev(last);
			this.last.setNext(newNode);
		} else {
			Node refNode = this.begin;
			for (int i = 0; i < index; i++) {
				refNode = refNode.next;
			}
			Node newNode = new Node(element, null, null);
			newNode.setNext(refNode.next);
			refNode.setNext(newNode);
			newNode.setPrev(refNode);
			newNode.next.prev = newNode;

		}
	}
		
		public void remove(int index) {
			if(!(index > size())) {
				if(size() == 1 && index == 0) {
					this.begin.setData(null);
					this.last.setData(null);
				}
				
				if(index == 0) {
					this.begin = this.begin.getNext();
					this.begin.setPrev(new Node());
				}
				
				if(index == size()) {
					this.last = last.getPrev();
					this.last.setNext(new Node());
				}
				
				Node temp = this.begin;
				int j = 0;
				while(temp != null) {
					if(j == index) {
						Node prev = temp.prev;
						Node next = temp.next;
						prev.setNext(next);
						next.setPrev(prev);
					}
					temp = temp.next;
					j++;
				}

			}
			throw new IndexOutOfBoundsException();
	}

	class Node {

		private Integer data;
		private Node prev;
		private Node next;

		public Node(Integer data, Node prev, Node next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}

		public Node() {

		}

		public Integer getData() {
			return data;
		}

		public void setData(Integer data) {
			this.data = data;
		}

		public Node getPrev() {
			return prev;
		}

		public void setPrev(Node prev) {
			this.prev = prev;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	}

}
