package org.launchcode.StudentPickUpManagement.services;

import org.apache.tomcat.util.codec.binary.Base64;
import org.launchcode.StudentPickUpManagement.models.User;
import org.launchcode.StudentPickUpManagement.models.UserModel;
import org.launchcode.StudentPickUpManagement.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public void createUser(UserModel userModel) throws Exception {
        User newUser = builduserentity(userModel);
        userDao.save(newUser);
                    }

    private User builduserentity(UserModel userModel) throws Exception {
        User userEnt = new User();
        userEnt.setFirstname(userModel.getFirstname());
        userEnt.setLastname(userModel.getLastname());
        userEnt.setEmail(userModel.getEmail());
        userEnt.setUsername(userModel.getUsername());
        userEnt.setPassword(getSaltedHash(userModel.getPassword()));
        userEnt.setUserType(userModel.getUserType());
        userEnt.setGrade(userModel.getGrade());
        userEnt.setAccessId(userModel.getAccessId());
        return userEnt;
    }
    private static final int iterations = 2*1;
    private static final int saltLen = 32;
    private static final int desiredKeyLen = 256;

    /** Computes a salted PBKDF2 hash of given plaintext password
     suitable for storing in a database.
     Empty passwords are not supported. */
    private static String getSaltedHash(String password) throws Exception {
        if (password == null || password.length() == 0)
            throw new IllegalArgumentException("Empty passwords are not supported.");
        byte[] salt = SecureRandom.getInstance("SHA1PRNG").generateSeed(saltLen);
        // store the salt with the password
        return Base64.encodeBase64String(salt) + "$" + hash(password, salt);
    }

    /** Checks whether given plaintext password corresponds
     to a stored salted hash of the password. */
    protected static boolean check(String password, String stored) throws Exception{
        String[] saltAndHash = stored.split("\\$");
        if (saltAndHash.length != 2) {
            throw new IllegalStateException(
                    "The stored password must have the form 'salt$hash'");
        }
        String hashOfInput = hash(password, Base64.decodeBase64(saltAndHash[0]));
        return hashOfInput.equals(saltAndHash[1]);
    }

    // using PBKDF2 from Sun, an alternative is https://github.com/wg/scrypt
    // cf. http://www.unlimitednovelty.com/2012/03/dont-use-bcrypt.html
    private static String hash(String password, byte[] salt) throws Exception {
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        SecretKey key = f.generateSecret(new PBEKeySpec(
                password.toCharArray(), salt, iterations, desiredKeyLen));
        return Base64.encodeBase64String(key.getEncoded());
    }}


