package project.thangnd.serviceImpls;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.thangnd.daos.CommentDao;
import project.thangnd.models.Comment;
import project.thangnd.services.CommentService;
@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentDao cmtDao;
	
	@Override
	public int insertComment(Comment cmt) {
		// TODO Auto-generated method stub
		return cmtDao.insertComment(cmt);
	}

	@Override
	public List<Comment> listComment(int id_rest) {
		// TODO Auto-generated method stub
		return cmtDao.listComment(id_rest);
	}

	@Override
	public BigInteger countComment(int id_rest) {
		// TODO Auto-generated method stub
		return cmtDao.countComment(id_rest);
	}

}
