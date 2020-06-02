package interview.sparearray;

/**
 * 实现稀疏数组
 *
 * 用于解决二维数组空间大的问题
 * 并和 二维数组 互相转换
 */
public class SparseArray {
    public static void main(String[] args) {
        /**
         * 首先实现一个二维数组 11 * 11
         * 0 表示 没有子，1 表示黑子，2 表示蓝子
         */
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;
        /**
         * 输出原始的 二维数组
         */
        System.out.println("=========原始的二维数组==========");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        /**
         * 将二维数组 转为 稀疏数组
         * 遍历二维数组 得到非 0 数据的个数
         */
        int sum = 0;
        for (int i= 0;i < 11;i ++){
            for (int j = 0;j < 11 ; j ++){
                if (chessArr1[i][j] != 0) {
                    sum ++;
                }
            }
        }
        System.out.println("====二维数组 非零个数为 " + sum);
        /**
         * 创建 对应的 稀疏数组
         */
        int sparseArr[][] = new int[sum + 1][3];
        //为稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //继续赋值
        int count = 0;
        //遍历二维数组 将不为零的数字 存放到 稀疏数组
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (chessArr1[i][j] != 0) {
                    count ++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        System.out.println();
        System.out.println("=======一下为稀疏数组============");
        for (int i = 0; i < sparseArr.length; i++) {
            //稀疏数组所在行的 第一 第二 第三
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
            System.out.println();
        }

        //将稀疏数组 转换为 二维数组
        // 1. 首先要知道多少行 多少列
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        //从第二行开始遍历
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        System.out.println("=========恢复 二维数组===============");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
