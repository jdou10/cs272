import jdk.nashorn.internal.ir.IndexNode;

public class Student {

    public int sno;
    public String sname;

    public Student(){
        sno=0;
        this.sname=null;
    }

    public Student(int _sno,String _name) {
        sno = _sno;
        sname = _name;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno){
        this.sno=sno;
    }

}

//5 125 32
//1000 1024
//1000 1000
//
//O(2^n)
//O(n^2)
//O(n^2)
//n*(1+n)/2
//n/2+n*n/2
//O(n^2)

//n=1


//O(n)


class IntArraySet{
    private int num;//数组中的元素个数
    private int[] data;//长度为16
    public IntArraySet(){
        num=0;
        data=new int[2];
    }
    public IntArraySet(int size){
        if(size>0){
            num=0;
            data=new int[size];
        }
    }

    public void addNoDuplicate(int element){
        for(int i=0;i<num;++i){
            if(data[i]==element){
                return;
            }
        }
        if(data.length==num){
            //store previous
            int[] new_data=new int[data.length];
            for(int i=0;i<num;++i){
                new_data[i]=data[i];
            }
            //
            data=new int[num*2];
            for(int i=0;i<num;++i){
                data[i]=new_data[i];
            }
        }
        data[num]=element;
        num++;
    }

    public boolean equals(Object o){
        if(o==null){
            return false;
        }
        //true
        //!true=false
        if(!(o instanceof IntArraySet)){
            return false;
        }
        IntArraySet bag=(IntArraySet)o;

        //this:[1 2 3 4]
        //bag[1 2]
        if(num!=bag.num){
            return false;
        }

        for(int i=0;i<bag.num;++i){
            if(data[i]!=bag.data[i]){
                return false;
            }
        }
        return true;

    }
    //this.equals(o)
    //1 2 3 4


    //
    //addNoDuplicate(1)
      //  addNoDuplicate(2)
    //1 2
    //addNoDuplicate(2)
    //1 2


}



class IntNode{
    private int data;
    private IntNode link;
    public IntNode(){
        data=10;
        link=null;
    }
    public IntNode(int _data,IntNode _link){
        data=_data;
        link=_link;
    }

    public void setData(int val){
        this.data=val;
    }
    public void addNodeAfter(int item){
        link=new IntNode(item,link);
    }
    //1->2->3->4->5
    //this.removeNodeAfter(2)
    public void removeNodeAfter(int e){
        IntNode node=this;
        while(node!=null){
            if(node.link!=null){
                if(node.link.data==e){
                    node.link=node.link.link;
                    break;
                }
            }
            node=node.link;
        }
    }
    public IntNode getLink(){
        return link;
    }
    public void setLink(IntNode node){
        this.link=node;
    }

    //1->2->3
    //item=2

    public void f3(int item){
        IntNode newnode=new IntNode();
        newnode.setData(item);
        IntNode preCursor=null;
        IntNode cursor=this;
        while(cursor!=null){
            preCursor=cursor;
            cursor=cursor.getLink();
        }
        preCursor.setLink(newnode);

    }
    //1->7->8->3->1->2

    //1
    //1->2
    //1->4->2
    //1->4->4->2
    //4->4->2

    //O(n)
}

//1->2->3
//the number of nodes
//O(N)

//num1=12
//8
//head.f2()=1.5


//


class DNode{
    public int data;
    public DNode next=null;
    public DNode prev=null;
    public DNode(){

    }

}
class DoublyLinkedListDummy{

    public DNode head;
    public DNode tail;

    public DoublyLinkedListDummy(){
        head=new DNode();
        tail=new DNode();
        head.next=tail;
        tail.prev=head;
    }

    public DNode getHead(){
        if(head.next==tail){
            return null;
        }
        return head.next;
    }

    public int listLength(){
        DNode node=head.next;
        int count=0;
        while(node!=tail){
            count++;
            node=node.next;
        }
        return count;
    }

    public void func(int element){
        DNode newnode=new DNode();
        newnode.data=element;
        newnode.prev=tail.prev;
        newnode.next=tail;
        tail.prev.next=newnode;
        tail.prev=newnode;
    }

}


class Computer{
    public String id;
    private String cpu_model;
    private int size;
    public Computer next;


};


class ComputerList{

    private Computer head;
    //每次添加都将其添加到链表头部
    public void add(Computer computer){
        computer.next=head;
        head=computer;
    }

    //查找遍历整个链表
    public void search(String id){
        Computer computer=head;
        while(computer!=null){
            if(computer.id==id){
                //finded
                return;
            }
            computer=computer.next;
        }
    }
}

//add


//添加到链表的头部
//


//search total linked list