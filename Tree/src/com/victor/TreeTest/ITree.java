package com.victor.TreeTest;

import java.util.Iterator;

public interface ITree <T>{
	public INode<T> root();
	public INode<T> parent(INode<T> n);
	public Iterator<INode<T>> children(INode<T> n);
	public boolean inInternal(INode<T> n);
	public boolean isExternal(INode<T> n);
	public boolean isRoot(INode<T> n);
	public int size();
	public boolean isEmpty();
	public Iterator<T> iterator();
	public Iterator<INode<T>> nodes();
	public T replace(INode<T> n, T e);

}
