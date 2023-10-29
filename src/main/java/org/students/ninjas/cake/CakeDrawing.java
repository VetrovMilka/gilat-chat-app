package org.students.ninjas.cake;

//Do with triangle algorithm
public class CakeDrawing {
        public static void main(String[] args) {
            int width = 10;
            int height = 2;
            drawCakeWithCandles(width, height);
            System.out.println("\uD83C\uDF82");
        }

        public static void drawCakeWithCandles(int width, int height) {

            for (int i = 0; i < height; i++){
                System.out.print("\t  ");
            }
            for (int i = 0; i < width/2; i++) {
                System.out.print("i");
            }
            System.out.println();

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < height-i; j++){
                    System.out.print("\t");
                }
                for (int j = 0; j < width; j++) {
                    System.out.print("0");
                }
                width+=8;
                System.out.println();
            }
        }
    }
