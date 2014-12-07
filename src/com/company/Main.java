package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        Acount a = new Acount("Jan","Kowalski");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        /*
         * Zapis do strumienia (plikowego, ale może być dowolne)
         */
        try {
            fos= new FileOutputStream("test.s"); //utworzenie strumienia wyjściowego
            oos = new ObjectOutputStream(fos);  //utworzenie obiektu zapisującego do strumienia

            oos.writeObject(a); //serializacja obiektu

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally { // zamykamy strumienie w finally
            try {
                if (oos != null) oos.close();
            } catch (IOException e) {}
            try {
                if (fos != null) fos.close();
            } catch (IOException e) {}
        }

        Acount b = null;
        /*
         * Odczyt ze strumienia plikowego (ale może być dowolne)
         */
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("test.s"); //utworzenie strumienia wejściowego
            ois = new ObjectInputStream(fis); //utworzenie obiektu odczytującego obiekty ze strumienia

            b = (Acount) ois.readObject(); //deserializacja obiektu

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally { // zasoby zwalniamy w finally
            try {
                if (ois != null) ois.close();
            } catch (IOException e) {}
            try {
                if (fis != null) fis.close();
            } catch (IOException e) {}
        }
    }
}
