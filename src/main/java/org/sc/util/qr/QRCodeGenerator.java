package org.sc.util.qr;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Map;

/**
 * Created by Sc on 9/6/2019.
 */
public class QRCodeGenerator {

    private static final String QR_CODE_IMAGE_PATH = "./MyQRCode.png";

    private static final int QR_WIDTH = 300;

    private static final int QR_HEIGHT = 300;

    private static void generateQRCodeImage(String text, int width, int height, String filePath)
            throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }

    public static BufferedImage generateQRCodeStream(String uuid) {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(uuid, BarcodeFormat.QR_CODE, QR_WIDTH, QR_HEIGHT);
            BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
            return bufferedImage;
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] getQRCodeImageByteArray(String text, int width, int height) {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

            ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
            byte[] pngData = pngOutputStream.toByteArray();
            return pngData;
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

 /*   public static void main(String[] args) {
        try {
            generateQRCodeImage("This is my first QR Code", 350, 350, QR_CODE_IMAGE_PATH);
        } catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }
    }*/

    public static void addQRCache() {
        JedisPool pool = new JedisPool(new JedisPoolConfig(), "10.0.100.235");
        String redisKey = "userId123456";
        String redisField = "qrcode";
        byte[] qrcode = getQRCodeImageByteArray(redisKey, QR_WIDTH, QR_HEIGHT);
        try (Jedis jedis = pool.getResource()) {
            jedis.hset(redisKey.getBytes(), redisField.getBytes(), qrcode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /// ... when closing your application:
        pool.close();
    }

    public static void getQRCache() {
        JedisPool pool = new JedisPool(new JedisPoolConfig(), "10.0.100.235");
        String redisKey = "userId123456";
        String redisField = "qrcode";
        try (Jedis jedis = pool.getResource()) {
            Map<byte[], byte[]> map = jedis.hgetAll(redisKey.getBytes());
            ByteArrayInputStream pngInputStream = new ByteArrayInputStream(map.get(redisField.getBytes()));
            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
            int ch;
            while ((ch = pngInputStream.read()) != -1) {
                swapStream.write(ch);
            }

            File pngFile = new File(QR_CODE_IMAGE_PATH);
            //swapStream.
            FileOutputStream fos2 = new FileOutputStream(pngFile);
            swapStream.writeTo(fos2);
            fos2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        pool.close();
    }

    public static void main(String[] args) {
        //addQRCache();
        //getQRCache();
        String s = "123213";
        byte[] bytes = s.getBytes();
        for (byte byte1 : bytes) {
            System.out.println(byte1);
        }
    }
}
