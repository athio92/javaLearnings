/**
 * Created by eclipze on 11/26/2016.
 */
public class MyLinkedList implements NodeList {
    //let root be the first ListItem in our custom LinkedList

    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null) {
            //The list was empty, so this item becomes the head of the list
            this.root = newItem;
            //return true to indicate success & exit from addItem method.
            return true;

        }
        //Execute following code if list is not empty.
        //Start operation from the root.
        ListItem currentItem = this.root;
        while (currentItem != null) {
            //compare root with newItem (item to be added)
            int comparison = (currentItem.compareTo(newItem));
            if (comparison < 0) {
                //newItem is greater, move right if possible
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    //there is no next. You have reached the end of the list.
                    currentItem.setNext(newItem);
                    newItem.setPrevious(currentItem);
                    return true;
                }
            } else if (comparison > 0) {
                //newItem is less, insert before.
                if (currentItem.previous() != null) {
                    currentItem.previous().setNext(newItem);
                    newItem.setPrevious(currentItem.previous());
                    newItem.setNext(currentItem);
                    currentItem.setPrevious(newItem);

                } else {
                    //the node with a previous is the root
                    newItem.setNext(this.root);
                    this.root.setPrevious(newItem);
                    this.root = newItem;
                }

            } else {
                //newItem is equal to currentItem
                System.out.println(newItem.getValue() + " is already present. Not added.");
                return false;
            }
        }
        return false;

    }

    @Override
    public boolean removeItem(ListItem itemToRemove) {
        if (itemToRemove != null) {
            System.out.println("Deleting item " + itemToRemove.getValue());

        }
        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(itemToRemove);
            if (comparison == 0) {
                //found the item to delete
                if (currentItem == this.root) {
                    //if match is found at the root,
                    // simply set the next item as the new root                }
                    this.root = currentItem.next();
                } else {
                    //bypass current item.
                    //update the 'next' of previous item
                    currentItem.previous().setNext(currentItem.next());
                    //update the 'previous' of next item
                    if (currentItem.next() != null) {
                        currentItem.next().setPrevious(currentItem.previous());
                    }

                }
                return true;
            } else if (comparison < 0) {
                //we haven't found the item to remove yet. Move to next item.
                currentItem = currentItem.next();
            } else {
                //comparison>0. Since items inside MyLinkedList are sorted,
                //this means item to be removed is not found
                //(we are already at an item greater than the one to be removed).
                return false;

            }
        }

        //we have reached the end of the list without finding item to delete.
        return false;
    }

    @Override
    //traverse = prints out members of mylinkedlist from root to end.
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The list is empty");
        } else {
            while (root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }
        }
    }


}
