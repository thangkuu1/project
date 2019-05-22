package project.thangnd.daos;

import java.math.BigInteger;
import java.util.List;

import project.thangnd.models.Comment;

public interface CommentDao {

	public int insertComment(Comment cmt);
	public List<Comment> listComment(int id_rest);
	public BigInteger countComment(int id_rest);
}
