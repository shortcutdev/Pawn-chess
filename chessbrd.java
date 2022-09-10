package q3;
import java.util.*;
public class chessbrd {
String C,D;
String board[][];
Scanner sc;
Map<String,ArrayList<Integer>>position_A;
Map<String,ArrayList<Integer>>position_B;
chessbrd(String C,String D)
{
this.C=C;
this.D=D;
board = new String[5][5];
position_A = new HashMap<>();
position_B = new HashMap<>();
for(String []value:board)
{
Arrays.fill(value,"-");
}
}
public void get_pawn_A()
{
sc = new Scanner(System.in);
for(int i=0;i<5;i++)
{
board[4][i] ="A"+"-"+sc.next();
}
for(int i=0;i<5;i++)
{
ArrayList<Integer>coordinates = new ArrayList<>();
coordinates.add(4);
coordinates.add(i);
position_A.put(board[4][i],coordinates);
}
// System.out.println(posA);
}
public void get_Pawn_B()
{
sc = new Scanner(System.in);
for(int i=0;i<5;i++)
{
board[0][i] ="B"+"-"+sc.next();
}
for(int i=0;i<5;i++)
{
ArrayList<Integer>cood = new ArrayList<>();
cood.add(0);
cood.add(i);
position_B.put(board[0][i],cood);
}
}
public boolean Amove(String play)
{
int indexColon = play.indexOf(':');
String entry = play.substring(0,indexColon);
entry = "A-"+entry;
char move =Character.toUpperCase(play.charAt(indexColon+1));
// System.out.println(move);
if(!position_A.containsKey(entry))
{
System.out.println("Invalid Pawn Selected!!\n Try Again");
return false;
}
ArrayList<Integer> coordinates = position_A.get(entry);
int x =coordinates.get(0);
int y=coordinates.get(1);
int updateX =x;
int updateY=y;
if(move=='F')
{
updateX--;
}
else if(move=='B')
{
updateX++;
}
else if(move=='L')
{
updateY--;
}
else if(move=='R')
{
updateY++;
}
else
{
System.out.println("Innvalid Move!!\nPlease Enter Again:");
return false;
}
if(updateX>=5 || updateX<0 || updateY>=5||updateY<0)
{
System.out.println("Innvalid Move!!\nPlease Enter Again:");
return false;
}
String current_position = board[x][y];
String updated_position = board[updateX][updateY];
if(updated_position.charAt(0)=='A')
{
System.out.println("Innvalid Move!!\nPlease Enter Again:");
return false;
}
if(updated_position.equals("-"))
{
board[updateX][updateY] = entry;
board[x][y]="-";
coordinates.set(0,updateX);
coordinates.set(1,updateY);
position_A.put(entry,coordinates);
// return true;
}
else if(updated_position.charAt(0)=='B')
{
position_B.remove(updated_position);
System.out.println(board[updateX][updateY]+" got attacked!!");
board[updateX][updateY] = entry;
board[x][y]="-";
coordinates.set(0,updateX);
coordinates.set(1,updateY);
position_A.put(entry,coordinates);
}
return true;
}
public boolean Bmove(String playerMove)
{
int indexColon = playerMove.indexOf(':');
String entry = playerMove.substring(0,indexColon);
entry = "B-"+entry;
char move =Character.toUpperCase(playerMove.charAt(indexColon+1));
if(!position_B.containsKey(entry))
{
System.out.println("Invalid Pawn Selected!!\n Try Again");
return false;
}
ArrayList<Integer> coordinates = position_B.get(entry);
int x =coordinates.get(0);
int y=coordinates.get(1);
int updateX =x;
int updateY=y;
if(move=='F')
{
updateX++;
}
else if(move=='B')
{
updateX--;
}
else if(move=='L')
{
updateY--;
}
else if(move=='R')
{
updateY++;
}
else
{
System.out.println("Invalid Move1!!\nPlease Enter Again:");
return false;
}
System.out.println(updateX+" "+updateY);
if(updateX>=5 || updateX<0 || updateY>=5||updateY<0)
{
System.out.println("Innvalid Move2!!\nPlease Enter Again:");
return false;
}
String currentPosition = board[x][y];
String updatedPosition = board[updateX][updateY];
if(updatedPosition.charAt(0)=='B')
{
System.out.println("Invalid Move3!!\nPlease Enter Again:");
return false;
}
if(updatedPosition.equals("-"))
{
board[updateX][updateY] = entry;
board[x][y]="-";
coordinates.set(0,updateX);
coordinates.set(1,updateY);
position_B.put(entry,coordinates);
// return true;
}
else if(updatedPosition.charAt(0)=='A')
{
position_A.remove(updatedPosition);
System.out.println(board[updateX][updateY]+" got attacked!!");
board[updateX][updateY] = entry;
board[x][y]="-";
coordinates.set(0,updateX);
coordinates.set(1,updateY);
position_A.put(entry,coordinates);
// return true;
}
return true;
}
public void display()
{
for(int i=0;i<5;i++)
{
for(int j=0;j<5;j++)
{
System.out.print(board[i][j]+"\t\t");
}
System.out.println();
}
}
}
