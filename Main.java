import java.util.*;
import java.util.Stack;
import java.util.Queue;
import java.lang.reflect.*;

public class Main{
    public static void dijkstra(String exp){
    
        String[] s = exp.split("s");
        Queue<String> q = new LinkedList<String>();
        q.addAll(Arrays.asList(s));
        Stack<String> op = new Stack<String>();
        Stack<Double> val = new Stack<Double>();
       while(!q.isEmpty())
         {
           String ch = q.poll();    
          if(ch.equals("("));
          else if(ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/") || ch.equals("%"))
           op.push(ch);
          else if(ch.equals(")")){
            
                  String o = op.pop();            
                  double v = val.pop();   
                    if(o.equals("+"))
                       v = val.pop() + v;
                  else if (o.equals("-"))
                     v = val.pop() - v;
                    else if (o.equals("*"))
                       v = val.pop() * v;
                   else if (o.equals("/"))
                      v = val.pop() / v;
                   else if (o.equals("%"))
                         v = val.pop() % v;
                  val.push(v);
            }
            else val.push(Double.parseDouble(ch));
                }
        System.out.println("The answer is ; " + val.pop());
    
        }
    
            public static void main(String [] args){
               String exp = "( ( 5 + (3 *8) ) - (2 * 7))" ;
                  System.out.println("The example is : " + exp);
                  
        
              dijkstra(exp);
    }


}