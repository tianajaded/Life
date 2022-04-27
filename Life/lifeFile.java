package Life;

import java.io.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class lifeFile implements Serializable {
    JFileChooser jfc;
    JButton jfcB;
    lifeBoard lifeBoard;
    static int[][][] grid;
    lifeGen lifeGen;
    private int currentgen;

    static void write() {
        try {
            FileOutputStream fos = new FileOutputStream("filename.txt");
            ObjectOutputStream out = new ObjectOutputStream(fos);
            int[][][] grid = {
                    { { 2, 3 }, // Shape a
                            { 3, 3 } },
                    { { 2, 12 }, // Shape b
                            { 2, 13 },
                            { 3, 12 },
                            { 3, 13 } },
                    { { 7, 6 }, // Shape c
                            { 7, 7 },
                            { 8, 5 },
                            { 8, 8 },
                            { 9, 6 },
                            { 9, 7 } },
                    { { 12, 12 }, // Shape d
                            { 12, 13 },
                            { 12, 14 },
                            { 8, 8 },
                            { 9, 6 },
                            { 9, 7 } },
                    { { 14, 5 }, // Shape e
                            { 15, 3 },
                            { 15, 5 },
                            { 16, 4 },
                            { 16, 5 } } };

            out.writeObject(grid);
            out.flush();
            out.close();

        } catch (Exception e) {
            System.out.println("an error occured");
        }
    }

    static int[][][] Read() {
        try {

            FileInputStream fis = new FileInputStream("fileName.txt");
            ObjectInputStream in = new ObjectInputStream(fis);
            int[][][] board = (int[][][]) in.readObject();

            in.close();
            fis.close();
            for (int[][] i : board) {
                System.out.println(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return grid;
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
            return grid;
        }
        return grid;

    }

}
