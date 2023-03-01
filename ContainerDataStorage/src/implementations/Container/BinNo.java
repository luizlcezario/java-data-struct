package implementations.Container;

public class BinNo<T extends Comparable<T>> {
	private T conteudo;
	private BinNo<T> left;
	private BinNo<T> right;

	public BinNo(T conteudo) {
		this.conteudo = conteudo;
		this.left = this.right =  null;
	}

	public BinNo(){
	}

	public T getConteudo() {
		return conteudo;
	}

	public void setConteudo(T conteudo) {
		this.conteudo = conteudo;
	}

	public BinNo<T> getLeft() {
		return left;
	}

	public void setLeft(BinNo<T> left) {
		this.left = left;
	}

	public BinNo<T> getRight() {
		return right;
	}

	public void setRight(BinNo<T> right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "BinaryTree [conteudo=" + conteudo + "]";
	}
}
