package com.example.todolist;

/*
Helps save the data to a certain file
 */


import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileHelper {

    public static final String FILENAME = "listinfo.dat";

    /*

Create a method to write the data to this file

*/

    public static void writeData(ArrayList<String> items, Context context) {

        try {
            FileOutputStream fos = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(items);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   /*

   Create method to read the data

    */


    public static ArrayList<String> readData(Context context) {
        ArrayList<String> itemsList = null;
        try {
            FileInputStream fis = context.openFileInput(FILENAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            itemsList = (ArrayList<String>) ois.readObject();
        } catch (FileNotFoundException e) {

            /*
            If there is nothing in the items list, a new items list is created
             */

            itemsList = new ArrayList<>();
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

       /*

       Returns items back to main activity to populate the list

        */
        return itemsList;
    }


}
