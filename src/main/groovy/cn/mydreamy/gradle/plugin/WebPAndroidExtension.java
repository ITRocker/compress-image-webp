package cn.mydreamy.gradle.plugin;

/**
 * @author yangzhao
 */

public class WebPAndroidExtension {
    private boolean useOriPng = false;
    private int quality = 75;
    private String pngBackupPath = "";
    private String webPResPath = "";

    public boolean isUseOriPng() {
        return useOriPng;
    }

    public void setUseOriPng(boolean useOriPng) {
        this.useOriPng = useOriPng;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public String getWebPResPath() {
        return webPResPath;
    }

    public void setWebPResPath(String webPResPath) {
        this.webPResPath = webPResPath;
    }

    public String getPngBackupPath() {
        return pngBackupPath;
    }

    public void setPngBackupPath(String pngBackupPath) {
        this.pngBackupPath = pngBackupPath;
    }
}
