package implementations.Container;

public class BinaryTree<T extends Comparable<T>> {

	public BinNo<T> root;

	public BinaryTree() {
		this.root = null;
	}

	public void inserir(T value) {
		BinNo<T> newContent = new BinNo<T>(value);
		this.root = insert(this.root, newContent);
	}

	private BinNo<T> insert(BinNo<T> now, BinNo<T> newContent) {
		if (now == null) {
			return newContent;
		}
		else if (newContent.getConteudo().compareTo(now.getConteudo()) < 0){
			now.setLeft(insert(now.getLeft(), newContent));
		}
		else {
			now.setRight(insert(now.getRight(), newContent));
		}
		return now;
	}

	public void print(boolean preOrder , boolean afterOrder) {
		if (preOrder && afterOrder) {
			return;
		}
		else if (preOrder) {
			showPreOrder(this.root);
		}
		else if (afterOrder) {
			showAfterOrder(this.root);
		}
		else {
			showInOrder(this.root);
		}
	}

	public void print() {
		print(false, false);
	}

	private void showInOrder(BinNo<T> now) {
		if (now != null) {
			showInOrder(now.getLeft());
			System.out.print(now.getConteudo() + " ");
			showInOrder(now.getRight());
		}
	}
	private void showAfterOrder(BinNo<T> now) {
		if (now != null) {
			showAfterOrder(now.getLeft());
			showAfterOrder(now.getRight());
			System.out.print(now.getConteudo() + " ");
		}
	}

	private void showPreOrder(BinNo<T> now) {
		if (now != null) {
			System.out.print(now.getConteudo() + " ");
			showPreOrder(now.getLeft());
			showPreOrder(now.getRight());
		}
	}

	public void remove(T value) {
		try {
			BinNo<T> now = this.root;
			BinNo<T> father = null;
			BinNo<T> child = null;
			BinNo<T> temp = null;
			while ( now != null && !now.getConteudo().equals(value)) {
				father = now;
				if (value.compareTo(now.getConteudo()) < 0) {
					now = now.getLeft();
				}
				else {
					now = now.getRight();
				}
			}
			if(now == null ) {
				throw new Exception("Elemento não encontrado");
			}
			else if (father == null) {
				if (now.getRight() == null) {
					this.root = now.getLeft();
				} else if (now.getLeft() == null) {
					this.root = now.getRight();
				} else {
					for (temp = now, child = now.getLeft(); child.getRight() != null; temp = child, child = child.getRight()) {
						if (child != now.getLeft()) {
							temp.setRight(child.getLeft());
							child.setLeft(now.getLeft());
						}
					}
					child.setRight(now.getRight());
					this.root = child;
				}
			}
			else if (now.getRight() == null) {

			} else if (now.getLeft() == null) {
				
			} else {
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


}
