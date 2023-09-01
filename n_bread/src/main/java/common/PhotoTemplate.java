package common;

import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.nio.file.Files;

import notice.model.vo.Notice;
import party.model.vo.Party;
import photo.model.service.PhotoService;
import photo.model.vo.Photo;
import qna.model.vo.Qna;

public class PhotoTemplate implements java.io.Serializable {

    public static int seqPhotoNum(String saveDatabase) {
        return new PhotoService().sequencePhotoNum(saveDatabase);
    }

    public static String savePathChange(String savePath, String folder) throws IOException {
        File photoFile = new File(savePath + "/" + folder);
        Files.createDirectories(photoFile.toPath());
        return savePath + "/" + folder;
    }

    public static Photo selectPhoto(int phNum, String saveDatabase) {
        Photo resultPhoto = new PhotoService().selectPhoto(phNum, saveDatabase);
        return resultPhoto;
    }

    public static Photo searchPhoto(Object tableName, String saveDatabase) {
        Photo resultPhoto = null;
        int resultPhNum = 0;
        if (saveDatabase.equals("notice")) {
            resultPhNum = ((Notice) tableName).getNoPhotoNum();
            System.out.println("읽어온 테이블의 사진테이블 번호 : " + resultPhNum);
        } else if (saveDatabase.equals("party")) {
            resultPhNum = ((Party) tableName).getPhNum();
            System.out.println("읽어온 테이블의 사진테이블 번호 : " + resultPhNum);
        } else if (saveDatabase.equals("qna")) {
            resultPhNum = ((Qna) tableName).getQaPhotoNum();
            System.out.println("읽어온 테이블의 사진테이블 번호 : " + resultPhNum);
        } else {
            resultPhNum = -1;
        }
        resultPhoto = new PhotoService().selectPhoto(resultPhNum, saveDatabase);
        return resultPhoto;
    }

    public static boolean deletePhotoDir(String deleteDir){
        File deleteFile = new File(deleteDir);
        return deleteFile.delete();
    }
}
