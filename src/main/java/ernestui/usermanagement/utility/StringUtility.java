package ernestui.usermanagement.utility;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.UUID;

import static java.lang.Long.parseLong;

@Service
public class StringUtility {

    public String generateRandomId() {
        return (randomStr() + randomStr()).replace("-","");
    }

    public String strUpperCase(String str){
        return str == null ? null : str.toUpperCase(Locale.ROOT);

    }

    public String strLowerCase(String str){
        return str == null ? null : str.toLowerCase(Locale.ROOT);
    }

    public String padding(String str, int len, char charx, String type){
        return strUpperCase(type).equalsIgnoreCase("left") ? StringUtils.leftPad(str, len,charx) : StringUtils.rightPad(str, len,charx);
    }

    public String randomChars() {
        return RandomStringUtils.randomNumeric(3);
    }

    public String substr(Object str, int start, int end) {
        return StringUtils.substring(str.toString(), start, end);
    }

    public String randomStr(){
        return UUID.randomUUID().toString();
    }

    public String randomString(){
        return UUID.randomUUID().toString().replace("-","");
    }

    public String generateId(String prefix) {
        return  (prefix + Long.toHexString(System.currentTimeMillis() + parseLong("1" + RandomStringUtils.randomNumeric(16)))).toUpperCase();
    }

    public String generateId() {
        return  ("FB" + Long.toHexString(System.currentTimeMillis() + parseLong("1" + RandomStringUtils.randomNumeric(16)))).toUpperCase();
    }

    public String generateReference() {
        return  (Long.toHexString(System.currentTimeMillis() + parseLong("1" + RandomStringUtils.randomNumeric(16)))).toUpperCase();
    }

    public String hashString(String content){
        return hashString("MD5", content);
    }

    public String hashString(String hash, String content){
        String encrypted = "";
       switch (strUpperCase(hash)){
           case "MD5":
               encrypted = DigestUtils.md5Hex(content);
               break;
           case "SHA128":
               encrypted = DigestUtils.sha1Hex(content);
               break;
           case "SHA256":
               encrypted = DigestUtils.sha256Hex(content);
               break;
           case "SHA512":
               encrypted = DigestUtils.sha512Hex(content);
               break;
           default:
               encrypted = DigestUtils.md5Hex(content);
               break;
       }
       return encrypted;
    }

    public String generateRandomNumber(int size) {
        return RandomStringUtils.randomNumeric(size);
    }
}
