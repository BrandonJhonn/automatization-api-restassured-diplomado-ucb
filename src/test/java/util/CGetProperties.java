package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CGetProperties {

    private static CGetProperties instance = null;

    private String pStrHost;
    private String pStrUser;
    private String pStrPwd;

    public String getpStrHost() {
        return pStrHost;
    }

    public void setpStrHost(String pStrHost) {
        this.pStrHost = pStrHost;
    }

    public String getpStrUser() {
        return pStrUser;
    }

    public void setpStrUser(String pStrUser) {
        this.pStrUser = pStrUser;
    }

    public String getpStrPwd() {
        return pStrPwd;
    }

    public void setpStrPwd(String pStrPwd) {
        this.pStrPwd = pStrPwd;
    }

    private CGetProperties() {

        Properties properties = new Properties();
        String vStrNameFile = "todo.properties";

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(vStrNameFile);

        if (inputStream != null) {
            try {
                properties.load(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        pStrHost = properties.getProperty("host");
        pStrUser = properties.getProperty("user");
        pStrPwd = properties.getProperty("pwd");
    }

    public static CGetProperties getInstance() {
        if (instance == null)
            instance = new CGetProperties();
        return instance;
    }
}
