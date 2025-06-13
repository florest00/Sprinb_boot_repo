package com.kh.app07.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
// 서비스보다도 @Component 때문에 bin으로 등록할 수 있어서 됨
// spring container 안쪽의 객체를 bin(bean?)이라고 함
public class BoardService {

    @Autowired
    //스프링아 이거 연결해줘라
    private BoardMapper boardMapper;

}
