package com.test.algo;

import java.util.Objects;

/**
 * Created by JUN on 2017-08-01.
 */

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

    private class Node {
        private Object data;
        private Node next;
        private Node prev;

        private Node(Object input) {
            this.data = input;
            this.next = null;
            this.prev = null;
        }

        public String toString() {
            return String.valueOf(this.data);
        }
    }

    // 시작 위치에 추가
    public void addFirst(Object input) {
        // 새로운 노드 생성
        Node newNode = new Node(input);

        // 새로운 노드의 다음 노드로 헤드 지정
        newNode.next = head;

        // 기존에 노드가 있다면 현재 헤드의 이전 노드로 새로운 노드 지정
        if(head != null) {
            head.prev = newNode;
        }

        head = newNode;
        size++;

        if(head.next == null) {
            tail = head;
        }
    }

    // 끝에 추가
    public void addLast(Object input) {
        // 새로운 노드 생성
        Node newNode = new Node(input);

        if(size == 0) {
            addFirst(input);
        } else {
            // tail의 다음 노드로 생성한 노드를 지정합니다.
            tail.next = newNode;
            // 새로운 노드의 이전 노드로 tail을 지정합니다.
            newNode.prev = tail;
            // 마지막 노드를 갱신합니다.
            tail = newNode;
            // 엘리먼트의 개수를 1 증가 시킵니다.
            size++;
        }
    }

    /**
     *  해당 Index 노드 찾기
     * @param index
     * @return
     */
    private Node node(int index) {
        // 노드의 인덱스가 전체 노드 수의 반보다 큰지 작은지 계산
        if(index < size / 2) {
            // head 부터 next를 통해 찾는다.
            Node findNode = head;
            for(int i=0; i < index; i++) {
                findNode = findNode.next;
            }
            return findNode;
        } else {
            // tail 부터 찾는다.
            Node findNode = tail;
            for(int i = size-1; i > index; i--) {
                findNode = findNode.prev;
            }
            return findNode;
        }
    }

    /**
     * 노드 원하는 위치 추가
     * @param k
     * @param input
     */
    public void add(int k, Object input) {
        if(k == 0) {
            addFirst(input);
        } else {
            Node temp1 = node(k-1);
            Node temp2 = temp1.next;

            Node newNode = new Node(input);

            // temp1 의 다음 노드로 새로운 노드 지정
            temp1.next = newNode;
            // 새로운 노드의 다음 노드로 temp2 지정
            newNode.next = temp2;

            // temp2의 이전 노드로 새로운 노드 지정
            if(temp2 != null) {
                temp2.prev = newNode;
            }

            // 새로운 노드의 이전 노드로 temp1 지정
            newNode.prev = temp1;
            size++;

            // 새로운 노드의 다음 노드가 없으면 새로운 노드가 마지막 노드이기 때문에 tail
            if(newNode.next == null) {
                tail = newNode;
            }
        }
    }

    public String toString() {
        if(head == null) {
            return "[]";
        }

        Node temp = head;
        String str = "[";

        while(temp.next != null) {
            str += temp.data + ", ";
            temp = temp.next;
        }

        str += temp.data;
        return str + "]";
    }

    /**
     * 처음 노드 삭제
     * @return
     */
    public Object removeFirst() {
        Node temp = head;
        head = head.next;

        Object returnData = temp.data;
        temp = null;

        if(head != null) {
            head.prev = null;
        }
        size--;
        return returnData;
    }

    /**
     * 특정 위치 노드 삭제
     * @param k
     * @return
     */
    public Object remove(int k) {
        // k-1 번째 노드를 temp로 지정
        Node temp = node(k-1);

        // temp.next를 삭제하기 전에 todoDeleted 에 보관
        Node todoDeleted = temp.next;
        // 삭제 대상 노드를 연결해서 분리
        temp.next = temp.next.next;
        if(temp.next != null) {
            // 삭제할 노드의 전후 노드 연결
            temp.next.prev = temp;
        }

        // 삭제할 노드의 데이터 리턴하기 위해 저장
        Object returnData = todoDeleted.data;
        // 삭제할 노드가 tail이었다면 tail을 이전 노드로 지정정
       if(todoDeleted == tail) {
            tail = temp;
        }

        todoDeleted = null;
        size--;
        return returnData;
    }

    /**
     * 마지막 노드 삭제
     * @return
     */
    public Object removeLast() {
        return remove(size-1);
    }

    /**
     * 인덱스로 데이터 가져오기
     * @param k
     * @return
     */
    public Object get(int k) {
        Node temp = node(k);
        return temp.data;
    }

    /**
     * 특정 데이터가 저장된 인덱스 알아내기
     * @param data
     * @return
     */
    public int indexOf(Object data) {
        // 탐색 대상 노드 temp 지정
        Node temp = head;
        int index = 0;

        while(temp.data != data) {
            temp = temp.next;
            index++;

            // temp null이면 탐색 대상이 없다.
            if(temp == null) {
                return -1;
            }
        }
        return index;
    }

    public int size() {
        return size;
    }

    public class ListIterator {
        public ListIterator listIterator() {
            return new ListIterator();
        }

        private Node next;
        private Node lastReturned;
        private int nextIndex;

        ListIterator() {
            next = head;
            nextIndex = 0;
        }

        public Object next() {
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.data;
        }

        public Object previous() {
            if(next == null) {
                lastReturned = next= tail;
            } else {
                lastReturned = next = next.prev;
            }
            nextIndex--;
            return lastReturned.data;
        }

        public boolean hasNext() {
            return nextIndex < size();
        }

        public int hasPrevious() {
            return nextIndex;
        }

        public void add(Object input) {
            Node newNode = new Node(input);

            if(lastReturned == null) {
                head = newNode;
                newNode.next = next;
            } else {
                lastReturned.next = newNode;
                newNode.prev = lastReturned;
                if(next != null) {
                    newNode.next = next;
                    next.prev = newNode;
                } else {
                    tail = newNode;
                }
            }
            lastReturned = newNode;
            nextIndex++;
            size++;
        }


        public void remove() {
            if(nextIndex == 0) {
                throw new IllegalStateException();
            }

            Node n = lastReturned.next;
            Node p = lastReturned.prev;

            if(p == null) {
                head = n;
                head.prev = null;
                lastReturned = null;
            } else {
                p.next = next;
                lastReturned.prev = null;
            }

            if(n == null) {
                tail = p;
                tail.next = null;
            } else {
                n.prev = p;
            }

            if (next == null) {
                lastReturned = tail;
            } else {
                lastReturned = next.prev;
            }

            lastReturned = next.prev;


            size--;
            nextIndex--;
        }
    }
}
