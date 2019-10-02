package nAryTree;

import java.util.ArrayList;
import java.util.List;

public class NAryTreeNode <K,T> {

	private T info;
	private K key;
	private NAryTreeNode<K,T> parent;
	private List<NAryTreeNode<K,T>> children;
	
	public NAryTreeNode(K key, T data) {
		info = data;
		this.key = key;
		children = new ArrayList<NAryTreeNode<K,T>>();
		parent = null;
	}
	public T getInfo() {
		return info;
	}
	public void setParent(NAryTreeNode<K,T> current) {
		parent = current;
	}
	public NAryTreeNode<K,T> getParent(){
		return parent;
	}
	public List<NAryTreeNode<K,T>> getChildren() {
		return children;
	}
	public K getKey() {
		return key;
	}
}
