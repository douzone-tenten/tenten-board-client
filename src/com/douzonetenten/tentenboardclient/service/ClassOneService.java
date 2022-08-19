package com.douzonetenten.tentenboardclient.service;

import com.douzonetenten.tentenboardclient.dao.PostDao;
import com.douzonetenten.tentenboardclient.dto.JoinPostDto;
import com.douzonetenten.tentenboardclient.dto.PostDto;

import java.sql.Connection;
import java.util.ArrayList;

import static com.douzonetenten.tentenboardclient.common.DBConnector.*;

public class ClassOneService {
    /**
     * 1반 게시판 서비스입니다.
     *
     * @author : 정수연
     */
    private static final PostDao postDao = new PostDao();


    /**
     * 선택한 게시글의 정보를 가져옵니다.
     *
     * @param selectNum :
     * @return : 선택한 게시글의 정보를 가져옵니다.
     * @author : 정수연
     * */
    public static ArrayList<JoinPostDto> findByPost(String selectNum) {

        Connection connection = getConnection();
        ArrayList<JoinPostDto> joinPostDtoArrayList = postDao.findByPost(connection, selectNum);
        return joinPostDtoArrayList;
    }

    /**
     * 게시글 입력에 대한 여부를 확인합니다.
     *
     * @param postDto : 입력한 값을 저장하기 위한 변수입니다.
     * @param boardNumber : 카테고리 번호입니다.
     * @return : 쿼리 실행 여부를 반환합니다.
     * @author : 정수연
     * */
    public int insertPost(PostDto postDto, String boardNumber) {
        Connection connection = getConnection();
        int result = postDao.insertPost(connection, postDto, boardNumber);
        if (result > 0) {
            commit(connection);
        } else rollback(connection);
        return result;
    }

    /**
     * 게시글 삭제에 대한 여부를 확인합니다.
     *
     * @param selectPost : 게시글의 번호입니다.
     * @return : 쿼리 실행 여부를 반환합니다.
     * @author : 정수연
     * */
    public int deletePost(String selectPost) {
        Connection connection = getConnection();
        int result = postDao.deletePost(connection,selectPost);
        if (result > 0) {
            commit(connection);
        } else rollback(connection);
        return result;
    }

    /**
     * 선택한 게시글의 상세 내용을 확인합니다.
     *
     * @param selectPost : 게시글의 번호입니다.
     * @return : 실행된 쿼리에서 선택된 정보를 반환합니다.
     * @author : 정수연
     * */
    public static ArrayList<JoinPostDto> detailPost(String selectPost) {//선택 포스팅 보기
        Connection connection = getConnection();
        ArrayList<JoinPostDto> joinPostDtoArrayList = postDao.findByPostDetail(connection, selectPost);
        return joinPostDtoArrayList;
    }

    /**
     * 선택한 게시글의 상세 내용을 확인합니다.
     *
     * @param postDto : 입력한 값을 저장하기 위한 변수입니다.
     * @param boardNumber : 카테고리의 번호입니다.
     * @return : 쿼리 실행 여부를 반환합니다.
     * @author : 정수연
     * */

    public int editPost(PostDto postDto, String boardNumber) {//선택된 게시글 수정
        Connection connection = getConnection();
        int result = postDao.editPost(connection, postDto, boardNumber);
        if (result > 0) {
            commit(connection);
        } else rollback(connection);
        return result;
    }
}