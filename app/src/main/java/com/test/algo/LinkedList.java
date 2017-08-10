package com.test.algo;

/**
 * Created by n3978 on 2017-08-10.
 */

public class LinkedList {

    private LinkedList head;
    private LinkedList tail;
    private int size = 0;

    // 데이터
    private Object data;
    // 다음 노드
    private LinkedList next = null;

    public LinkedList() {
    }

    public LinkedList(Object input) {
        this.data = input;
        this.next = null;
    }

    // 데이터 출력
    public String toString() {
        if(head == null) {
            return "[]";
        }

        LinkedList temp = head;
        String str = "[";

        // 다음 노드가 없을 때 까지 반복문 실행
        // 마지막 노드는 다음 노드가 없기 때문에 마지막 노드 제외
        while(temp.next != null) {
            str += temp.data + ", ";
            temp = temp.next;
        }

        str += temp.data;
        return str + "]";
    }

    // 첫번째 추가
    public void addFirst(Object input) {
        LinkedList newNode = new LinkedList(input);

        newNode.next = head;
        head = newNode;

        size++;
        if(head.next == null) {
            tail = head;
        }
    }

    // 끝에 추가
    public void addLast(Object input) {
        LinkedList newNode = new LinkedList(input);

        if(size == 0) {
            addFirst(input);
        } else {
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    public LinkedList node(int index) {
        LinkedList x = head;
        for(int i=0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    public void add(int k, Object input) {
        if(k == 0) {
            addFirst(input);
        } else {
            // k번째 뒤 노드를 가져옴
            LinkedList temp1 = node(k-1);

            // k번쨰 노드를 temp2로 지정
            LinkedList temp2 = temp1.next;

            // 새로운 노드 생성
            LinkedList newNode = new LinkedList(input);

            // temp1의 다음 노드로 새로운 노드 지정
            temp1.next = newNode;

            // 새로운 노드의 다음 노드로 temp2 지정
            newNode.next = temp2;
            size++;

            // 새로운 노드의 다음 노드가 없으면 새로운 노드가 마지막 노드
            if(newNode.next == null) {
                tail = newNode;
            }

        }

    }

    public Object removeFirst() {
        // 첫번째 노드를 temp 지정, head의 값을 두번째 노드로 변경
        LinkedList temp = head;
        head = head.next;

        // 데이터 삭제전 리턴할 값을 임시 변수에 담는다.
        Object returnData = temp.data;
        temp = null;
        size--;

        return returnData;
    }

    public Object remove(int k) {
        if(k == 0) {
            return removeFirst();
        }

        LinkedList temp = node(k-1);
        LinkedList todoDeleted = temp.next;

        temp.next = temp.next.next;

        Object returnData = todoDeleted.data;
        if(todoDeleted == tail) {
            tail = temp;
        }

        todoDeleted = null;
        size--;
        return returnData;
    }

    public Object removeLast() {
        return remove(size-1);
    }

    public int size() {
        return size;
    }

    public Object get(int k) {
        LinkedList temp = node(k);
        return temp.data;
    }


    // 특정값의 인덱스 확인
    public int indexOf(Object data) {
        // 탐색 대상 노드 지정
        LinkedList temp = head;

        // 탐색 대상은 몇번째인가?
        int index = 0;

        while(temp.data != data) {
            temp = temp.next;
            index++;

            if(temp == null) {
                return -1;
            }
        }
        return index;

    }

    // 반복작업 처리
    public ListIterator listIterator() {
        return new ListIterator();
    }

    class ListIterator {
        private LinkedList next;
        private LinkedList lastReturned;
        private int nextIndex;

        public ListIterator() {
            next = head;
        }
        public Object next() {
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.next;
        }

        public boolean hasNext() {
            return nextIndex < size();
        }

        public void add(Object input) {
            LinkedList newNode = new LinkedList(input);

            if(lastReturned == null) {
                head = newNode;
                newNode.next = next;
            } else {
                lastReturned.next = newNode;
                newNode.next = next;
            }

            lastReturned = newNode;
            nextIndex++;
            size++;
        }

        public void remove() {
            if(nextIndex == 0) {
                throw new IllegalStateException();
            }

            LinkedList.this.remove(nextIndex-1);
            nextIndex--;
        }
    }

    void appendToTail(int d) {
        LinkedList end = new LinkedList(d);
        LinkedList n = this;
        while(n.next != null) {
            n = n.next;
        }
        n.next = end;
    }
}

