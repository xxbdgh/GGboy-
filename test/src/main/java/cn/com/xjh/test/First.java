package cn.com.xjh.test;


import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;

public class First {

    public static final Logger log = LoggerFactory.getLogger(First.class);

    public static String getTempPath(String tempPath, String filePath) throws Exception {
//        String tempPath="    ";//保存的目标路径
        File targetFile = new File(tempPath);
        if (!targetFile.getParentFile().exists()) {
            targetFile.getParentFile().mkdirs();
        }
        File file2 = new File(filePath);
        if (file2.exists()) {
            log.info("文件存在，路径正确！");
            FFmpegFrameGrabber ff = new FFmpegFrameGrabber(file2);
            ff.start();
            int ftp = ff.getLengthInFrames();
            int flag=0;
            Frame frame = null;
            while (flag <= ftp) {
                //获取帧
                frame = ff.grabImage();
                //过滤前3帧，避免出现全黑图片
                if ((flag>3)&&(frame != null)) {
                    break;
                }
                flag++;
            }
            ImageIO.write(FrameToBufferedImage(frame), "jpg", targetFile);
            ff.close();
            ff.stop();
        }
        return null;
    }
    private static RenderedImage FrameToBufferedImage(Frame frame) {
        //创建BufferedImage对象
        Java2DFrameConverter converter = new Java2DFrameConverter();
        return converter.getBufferedImage(frame);
    }

    public static void main(String[] args) {
        try {
//            getTempPath("http://jyt.fty.pw:8080/videos/guoyifang/a2966518-03dd-4a31-b05b-5c52db6baf73.mp4", "D:\\test.jpg");
            getTempPath("http://alist.rrow.link/Rrow's%20Resources", "http://120.48.34.51:5244/d/onedrive/gupao/test.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
