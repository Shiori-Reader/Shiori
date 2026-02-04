package ui;

import java.io.InputStream;
import java.util.Properties;

public class BuildInfo {
    private static final Properties props = new Properties();

    static {
        try (InputStream is = BuildInfo.class.getResourceAsStream("/build.properties")) {
            if (is != null) {
                props.load(is);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isPreview() {
        return "preview".equalsIgnoreCase(props.getProperty("build.type"));
    }
}