package com.petmet.web.service;

import java.util.Date;
import java.util.List;

import com.petmet.web.dao.BoardCategoryDao;
import com.petmet.web.dao.BoardDao;
import com.petmet.web.dao.jdbc.JdbcBoardCategoryDao;
import com.petmet.web.dao.jdbc.JdbcBoardDao;
import com.petmet.web.entity.Board;
import com.petmet.web.entity.BoardCategory;
import com.petmet.web.entity.BoardView;

public class BoardService {
	private BoardDao boardDao;
	
	//---------------------------------- Constructor ----------------------------------
	public BoardService() {
		boardDao = new JdbcBoardDao();
	}
	
	//---------------------------------- Functions ----------------------------------
	public int insert(Board board) {
		return boardDao.insert(board);
	}
	
	public int update(Board board) {
		return boardDao.update(board);
	}
	
	public int delete(int id) {
		return boardDao.delete(id);
	}
	
	public Board get(int id) {
		return boardDao.get(id);
	}
	
	// -------------- getList --------------
	public List<Board> getList() {
		return getList(null, null, null, null, null, 1, 20);
	}
	
	public List<Board> getList(int page){
		return getList(null, null, null, null, null, page, 20);
	}
	
	public List<Board> getList(int page, int size){
		return getList(null, null, null, null, null, page, size);
	}
	
	public List<Board> getList(String selectBox, String query){
		return getList(selectBox, query, null, null, null, 1, 20);
	}
	
	public List<Board> getList(String boardCategory){
		return getList(null, null, boardCategory, null, null, 1, 20);
	}
	
	public List<Board> getList(Date startDate, Date endDate){
		return getList(null, null, null, startDate, endDate, 1, 20);
	}
	
	public List<Board> getList(String selectBox, String query, int page){
		return getList(selectBox, query, null, null, null, page, 20);
	}
	
	public List<Board> getList(String selectBox, String query, int page, int size){
		return getList(selectBox, query, null, null, null, page, size);
	}
	
	public List<Board> getList(String boardCategory, int page){
		return getList(null, null, boardCategory, null, null, page, 20);
	}
	
	public List<Board> getList(String boardCategory, int page, int size){
		return getList(null, null, boardCategory, null, null, page, size);
	}
	
	public List<Board> getList(Date startDate, Date endDate, int page){
		return getList(null, null, null, startDate, endDate, page, 20);
	}
	
	public List<Board> getList(Date startDate, Date endDate, int page, int size){
		return getList(null, null, null, startDate, endDate, page, size);
	}
	
	public List<Board> getList(String selectBox, String query, String boardCategory, int page){
		return getList(selectBox, query, boardCategory, null, null, page, 20);
	}
	
	public List<Board> getList(String selectBox, String query, String boardCategory, int page, int size){
		return getList(selectBox, query, boardCategory, null, null, page, size);
	}
	
	public List<Board> getList(String boardCategory, Date startDate, Date endDate, int page){
		return getList(null, null, boardCategory, startDate, endDate, page, 20);
	}
	
	public List<Board> getList(String boardCategory, Date startDate, Date endDate, int page, int size){
		return getList(null, null, boardCategory, startDate, endDate, page, size);
	}
	
	public List<Board> getList(String selectBox, String query, Date startDate, Date endDate, int page){
		return getList(selectBox, query, null, startDate, endDate, page, 20);
	}
	
	public List<Board> getList(String selectBox, String query, Date startDate, Date endDate, int page, int size){
		return getList(selectBox, query, null, startDate, endDate, page, size);
	}
	
	// ---- getList 최종
	public List<Board> getList(String selectBox, String query, String boardCategory
								, Date startDate, Date endDate, int page, int size){
		// page & size
		int startIndex = 1 + (page - 1) * size;
		int endIndex = size * page;
		
		return boardDao.getList(selectBox, query, boardCategory, startDate, endDate, startIndex, endIndex);
	}
	// ---------------------------------------
	public int deleteList(int[] ids) {
		int result = 0;
		
		for(int i=0; i < ids.length; i++, result++) {
			int id = ids[i];
			boardDao.delete(id);
		}
		
		return result;
	}
	
	public int updateList(List<Board> list) {
		int result = 0;
		
		for(Board board : list) {
			boardDao.update(board);
			result++;
		}
		
		return result;
	}
	
	public Board getPrev(int id) {
		return boardDao.get(id-1);
	}
	
	public Board getNext(int id) {
		return boardDao.get(id+1);
	}
	
	public List<BoardCategory> getCategoryList(){
		BoardCategoryDao categoryDao = new JdbcBoardCategoryDao();
		return categoryDao.getList();
	}
	
	// -------------- getViewList --------------
	public List<BoardView> getViewList() {
		return getViewList(null, null, null, null, null, 1, 20);
	}
	
	public List<BoardView> getViewList(int page){
		return getViewList(null, null, null, null, null, page, 20);
	}
	
	public List<BoardView> getViewList(int page, int size){
		return getViewList(null, null, null, null, null, page, size);
	}
	
	public List<BoardView> getViewList(String selectBox, String query){
		return getViewList(selectBox, query, null, null, null, 1, 20);
	}
	
	public List<BoardView> getViewList(String boardCategory){
		return getViewList(null, null, boardCategory, null, null, 1, 20);
	}
	
	public List<BoardView> getViewList(Date startDate, Date endDate){
		return getViewList(null, null, null, startDate, endDate, 1, 20);
	}
	
	public List<BoardView> getViewList(String selectBox, String query, int page){
		return getViewList(selectBox, query, null, null, null, page, 20);
	}
	
	public List<BoardView> getViewList(String selectBox, String query, int page, int size){
		return getViewList(selectBox, query, null, null, null, page, size);
	}
	
	public List<BoardView> getViewList(String boardCategory, int page){
		return getViewList(null, null, boardCategory, null, null, page, 20);
	}
	
	public List<BoardView> getViewList(String boardCategory, int page, int size){
		return getViewList(null, null, boardCategory, null, null, page, size);
	}
	
	public List<BoardView> getViewList(Date startDate, Date endDate, int page){
		return getViewList(null, null, null, startDate, endDate, page, 20);
	}
	
	public List<BoardView> getViewList(Date startDate, Date endDate, int page, int size){
		return getViewList(null, null, null, startDate, endDate, page, size);
	}
	
	public List<BoardView> getViewList(String selectBox, String query, String boardCategory, int page){
		return getViewList(selectBox, query, boardCategory, null, null, page, 20);
	}
	
	public List<BoardView> getViewList(String selectBox, String query, String boardCategory, int page, int size){
		return getViewList(selectBox, query, boardCategory, null, null, page, size);
	}
	
	public List<BoardView> getViewList(String boardCategory, Date startDate, Date endDate, int page){
		return getViewList(null, null, boardCategory, startDate, endDate, page, 20);
	}
	
	public List<BoardView> getViewList(String boardCategory, Date startDate, Date endDate, int page, int size){
		return getViewList(null, null, boardCategory, startDate, endDate, page, size);
	}
	
	public List<BoardView> getViewList(String selectBox, String query, Date startDate, Date endDate, int page){
		return getViewList(selectBox, query, null, startDate, endDate, page, 20);
	}
	
	public List<BoardView> getViewList(String selectBox, String query, Date startDate, Date endDate, int page, int size){
		return getViewList(selectBox, query, null, startDate, endDate, page, size);
	}
	
	// ---- getViewList 최종
	public List<BoardView> getViewList(String selectBox, String query, String boardCategory
								, Date startDate, Date endDate, int page, int size){
		// page & size
		int startIndex = 1 + (page - 1) * size;
		int endIndex = size * page;
		
		return boardDao.getViewList(selectBox, query, boardCategory, startDate, endDate, startIndex, endIndex);
	}
	// ---------------------------------------
}