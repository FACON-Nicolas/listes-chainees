# LinkedList

This is a project developped at school in a resources called `Dev Efficace`. This project contains a source code for LinkedList, SortedLinkedList and DoublyLinkedList.

![](https://cdn.programiz.com/sites/tutorial2program/files/linked-list-concept.png)

# Summary

* **[Summary](#summary)**
* **[Credits](#credits)**
* **[Install](#install)**
  * **[Pre-requisites](#pre-requisites)**
  * **[Installation](#installation)**
* **[Description](#description)**
  * **[LinkedList](#linkedlist)**
  * **[SortedLinkedList](#sortedlinkedlist)**
  * **[DoublyLinkedList](#doublylinkedlist)**

# Credits

* **[FACON Nicolas](github.com/FACON-Nicolas)** : project developer

# Install

## Pre-requisites

+ Java
```shell
sudo apt update
sudo apt install default-jre
java -version
```

## Installation

```shell
git clone https://github.com/FACON-Nicolas/listes-chainees
```

# Description

## LinkedList

A linked List is an Object composed by a node, a node is composed by two objects:
+ an element
+ a pointer on next node

![](https://cdn.programiz.com/sites/tutorial2program/files/linked-list-concept.png)
to know if an element exists, the algorithm is next
```
searchElt(elt):
    node <- head
    while (node is not null):
        if (nodeElt = elt): #elt exists
            return true
        node <- nodeNext
    return false #elt doesn't exist
```

## SortedLinkedList

![](https://nitemice.files.wordpress.com/2014/07/midaddani.gif)
A sorted linked list is a linked list but sorted, the next node elt is greater or equal than the current node Elt, example:

```
1 -> 3 -> 6 -> 10
```

to insert an elt, the algorithm is next:
```
insertElt(elt):
    node <- head
    if (head is null):
        head = Node
        headElt <- elt
        end
    while (node is not null):
        if (nodeElt < elt):
            newNode <- Node
            newNodeElt <- elt
            nodeNext <- newNode
            newNodeNext <- nodeNext
            end
        node <- nodeNext
    end
```

## DoublyLinkedList

![](https://www.thecrazyprogrammer.com/wp-content/uploads/2015/09/Doubly-Linked-List-in-C-and-C-.gif)


A doubly linked list is a list composed by a DoublyLinkedNode, this node is composed by 3 objects:
+ an elt
+ a next Node
+ a previous Node

Example:
```
1 <-> 3 <-> 6 <-> 10
```