package cn.mydreamy.gradle.plugin.utils

import cn.mydreamy.gradle.plugin.WebPAndroidExtension
import cn.mydreamy.gradle.plugin.task.ConvertTask
import org.gradle.api.Project

/**
 * @author yangzhao
 */
class SourceUtils {

    public static String webPResPath
    public static String pngBackupResPath

    /**
     * add resource dir ,res_webp
     * @param project
     */
    static void addResourceDir(Project project, WebPAndroidExtension extension) {
        String webPResPath = extension.getWebPResPath()
        if (null == webPResPath || "".equals(webPResPath)) {
            Collection<File> androidResDirs = ConvertTask.ConfigAction.getAndroidResDirectories(project);
            Iterator<File> iterator = androidResDirs.iterator();
            while (iterator.hasNext()) {
                File resFile = iterator.next().getAbsoluteFile();
                String resName = resFile.getName();
                if ("res".equals(resName)) {
                    String resRootPath = resFile.getParentFile().getAbsolutePath();
                    webPResPath = resRootPath + "/res_webp/";
                }
            }
        }

        String pngBackupResPath = extension.getPngBackupPath()
        if (null == pngBackupResPath || "".equals(pngBackupResPath)) {
            Collection<File> androidResDirs = ConvertTask.ConfigAction.getAndroidResDirectories(project);
            Iterator<File> iterator = androidResDirs.iterator();
            while (iterator.hasNext()) {
                File resFile = iterator.next().getAbsoluteFile();
                String resName = resFile.getName();
                if ("res".equals(resName)) {
                    String resRootPath = resFile.getParentFile().getAbsolutePath();
                    pngBackupResPath = resRootPath + "/res_png_ori/";
                }
            }
        }

        SourceUtils.webPResPath = webPResPath;
        SourceUtils.pngBackupResPath = pngBackupResPath;
        println("webPResPath:" + webPResPath + "\npngBackupResPath:" + pngBackupResPath)

        // get package name from android plugin
        def androidPlugin = project.android;
        // add vector and shape dirs to sourceSets
        if (androidPlugin != null) {
            androidPlugin.sourceSets.each { sourceSet ->
                println("dir:" + sourceSet.name + "," + sourceSet.res)
//                dir:debug,[src/debug/res]
//                debug dir:F:\github\YYSvgView\appWebp\src\debug\res
                if (sourceSet.name.equals('debug')) {
                    for (dir in sourceSet.res.srcDirs) {
                        println("debug dir:" + dir.absolutePath)
                    }

                    if (!extension.isUseOriPng()) {
                        sourceSet.res.srcDir(new File(webPResPath))
                    } else {
                        sourceSet.res.srcDir(new File(pngBackupResPath))
                    }
                }
//                dir:release,[src/release/res]
//                release dir:F:\github\YYSvgView\appWebp\src\release\res
                if (sourceSet.name.equals('release')) {
                    for (dir in sourceSet.res.srcDirs) {
                        println("release dir:" + dir.absolutePath)
                    }

                    if (!extension.isUseOriPng()) {
                        sourceSet.res.srcDir(new File(webPResPath))
                    } else {
                        sourceSet.res.srcDir(new File(pngBackupResPath))
                    }
                }
            }
        }
    }
}
