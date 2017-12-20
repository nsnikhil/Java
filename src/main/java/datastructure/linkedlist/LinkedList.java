package datastructure.linkedlist;

/**
 * @param <T> Generic to be replaced with any object sub class
 */
public class LinkedList<T> {

    private Node<T> mRoot;

    /**
     * Insert the node at beginning, if the list is empty
     * assign root as the new node else set the new node link
     * to be root and then assign the new node as root.
     *
     * @param data the value to be inserted in list
     */
    public void insertFirst(T data){
        Node<T> temp = new Node<>(data,null);
        if(mRoot==null){
            mRoot = temp;
            return;
        }
        temp.setNode(mRoot);
        mRoot = temp;

    }

    /**
     * If the root is null the new node is assigned to root
     * else iterate until you reach the last node and then
     * set the node of the lost node to newly created
     * node.
     *
     * @param data the data to be inserted
     */
    public void insertLast(T data){
        Node<T> temp = new Node<>(data,null);
        if(mRoot==null){
            mRoot = temp;
            return;
        }
        Node<T> loop = mRoot;
        while (loop.getNode() != null)
            loop = loop.getNode();
        loop.setNode(temp);
    }

    /**
     *
     * If root is null assign the new node to root
     * else if position is 1 insert at beginning
     * else if position is equal to size insert at end
     * else iterate to the position and first store the next node
     * and then set the node link to new node and then set the link
     * of new node to the stored node
     *
     * Eg -> 5,6,8,9 insert 7 at 3
     *
     * iterate up-to 6 and store 8 in x
     * set 6->link = 7 and 7->link = x
     * and finally you have 5,6,7,8,9
     *
     * @param position  the position at which the element is to be inserted
     * @param data      the element
     */
    public void insertAtPosition(int position, T data) {
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

    /**
     * Delete the first element but setting the
     * root link to point subsequent node.
     */
    public void deleteFirst(){
        nullCheck();
        mRoot = mRoot.getNode();
    }

    /**
     * Iterate to 2nd last element and
     * set its node/link to point ot null.
     */
    public void deleteLast(){
        nullCheck();
        Node<T> loop = mRoot;
        while (loop.getNode().getNode() != null)
            loop = loop.getNode();
        loop.setNode(null);
    }

    /**
     * if position = 1 delete from first
     * else if position is equal to size delete from end
     * else iterate up-to position-1 and set its link to
     * point to next to next node.
     *
     * Eg -> 5,7,3,8,9 delete from position 3
     * iterate up-to 7 and set
     * 7->setLink = 7->getLink->getLink(which is 8 in this case)
     * and finally you have 5,7,8,9.
     *
     * @param position  the position at which you want to delete the node
     */
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
        loop.setNode(loop.getNode().getNode());
    }

    /**
     *
     * Iterate until you reach the element to whose link
     * is the element you want to delete, then set the link
     * of that element to point to next to next element
     *
     * Eg -> 5,7,8,9 delete 8
     * iterate till 7 and then set
     * 7->setLink = 7->getLink->getLink(which is 9 in this case)
     * finally we have 5,7,9
     *
     * @param data  the element to be deleted
     */
    public void deleteItem(T data){
        nullCheck();
        if (!searchByItem(data)) throw new IllegalArgumentException("Invalid data");
        Node<T> loop = mRoot;
        while (loop.getNode().getData() != data)
            loop = loop.getNode();
        loop.setNode(loop.getNode().getNode());
    }

    /**
     * @return the first element of the list
     */
    public T getFirst(){
        nullCheck();
        return mRoot.getData();
    }

    /**
     *
     * iterate until last node is reached and
     * then return its data.
     *
     * @return the last element of the list
     */
    public T getLast(){
        nullCheck();
        Node<T> loop = mRoot;
        while (loop.getNode() != null)
            loop = loop.getNode();
        return loop.getData();
    }

    /**
     *
     * If position = 1 get the first item
     * else if position == size get the last element
     * else iterate till position and return the data of the node
     *
     * @param position  the position at which you want to get the item
     * @return the item
     */
    public T getAtPosition(int position){
        nullCheck();
        if (position == 1)
            return getFirst();
        if (position == getSize())
            getLast();
        int counter = 0;
        Node<T> loop = mRoot;
        while (counter<position-1){
            loop = loop.getNode();
            counter++;
        }
        return loop.getData();
    }

    /**
     *
     * iterate till end comparing each item and return true as soon
     * as you find the ite,
     *
     * @param data  the item to be searched
     * @return true if item is present else !true
     */
    public boolean searchByItem(T data){
        nullCheck();
        Node<T> loop = mRoot;
        while (loop!=null){
            if (loop.getData().equals(data))
                return true;
            loop = loop.getNode();
        }
        return false;
    }

    /**
     *
     * iterate until you find the element and also
     * increment the counter and return the counter as
     * soon as you find the element
     *
     * @param data  the item whose position you want
     * @return the position of item
     */
    public int getItemPosition(T data){
        nullCheck();
        int position = -1;
        int counter = 1;
        Node<T> loop = mRoot;
        while (loop!=null){
            if (loop.getData().equals(data))
                return counter;
            loop = loop.getNode();
            counter++;
        }
        return position;
    }

    /**
     * Print of data of each node till end
     */
    public void display(){
        nullCheck();
        Node<T> loop = mRoot;
        while (loop!=null){
            System.out.print(loop.getData()+" ");
            loop = loop.getNode();
        }
    }

    /**
     * @return the size of list
     */
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

    /**
     * @return true if list is empty else !true
     */
    public boolean isEmpty(){
        return mRoot == null || getSize() == 0;
    }

    /**
     * throw a null pointer exception is list is null
     */
    private void nullCheck(){
        if (mRoot == null) throw new NullPointerException("List is null");
    }
}