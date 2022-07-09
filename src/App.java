import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;

public class App {
    public static int sisi = 0;
    public static void main(String[] args) throws Exception {
        System.out.println("\nHitung Volume Kubus");
        System.out.println("======================");
        System.out.print("Masukkan panjang sisi\t:\t");
        Scanner keyboard = new Scanner(System.in);

        sisi = keyboard.nextInt();
        ReadnWrite.tulisFile();
        ReadnWrite.bacaFile();

        keyboard.close();
    }
    public class ReadnWrite {
        public static String lokasiFile = "D:\\UPH\\SEM AKSEL\\PBO\\PROGRAM\\21SI1\\21SI1\\README.md";
    
        public static void bacaFile(){
            String data;
            FileReader fin = null;
            try {
                fin = new FileReader(lokasiFile);
                BufferedReader br = new BufferedReader(fin);
                do {
                    data = br.readLine();
                    if(data != null){
                        System.out.println(data);
                    }
                } while (data!=null);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                //TODO: handle exception
            }
            finally{
                if(fin!=null){
                    try {
                        fin.close();
                    } catch (Exception e) {
                        //TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
        public static void tulisFile(){
            String data = "";
            FileWriter fout = null;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                fout = new FileWriter(lokasiFile);
                data = "Volume kubus adalah\t:\t " + hitungVolume(sisi) + " cm^3";
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }finally{
                if(fout != null){
                    try {
                        fout.write(data);
                        fout.close();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
        public static int hitungVolume(int sisi){
            return (int) Math.pow(sisi, 3);
        }
    }
    
}
