import java.util.LinkedList;
import java.util.Queue;

public class TreeLeetCodeAmazon {
	class node{
		node right, left;
		int grade, count;
		boolean empty;
		node(node rt, node lt, int gd, int ct){
			right=rt;
			left=lt;
			grade=gd;
			count=ct;
			empty=false;
		}
		node(){
			empty=true;
		}
	}
	
	node head;
	
	void putTree(int val){
		if(head == null){
			System.out.print("null");
			head = new node(null, null, val, 1);
		} else{
			node traverse=head;
			while(true){
				if(traverse.grade == val){
					System.out.print("foundGrade");
					traverse.count++;
					break;
				}else{
					if(traverse.grade>val){
						//left
						System.out.print("left");
						if(traverse.left == null){
							traverse.left = new node(null, null, val, 1);
							break;
						}else{
							traverse = traverse.left; 
						}
					}else{
						//right
						System.out.print("right");
						if(traverse.right == null){
							traverse.right = new node(null, null, val, 1);
							break;
						} else{
							traverse = traverse.right;
						}
					}
				}
			}
		}
	}
	String levelOrder(){
		StringBuilder sbr=new StringBuilder();
		Queue<node> q=new LinkedList();
		q.add(head);
		while(!q.isEmpty()){			
			node tmp=q.remove();
			if(tmp.empty){				
			}else{
			sbr.append(tmp.grade);
			sbr.append(':');
			sbr.append(tmp.count);
			}
			sbr.append(',');
			node lt=tmp.left, rt=tmp.right;
			if(lt==null && rt == null){
				continue;
			}
			if(lt==null){
				lt=new node();
			}
			if(rt == null){
				rt = new node();
			}
			q.add(lt);
			q.add(rt);
		}
		sbr.deleteCharAt(sbr.length()-1);
		return sbr.toString();
	}
	public static void main(String[] args) {
		TreeLeetCodeAmazon ob=new TreeLeetCodeAmazon();
		String s="[4, 2, 5, 5, 6, 1, 4]";
		s=s.substring(1, s.length()-1);
		for(String st:s.split(",")){
			int val=Integer.parseInt(st.trim());
			System.out.print(val+",");
			ob.putTree(val);
		}
		System.out.println();
		System.out.println(ob.levelOrder());
	}

}
