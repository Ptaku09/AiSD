package zadanie1;

import java.util.Arrays;

public class Main {

    static void wyswietl(int[] tab, int i, int roz) {
        if (i >= roz)
            return;
        else {
            System.out.print(tab[i] + " ");
            wyswietl(tab, i + 1, roz);
        }
    }

    static void wyswietl2(int[] tab, int n) {
        if (n == 0) {
            return;
        } else {
            wyswietl2(tab, n - 1);
            System.out.print(tab[n - 1] + " ");
        }
    }


    static int suma(int[] tab, int i, int roz) {
        if (i >= roz - 1)
            return tab[i];
        else {
            return suma(tab, i + 1, roz) + tab[i];
        }
    }

    static int suma2(int[] tab, int n) {
        if (n == 0) {
            return 0;
        } else {
            int s = suma2(tab, n - 1);
            return s + tab[n - 1];
        }
    }

    static int wyszukaj(int[] tab, int pierwszy, int ostatni, int szukana) {
        if (pierwszy > ostatni) {
            return -1;
        } else {
            int srodkowyIndeks = (pierwszy + ostatni) / 2;

            if (szukana == tab[srodkowyIndeks]) {
                return srodkowyIndeks;
            } else if (szukana < tab[srodkowyIndeks]) {
                return wyszukaj(tab, pierwszy, srodkowyIndeks - 1, szukana);
            } else {
                return wyszukaj(tab, srodkowyIndeks + 1, ostatni, szukana);
            }
        }
    }

    public static void main(String[] args) {
        int[] liczby = {32, 12, 123, 43, 25, 756, 84};

        wyswietl(liczby, 0, liczby.length);
        System.out.println();
        System.out.println(suma(liczby, 0, liczby.length));
        System.out.println(suma2(liczby, liczby.length));

        Arrays.sort(liczby);
        wyswietl2(liczby, liczby.length);
        System.out.println();
        System.out.println(wyszukaj(liczby, 0, liczby.length, 756));
    }
}
