package photo.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import photo.model.dao.PhotoDao;
import photo.model.vo.Photo;

import static common.JDBCTemplate.*;
public class PhotoService {
	PhotoDao dao = new PhotoDao();
	
	public PhotoService() {}


	public int insertPhoto(Photo photo, String saveDatabase) {
		Connection conn = getConnection();
		int result = dao.insertPhoto(conn, photo,saveDatabase);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}


	public int sequencePhotoNum(String saveDatabase) {
		Connection conn = getConnection();
		int result =  dao.sequencePhotoNum(conn,saveDatabase );
		close(conn);
		return result;
	}


	public Photo selectPhoto(int phNum, String saveDatabase) {
		Connection conn = getConnection();
		Photo resultPhoto = dao.selectPhoto(conn,phNum,saveDatabase);
		return resultPhoto;
	}


	public ArrayList<Photo> selectPhotoList() {
		Connection conn = getConnection();
		ArrayList<Photo> resultList = dao.selectPhotoList(conn);
		return resultList;
	}	
}
