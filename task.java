
package q3;

import java.util.*;
public class task {
static Scanner in;
public static void main(String[] args) {
in = new Scanner(System.in);
System.out.println("Enter the Names of Player :");
System.out.println("Enter Player 1 Name :");
String A = in.next();
System.out.println("Enter Player 2 Name :");
String B = in.next();
chessbrd ob = new chessbrd(A,B);
LetsPlay(A,B);
}
public static void LetsPlay(String A,String B)
{
	chessbrd ob = new chessbrd(A,B);
System.out.println("Enter the Pawn's of A ");
ob.get_pawn_A();
System.out.println("Enter the Pawn's of B ");
ob.get_Pawn_B();
// ob.display();
boolean AMove =false;
while(ob.position_A.size()!=0 && ob.position_B.size()!=0)
{
boolean isPossible=false;
System.out.println("Current Grid");
ob.display();
while(!isPossible)
{
if(AMove)
{
System.out.println("Player A's Move : ");
String move =in.next();
isPossible=ob.Amove(move);
if(!isPossible)
{
continue;
}
AMove =!AMove;
}
else
{
System.out.println("Player B's Move : ");
String move =in.next();
isPossible=ob.Bmove(move);
if(!isPossible)
{
continue;
}
AMove =!AMove;
}
if(ob.position_A.size()==0)
{
System.out.println("Congrats "+ob.D+" Won!!");
System.out.println("Press 1 To Play Again!!");
int choice =in.nextInt();
if(choice==1)
{
LetsPlay(A,B);
}
}
if(ob.position_B.size()==0)
{
System.out.println("Congrats "+ob.C+" Won!!");
System.out.println("Press 1 To Play Again!!");
int choice =in.nextInt();
if(choice==1)
{
LetsPlay(A,B);
}
}
}
}
}
}
