package leet327;

public class BSCNode {

	public int value;
	public int sum;
	public BSCNode left, right;
	public BSCNode(int value) {
		this.value = value;
		this.sum = 0;
		this.left = this.right = null;
	}
}
