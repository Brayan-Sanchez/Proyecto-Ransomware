package Encriptacion;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;
import java.util.Arrays;
import java.util.Base64;

public class Encriptacion {
    private final SecretKeySpec secretKey;
    private final IvParameterSpec iv;

    public Encriptacion(String llave) {
        byte[] key = llave.getBytes();
        key = Arrays.copyOf(key, 16); // use only first 128 bit

        this.secretKey = new SecretKeySpec(key, "AES");
        this.iv = new IvParameterSpec(key);
    }

    public void encriptar(String rutaArchivo) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

        Path path = Paths.get(rutaArchivo);
        byte[] fileContent = Files.readAllBytes(path);
        byte[] encrypted = cipher.doFinal(fileContent);

        String encryptedText = Base64.getEncoder().encodeToString(encrypted);
        Files.write(Paths.get(rutaArchivo + ".enc"), encryptedText.getBytes());

        // Ocultar el archivo original
        Path originalPath = Paths.get(rutaArchivo);
        Files.setAttribute(originalPath, "dos:hidden", true, java.nio.file.LinkOption.NOFOLLOW_LINKS);
    }

    public void desencriptar(String rutaArchivo) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);

        byte[] encrypted = Files.readAllBytes(Paths.get(rutaArchivo));
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encrypted));

        Files.write(Paths.get(rutaArchivo.replace(".enc", "")), decrypted);

        // Mostrar el archivo original
        Path originalPath = Paths.get(rutaArchivo.replace(".enc", ""));
        Files.readAttributes(originalPath, DosFileAttributes.class);
        Files.setAttribute(originalPath, "dos:hidden", false, java.nio.file.LinkOption.NOFOLLOW_LINKS);

        // Eliminar el archivo encriptado
        Files.deleteIfExists(Paths.get(rutaArchivo));
    }
}