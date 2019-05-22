package project.thangnd.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import project.thangnd.dtos.CommentDto;
import project.thangnd.models.Comment;
import project.thangnd.models.User;
import project.thangnd.services.CommentService;
import project.thangnd.services.UserService;

@Controller
public class CommentController {

	Logger logger = Logger.getLogger(CommentController.class);
	@Autowired 
	private CommentService cmtService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="comment")
	@ResponseBody Map<String, Object> comment(@RequestParam("content_cmt") String content_cmt, 
											@RequestParam("id_rest") String id_rest, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		StringBuffer sb = new StringBuffer();
		List<CommentDto> list_comment = new ArrayList<>();
		sb.append(" " );
		try {
			Comment cmt = new Comment();
			cmt.setCmt_status("I");
			cmt.setContent_cmt(content_cmt);
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			cmt.setDate(format.format(date));
			cmt.setId_rest(Integer.parseInt(id_rest));
			User user = (User) session.getAttribute("user");
			cmt.setId_user(user.getUser_id());
			int result = cmtService.insertComment(cmt);
			if(result == 1){
				sb.append("insert comment success");
			}else{
				sb.append("insert comment failed " );
			}
			list_comment = loadCommentDto(Integer.parseInt(id_rest));
			if(list_comment.size() > 0){
				map.put("data", list_comment);
				System.out.println("CommentController # list comment success");
			}else{
				System.out.println("CommentController # list comment error");
			}
		} catch (Exception e) {
			e.printStackTrace();
//			System.out.println("CommentController insertComment error");
			logger.error(" error");
		}
		System.out.println("content_cmt: " + content_cmt +" id_rest: " + id_rest);
//		System.out.println(sb);
		logger.info(sb);
		return map;
	}
	
	@RequestMapping(value="loadcomment")
	@ResponseBody Map<String, Object> listcomment(@RequestParam("id_rest") String id_rest, HttpSession session){
		Map<String, Object> map = new HashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append("CommentController #loadcomment ");
		List<CommentDto> list_comment = new ArrayList<>();
		try {
//			list_comment = cmtService.listComment();
			list_comment = loadCommentDto(Integer.parseInt(id_rest));
			if(list_comment.size() > 0){
				sb.append("List comment is value ");
				map.put("data", list_comment);
			}else{
				sb.append("list comment is not value");
			}
		} catch (Exception e) {
			e.printStackTrace();
//			System.out.println("CommentController #listcomment");
			logger.error("error");
		}
		logger.info(sb);
		return map;
	}
	
	
	public List<CommentDto> loadCommentDto(int id_rest){
		List<CommentDto> listCommentDto = new ArrayList<>();
		List<Comment> listComment = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		try {
			listComment = cmtService.listComment(id_rest);
			if(listComment == null){
				sb.append("List comment is not value");
				listComment = null;
			}else{
				sb.append("List comment is value");
				for(int i = 0; i < listComment.size(); i++ ){
					CommentDto cmt_dto = new CommentDto();
					cmt_dto.setContent_cmt(listComment.get(i).getContent_cmt());
					cmt_dto.setDate(listComment.get(i).getDate());
					cmt_dto.setId_cmt(listComment.get(i).getId_cmt());
					cmt_dto.setId_rest(String.valueOf(listComment.get(i).getId_rest()));
					cmt_dto.setId_user(String.valueOf(listComment.get(i).getId_user()));
					User user = userService.getUserById(listComment.get(i).getId_user());
					if(user == null){
						sb.append("User is not value ");
						
					}else{
						sb.append("User is value " );
						cmt_dto.setImage_user(user.getImage_user());
						cmt_dto.setUsername(user.getUsername());
					}
					listCommentDto.add(cmt_dto);
					for(int j  = 0; j < listCommentDto.size() ; j++){
						sb.append(listCommentDto.get(i).toString());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			listComment = null;
			System.out.println("CommentController #loadComment error");
			logger.error("error exception");
		}
//		System.out.println(sb);
		logger.info(sb);
		return listCommentDto;
	}
}
