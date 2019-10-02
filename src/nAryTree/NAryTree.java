package nAryTree;

import java.util.List;

public class NAryTree<K, T> {

	private NAryTreeNode<K,T> root;

	public NAryTree() {
		root = null;
	}

	public NAryTreeNode<K,T> getRoot() {
		return root;
	}

	public void setRoot(NAryTreeNode<K,T> root) {
		this.root = root;
	}

	public T search(K key){
		NAryTreeNode<K, T> node = search(key, root);
		if(node != null) {
			return node.getInfo();
		}
		else {
			return null;
		}
	}

	private NAryTreeNode<K, T> search(K key, NAryTreeNode<K, T> rnode) {
		if(rnode == null || key.equals(rnode.getKey())) {
			return rnode;
		}
		else {
			List<NAryTreeNode<K, T>> children = rnode.getChildren(); 
			NAryTreeNode<K, T> node = null;
			for(int i = 0; i < children.size() && node == null; i++) {
				node = search(key, children.get(i));
			}
			return node;
		}
	}
	
	public boolean add(K parentK, K key, T info) {
		boolean added = false;
		NAryTreeNode<K, T> newNode = new NAryTreeNode<K,T>(key, info);

		if(parentK == null && root == null) {
			root = newNode;
			added = true;
		}else {
			NAryTreeNode<K, T> parent = search(parentK, root);
			NAryTreeNode<K, T> node = search(key, root);
			if(parent != null && node == null) {
				parent.getChildren().add(newNode);
				added = true;
			}
		}
		return added;
	}
	
	public boolean isLeaf(K key) {
		boolean is = false;
		NAryTreeNode<K, T> node = search(key, root);
		if(node!= null && node.getChildren().size() <= 0) {
			is = true;
		}
		return is;
	}
	
	public int leafsAmount() {
		return leafsAmount(root);
	}
	
	private int leafsAmount(NAryTreeNode<K, T> rnode) {
		if(rnode==null) {
			return 0;
		}else if(rnode.getChildren().size()==0){
			return 1;
		}else{
			int leafsAmount = 0;
			List<NAryTreeNode<K, T>> children = rnode.getChildren();
			for(int i=0;i<children.size();i++) {
				leafsAmount += leafsAmount(children.get(i));
			}
			return leafsAmount;
		}
	}
	//	public boolean empty() {
	//		boolean empty = false;
	//		if(root == null) {
	//			empty = true;
	//		}
	//		return empty;
	//	}
}
