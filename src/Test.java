public class Test {

    int x = 2;
    double y = 17;


    int mx = 3;
    int my = 2;
    int radius = 3;

    double ergebnis = Math.sqrt(Math.pow((mx - x),2) + Math.pow((my- y),2));
    double ergebni2 = Math.sqrt(Math.pow((x - mx),2) + Math.pow((y- my),2));
    int zwischenergebnis = ((x * x) - (mx * mx));
   // int zwischenergebnis2 = ((y * y) - (my * my));
    public static void main(String[] args){
        Test test = new Test();
        test.test();

    }

    //    if((posX - enemyPosX)*2 + (posY - enemyPosY)*2 < range){

    public void test(){
    if(ergebnis <= radius){
        System.out.println("pog " + ergebnis);
        System.out.println("pog2 " +ergebni2);
    }else{
        System.out.println("nope " + ergebnis);
        System.out.println("nope " + ergebni2);
    }
       }
    }

