package com.douzonetenten.tentenboardclient.service;

import com.douzonetenten.tentenboardclient.common.DBConnector;
import com.douzonetenten.tentenboardclient.dao.QnADao;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;


import java.sql.Connection;
import java.util.ArrayList;

public class QnAService {
    private final QnADao qnADao = new QnADao();

    public QnAService() {}


    /**
     * QnA 게시판에 게시글을 조회하는 메소드
     *
     * @param selectNum - 조회할 게시판의 카테고리 넘버입니다.
     * @author 강도영
     */
    //QnA 게시글 목록조회
    public ArrayList<JoinPostDto> findAllByQnA(String selectNum) {
        Connection connection = DBConnector.getConnection();
        ArrayList<JoinPostDto> joinPostDtoArrayList = this.qnADao.findAllByQnA(connection, selectNum);
        return joinPostDtoArrayList;
    }


    /**
     * QnA 게시판에 게시글을 작성하는 메소드
     *
     * @param selectNum - 조회할 게시판의 카테고리 넘버입니다.
     * @param postDto - 입력한 값을 저장하기 위한 변수입니다.
     * @param userId - 로그인한 사용자의 아이디를 출력하기 위해 사용하는 변수입니다.
     * @author 강도영
     */
    //QnA 게시글 작성
    public int insertQnA(PostDto postDto, Long userId, String selectNum) {
        Connection connection = DBConnector.getConnection();
        int result = this.qnADao.insertQnA(connection, postDto, userId, selectNum);
            if (result > 0){
                DBConnector.commit(connection);
            }
            else {
                DBConnector.rollback(connection);
            }
            return result;
    }


    /**
     * QnA 게시판에 게시글을 상세조회 하는 메소드
     *
     * @param selectDetailNum - 상세조회할 게시글의 넘버입니다.
     * @author 강도영
     */
    //QnA 게시글 상세조회
    public ArrayList<JoinPostDto> detailQnA(String selectDetailNum) {
        Connection connection = DBConnector.getConnection();
        ArrayList<JoinPostDto> joinPostDtoListDetail = this.qnADao.detailQnA(connection, selectDetailNum);

        return joinPostDtoListDetail;
    }


    /**
     * QnA 게시판에 게시글을 삭제하는 메소드
     *
     * @param postNo - 삭제할 게시글의 번호 넘버입니다.
     * @author 강도영
     */
    //QnA 게시글 삭제
    public int deleteQnA(String postNo) {
        Connection connection = DBConnector.getConnection();
        int result = this.qnADao.deleteQnA(connection, postNo);
        if(result > 0) {
            DBConnector.commit(connection);
        }
        else {
            DBConnector.rollback(connection);
        }
        return result;
    }


    /**
     * QnA 게시판에 게시글을 수정하는 메소드
     *
     * @param postDto - 입력한 값을 저장하기 위한 변수입니다.
     * @param selectDetailNum - 상세조회할 게시글의 넘버입니다.
     * @author 강도영
     */
    //QnA 게시글 수정
    public int updateQnA(PostDto postDto, String selectDetailNum) {
        Connection connection = DBConnector.getConnection();
        int resultUpdate = this.qnADao.updateQnA(connection, postDto, selectDetailNum);

        if(resultUpdate > 0) {
            DBConnector.commit(connection);
        }
        else {
            DBConnector.rollback(connection);
        }
        return resultUpdate;
    }
}
