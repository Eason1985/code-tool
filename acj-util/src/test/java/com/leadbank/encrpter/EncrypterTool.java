package com.leadbank.encrpter;
import java.io.IOException;
import java.util.Scanner;

import com.acjkj.util.Encrypter;

/**
 * 
 * @author jia.chen
 *
 */
public class EncrypterTool {

    /**
     * <pre>
     *
     * </pre>
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        while (true) {

            encrypter();
        }

    }

    public static void encrypter() {

        System.out.print("请输入要加密的字符串:");

        Scanner sc = new Scanner(System.in);

        String encrypterString = sc.nextLine();

        if (encrypterString != null && !"".equals(encrypterString.trim())) {

            if ("exit".equals(encrypterString.trim().toLowerCase())) {

                System.exit(0);

            } else {

                System.out.println("加密的字串:" + Encrypter.encrypt(encrypterString.trim()));

            }

        } else {

            System.out.println("输入的字串为空，请重新输入");
        }

    }

}
