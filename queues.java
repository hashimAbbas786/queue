/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication90;

class Queue {
    int front = -1;
    int rear = -1;
    int size;
    int[] arr;
    Queue(int size) {
        this.size = size;
        this.arr = new int[this.size];
    }
    public void enqueue(int item) {
        
        if((this.rear == this.size - 1 && this.front == 0) || this.rear == this.front - 1) {
            try {
                throw new Exception("Overflow");
            } catch(Exception e) {
                System.out.println(e);
            }
            return;
        }
        if(this.rear == -1 && this.front == -1) {
            this.front = 0;
        }
        if((this.rear == this.size - 1) && this.front != 0) {
            this.rear = 0;
            this.arr[this.rear] = item;
        } else {
            this.rear = this.rear + 1;
            this.arr[this.rear] = item;
        }
        
    }
    
    public void dequeue() {
        if(this.rear == -1 && this.front == -1) {
            System.out.println("Underflow");
            return;
        }
        if(this.front == this.rear) {
            this.rear = -1;
            this.front = -1;
            return;
        }
        if(this.front == this.size - 1) {
            this.front = 0;
        } else {
            this.front++;
        }
    }
    public boolean isFull() {
        boolean flag = false;
        if(this.rear == 0 && this.front == this.size - 1) {
            flag = true;
        } else if(this.rear == this.front - 1) {
            flag = true;
        }
        return flag;
    }
    public boolean isEmpty() {
        boolean flag = false;
        if(this.rear == -1 && this.front == -1) {
            flag = true;
        }
        return flag;
    }
    public int peek() {
        return this.arr[this.rear];
    }
}

public class JavaApplication90 {

    public static void main(String[] args) {

        Queue queue = new Queue(4);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.isFull();
        try {
            for(int i = 0; i < queue.size; i++) {
                System.out.println(queue.arr[i]);
            }
        } catch(Exception e) {
            
        }
    }
    
}
