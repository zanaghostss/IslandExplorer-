import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner=new Scanner(System.in);

        System.out.println("enter row and columns + rows  + column ");
        int row=scanner.nextInt();
        int cilumns=scanner.nextInt();

        int array[][]=new int[row][cilumns];

        System.out.println("enter the elemnts of array");

        for (int i = 0; i < row; i++) {
            for (int j = 0; j <cilumns ; j++) {
                array[i][j]=scanner.nextInt();
            }
        }

        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <cilumns ; j++) {
                if (array[i][j]%2==0){
                    array[i][j]=0;
                }
                else {
                    array[i][j]=1;
                }
            }
        }
        System.out.println("enter the locations");
        int is=scanner.nextInt();
        int js=scanner.nextInt();

        int ie=scanner.nextInt();
        int je=scanner.nextInt();


        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <cilumns ; j++) {
                System.out.print(array[i][j]+"\t");
            }
            System.out.println();
        }
        // 0 0
        // 1 1

        int a2 [][]=new int[ie-is+1][je-js+1];


        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <cilumns ; j++) {
                if (i>=is-1&j>=js-1&i<=ie-1&j<=je-1){
                    int Is=is-1;
                    int Js=js-1;
                    if(Is<0){
                        Is=0;
                    }
                    if(Js<0){
                        Js=0;
                    }
                    a2[i-Is][j-Js]=array[i][j];
                }
            }
        }
        System.out.println();

        for (int i = 0; i <ie-is+1 ; i++) {
            for (int j = 0; j <je-js+1 ; j++) {
                System.out.print(a2[i][j]+"\t");
            }
            System.out.println();
        }

        int row1=a2.length;
        int col1=a2[0].length;

        //int island=0;
        boolean vistes[][]=new boolean[row1][col1];
        int save[][]=new int[row1][col1];
        int roe9[]=new int[row1];
        int col9[]=new int[col1];

        dfs(a2,is-1,js-1,vistes,save,roe9,col9);



        }




    public static void dfs(int [][]matrix,int stratrow,int startcol,boolean[][]visted,int [][] save,int [] roww,int [] colmm){

        int rows=matrix.length;
        int col=matrix[0].length;

        if (stratrow<0||stratrow>=rows||startcol<0||startcol>=col||matrix[stratrow][startcol]==0) {
            System.out.println("masir namonaseb");
            return;
        }//basecase1

        if (visted[stratrow][startcol]){
            return;
        }//basecase2
        int c=0;

        int c9=0;

        if (stratrow == roww[0] + 1){
            System.out.print("Down");
            c9++;

        }
        if (stratrow==roww[0]-1){
            System.out.println("UP");
            c9++;
        }
        if (startcol==colmm[0]+1){
            System.out.println("Right");
            c9++;
        }
        if (startcol==colmm[0]-1){
            System.out.println("Left");
            c9++;
        }
        if (c9==0){
            System.out.println("masir namonaseb");
            return;
        }//basecase3


        visted[stratrow][startcol]=true;
        System.out.println("visted");
        roww[0]=stratrow;
        colmm[0]=startcol;
        save[stratrow][startcol]=stratrow+1+startcol+1;


        dfs(matrix,stratrow-1,startcol,visted,save,roww,colmm);//up
        dfs(matrix,stratrow+1,startcol,visted,save,roww,colmm);//down
        dfs(matrix,stratrow,startcol-1,visted,save,roww,colmm);//left
        dfs(matrix,stratrow,startcol+1,visted,save,roww,colmm);//right

    }

}