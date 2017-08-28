package bishi.sohu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int a, b, c, d, e, f, t;
        int packets;

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            a = in.nextInt();
            b = in.nextInt();
            c = in.nextInt();
            d = in.nextInt();
            e = in.nextInt();
            f = in.nextInt();
            while (a != 0 || b != 0 || c != 0 || d != 0 || e != 0 || f != 0)

            {
                packets = f;
                packets += e;
                a -= 11 * e;
                packets += d;
                if (b >= 5 * d) {
                    b -= 5 * d;
                } else {
                    t = 5 * d - b;
                    b = 0;
                    a -= 4 * t;
                }
                packets += c / 4;
                t = c % 4;
                if (t != 0) {
                    packets += 1;
                    if (t == 1) {
                        if (b >= 5) {
                            b -= 5;
                            a -= 7;
                        } else if (b >= 0) {
                            a -= (36 - 9 - 4 * b);
                            b = 0;
                        }
                    } else if (t == 2) {
                        if (b >= 3) {
                            b -= 3;
                            a -= 6;
                        } else if (b >= 0) {
                            a -= (36 - 18 - 4 * b);
                            b = 0;
                        }
                    } else if (t == 3) {
                        if (b >= 1) {
                            b -= 1;
                            a -= 5;
                        } else if (b >= 0) {
                            a -= (36 - 27 - 4 * b);
                            b = 0;
                        }
                    }
                }
                if (b > 0) {
                    packets += b / 9;
                    t = b % 9;
                    if (t != 0) {
                        packets += 1;
                        a -= 36 - 4 * t;
                    }
                }
                if (a > 0) {
                    packets += a / 36;
                    t = a % 36;
                    if (t != 0) {
                        packets += 1;
                    }
                }
                System.out.println(packets);
                if(!in.hasNext()) break;
                a = in.nextInt();
                b = in.nextInt();
                c = in.nextInt();
                d = in.nextInt();
                e = in.nextInt();
                f = in.nextInt();
            }
        }
    }
    }
