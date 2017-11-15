package datastructure.linkedlist;

public class LinkedList<T> {

    private Node<T> mRoot;

    public void insertFirst(T data){
        Node<T> temp = new Node<>(data,null);
        if(mRoot==null){
            mRoot = temp;
            return;
        }
        temp.setNode(mRoot);
        mRoot = temp;

    }

    public void insertLast(T data){
        Node<T> temp = new Node<>(data,null);
        if(mRoot==null){
            mRoot = temp;
            return;
        }
        Node<T> loop = mRoot;
        while (loop.getNode()!=null){
            loop = loop.getNode();
        }
        loop.setNode(temp);
    }

    public void insertAtPosition(int position,T data){
        Node<T> temp = new Node<>(data,null);
        if(mRoot==null){
            mRoot = temp;
            return;
        }
        if(position==1){
            insertFirst(data);
            return;
        }
        if(position==getSize()){
            insertLast(data);
            return;
        }

        int counter = 0;
        Node<T> loop = mRoot;
        while (counter<position-2){
            counter++;
            loop = loop.getNode();
        }
        Node<T> next = loop.getNode();
        loop.setNode(temp);
        temp.setNode(next);
    }

    public void deleteFirst(){
        nullCheck();
        mRoot = mRoot.getNode();
    }

    public void deleteLast(){
        nullCheck();
        Node<T> loop = mRoot;
        while(loop.getNode().getNode()!=null){
            loop = loop.getNode();
        }
        loop.setNode(null);
    }

    public void deleteAtPosition(int position){
        nullCheck();
        if(position==1){
            deleteFirst();
            return;
        }
        if(position==getSize()){
            deleteLast();
            return;
        }
        int counter = 0;
        Node<T> loop = mRoot;
        while (counter<position-2){
            loop = loop.getNode();
            counter++;
        }
        Node<T> next = loop.getNode();
        loop.setNode(next.getNode());
    }

    public void deleteItem(T data){
        nullCheck();
        if(!searchByItem(data)){
            throw new IllegalArgumentException("Invalid data");
        }
        Node<T> loop = mRoot;
        while (loop.getNode().getData()!=data){
            loop = loop.getNode();
        }
        Node<T> toDelete = loop.getNode();
        loop.setNode(toDelete.getNode());
    }

    public T getFirst(){
        nullCheck();
        return mRoot.getData();
    }

    public T getLast(){
        nullCheck();
        Node<T> loop = mRoot;
        while (loop.getNode()!=null){
            loop = loop.getNode();
        }
        return loop.getData();
    }

    public T getAtPosition(int position){
        nullCheck();
        if(position==1){
            return getFirst();
        }
        if(position==getSize()){
            getLast();
        }
        int counter = 0;
        Node<T> loop = mRoot;
        while (counter<position-1){
            loop = loop.getNode();
            counter++;
        }
        return loop.getData();
    }


    public boolean searchByItem(T data){
        nullCheck();
        Node<T> loop = mRoot;
        while (loop!=null){
            if(loop.getData().equals(data)){
                return true;
            }
            loop = loop.getNode();
        }
        return false;
    }

    public int getItemPosition(T data){
        nullCheck();
        int position = -1;
        int counter = 1;
        Node<T> loop = mRoot;
        while (loop!=null){
            if(loop.getData().equals(data)){
                return counter;
            }
            loop = loop.getNode();
            counter++;
        }
        return position;
    }

    public void display(){
        nullCheck();
        Node<T> loop = mRoot;
        while (loop!=null){
            System.out.print(loop.getData()+" ");
            loop = loop.getNode();
        }
    }

    public int getSize(){
        nullCheck();
        int counter = 0;
        Node<T> loop = mRoot;
        while (loop!=null){
            loop = loop.getNode();
            counter++;
        }
        return counter;
    }

    public boolean isEmpty(){
        return mRoot == null || getSize() == 0;
    }

    private void nullCheck(){
        if(mRoot==null){
            throw new NullPointerException("List is null");
        }
    }

}
